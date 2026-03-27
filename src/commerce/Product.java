package commerce;

/**
 * Product 클래스: 개별 상품의 정보를 저장하는 '설계도'입니다.
 */
public class Product {
    // 필드(속성): 객체가 가지는 데이터들입니다.
    private String name;   // 상품명
    private int price;     // 가격
    private String desc;   // 상품 설명
    private int stock;     // 재고 수량

    // 생성자(Constructor): 'new Product(...)'를 호출할 때 실행되는 특수 메서드입니다.
    // 외부에서 전달받은 값들을 이 객체의 실제 데이터(this.필드)로 채워주는 역할을 합니다.
    public Product(String name, int price, String desc, int stock) {
        this.name = name;   // this는 '현재 생성된 이 객체'를 가리킵니다.
        this.price = price;
        this.desc = desc;
        this.stock = stock;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getDesc() {
        return desc;
    }
    public int getStock() {
        return stock;
    }
}