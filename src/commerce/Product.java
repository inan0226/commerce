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

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getStock() {
        return this.stock;
    }
}

