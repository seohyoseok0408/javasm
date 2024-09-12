package edu.sm.dao;

import edu.sm.dto.Cust;
import edu.sm.exception.DuplicatedIdException;
import edu.sm.frame.Dao;
import edu.sm.frame.MService;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class CustDao implements Dao<String, Cust> {
    @Override
    public Cust insert(Cust cust, Connection con) throws  Exception {
        // Connection은 서비스 단에서 관리
        PreparedStatement ps = null;
        try { // 아래 try, catch, finally 로직 예시는 굉장히 굉장히 굉장히 중요하다.
            ps = con.prepareStatement(Sql.insertCust);
            ps.setString(1, cust.getId());
            ps.setString(2, cust.getPwd());
            ps.setString(3, cust.getName());
            ps.executeUpdate(); // 여기서 에러날 수도 있는 걸 생각하라.
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new DuplicatedIdException("EX0001");
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

        return cust;
    }

    @Override
    public Cust update(Cust cust, Connection con) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.updateCust);
            ps.setString(1, cust.getPwd());
            ps.setString(2, cust.getName());
            ps.setString(3, cust.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return cust;
    }

    @Override
    public boolean delete(String s, Connection con) throws Exception {
        boolean flag = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.deleteCust);
            ps.setString(1, s);
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
    public Cust select(String s, Connection con) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cust cust = null;
        try {
            ps = con.prepareStatement(Sql.selectOneCust);
            ps.setString(1, s);
            rs = ps.executeQuery();
            rs.next();
            cust = new Cust();
            cust.setId(rs.getString("id"));
            cust.setPwd(rs.getString("pwd"));
            cust.setName(rs.getString("name"));
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
        return cust;
    }

    @Override
    public List<Cust> select(Connection con) throws Exception {
        List<Cust> custs = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(Sql.selectCust);
            rs = ps.executeQuery();
            while (rs.next()) {
                custs.add(new Cust(rs.getString("id"), rs.getString("pwd"), rs.getString("name")));
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
        return custs;
    }

}
