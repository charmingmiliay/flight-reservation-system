package controller;

import java.util.Scanner;

public class Mainscreen implements Function{
    public static void main(String[] args) {
        boolean onOff = true;
        int scanNum = 0;
        Scanner sc = new Scanner(System.in);

        pl.initializingPassengers(); //리스트로 저장할 데이터 코드를 실행시켜 reservation이라는 리스트에 데이터가 저장되도록 메소드를 실행한다.
        while(onOff){
            System.out.println("안녕하세요, 항공권 예약 프로그램입니다.");
            System.out.println("1: 탑승객 등록");
            System.out.println("2. DB에 등록된 모든 탑승객 조회");
            System.out.println("3. 탑승객 정보 수정");
            System.out.println("4. 탑승객 정보 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.println("메뉴 번호를 정수로 입력하세요: ");
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
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    onOff = false;
                    break;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다. 다시 입력하세요");
                    break;
            }
        }

    }
}
