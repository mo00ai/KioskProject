package com.example.kiosk;

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

        //        System.out.println("==============================================");
//        System.out.println("==============================================");
//        System.out.println("--------------맘스터치에 어서오세요--------------");
//        System.out.println("==============================================");
//        System.out.println("================---------------===============");
//        System.out.println("================---1.메뉴보기---===============");
//        System.out.println("================-----0.종료-----===============");
//        System.out.println("================---------------===============");
//        System.out.println("==============================================");

        //list 선언 및 초기화
        //add 함수를 통해 new MenuOtem(이름,가격,설명) list 추가
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("싸이버거", 4.9,"매콤한 통다리살 패티가 통째로~ 맘스터치 시그니처 버거"));
        menuItems.add(new MenuItem("불싸이버거", 5.1,"불 맛이 살아있는 싸이버거의 진또배기"));
        menuItems.add(new MenuItem("화이트갈릭버거", 4.9,"크림처럼 부드러운 화이트갈릭 소스에 통가슴살"));
        menuItems.add(new MenuItem("통새우버거", 4.9,"통새우살 패티에 신선한 양상추는 덤~"));
        menuItems.add(new MenuItem("딥치즈버거", 4.9,"부드러운 치즈와 한층 더 촉촉해진 닭가슴살"));



        Scanner scanner = new Scanner(System.in);









        //메뉴 고르기
        while(true) {
            try {

                //메뉴들 출력
                System.out.println(" 🍔 맘스터치 메뉴 🍔 ");

                for(int i = 0; i<menuItems.size(); i++) {

                    String menuName = menuItems.get(i).getMenuName();
                    double menuPrice = menuItems.get(i).getMenuPrice();
                    String menuInfo = menuItems.get(i).getMenuInfo();

                    System.out.printf("%-2d. %-15s| W %5.1f | %s%n", i+1, menuName, menuPrice, menuInfo);
                }

                System.out.println("0 . 종료               |  종료");
                System.out.println();


                System.out.print("1~5 또는 0을 입력하세요: ");
                int num = scanner.nextInt();

                if (num == 1) {
                    System.out.println("\n-------- 선택한 메뉴 --------");
                    String menuName = menuItems.get(num-1).getMenuName();
                    double menuPrice = menuItems.get(num-1).getMenuPrice();
                    String menuInfo = menuItems.get(num-1).getMenuInfo();
                    System.out.printf("%-2d. %-15s| W %5.1f | %s%n", num, menuName, menuPrice, menuInfo);

                    System.out.println("\n0. 종료");
                    System.out.println("9. 이전으로");

                    System.out.print("\n입력 : ");
                    num = scanner.nextInt();

                    if(num == 0) {
                        System.out.println("\n종료합니다.");
                        break;
                    } else if (num == 9) {
                        System.out.println("\n메뉴화면으로 돌아갑니다.\n");
                    }
                } else if (num == 2) {
                    System.out.println("2. 불싸이버거");
                    break;
                } else if (num == 3) {
                    System.out.println("3. 화이트갈릭버거");
                    break;
                } else if (num == 4) {
                    System.out.println("4. 통새우버거");
                    break;
                } else if (num == 5) {
                    System.out.println("5. 딥치즈버거");
                    break;
                } else if (num == 0) {
                    System.out.println("종료");
                    break;
                } else {
                    System.out.println("\n❌ 1~5 사이에서 다시 입력해주세요.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n❌ 숫자만 입력해주세요\n");
                scanner.next();//버퍼비우기
            }
        }




    }
}

