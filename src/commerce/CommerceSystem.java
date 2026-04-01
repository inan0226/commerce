package commerce;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    private List<Category> categories;
    private Cart cart = new Cart();
    private Scanner sc = new Scanner(System.in);

    // 💡 [핵심] 관리자 전담 직원을 고용합니다!
    private AdminManager adminManager;

    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
        // 시스템 시작 시, 전담 직원에게 진열대와 장바구니 정보를 줘서 출근시킵니다.
        this.adminManager = new AdminManager(categories, cart, sc);
    }

    public void start() {
        while (true) {
            showMainMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) {
                System.out.println("종료합니다.");
                break;
            } else if (choice > 0 && choice <= categories.size()) {
                handleCategory(categories.get(choice - 1));
            } else if (choice == 4 && !cart.isEmpty()) {
                handleOrder();
            } else if (choice == 5 && !cart.isEmpty()) {
                cart.clear();
                System.out.println("장바구니를 비웠습니다.");
            } else if (choice == 6) {
                // 💡 [핵심] 사용자가 6번을 누르면? "어이, 관리자 직원! 네가 처리해!" 하고 넘겨버립니다.
                adminManager.authenticateAndStart();
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n[ 메인 메뉴 ]");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }
        System.out.println("0. 종료");
        if (!cart.isEmpty()) System.out.println("4. 장바구니 확인 | 5. 주문 취소");
        System.out.println("6. 관리자 모드");
        System.out.print("입력: ");
    }

    // 아래는 오직 '일반 손님'을 위한 로직만 남았습니다.
    private void handleCategory(Category category) {
        while (true) {
            System.out.println("\n[ " + category.getName() + " ]");
            category.printProducts();
            System.out.print("0. 뒤로가기 / 상품번호 입력: ");

            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 0) return;

            if (choice > 0 && choice <= category.getProducts().size()) {
                Product selected = category.getProducts().get(choice - 1);
                System.out.print(selected.getName() + "를 담으시겠습니까? (1.확인 2.취소): ");
                if (sc.nextInt() == 1) {
                    sc.nextLine();
                    if (selected.getStock() > 0) {
                        cart.addProduct(selected, 1);
                        System.out.println("장바구니 추가 완료!");
                    } else System.out.println("재고가 부족합니다!");
                } else sc.nextLine();
            }
        }
    }

    private void handleOrder() {
        System.out.println("\n[ 장바구니 확인 ]");
        cart.printReceipt();
        System.out.println("총 금액: " + cart.calculateTotal() + "원");
        System.out.print("1. 주문 확정 2. 돌아가기: ");
        if (sc.nextInt() == 1) {
            sc.nextLine();
            cart.processPayment();
            System.out.println("주문 완료!");
        } else sc.nextLine();
    }
}