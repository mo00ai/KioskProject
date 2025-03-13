package com.example.kiosk;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    
    //메뉴 리스트
    private List<Menu> menus;

    //메뉴 리스트의 게터 세터
    public List<Menu> getMenus() {
        return menus;
    }
    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    
    //키오스크 실행 메서드
    public void start() {

        Scanner scanner = new Scanner(System.in);

        //필요한 변수들 전역변수로 선언 및 초기화
        boolean isKioskOff = false;
        boolean isCartEmpty = true;
        int mainNum=0;
        Cart cart = new Cart();


        //키오스크 인트로 출력문
        printBurgerMain();

        //메인메뉴 고르기
        while (!isKioskOff) {

            //루프 돌았을 때 장바구니가 비었는지 확인
            if(cart.getCartList().isEmpty()) {
                isCartEmpty = true;
            } else {
                isCartEmpty = false;
            }


            //메인 메뉴 출력 메서드
            //장바구니에 상품이 있을시엔 Orders, Cancel도 출력
            printMainMenu(isCartEmpty);


            int endNo = 0;

            if(isCartEmpty) {
                endNo = this.menus.size();
            } else {
                endNo = this.menus.size() + 2;
            }


            //메인메뉴 입력값 검사
            mainNum = checkingInput(scanner,1, endNo);


            //입력값에 따른 로직 or 메서드 실행
            if (mainNum >= 1 && mainNum <= this.menus.size()) {
                //서브메뉴 고르기 실행
                pickSubMenu(this.menus.get(mainNum-1), scanner, cart);
            } else if(mainNum ==0) {
                //키오스크 종료
                System.out.println("키오스크를 종료합니다.");
                isKioskOff = true;
                break;
            } else if ( mainNum == this.menus.size() + 1) {
                //주문 여부에 따라 키오스크 종료 or 다시 메인메뉴 고르기
                isKioskOff = pickOrders(cart, scanner);
            } else if ( mainNum == this.menus.size() + 2) {
                System.out.println("주문 취소 되었습니다.");
                //장바구니 비우는 메서드 실행
                cart.makeEmptyCart();
                System.out.println("메인메뉴로 돌아갑니다.");
            }

        }

        //스캐너 닫기
        scanner.close();

    }




    //주문하는 메서드
    public boolean pickOrders(Cart cart, Scanner scanner) {

        //장바구니 목록 출력
        cart.printCartList();

        //주문 할지 말지 입력
        int orderNum = checkingInput(scanner, 1,2);

        //주문 할게요
        if(orderNum == 1) {
            //할인 목록 출력
            Discount.printDiscountList();

            //할인 선택 입력값 검사
            int discountNum = checkingInput(scanner, 1, 4);

            //할인 enum에서 선택
            Discount myDiscount = Discount.selectDiscount(discountNum);

            //할인에 따른 총액 출력
            if(discountNum == 4) {
                System.out.println("\n주문이 완료되었습니다. 금액은 W " + cart.getTotalPrice()+" 입니다.");
            } else {
                System.out.println("\n주문이 완료되었습니다. 금액은 W " + cart.getDisCountedPrice(myDiscount)+" 입니다.");
            }

            return  true;

            //주문 안해요
        } else if (orderNum == 2) {
            System.out.println("메인 메뉴로 돌아갑니다.");
            return  false;
        }

        return false;
    }



    //서브메뉴 고르는 메서드
    public void pickSubMenu(Menu menu, Scanner scanner, Cart cart) {


        while (true) {

            //서브메뉴 리스트 출력
            menu.printMenuItemList();

            //선택한 카테고리 내 메뉴 선택
            //입력값 검사 메서드 호출 (int반환)
            int menuItemNum = checkingInput(scanner, 1,5);

            if (menuItemNum >= 1 && menuItemNum <= 5) {
                //선택한 메뉴 보여주기
                menu.printPickedMenu(menuItemNum);
            } else if (menuItemNum == 0) {
                System.out.println("메인메뉴로 돌아갑니다.");
                break;
            }


            //선택한 메뉴 장바구니 추가 여부 입력
            int num = checkingInput(scanner, 1, 2);

            if(num == 1) {
                //장바구니 추가
                cart.addCartList(menu.getMenuItems().get(menuItemNum-1));

                String menuName = menu.getMenuItems().get(menuItemNum-1).getMenuName();
                System.out.println("\n"+menuName+" 메뉴가 장바구니에 추가되었습니다.");

                break; //메인으로 돌아가기
            } else if (num == 2) {
                System.out.println("\n"+menu.getMenuCategory()+" 메뉴로 돌아갑니다.");
            }

        }


    }


    //메인메뉴 목록 출력 메서드
    public void printMainMenu(boolean isCartEmpty) {

        System.out.println("\n🍔 맘스터치 메뉴 🍔");
        for(int i=0; i<this.menus.size(); i++) {
            String menuCategory = this.menus.get(i).getMenuCategory();
            System.out.println((i+1)+". " + menuCategory);
        }

        //장바구니 상태에 따라 하위 출력문을 출력할지 말지 결정함
        if(isCartEmpty) {
            System.out.println("0. 종료\n");
        }

        if (!isCartEmpty) {
            System.out.println("\n🍔 주문/장바구니 확인 🍔");
            System.out.println(this.menus.size()+1 + ". Orders   | 장바구니를 확인 후 주문합니다");
            System.out.println(this.menus.size()+2 + ". Cancel   | 주문을 취소합니다.");
            System.out.println("0. 종료\n");
        }
        
    }



    //입력값 예외 처리 로직
    public int checkingInput(Scanner scanner, int startNo, int endNo) {

        while (true) {

            try {

                System.out.print(startNo + "~" + endNo + " 사이의 숫자를 입력해주세요: ");
                int input = scanner.nextInt();

                if (input >= startNo && input <= endNo || input == 0) {
                    return input;
                }  else {
                    throw new IllegalArgumentException();
                }

            } catch (InputMismatchException e) {
                System.out.println("\n❌ 숫자만 입력해주세요\n");
                scanner.next();//버퍼비우기
            } catch (IllegalArgumentException e) {
                System.out.println("\n❌" + startNo + "~" + endNo + "에서 다시 입력해주세요.\n");
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
