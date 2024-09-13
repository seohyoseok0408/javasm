package edu.sm.product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

public class ProductDelete {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        int id = 2;
        try {
            productService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
