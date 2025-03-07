package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;

public class Kiosk {
    MenuItem menuItem;

    //프로그램 순서 및 흐름 제어를 담당하는 클래스
    private List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void insertBurgers() {

        MenuItem menuItem1 = new MenuItem("싸이버거", 4.9,"매콤한 통다리살 패티가 통째로~ 맘스터치 시그니처 버거");
        MenuItem menuItem2 =new MenuItem("불싸이버거", 5.1,"불 맛이 살아있는 싸이버거의 진또배기");
        MenuItem menuItem3 = new MenuItem("화이트갈릭버거", 4.9,"크림처럼 부드러운 화이트갈릭 소스에 통가슴살");
        MenuItem menuItem4 = new MenuItem("통새우버거", 4.9,"통새우살 패티에 신선한 양상추는 덤~");
        MenuItem menuItem5 = new MenuItem("딥치즈버거", 4.9,"부드러운 치즈와 한층 더 촉촉해진 닭가슴살");

        Kiosk kiosk = new Kiosk(List.of(menuItem1, menuItem2, menuItem3,menuItem4,menuItem5));

    }

    public void start() {

        insertBurgers();



    }
}
