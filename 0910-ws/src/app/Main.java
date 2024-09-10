package app;

import dto.Customer;
import dto.Item;
import frame.Db;
import repository.CustomerDb;
import repository.ItemDb;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Db<Integer, Customer> db = new CustomerDb();

        Customer cust = new  Customer(1, "pwd1", "tom");
        System.out.println(cust);

        // insert 테스트
        try {
            db.insert(cust);
        } catch (Exception e) {
            System.out.println("입력시 오류 발생");
        }

        // update 테스트
        try {
            db.update(cust);
        } catch (Exception e) {
            System.out.println("업데이트 오류 발생");
        }

        // delete 테스트
        try {
            db.delete(1);
        } catch (Exception e) {
            System.out.println("삭제시 오류 발생");
        }

        // select 테스트
        String id = "1";
        Customer dbCust = null;
        try {
            dbCust = db.select(1);
            System.out.println("검색한 "+id+"번 사용자의 이름은: " +dbCust.getName());
        } catch (Exception e) {
            System.out.println("사용자 조회 중 오류 발생");
        }

        // 사용자 전체반환 select 테스트
        List<Customer> custs = null;
        try {
            custs = db.select();
            for (Customer c : custs) {
                System.out.println(c);
            }
        } catch (Exception e) {
            System.out.println("조회시 에러 발생");
        }

        // 이름으로 검색 테스트
        List<Customer> scust = null;
        try {
            String input = "최";
            scust = db.searchByName(input);
            for (Customer c : scust) {
                System.out.println(c);
            }
        } catch (Exception e) {
            System.out.println("조회시 에러 발생");
        }

        System.out.println("-----------------------------------------------------------");

        Db<Integer, Item> db2 = new ItemDb();

        Item item = new Item(1, "국밥밀키트", 23000, "test.png");
        System.out.println(item);

        // insert 테스트
        try {
            db2.insert(item);
        } catch (Exception e) {
            System.out.println("입력시 오류 발생");
        }

        // update 테스트
        try {
            db2.update(item);
        } catch (Exception e) {
            System.out.println("업데이트 오류 발생");
        }

        // delete 테스트
        try {
            db2.delete(1);
        } catch (Exception e) {
            System.out.println("삭제시 오류 발생");
        }

        // select 테스트
        String id2 = "1";
        Customer dbItem = null;
        try {
            dbItem = db.select(1);
            System.out.println("검색한 "+id2+"번 상품의 이름은: " +dbItem.getName());
        } catch (Exception e) {
            System.out.println("사용자 조회 중 오류 발생");
        }

        // 상품 전체반환 select 테스트
        List<Item> items = null;
        try {
            items = db2.select();
            for (Item i : items) {
                System.out.println(i);
            }
        } catch (Exception e) {
            System.out.println("조회시 에러 발생");
        }
    }
}
