package edu.sm.dao;

import edu.sm.dto.Product;
import edu.sm.exception.DuplicatedNameException;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Integer, Product> {

    @Override
    public Product insert(Product product, Connection con) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.insertProduct);
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getPrice());
            ps.setString(4, product.getSize());
            ps.setString(5, product.getColor());
            ps.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new DuplicatedNameException("중복된 제품 이름: " + product.getName());
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
    public Product update(Product product, Connection con) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.updateProduct);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getPrice());
            ps.setString(3, product.getSize());
            ps.setString(4, product.getColor());
            ps.setInt(5, product.getId());
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
    public boolean delete(Integer id, Connection con) throws Exception {
        PreparedStatement ps = null;
        boolean result = false;
        try {
            ps = con.prepareStatement(Sql.deleteProduct);
            ps.setInt(1, id);
            int temp = ps.executeUpdate();
            if (temp == 1) {
                result = true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return result;
    }

    @Override
    public Product select(Integer id, Connection con) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Product product = null;
        try  {
            ps = con.prepareStatement(Sql.selectOneProduct);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("size"),
                        rs.getString("color"),
                        rs.getTimestamp("registration_date")
                );
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
        return product;
    }

    @Override
    public List<Product> select(Connection con) throws SQLException {
        PreparedStatement ps = null;
        List<Product> products = new ArrayList<>();
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(Sql.selectProduct);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("size"),
                        rs.getString("color"),
                        rs.getTimestamp("registration_date")
                );
                products.add(product);
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