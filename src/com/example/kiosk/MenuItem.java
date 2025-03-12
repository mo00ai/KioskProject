package com.example.kiosk;

public class MenuItem {
    //세부 메뉴 속성
    //햄버거의 이름, 가격 설명
    //예시 > ShackBurger, 6.9, 토마토, 양상추, 쉑소스가 토핑된 치즈버거
    //new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거")


    //필드
    private String menuName;
    private double menuPrice;
    private String menuInfo;


    //메뉴아이템 생성자
    public MenuItem(String menuName, double menuPrice, String menuInfo) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuInfo = menuInfo;
    }
    


    //게터 세터
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(double menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getMenuInfo() {
        return menuInfo;
    }

    public void setMenuInfo(String menuInfo) {
        this.menuInfo = menuInfo;
    }




}
