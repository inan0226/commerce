package commerce;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private List<Category> categories;

    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");

            for (int i = 0; i < categories.size(); i++) {
                Category c = categories.get(i);
                System.out.println((i + 1) + ". " + c.getName());
            }

            System.out.println("0. 종료         | 프로그램 종료");
            System.out.print("입력: ");

            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            } else if (choice > 0 && choice <= categories.size()) {
                Category selectedCategory = categories.get(choice - 1);

                while (true) {
                    System.out.println("\n[ " + selectedCategory.getName() + " 카테고리 ]");

                    List<Product> categoryProducts = selectedCategory.getProducts();

                    for (int i = 0; i < categoryProducts.size(); i++) {
                        Product p = categoryProducts.get(i);
                        System.out.println((i + 1) + ". " + p.getName() + " | " + p.getPrice() + "원 | " + p.getDesc());
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.print("입력: ");

                    int prodChoice = sc.nextInt();

                    if (prodChoice == 0) {
                        break;
                    } else if (prodChoice > 0 && prodChoice <= categoryProducts.size()) {
                        Product selectedProduct = categoryProducts.get(prodChoice - 1);

                        System.out.println("선택한 상품: " + selectedProduct.getName() + " | " + selectedProduct.getPrice() + "원 | " + selectedProduct.getDesc() + " | 재고: " + selectedProduct.getStock() + "개");
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    }
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }

        }
    }
}