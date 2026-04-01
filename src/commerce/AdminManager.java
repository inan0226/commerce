package commerce;

import java.util.List;
import java.util.Scanner;

// 관리자 업무만 전문적으로 처리하는 새로운 클래스입니다.
public class AdminManager {
    private List<Category> categories;
    private Cart cart;
    private Scanner sc;
    private final String ADMIN_PASSWORD = "admin123";

    // 생성자: 시스템으로부터 진열대(categories), 장바구니(cart), 입력기(sc)를 건네받습니다.
    public AdminManager(List<Category> categories, Cart cart, Scanner sc) {
        this.categories = categories;
        this.cart = cart;
        this.sc = sc;
    }

    // 관리자 인증 및 시작
    public void authenticateAndStart() {
        for (int i = 0; i < 3; i++) {
            System.out.print("\n관리자 비밀번호: ");
            if (ADMIN_PASSWORD.equals(sc.nextLine())) {
                System.out.println("인증 성공!");
                showAdminMenu();
                return;
            }
            System.out.println("오류! 남은 기회: " + (2 - i));
        }
        System.out.println("3회 오류. 메인으로 돌아갑니다.");
    }

    private void showAdminMenu() {
        while (true) {
            System.out.println("\n[ 관리자 모드 ] 1.추가 2.수정 3.삭제 4.현황 0.나가기");
            System.out.print("입력: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) return;
            else if (choice == 1) addProduct();
            else if (choice == 2) editProduct();
            else if (choice == 3) deleteProduct();
            else if (choice == 4) viewAllProducts();
            else System.out.println("잘못된 입력입니다.");
        }
    }

    private Product findGlobalProduct(String name) {
        for (Category c : categories) {
            Product p = c.findProductByName(name);
            if (p != null) return p;
        }
        return null;
    }

    private void addProduct() {
        System.out.println("\n어느 카테고리에 추가하시겠습니까?");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }
        System.out.print("입력: ");
        int catIdx = sc.nextInt() - 1;
        sc.nextLine();

        if (catIdx < 0 || catIdx >= categories.size()) return;
        Category targetCat = categories.get(catIdx);

        System.out.print("상품명: "); String name = sc.nextLine();
        if (targetCat.findProductByName(name) != null) { System.out.println("중복된 상품명입니다!"); return; }

        System.out.print("가격: "); int price = sc.nextInt(); sc.nextLine();
        System.out.print("설명: "); String desc = sc.nextLine();
        System.out.print("재고: "); int stock = sc.nextInt(); sc.nextLine();

        targetCat.addProduct(new Product(name, price, desc, stock));
        System.out.println("추가 완료!");
    }

    private void editProduct() {
        System.out.print("\n수정할 상품명: ");
        Product p = findGlobalProduct(sc.nextLine());

        if (p == null) { System.out.println("상품을 찾을 수 없습니다."); return; }

        System.out.println("수정할 항목 (1.가격 2.설명 3.재고): ");
        int choice = sc.nextInt(); sc.nextLine();

        if (choice == 1) { System.out.print("새 가격: "); p.setPrice(sc.nextInt()); sc.nextLine(); }
        else if (choice == 2) { System.out.print("새 설명: "); p.setDesc(sc.nextLine()); }
        else if (choice == 3) { System.out.print("새 재고: "); p.setStock(sc.nextInt()); sc.nextLine(); }
        System.out.println("수정 완료!");
    }

    private void deleteProduct() {
        System.out.print("\n삭제할 상품명: ");
        String name = sc.nextLine();

        for (Category c : categories) {
            if (c.removeProductByName(name)) {
                cart.removeIfDeleted(name);
                System.out.println("삭제 완료!");
                return;
            }
        }
        System.out.println("상품을 찾을 수 없습니다.");
    }

    private void viewAllProducts() {
        for (Category c : categories) {
            System.out.println("\n--- " + c.getName() + " ---");
            c.printProducts();
        }
    }
}