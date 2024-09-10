package repository;

import dto.Cust;
import frame.Db;

import java.util.ArrayList;
import java.util.List;

// Cust 객체가 들어오면 그것을 db에 집어넣는 역할을 한다.
// 내 마음대로 하는 것이 아닌, 뼈대를 통해 보고 만든다. (뼈대 -> frame)
// Cust의 키는 id일거고 String, 그리고 Cust
public class CustDb implements Db<String, Cust> {
    @Override
    public void insert(Cust cust) throws Exception {
        System.out.println("Inserted: "+ cust.getName());
    }

    @Override
    public void update(Cust cust) throws Exception{
        System.out.println("Updated: "+ cust.getName());
    }

    @Override
    public void delete(String s) throws Exception{
        System.out.println("Deleted: "+ s);
    }

    @Override
    public Cust select(String s) throws Exception{
        Cust cust = null;
        cust = new Cust(s, "ppp", "이말숙");
        return cust;
    }

    @Override
    public List<Cust> select() throws Exception{
        List<Cust> custs = new ArrayList<Cust>();
        custs.add(new Cust("id01", "pwd01", "이말숙"));
        custs.add(new Cust("id02", "pwd02", "홍길동"));
        custs.add(new Cust("id03", "pwd03", "서효석"));
        custs.add(new Cust("id04", "pwd04", "이말년"));
        custs.add(new Cust("id05", "pwd05", "빈츠존"));
        custs.add(new Cust("id06", "pwd06", "나맛있"));
        return custs;
    }

    @Override
    public List<Cust> searchByName(String name) throws Exception {
        List<Cust> custs = new ArrayList<Cust>();
        custs.add(new Cust("id01", "pwd01", "김말숙"));
        custs.add(new Cust("id02", "pwd02", "김길동"));
        custs.add(new Cust("id03", "pwd03", "김효석"));
        custs.add(new Cust("id04", "pwd04", "김서진"));
        custs.add(new Cust("id05", "pwd05", "김츠존"));
        custs.add(new Cust("id06", "pwd06", "김맛있"));
        return custs;

    }
}
