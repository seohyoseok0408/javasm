package edu.sm.cust;

import edu.sm.dto.Cust;
import edu.sm.service.CustService;

public class CustDelete {
    public static void main(String[] args) {
        CustService custService = new CustService();
        Cust cust = Cust.builder()
                .id("id04")
                .build();

        try {
            custService.remove(cust.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
