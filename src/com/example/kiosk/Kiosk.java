package com.example.kiosk;

import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    
    // 메뉴 리스트
    private List<Menu> menus;

    //메뉴 리스트의 게터 세터
    public List<Menu> getMenus() {
        return menus;
    }
    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    
    //키오스크 시작하는 메서드
    public void start() {

        //키오스크 인트로 출력문
        printBurgerMain();
        
        Scanner scanner = new Scanner(System.in);

        //필요한 변수들 전역변수로 선언 및 초기화
        boolean mainMenuPrinting = true;
        boolean categoryMenuPrinting =true;
        boolean backButton = true;
        boolean exitKiosk = false;
        boolean exitCategory = false;
        int mainNum=0;
        int menuItemNum = 0;
        Menu pickedCategory = null;

        //메뉴 고르기
        while (!exitKiosk) {

            //메인메뉴로 돌아왔을 때 데이터가 꼬이지 않도록 재초기화
            mainNum=0;
            menuItemNum = 0;
            pickedCategory = null;
            exitCategory = false;


            //메인 메뉴 출력
            if(mainMenuPrinting) {
                System.out.println("\n🍔 맘스터치 메뉴 🍔");
                for(int i=0; i<this.menus.size(); i++) {
                    String menuCategory = this.menus.get(i).getMenuCategory();
                    System.out.println((i+1)+". " + menuCategory);
                }
                System.out.println("0. 종료\n");
            }


            //메인 메뉴 입력

            //입력값 검사 메서드 호출
            mainNum = checkingInput(scanner,1, this.menus.size());

            if (mainNum >= 1 && mainNum <= this.menus.size()) {
                pickedCategory = this.menus.get(mainNum - 1);
            } else if (mainNum == 0) {
                System.out.println("키오스크를 종료합니다.");
                exitKiosk = true;
                break; //꼭 break을 해줘야 다음 로직으로 안넘어감
            }


            //카테고리(햄버거,음료,사이드) 별 메뉴 출력 및 입력 while문
            //exitCategory = true면 빠져나갈 수 있음
            while (!exitCategory) {

                //선택한 카테고리 메뉴 출력

                // CategoryMenuPrinting -> 이 boolean으로 인해 입력값을 잘못 입력했을 때
                // 메뉴 화면을 다시 보여주는게 아니라 숫자 입력만 다시 할 수 있도록 유도함
                // 콘솔 화면 정리를 함
                if (categoryMenuPrinting) {
                    pickedCategory.printMenuItemList();
                }

                //선택한 카테고리 내 메뉴 선택

                //입력값 검사 메서드 호출 (int반환)
                menuItemNum = checkingInput(scanner, 1,5);

                if (menuItemNum >= 1 && menuItemNum <= 5) {
                    pickedCategory.printPickedMenu(menuItemNum);
                    break;
                } else if (menuItemNum == 0) {
                    System.out.println("메인메뉴로 돌아갑니다.");
                    exitCategory = true;
                } else {
                    categoryMenuPrinting = false;
                }

            }

        }
        //스캐너 닫기
        scanner.close();
    }

    //입력값 예외 처리 로직
    public int checkingInput(Scanner scanner, int startNo, int endNo) {

        int input = 0;

        while (true) {

            try {
                System.out.print(startNo + "~" + endNo + " 사이의 숫자를 입력해주세요: ");
                input = scanner.nextInt();

                if (input >= startNo && input <= endNo) {
                    return input;
                } else if (input == 0) {
                    return input;
                } else {
                    throw new IllegalArgumentException();
                }

            } catch (InputMismatchException e) {
                System.out.println("\n❌ 숫자만 입력해주세요\n");
                scanner.next();//버퍼비우기
            } catch (IllegalArgumentException e) {
                System.out.println("\n❌" + startNo + "~" + endNo + "사이에서 다시 입력해주세요.\n");
            }

        }

    }


    //메인메뉴 전 키오스크 인트로 출력 반환
    public void printBurgerMain() {
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔   햄버거 드실라우  🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
    }




}
