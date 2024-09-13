package edu.sm.cust;

import edu.sm.dto.Cust;
import edu.sm.exception.DuplicatedIdException;
import edu.sm.service.CustService;

public class CustInsert{
    public static void main(String[] args) {
        CustService custService = new CustService();
        Cust cust = Cust.builder()
                .id("id66")
                .pwd("pwd88")
                .name("임꺽정")
                .build();

        try {
            custService.add(cust);
        } catch (DuplicatedIdException e) {
            System.out.println("ID가 중복 되어 입력이 안됩니다.");
        } catch (Exception e) {
            System.out.println("시스템 장애 발생");
//            e.printStackTrace(); // 개발자 테스트에선 이것이 중요함
        }

    }
}
