package com.db;

public class ItemDb implements Db{
    @Override
    public void insert(Object obj) {
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
