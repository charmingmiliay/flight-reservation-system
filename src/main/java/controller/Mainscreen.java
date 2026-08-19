package controller;

import java.util.Scanner;

public class Mainscreen implements Function{
    public static void main(String[] args) {
        boolean onOff = true; //while문을 사용하여 메뉴옵션을 선택하는 선택지가 반복적으로 실행될 수 있도록 true를 가진다.
        int scanNum = 0;
        Scanner sc = new Scanner(System.in);

        pl.initializingPassengers(); //리스트로 저장할 데이터 코드를 실행시켜 reservation이라는 리스트에 데이터가 저장되도록 메소드를 실행한다.
        while(onOff){ //onOff 변수에 false(9를 입력할 경우)가 저장될 경우에만 프로그램을 종료한다. 이외에는 끊임없이 반복되도록 한다.
            System.out.println("안녕하세요, 항공권 예약 프로그램입니다.");
            System.out.println("1: 탑승객 등록");
            System.out.println("2. DB에 등록된 모든 탑승객 조회");
            System.out.println("3. 탑승객 정보 수정");
            System.out.println("4. 탑승객 정보 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.println("메뉴 번호를 정수로 입력하세요: ");
            try {// 숫자가 아니면 예외 발생
                scanNum = sc.nextInt();
                sc.nextLine();
                switch (scanNum){
                    case 1:
                        Function.register();
                        break;
                    case 2:
                        Function.showPassengers();
                        break;
                    case 3:
                        Function.renameInfo();
                        break;
                    case 4:
                        Function.removeInfo();
                        break;
                    case 9:
                        System.out.println("프로그램을 종료합니다.");
                        onOff = false;
                        break;
                    default: //1,2,3,4,9 이외의 다른 정수를 입력했을 경우 실행한다.
                        System.out.println("번호를 잘못 입력하셨습니다. 다시 입력하세요");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("정수만 입력하세요.");
                sc.next(); // 잘못 입력한 문자열을 버려야 무한 예외 방지
            }
        }

        sc.close(); //프로그램이 종료되면 scanner를 반납(스캐너 닫기)
    }
}
