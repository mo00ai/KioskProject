package com.example.kiosk;

import java.util.List;

public class Menu {
    //카테고리 이름 필드 추가
    //MenuItem 클래스를 list로 관리
    
    //MenuItem 클래스를 관리하는 클래스
    //예시 : 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함합니다.
    private String menuCategory;

    //프로그램 순서 및 흐름 제어를 담당하는 클래스
    private List<MenuItem> menuItems;



    public Menu(String menuCategory, List<MenuItem> menuItems) {
        this.menuItems = menuItems;
        this.menuCategory = menuCategory;
    }

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

    public void addMenuList(Menu menu) {

    }


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

    public void printPickedMenu(int menuItemNum) {
        String menuName = this.menuItems.get(menuItemNum - 1).getMenuName();
        double menuPrice = this.menuItems.get(menuItemNum - 1).getMenuPrice();
        String menuInfo = this.menuItems.get(menuItemNum - 1).getMenuInfo();

        System.out.println("\n-------- 선택한 메뉴 --------");
        System.out.printf("%-2d. %-15s| W %5.1f | %s%n", menuItemNum, menuName, menuPrice, menuInfo);
        System.out.println("\n----------------------------");

        System.out.println("0 . 이전으로");

    }







}
