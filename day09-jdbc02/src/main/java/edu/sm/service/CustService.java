package edu.sm.service;

import edu.sm.dao.CustDao;
import edu.sm.dto.Cust;
import edu.sm.exception.DuplicatedIdException;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.Dao;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CustService implements MService<String, Cust> {
    // Service에 Connection을 만들어야 한다.

    CustDao dao;
    ConnectionPool cp;;

    public CustService() {
        dao = new CustDao();
        try {
            cp = ConnectionPool.create(); //
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cust add(Cust cust) throws DuplicatedIdException, Exception {
        Connection con = cp.getConnection();
        // insert시 문제가 일어날수도있단걸 생각해야함(ex,ID중복). 만약 오류나면 Exception으로만 떤지게되고 그아래는 진행X.
        // 그래서 try/catch를 해야한다.
        try{
            con.setAutoCommit(false); // 커넥션아 커밋될때까지 기다려
            dao.insert(cust, con);
//            dao.insert(cust, con);
            con.commit(); // 위 두 문장이 제대로 실행되면 commit해서 같이 들어감. 근데 2번째가 에러나서 catch로 가면 커밋을 안한거고, catch에서 롤백해야함
            System.out.println("Send SMS to: " + cust.getId());
        } catch (DuplicatedIdException e) {
            con.rollback();
            throw e;
        }
        catch (Exception e) {
            throw e; // 예외 발생 시 예외를 이것을 호출한 애플리케이션쪽으로 떤지게되고 끝남. 즉, return은 실행 안됨 (정상임)
        } finally {
            cp.releaseConnection(con);
        }
        return cust;
    }

    @Override
    public Cust modify(Cust cust) throws Exception {
        Connection conn = cp.getConnection();
        try {
            dao.update(cust, conn);
            System.out.println("Send (Updated) SMS to: " + cust.getId());
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return cust;
    }

    @Override
    public Boolean remove(String s) throws Exception {
        Connection conn = cp.getConnection();
        Boolean result = false;
        try {
            result = dao.delete(s, conn);
            System.out.println("삭제완료 id : " + s);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return result;
    }

    @Override
    public Cust get(String s) throws Exception {
        Connection conn = cp.getConnection();
        Cust cust = null;
        try {
            cust = dao.select(s, conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return cust;
    }

    @Override
    public List<Cust> get() throws Exception {
        Connection conn = cp.getConnection();
        List<Cust> custs = null;
        try {
            custs = dao.select(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(conn);
        }
        return custs;
    }
}
