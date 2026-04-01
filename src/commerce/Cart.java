package commerce;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void clear() { items.clear(); }
    public boolean isEmpty() { return items.isEmpty(); }

    public int calculateTotal() {
        int total = 0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    public void printReceipt() {
        for (CartItem item : items) {
            Product p = item.getProduct();
            System.out.println(p.getName() + " | " + p.getPrice() + "원 | 수량: " + item.getQuantity() + "개");
        }
    }

    public void processPayment() {
        for (CartItem item : items) {
            item.getProduct().reduceStock(item.getQuantity());
        }
        items.clear();
    }

    //  관리자가 상품을 지웠을 때, 이름만 넘겨주면 장바구니가 알아서 지웁니다.
    public void removeIfDeleted(String productName) {
        items.removeIf(item -> item.getProduct().getName().equals(productName));
    }
}