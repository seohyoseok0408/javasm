package edu.sm.dao;

import edu.sm.dto.Cust;
import edu.sm.dto.Product;
import edu.sm.exception.DuplicatedIdException;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Integer, Product> {

    @Override
    public Product insert(Product product, Connection con) throws DuplicatedIdException, Exception {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.insertProduct);
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setTimestamp(4, new java.sql.Timestamp(product.getRegdate().getTime()));
            ps.executeUpdate();
        } catch (Exception e) {
            throw e; // 나중에 중복 id 수정
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return product;
    }

    @Override
    public Product update(Product product, Connection con) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.updateProduct);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getPrice());
            ps.setInt(3, product.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return product;
    }

    @Override
    public boolean delete(Integer i, Connection con) throws Exception {
        boolean flag = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.deleteProduct);
            ps.setInt(1, i);
            int result =  ps.executeUpdate();
            if (result == 1) {
                flag = true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return flag;
    }


    @Override
    public Product select(Integer i, Connection con) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Product product = null;
        try {
            ps = con.prepareStatement(Sql.selectOneProduct);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            rs.next();
            product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getInt("price"));
            product.setRegdate(rs.getDate("regdate"));
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return product;
    }

    @Override
    public List<Product> select(Connection con) throws Exception {
        List<Product> products = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(Sql.selectProduct);
            rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getDate("regdate")));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return products;
    }
}
