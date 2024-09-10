package com.db;

public class CustomerDb implements Db{
    @Override
    public void insert(Object obj) {
        Customer c = (Customer) obj;
        System.out.println(c.getName());
        System.out.println("Inserted: "+obj);
    }

    @Override
    public void update(Object obj) {
        System.out.println("Updated: "+obj);
    }

    @Override
    public void delete(Object obj) {
        System.out.println("Deleted: "+obj);
    }
}
