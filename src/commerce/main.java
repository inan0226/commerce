package commerce;

import java.util.ArrayList;
import java.util.List;


public class main {
    public static void main(String[] args) {

        List<Product> electronicsProducts = new ArrayList<>();
        electronicsProducts.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10));
        electronicsProducts.add(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 10));
        electronicsProducts.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 10));
        electronicsProducts.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 10));


        Category electronicsCategory = new Category("전자제품", electronicsProducts);
        Category clothingCategory= new Category("의류", new ArrayList<>());
        Category foodCategory = new Category("식품", new ArrayList<>());


        List<Category> categories = new ArrayList<>();
        categories.add(electronicsCategory);
        categories.add(clothingCategory);
        categories.add(foodCategory);


        CommerceSystem system = new CommerceSystem(categories);
        system.start();
    }
}
