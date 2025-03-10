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








}
