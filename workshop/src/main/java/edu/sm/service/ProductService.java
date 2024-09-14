package edu.sm.service;

import edu.sm.dao.ProductDao;
import edu.sm.dto.Product;
import edu.sm.exception.DuplicatedNameException;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
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

    // insert 메서드 (기존 add 메서드)
    @Override
    public Product add(Product product) throws Exception {
        Connection con = cp.getConnection();
        try {
            con.setAutoCommit(false);  // 트랜잭션 시작
            dao.insert(product, con);
            con.commit();
        } catch (DuplicatedNameException e) {
            con.rollback();
            throw e;
        } catch (Exception e) {
            con.rollback();
            throw e;
        } finally {
            if (con != null) {
                cp.releaseConnection(con);
            }
        }
        return product;
    }

    // update 메서드 (기존 modify 메서드)
    @Override
    public Product modify(Product product) throws Exception {
        Connection con =  cp.getConnection();
        try {
           dao.update(product, con);
            con.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                cp.releaseConnection(con);
            }
        }
        return product;
    }

    // delete 메서드 (기존 remove 메서드)
    @Override
    public Boolean remove(Integer id) throws Exception {
        Connection con = cp.getConnection();
        Boolean result = false;
        try {
            result = dao.delete(id, con);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return result;
    }

    // selectOne 메서드 (기존 get(K k) 메서드)
    @Override
    public Product get(Integer id) throws Exception {
        Connection con = cp.getConnection();
        Product product = null;
        try {
            product = dao.select(id, con);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return product;
    }

    // select 메서드 (기존 get() 메서드)
    @Override
    public List<Product> get() throws Exception {
        Connection con = cp.getConnection();
        List<Product> products = null;
        try {
            products = dao.select(con);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return products;
    }
}