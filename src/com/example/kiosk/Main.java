package com.example.kiosk;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // List 선언 및 초기화
        // add 함수를 통해 new MenuItem(이름, 가격, 설명) List에 삽입

        // Scanner 선언

        // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
        // 숫자를 입력 받기
        // 입력된 숫자에 따른 처리
        // 프로그램을 종료
        // 선택한 메뉴 : 이름, 가격, 설명

        MenuItem menuItem1 = new MenuItem("싸이버거", 4.9,"매콤한 통다리살 패티가 통째로~ 맘스터치 시그니처 버거");
        MenuItem menuItem2 =new MenuItem("불싸이버거", 5.1,"불 맛이 살아있는 싸이버거의 진또배기");
        MenuItem menuItem3 = new MenuItem("화이트갈릭버거", 4.9,"크림처럼 부드러운 화이트갈릭 소스에 통가슴살");
        MenuItem menuItem4 = new MenuItem("통새우버거", 4.9,"통새우살 패티에 신선한 양상추는 덤~");
        MenuItem menuItem5 = new MenuItem("딥치즈버거", 4.9,"부드러운 치즈와 한층 더 촉촉해진 닭가슴살");

        List<MenuItem> menuItems = new ArrayList<>(List.of(menuItem1,menuItem2,menuItem3,menuItem4,menuItem5));
        Kiosk kiosk = new Kiosk(menuItems);

        kiosk.start();

    }
}

