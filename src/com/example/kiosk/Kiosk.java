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
        boolean cartExist = false;
        boolean readyOrder = false;
        boolean isMainMenu = false;
        int mainNum=0;
        int menuItemNum = 0;
        Menu pickedCategory = null;

        Cart cartList = new Cart();

        //메뉴 고르기
        while (!exitKiosk) {

            //메인메뉴로 돌아왔을 때 데이터가 꼬이지 않도록 재초기화
            mainNum=0;
            menuItemNum = 0;
            pickedCategory = null;
            exitCategory = false;


//            //메인 메뉴 출력
//            if(mainMenuPrinting) {
                System.out.println("\n🍔 맘스터치 메뉴 🍔");
                for(int i=0; i<this.menus.size(); i++) {
                    String menuCategory = this.menus.get(i).getMenuCategory();
                    System.out.println((i+1)+". " + menuCategory);
                }

                if(!cartExist) {
                    System.out.println("0. 종료\n");
                }

                if (cartExist) {
                    System.out.println("\n🍔 주문/장바구니 확인 🍔");
                    System.out.println(this.menus.size()+1 + ". Orders   | 장바구니를 확인 후 주문합니다");
                    System.out.println(this.menus.size()+2 + ". Cancel   | 주문을 취소합니다.");
                    System.out.println("0. 종료\n");
                }
//            }


            //메인 메뉴 입력

            //입력값 검사 메서드 호출
            isMainMenu = true;
            mainNum = checkingInput(scanner,1, this.menus.size(), cartExist,  isMainMenu);

            if (mainNum >= 1 && mainNum <= this.menus.size()) {
                pickedCategory = this.menus.get(mainNum - 1);
                readyOrder = false;
            } else if (mainNum == 0) {
                System.out.println("키오스크를 종료합니다.");
                exitKiosk = true;
                break; //꼭 break을 해줘야 다음 로직으로 안넘어감
            } else if(mainNum == 4) {
                cartList.printCartList();
                readyOrder = true;
            } else if( mainNum == 5) {
                System.out.println("주문 취소 되었습니다.");
                System.out.println("메인메뉴로 돌아갑니다.");
                cartList.makeEmptyCart(); //장바구니 비우기
                cartExist = false;
                exitCategory = true;
            }



            //주문을 클릭할시 실행되는 코드블록
            if(readyOrder) {
                isMainMenu = false;
                int orderNum = checkingInput(scanner, 1,2, cartExist, isMainMenu);

                if(orderNum == 1) {
                    Discount.printDiscountList();

                    int discountNum = checkingInput(scanner, 1, 4, cartExist, isMainMenu);

                    Discount myDiscount = Discount.selectDiscount(discountNum);

                    if(discountNum == 4) {
                        System.out.println("\n주문이 완료되었습니다. 금액은 W " + cartList.getTotalPrice()+" 입니다.");
                    } else {
                        System.out.println("\n주문이 완료되었습니다. 금액은 W " + cartList.getDisCountedPrice(myDiscount)+" 입니다.");
                    }

                    exitKiosk = true;
                    break;
                } else if (orderNum == 2) {
                    exitCategory = true;
                }


            }



            while (!exitCategory) {


                if (categoryMenuPrinting) {
                    pickedCategory.printMenuItemList();
                }

                //선택한 카테고리 내 메뉴 선택

                //입력값 검사 메서드 호출 (int반환)
                isMainMenu = false;
                menuItemNum = checkingInput(scanner, 1,5, cartExist,  isMainMenu);

                if (menuItemNum >= 1 && menuItemNum <= 5) {
                    pickedCategory.printPickedMenu(menuItemNum);
                } else if (menuItemNum == 0) {
                    System.out.println("메인메뉴로 돌아갑니다.");
                    exitCategory = true;
                } else {
                    categoryMenuPrinting = false;
                }





                //장바구니 추가 할건지 입력
                int num = checkingInput(scanner, 1, 2, cartExist, isMainMenu);

                if(num == 1) {
                    pickedCategory.printAddedCartMenu(menuItemNum);

                    //장바구니 추가
                    cartList.addCartList(this.menus.get(mainNum-1).getMenuItems().get(menuItemNum-1));

                    exitCategory = true;
                    cartExist = true;
                } else if (num == 2) {
                    categoryMenuPrinting = true;
                }

            }

        }

        //스캐너 닫기
        scanner.close();
    }







    //입력값 예외 처리 로직
    public int checkingInput(Scanner scanner, int startNo, int endNo, boolean cartExist, boolean isMainMenu) {

        int input = 0;

        while (true) {

            try {

                if(isMainMenu && cartExist) {
                    System.out.print(startNo + "~" + (endNo + 2) + " 사이의 숫자를 입력해주세요 : ");
                    input = scanner.nextInt();
                } else {
                    System.out.print(startNo + "~" + endNo + " 사이의 숫자를 입력해주세요: ");
                    input = scanner.nextInt();
                }



                if (input >= startNo && input <= endNo) {
                    return input;
                } else if (input == 0) {
                    return input;
                } else if ((input == endNo + 1 || input == endNo + 2) && cartExist ) {
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
