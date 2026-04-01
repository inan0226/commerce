package commerce;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        //  전자제품 데이터 준비
        List<Product> electronicsProducts = new ArrayList<>();
        electronicsProducts.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 15));
        electronicsProducts.add(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 64));
        electronicsProducts.add(new Product("MacBook Pro", 2400000, "M3 칩셋 노트북", 12));
        electronicsProducts.add(new Product("AirPods Pro", 350000, "무선 이어폰", 15));

        // 의류 데이터 준비
        List<Product> clothingProducts = new ArrayList<>();
        clothingProducts.add(new Product("후드티", 59000, "편안한 오버핏 후드티", 50));
        clothingProducts.add(new Product("티셔츠", 29000, "기본 면 티셔츠", 100));

        // 식품 데이터 준비
        List<Product> foodProducts = new ArrayList<>();
        foodProducts.add(new Product("소고기", 45000, "신선한 한우 등심 300g", 20));
        foodProducts.add(new Product("돼지고기", 15000, "국산 삼겹살 500g", 30));

        // 카테고리 폴더 만들기
        Category electronicsCategory = new Category("전자제품", electronicsProducts);
        Category clothingCategory = new Category("의류", clothingProducts);
        Category foodCategory = new Category("식품", foodProducts);

        // 전체 카테고리 묶기
        List<Category> categories = new ArrayList<>();
        categories.add(electronicsCategory);
        categories.add(clothingCategory);
        categories.add(foodCategory);

        // 시스템에 넘겨주고 가동 시작!
        CommerceSystem system = new CommerceSystem(categories);
        system.start();
    }
}