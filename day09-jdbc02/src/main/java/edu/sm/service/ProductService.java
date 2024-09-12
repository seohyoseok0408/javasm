package edu.sm.service;

import edu.sm.dao.ProductDao;
import edu.sm.dto.Cust;
import edu.sm.dto.Product;
import edu.sm.exception.DuplicatedIdException;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ProductService implements MService<Integer, Product> {
    ProductDao dao;
    ConnectionPool cp;

    public ProductService() {
        dao = new ProductDao();
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Product add(Product product) throws DuplicatedIdException, Exception {
        Connection con = cp.getConnection();
        product.setRegdate(new Date());
        try {
            con.setAutoCommit(false);
            dao.insert(product, con);
            con.commit();
            System.out.println("ProductService : add 실행됨");
        } catch (Exception e) {
            con.rollback();
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return product;
    }

    @Override
    public Product modify(Product product) throws Exception {
        Connection conn = cp.getConnection();
        try {
            dao.update(product, conn);
            System.out.println("ProductService : modify 실행 : " + product.getId());
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return product;
    }

    @Override
    public Boolean remove(Integer i) throws Exception {
        Connection conn = cp.getConnection();
        Boolean result = false;
        try {
            result = dao.delete(i, conn);
            System.out.println("ProductService : remove 실행 id : " + i);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return result;
    }

    @Override
    public Product get(Integer i) throws Exception {
        Connection conn = cp.getConnection();
        Product product = null;
        try {
            product = dao.select(i, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return product;
    }

    @Override
    public List<Product> get() throws Exception {
        Connection conn = cp.getConnection();
        List<Product> products = null;
        try {
            products = dao.select(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return products;
    }
}
