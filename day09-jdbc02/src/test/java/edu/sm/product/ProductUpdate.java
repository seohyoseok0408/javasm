package edu.sm.product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

public class ProductUpdate {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Product product = Product.builder()
                .id(3)
                .name("수박2")
                .price(15000)
                .build();

        try {
            productService.modify(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
