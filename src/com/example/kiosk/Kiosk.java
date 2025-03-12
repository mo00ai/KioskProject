package com.example.kiosk;

import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    MenuItem menuItem;

    Menu menu;

    private List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔   햄버거 드실라우  🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");
        System.out.println("🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔🍔");


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
            while(true) {
                try {

                    System.out.print("1~" + this.menus.size() + " 사이의 숫자를 입력해주세요: ");
                    mainNum = scanner.nextInt();

                    if (mainNum >= 1 && mainNum <= this.menus.size()) {
                        pickedCategory = this.menus.get(mainNum - 1);
                        break;
                    } else if (mainNum == 0) {
                        System.out.println("키오스크를 종료합니다.");
                        exitKiosk = true;
                        break;
                    } else {
                        System.out.println("\n❌ 1~" + this.menus.size() + "사이에서 다시 입력해주세요.\n");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("\n❌ 숫자만 입력해주세요\n");
                    scanner.next();//버퍼비우기
                }
            }


            while (!exitCategory) {
                //선택한 카테고리 메뉴 출력
                if (categoryMenuPrinting) {
                    pickedCategory.printMenuItemList();
                }

                //선택한 카테고리 내 메뉴 선택
                try {
                    System.out.print("1~5 또는 0을 입력하세요: ");
                    menuItemNum = scanner.nextInt();

                    if (menuItemNum >= 1 && menuItemNum <= 5) {
                        pickedCategory.printPickedMenu(menuItemNum);
                    } else if (menuItemNum == 0) {
                        System.out.println("메인메뉴로 돌아갑니다.");
                        exitCategory = true;
                    } else {
                        System.out.println("\n❌ 1~5 사이에서 다시 입력해주세요.\n");
                        categoryMenuPrinting = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\n❌ 숫자만 입력해주세요\n");
                    scanner.next();//버퍼비우기
                }

            }


        }
        scanner.close();
    }

    //입력값 예외 처리 로직
    public int checkingInput(Scanner scanner, int startNo, int endNo, Menu pickedCategory, boolean exitKiosk) {

        int input = 0;

        while (true) {

            try {
                if (pickedCategory == null) {

                    System.out.print("1~" + this.menus.size() + " 사이의 숫자를 입력해주세요: ");
                    input = scanner.nextInt();
                    
                    if (input >= 1 && input <= this.menus.size()) {
                        pickedCategory = this.menus.get(input - 1);
                        break;
                    } else if (input == 0) {
                        System.out.println("키오스크를 종료합니다.");
                        exitKiosk = true;
                        break;
                    } else {
                        System.out.println("\n❌ 1~" + this.menus.size() + "사이에서 다시 입력해주세요.\n");
                    }

                } else {

                    System.out.print("1~5 또는 0을 입력하세요: ");
                    input = scanner.nextInt();

                    if (input >= 1 && input <= 5) {
                        pickedCategory.printPickedMenu(input);
                    } else if (input == 0) {
                        System.out.println("메인메뉴로 돌아갑니다.");
                        exitCategory = true;
                    } else {
                        System.out.println("\n❌ 1~5 사이에서 다시 입력해주세요.\n");
                        categoryMenuPrinting = false;
                    }

                }

            } catch (InputMismatchException e) {
                System.out.println("\n❌ 숫자만 입력해주세요\n");
                scanner.next();//버퍼비우기
            }

        }


    }

}
