package commerce;

public class Product {
    private String name;
    private int price;
    private String desc;
    private int stock;

    public Product(String name, int price, String desc, int stock) {
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.stock = stock;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getDesc() { return desc; }
    public int getStock() { return stock; }

    // 결제 시 재고 차감
    public void reduceStock(int amount) { this.stock -= amount; }

    // 관리자용 수정 메서드
    public void setPrice(int price) { this.price = price; }
    public void setDesc(String desc) { this.desc = desc; }
    public void setStock(int stock) { this.stock = stock; }
}