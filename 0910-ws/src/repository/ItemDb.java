package repository;

import dto.Item;
import frame.Db;

import java.util.ArrayList;
import java.util.List;

public class ItemDb implements Db<Integer, Item> {
    @Override
    public void insert(Item item) throws Exception {
        System.out.println("Insert: " + item);
    }

    @Override
    public void update(Item item) throws Exception {
        System.out.println("Update: " + item);
    }

    @Override
    public void delete(Integer i) throws Exception {
        System.out.println("Delete: " + i +"번 아이템 삭제");
    }

    // id로 상품 검색
    @Override
    public Item select(Integer i) throws Exception {
        Item item = null;
        item = new Item(1, "국밥밀키트", 23000, "test.png");
        return item;
    }

    @Override
    public List<Item> select() throws Exception {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "체리", 1000, "cherry.png"));
        items.add(new Item(2, "포도", 5000, "grape.png"));
        items.add(new Item(3, "사과", 3000, "apple.png"));
        items.add(new Item(4, "수박", 10000, "watermelon.png"));
        items.add(new Item(5, "참외", 6000, "idonknow.png"));
        items.add(new Item(6, "멜론", 15000, "melon.png"));
        return items;
    }
}
