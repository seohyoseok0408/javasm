package repository;

import dto.Customer;
import frame.Db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerDb implements Db <Integer, Customer> {
    @Override
    public void insert(Customer customer) throws Exception {
        System.out.println("Insert: " + customer);
    }

    @Override
    public void update(Customer customer) throws Exception {
        System.out.println("Update: " + customer);

    }

    @Override
    public void delete(Integer i) throws Exception {
        System.out.println("Delete: "+i+"번 사용자");

    }

    // id로 사용자 검색
    @Override
    public Customer select(Integer i) throws Exception {
        Customer customer = null;
        customer = new Customer(i, "pwd01", "홍길동");
        return customer;
    }

    // 전체 사용자 반환
    @Override
    public List<Customer> select() throws Exception {
        List<Customer> custs = new ArrayList<>();
        custs.add(new Customer(1, "pwd01", "서효석"));
        custs.add(new Customer(2, "pwd02", "홍길동"));
        custs.add(new Customer(3, "pwd03", "이무개"));
        custs.add(new Customer(4, "pwd04", "이태빈"));
        custs.add(new Customer(5, "pwd05", "이동우"));
        custs.add(new Customer(6, "pwd06", "진완규"));
        return custs;
    }

    //  이름으로 사용자 검색
    @Override
    public List<Customer> searchByName(String name) throws Exception {
        List<Customer> custs = new ArrayList<>();
        custs.add(new Customer(1, "pwd01", "최효석"));
        custs.add(new Customer(2, "pwd02", "최길동"));
        custs.add(new Customer(3, "pwd03", "최무개"));
        custs.add(new Customer(4, "pwd04", "최태빈"));
        custs.add(new Customer(5, "pwd05", "최동우"));
        custs.add(new Customer(6, "pwd06", "최완규"));

        return custs;
    }
}
