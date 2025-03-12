package com.example.kiosk;

import java.util.List;

public class Menu {

    //필드

    //카테고리명
    private String menuCategory;

    //메뉴아이템 리스트
    private List<MenuItem> menuItems;


    //생성자
    public Menu(String menuCategory, List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        this.menuCategory = menuCategory;
    }


    //게터세터
    public String getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }



    //기능들
    //카테고리별 메뉴를 출력
    public void printMenuItemList() {

        int startNo = 0;
        int endNo = this.menuItems.size();

        System.out.println("\n🍔 맘스터치 "+this.menuCategory+ " 메뉴 🍔");

        for(int i=0; i<this.menuItems.size(); i++) {
            String menuName = this.menuItems.get(i).getMenuName();
            double menuPrice = this.menuItems.get(i).getMenuPrice();
            String menuInfo = this.menuItems.get(i).getMenuInfo();

            //영어는 한 글자당 1byte
            //한글은 한 글자당 2byte

            int menuSize = 22;
            int length = menuSize - menuName.length();

            System.out.printf("%-2d. %-" + length + "s | W %3.1f | %s%n", i + 1, menuName, menuPrice, menuInfo);
        }

        System.out.println("0 . 뒤로가기               |");
        System.out.println();

    }

    
    //카테고리별 메뉴 내에서 선택한 메뉴 출력문을 반환
    public void printPickedMenu(int menuItemNum) {
        String menuName = this.menuItems.get(menuItemNum - 1).getMenuName();
        double menuPrice = this.menuItems.get(menuItemNum - 1).getMenuPrice();
        String menuInfo = this.menuItems.get(menuItemNum - 1).getMenuInfo();

        System.out.println("\n-------- 선택한 메뉴 --------");
        System.out.printf("%-2d. %-15s| W %5.1f | %s%n", menuItemNum, menuName, menuPrice, menuInfo);
        System.out.println("-----------------------------");

        System.out.println("0 . 이전으로");

    }







}
