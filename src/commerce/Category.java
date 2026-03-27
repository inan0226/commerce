package commerce;

import java.util.List;


 // Category 클래스: 여러 Product 객체들을 하나의 그룹(전자제품 등)으로 묶어주는 역할입니다.

public class Category {
    private String name;            // 카테고리 이름
    private List<Product> products; // 이 카테고리에 속한 상품 리스트 (객체 간의 포함 관계)

    // 생성자: 카테고리 이름과 그 안에 들어갈 상품 리스트를 받아서 초기화합니다.
    public Category(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    // Getter 메서드: private으로 보호된 필드 값을 외부에서 읽을 수 있게 해줍니다.
    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        return this.products;
    }
}