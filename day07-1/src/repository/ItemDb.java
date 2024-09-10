package repository;

import dto.Item;
import frame.Db;

import java.util.ArrayList;
import java.util.List;

public class ItemDb implements Db<Integer, Item> {
    @Override
    public void insert(Item item) throws Exception {
        System.out.println(item);
    }

    @Override
    public void update(Item item) throws Exception{

    }

    @Override
    public void delete(Integer i) throws Exception{

    }

    @Override
    public Item select(Integer integer) throws Exception{
        Item item = null;
        item = new Item(1, "jeans", 25000);
        return item;
    }

    @Override
    public List<Item> select() throws Exception{
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(1, "jeans", 25000));
        items.add(new Item(2, "Tshirts", 43000));
        items.add(new Item(3, "Shoes", 93000));
        items.add(new Item(4, "gloves", 6600));
        items.add(new Item(5, "ring", 8700));
        items.add(new Item(6, "hat", 11000));
        return items;
    }
}
