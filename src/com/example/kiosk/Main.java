package com.example.kiosk;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        //Menu들 MenuItem에 등록
//        MenuItem menuItem1 = new MenuItem("싸이버거", 4.9,"매콤한 통다리살 패티가 통째로~ 맘스터치 시그니처 버거");
//        MenuItem menuItem2 =new MenuItem("불싸이버거", 5.1,"불 맛이 살아있는 싸이버거의 진또배기");
//        MenuItem menuItem3 = new MenuItem("화이트갈릭버거", 4.9,"크림처럼 부드러운 화이트갈릭 소스에 통가슴살");
//        MenuItem menuItem4 = new MenuItem("통새우버거", 4.9,"통새우살 패티에 신선한 양상추는 덤~");
//        MenuItem menuItem5 = new MenuItem("딥치즈버거", 4.9,"부드러운 치즈와 한층 더 촉촉해진 닭가슴살");
//
//        //MenuItem을 관리하는 List에 등록
//        List<MenuItem> menuItems = new ArrayList<>(List.of(menuItem1,menuItem2,menuItem3,menuItem4,menuItem5));
//
//        //kiosk 객체 생성
//        Kiosk kiosk = new Kiosk(menuItems);
//
//        //키오스크 실행
//        kiosk.start();


        //---------------------------------------------------------//


        // Menu 객체 생성하면서 카테고리 이름 설정
        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입

        // Kiosk 객체 생성
        // Kiosk 내 시작하는 함수 호출


        //햄버거
        MenuItem burger1 = new MenuItem("싸이버거", 4.9,"매콤한 통다리살 패티가 통째로~ 맘스터치 시그니처 버거");
        MenuItem burger2 =new MenuItem("불싸이버거", 5.1,"불 맛이 살아있는 싸이버거의 진또배기");
        MenuItem burger3 = new MenuItem("화이트갈릭버거", 4.9,"크림처럼 부드러운 화이트갈릭 소스에 통가슴살");
        MenuItem burger4 = new MenuItem("통새우버거", 4.9,"통새우살 패티에 신선한 양상추는 덤~");
        MenuItem burger5 = new MenuItem("딥치즈버거", 4.9,"부드러운 치즈와 한층 더 촉촉해진 닭가슴살");

        Menu burgers = new Menu("햄버거",List.of(burger1,burger2,burger3,burger4,burger5));


        MenuItem beverage1 = new MenuItem("펩시콜라", 1.6, "355ml");
        MenuItem beverage2 = new MenuItem("펩시콜라제로", 1.6, "355ml");
        MenuItem beverage3 = new MenuItem("사이다", 1.6, "355ml");
        MenuItem beverage4 = new MenuItem("청포도에이드", 2.2, "355ml");
        MenuItem beverage5 = new MenuItem("레몬에이드", 2.2, "355ml");

        Menu beverages = new Menu("음료", List.of(beverage1,beverage2,beverage3,beverage4,beverage5));


        MenuItem side1 = new MenuItem("코울슬로", 1.9, "입맛을 돋우는 양배추의 아삭한 식감과 상큼함");
        MenuItem side2 = new MenuItem("콘샐러드", 1.9, "달콤한 스위트콘에 신선한 야채가 어우러진다");
        MenuItem side3 = new MenuItem("바삭한크림치즈볼", 2.1, "달콤한 치즈의 풍미를 바삭하고 쫀득하게 즐기자");
        MenuItem side4 = new MenuItem("케이준양념감자(중)", 2.1, "케이준 스타일의 바삭한 양념감자 (중)");
        MenuItem side5 = new MenuItem("케이준양념감자(대)", 3.6, "케이준 스타일의 바삭한 양념감자 (대)");

        Menu sides = new Menu("사이드",List.of(side1,side2,side3,side4,side5));




        Kiosk kiosk = new Kiosk();
        kiosk.setMenus(List.of(burgers,beverages,sides));

        kiosk.start();


    }
}

