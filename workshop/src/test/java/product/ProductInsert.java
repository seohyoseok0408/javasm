package product;

import edu.sm.dto.Product;
import edu.sm.exception.DuplicatedNameException;
import edu.sm.service.ProductService;

import java.sql.Date;

public class ProductInsert {
    public static void main(String[] args) {

        ProductService productService = new ProductService();

        Product product = Product.builder()
                .id(0)
                .name("testname")
                .price(123)
                .size("M")
                .color("Red")
                .build();

        try {
            productService.add(product);
            System.out.println(product.getName() + "이(가) 성공적으로 추가되었습니다.");
        } catch (DuplicatedNameException e) {
            System.out.println("상품명이 중복 되어 등록이 불가합니다. : " + product.getId());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("시스템 장애가 발생했습니다.");
        }
    }
}