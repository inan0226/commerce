package commerce;

import java.util.List;
import java.util.Scanner;


// CommerceSystem 클래스: 카테고리들을 관리하고 메뉴 출력 및 입력 로직을 담당합니다.

public class CommerceSystem {

    // 시스템이 관리할 카테고리 목록입니다.
    private List<Category> categories;

    // 생성자: Main에서 만든 카테고리 리스트를 전달받아 시스템을 준비시킵니다.
    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }
        Scanner sc = new Scanner(System.in);
    // 시스템의 핵심 로직(반복문, 조건문)이 시작되는 메서드입니다.
    public void start() {


        // [바깥쪽 무한루프]: 메인 카테고리 선택 화면
        while (true) {
            System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");

            // 리스트의 size만큼 반복하며 카테고리 이름을 출력합니다.
            for (int i = 0; i < categories.size(); i++) {
                Category c = categories.get(i);
                System.out.println((i + 1) + ". " + c.getName());
            }

            System.out.println("0. 종료         | 프로그램 종료");
            System.out.print("입력: ");

            int choice = sc.nextInt(); // 사용자의 메뉴 선택 입력

            if (choice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break; // 0 입력 시 바깥쪽 루프를 탈출하여 프로그램 종료
            }
            // 선택한 번호가 카테고리 범위 내에 있는지 확인
            else if (choice > 0 && choice <= categories.size()) {
                // 선택한 번호에서 1을 빼서 리스트의 인덱스(0부터 시작)로 접근합니다.
                Category selectedCategory = categories.get(choice - 1);

                // [안쪽 무한루프]: 선택된 카테고리의 상품 목록 화면
                while (true) {
                    System.out.println("\n[ " + selectedCategory.getName() + " 카테고리 ]");

                    // 해당 카테고리가 가진 상품 리스트를 가져옵니다.
                    List<Product> categoryProducts = selectedCategory.getProducts();

                    // 상품 리스트를 반복하며 상세 정보를 출력합니다.
                    for (int i = 0; i < categoryProducts.size(); i++) {
                        Product p = categoryProducts.get(i);
                        System.out.println((i + 1) + ". " + p.getName() + " | " + p.getPrice() + "원 | " + p.getStock());
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.print("입력: ");

                    int prodChoice = sc.nextInt();

                    if (prodChoice == 0) {
                        break; // 안쪽 루프만 탈출하여 다시 메인 카테고리 화면으로 이동
                    }
                    // 선택한 상품 번호가 유효한지 확인
                    else if (prodChoice > 0 && prodChoice <= categoryProducts.size()) {
                        // 실제 선택된 상품 객체를 꺼내옵니다.
                        Product selectedProduct = categoryProducts.get(prodChoice - 1);

                        // 객체의 필드값들을 조합하여 최종 정보 출력
                        System.out.println("선택한 상품: " + selectedProduct.getName() +
                                " | " + selectedProduct.getPrice() + "원" +
                                " | " + selectedProduct.getDesc() +
                                " | 재고: " + selectedProduct.getStock() + "개");
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }
}