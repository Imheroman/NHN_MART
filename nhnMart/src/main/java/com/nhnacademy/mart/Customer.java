package com.nhnacademy.mart;

import java.util.ArrayList;

public class Customer {

    // 고객 구매 목록
    private final BuyList buyList;

    // 고객 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    // TODO pickFoods 메서드 구현
    public void pickFoods(FoodStand foodStand) {
        ArrayList<BuyList.Item> items = buyList.getItems();
        ArrayList<Food> foods = foodStand.getFoods();


        for (BuyList.Item item : items) {
            String name = item.getName();
            int price = 0;
//            int price = item.getAmount(); // foodStand.
            for (Food food : foods) {
                if (food.getName().equals(name)) {
                    price = item.getAmount() * food.getPrice();
                    break;
                }
            }

            System.out.println("name: " + name + ", price: " + price);
            basket.add(new Food(name, price));
        }
    }

    // TODO payTox 메서드 구현


}
