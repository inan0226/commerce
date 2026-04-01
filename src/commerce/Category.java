package commerce;

import java.util.List;

public class Category {
    private String name;
    private List<Product> products;

    public Category(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() { return name; }
    public List<Product> getProducts() { return products; }

    public void printProducts() {
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println((i + 1) + ". " + p.getName() + " | " + p.getPrice() + "원 | 재고: " + p.getStock() + "개");
        }
    }

    //  이름으로 상품을 찾는 책임을 카테고리가 가집니다.
    public Product findProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) return p;
        }
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    //  상품 삭제도 카테고리가 직접 처리하고 성공 여부를 알려줍니다.
    public boolean removeProductByName(String name) {
        Product p = findProductByName(name);
        if (p != null) {
            products.remove(p);
            return true;
        }
        return false;
    }
}