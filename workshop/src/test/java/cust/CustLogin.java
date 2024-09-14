package cust;

import edu.sm.dto.Cust;
import edu.sm.service.CustService;

public class CustLogin {
    public static void main(String[] args) {
        CustService custService = new CustService();
        String email = "taebin123@naver.com";
        String pwd = "1234";

        try {
            Cust cust = custService.login(email, pwd);
            if (cust != null) {
                System.out.println("로그인 성공: " + cust.getName());
            } else {
                System.out.println("로그인 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
