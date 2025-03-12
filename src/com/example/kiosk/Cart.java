package com.example.kiosk;

import java.util.LinkedList;
import java.util.List;

public class Cart {

    Menu menu;
    MenuItem menuItem;

    private List<MenuItem> cartList = new LinkedList<>();

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
        System.out.println("\n🍔 장바구니 🍔");
        for(MenuItem item : this.cartList) {
            System.out.printf(" %-15s| W %5.1f | %s%n", item.getMenuName(), item.getMenuPrice(), item.getMenuInfo());
        }
        System.out.println("\n 총금액 : "+ getTotalPrice());
        System.out.println();
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
