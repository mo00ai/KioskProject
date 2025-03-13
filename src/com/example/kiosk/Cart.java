package com.example.kiosk;

import java.util.*;

public class Cart {

    Menu menu;
    MenuItem menuItem;

    private List<MenuItem> cartList = new LinkedList<>();

    public Map<MenuItem, Integer> getCartQuantityList() {
        return cartQuantityList;
    }

    public void setCartQuantityList(Map<MenuItem, Integer> cartQuantityList) {
        this.cartQuantityList = cartQuantityList;
    }

    private Map<MenuItem,Integer> cartQuantityList = new HashMap<>();

    public List<MenuItem> getCartList() {
        return cartList;
    }

    public void setCartList(List<MenuItem> cartList) {
        this.cartList = cartList;
    }

    public void addCartList (MenuItem item) {

        this.cartList.add(item);
    }

    public void printCartList() {
        System.out.println("\n--------------------------------------------------------");
        System.out.println("🍔 장바구니 🍔");
        System.out.println("--------------------------------------------------------");
        for(MenuItem item : this.cartList) {
            Integer count = cartQuantityList.get(item);
            if(count == null) {
                cartQuantityList.put(item, 1);
            } else {
                cartQuantityList.put(item, count + 1);
            }
        }

        for(MenuItem item : this.cartQuantityList.keySet()) {
            System.out.printf(" %-15s| W %5.1f | 수량: %d | %s%n", item.getMenuName(), item.getMenuPrice(), cartQuantityList.get(item).intValue(), item.getMenuInfo());
        }
        System.out.println("--------------------------------------------------------");
        System.out.println(" 총금액 : "+ getTotalPrice());
        System.out.println("--------------------------------------------------------");
        System.out.println("1. 주문          | 2. 메뉴판 돌아가기");
        System.out.println();
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for(MenuItem item : this.cartList) {
            totalPrice += item.getMenuPrice();
        }
        return  totalPrice;
    }

    public void makeEmptyCart() {
        this.cartList.clear();
    }
}
