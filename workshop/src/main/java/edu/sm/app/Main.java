package edu.sm.app;

import edu.sm.dto.Cart;
import edu.sm.dto.Cust;
import edu.sm.dto.Order;
import edu.sm.dto.Product;
import edu.sm.service.CartService;
import edu.sm.service.CustService;
import edu.sm.service.OrderService;
import edu.sm.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static CustService custService = new CustService();
    private static CartService cartService = new CartService();
    private static ProductService productService = new ProductService();
    private static OrderService orderService = new OrderService();
    private static Cust loggedInUser = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            if (loggedInUser == null) {
                showLoginMenu(); // 로그인 및 회원가입 메뉴
            } else {
                showMainMenu();  // 로그인 후 메인 메뉴
            }
        }
    }

    // 로그인 및 회원가입 메뉴
    private static void showLoginMenu() {
        System.out.println("\n===== 로그인 메뉴 =====");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("3. 종료");
        System.out.print("선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // 줄바꿈 문자 처리

        switch (choice) {
            case 1:
                signUp();
                break;
            case 2:
                login();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }

    // 로그인 후 메인 메뉴
    private static void showMainMenu() {
        System.out.println("\n===== 메인 메뉴 =====");
        System.out.println("1. 전체 상품 조회");
        System.out.println("2. 장바구니에 상품 추가 ");
        System.out.println("3. 장바구니 전체 상품 조회");
        System.out.println("4. 장바구니 상품 수량 수정");
        System.out.println("5. 장바구니에서 상품 제거");
        System.out.println("6. 주문 내역 보기");
        System.out.println("7. 사용자 정보 수정");
        System.out.println("8. 로그아웃");
        System.out.println("9. 종료");
        System.out.print("선택: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                viewAllProduct();
                break;
            case 2:
                addProductToCart();
            case 3:
                viewAllProductsInCart();
                break;
            case 4:
                updateCartProductQuantity();
                break;
            case 5:
                removeProductFromCart();
                break;
            case 6:
                viewAllOrder();
                break;
            case 7:
                updateUser();
                break;
            case 8:
                loggedInUser = null;
                System.out.println("로그아웃 되었습니다.");
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }

    private static void viewAllOrder() {
        List<Order> orders = null;
        try {
            orders = orderService.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (Order order : orders) {
            System.out.println(order);
        }
    }

    // 회원가입
    private static void signUp() {
        System.out.print("이메일: ");
        String email = scanner.nextLine();
        System.out.print("비밀번호: ");
        String pwd = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("주소: ");
        String address = scanner.nextLine();
        System.out.print("전화번호: ");
        String phone = scanner.nextLine();
        System.out.print("생년월일 (yyyy-MM-dd): ");
        String birthdate = scanner.nextLine();

        Cust newUser = Cust.builder()
                .email(email)
                .pwd(pwd)
                .name(name)
                .address(address)
                .phone(phone)
                .birthdate(java.sql.Date.valueOf(birthdate))
                .build();

        try {
            custService.add(newUser);
            System.out.println("회원가입 성공!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("회원가입 실패");
        }
    }

    // 로그인
    private static void login() {
        System.out.print("이메일: ");
        String email = scanner.nextLine();
        System.out.print("비밀번호: ");
        String pwd = scanner.nextLine();

        try {
            Cust user = custService.login(email, pwd);
            if (user != null) {
                loggedInUser = user;
                System.out.println("로그인 성공: " + user.getName());
            } else {
                System.out.println("로그인 실패: 이메일 또는 비밀번호를 확인하세요.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("로그인 중 오류 발생");
        }
    }

    // 사용자 정보 수정
    private static void updateUser() {
        System.out.print("새 비밀번호: ");
        String newPwd = scanner.nextLine();
        System.out.print("새 주소: ");
        String newAddress = scanner.nextLine();
        System.out.print("새 전화번호: ");
        String newPhone = scanner.nextLine();

        loggedInUser.setPwd(newPwd);
        loggedInUser.setAddress(newAddress);
        loggedInUser.setPhone(newPhone);

        try {
            custService.modify(loggedInUser);
            System.out.println("사용자 정보 수정 완료");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("사용자 정보 수정 실패");
        }
    }

    // 장바구니에 상품 추가
    private static void addProductToCart() {
        System.out.print("상품 ID: ");
        int productId = scanner.nextInt();
        System.out.print("수량: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        Cart cart = Cart.builder()
                .cId(loggedInUser.getId())   // 현재 로그인한 사용자의 ID
                .pId(productId)
                .count(count)
                .build();

        try {
            cartService.add(cart);
            System.out.println("장바구니에 상품이 추가되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("상품 추가 실패");
        }
    }

    // 특정 상품 조회
    private static void viewProductInCart() {
        System.out.print("장바구니 내 상품 ID: ");
        int cartId = scanner.nextInt();
        scanner.nextLine();

        try {
            Cart cart = cartService.get(cartId);
            System.out.println("장바구니 상품: " + cart);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("상품 조회 실패");
        }
    }

    // 장바구니 내 모든 상품 조회
    private static void viewAllProductsInCart() {
        try {
            List<Cart> carts = cartService.getCartByCustomerId(loggedInUser.getId());
            System.out.println("사용자 " + loggedInUser.getId() + "의 장바구니: " + carts);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("장바구니 조회 실패");
        }
    }

    // 장바구니 내 상품 수량 수정
    private static void updateCartProductQuantity() {
        System.out.print("수정할 장바구니 내 상품 ID: ");
        int cartId = scanner.nextInt();
        System.out.print("새 수량: ");
        int newCount = scanner.nextInt();
        scanner.nextLine();

        Cart cart = Cart.builder()
                .id(cartId)
                .count(newCount)
                .build();

        try {
            cartService.modify(cart);
            System.out.println("상품 수량이 수정되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("수량 수정 실패");
        }
    }

    // 장바구니에서 특정 상품 제거
    private static void removeProductFromCart() {
        System.out.print("삭제할 장바구니 내 상품 ID: ");
        int cartId = scanner.nextInt();
        scanner.nextLine();

        try {
            cartService.remove(cartId);
            System.out.println("장바구니에서 상품이 삭제되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("상품 삭제 실패");
        }
    }

    private static void viewAllProduct() {
        System.out.println("전체 상품들 !!");
        List<Product> products = null;
        try {
            products = productService.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (Product product : products) {
            System.out.println(product);
        }
    }
}
