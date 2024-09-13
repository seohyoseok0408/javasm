package edu.sm.product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

public class ProductInsert {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Product product = Product.builder()
                .name("아이스티")
                .price(123)
                .build();

        try {
            productService.add(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
