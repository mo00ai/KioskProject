package com.example.kiosk;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

public enum Discount {
    NATIONAL(10),
    ARMY(5),
    STUDENT(3),
    NORMAL(0);

    private int percentage;

    Discount(int percentage) {
        this.percentage = percentage;
    }

    public static Discount selectDiscount(int discountNum) {
        Discount[] discounts = Discount.values();
        return discounts[discountNum-1];
    }

    public int getPercentage() {
        return percentage;
    }

//    public static double getDisCountedPrice(double price) {
//        return price * ((100-this.percentage) * 0.01);
//    }

    public static void printDiscountList() {

        System.out.println("\n-----------------------------------");
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("-----------------------------------");
        System.out.printf("1. 국가유공자   : %d%%%n", NATIONAL.percentage);
        System.out.printf("2. 군인        : %d%%%n", ARMY.percentage);
        System.out.printf("3. 학생        : %d%%%n", STUDENT.percentage);
        System.out.printf("4. 일반        : %d%%%n", NORMAL.percentage);
        System.out.println("-----------------------------------");
    }


}
