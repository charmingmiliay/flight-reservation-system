package controller;

import java.util.Scanner;

public interface Function {
    static PassengerDTO ps = new PassengerDTO();
    PassengerList pl = new PassengerList();
    static Scanner sc = new Scanner(System.in);


    public static void register(){
        System.out.print("이름: ");
        ps.setName(sc.nextLine());

        System.out.print("나이: ");
        ps.setAge(sc.nextInt());
        sc.nextLine();

        System.out.print("국적(정자로 정확히 기입하세요): ");
        ps.setCountry(sc.nextLine());

        System.out.print("여권번호(Pxxxx): ");
        ps.setPassportNum(sc.nextLine());

        System.out.println("현재 항공의 결항으로 목적지가 한정되어있습니다. 아래 보기에서 선택 가능합니다.");
        System.out.println("United Kingdom, Philippines, Italy, Vietnam, Japan, China ");
        System.out.print("목적지(정자로 정확히 기입하세요): ");
        ps.setArrivals(sc.nextLine());

        System.out.println("=======입력된 탑승객의 정보=======");
        System.out.println("탑승객의 번호: " + ps.getPassengerNUm());
        System.out.println("이름: " + ps.getName());
        System.out.println("나이: " + ps.getAge());
        System.out.println("국적: " + ps.getCountry());
        System.out.println("여권번호: " + ps.getPassportNum());
        System.out.println("도착지: " + ps.getArrivals());

    }

    public static void showPassengers(){
        System.out.println("저장된 탑승객 수: " + pl.reservation.size());

        if (pl.reservation.isEmpty()) {
            System.out.println("등록된 탑승객이 없습니다.");
            return;
        }
        for(PassengerDTO p: pl.getReservation()){
            showPrintPassengers(p);
        }
    }

    public static void showPrintPassengers(PassengerDTO p){
        System.out.println("=======입력된 탑승객의 정보=======");
        System.out.println("탑승객의 번호: " + p.getPassengerNUm());
        System.out.println("이름: " + p.getName());
        System.out.println("나이: " + p.getAge());
        System.out.println("국적: " + p.getCountry());
        System.out.println("여권번호: " + p.getPassportNum());
        System.out.println("도착지: " + p.getArrivals());
    }

}
