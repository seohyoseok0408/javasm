package edu.sm.cust;

import edu.sm.dto.Cust;
import edu.sm.service.CustService;

public class CustUpdate {
    public static void main(String[] args) {
        CustService custService = new CustService();
        Cust cust = Cust.builder()
                .id("id02")
                .pwd("00")
                .name("홍길동")
                .build();

        try {
            custService.modify(cust);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
