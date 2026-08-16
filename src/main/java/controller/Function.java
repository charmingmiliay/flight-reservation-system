package controller;

import java.util.Scanner;

public interface Function {
    static PassengerDTO ps = new PassengerDTO();
    PassengerList pl = new PassengerList();
    static Scanner sc = new Scanner(System.in);


    public static void register(){
        System.out.print("이름: ");
        ps.setName(sc.nextLine());
        sc.nextLine();

        System.out.print("나이: ");
        ps.setAge(sc.nextInt());
        sc.nextLine();
        settingGrade(ps.getAge(), Grade.values() );

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
        System.out.println("등급: " + ps.getGrade());
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
        System.out.println("등급: " + p.getGrade());
        System.out.println("국적: " + p.getCountry());
        System.out.println("여권번호: " + p.getPassportNum());
        System.out.println("도착지: " + p.getArrivals());
    }

    public static void renameInfo(){
        PassengerDTO pss = new PassengerDTO();

        System.out.println("수정할 탑승객의 번호를 입력하시거나, ");
        System.out.println("탑승객 목록을 조회하시려면 0번을 입력하세요:");
        int scanNum2 = sc.nextInt();
        if(scanNum2 > 0){
            if(scanNum2 < 11){
                System.out.println(pss.toString());
                register();
            }
            else{
                System.out.println("잘못된 번호를 입력하셨습니다.");
                renameInfo();
            }
        }
        else if(scanNum2 == 0){
            showPassengers();
        }
        else{
            System.out.println("잘못된 번호를 입력하셨습니다.");
            renameInfo();
        }

    }

    public static Grade settingGrade(int age, Grade[] grade){
        Grade grades;
        if(age <= 13){
            grades=Grade.CHILD;
        }
        else if(age <= 19){
            grades=Grade.TEENAGER;
        }
        else if(age <= 59){
            grades=Grade.ADULT;
        }
        else {
            grades=Grade.SENIOR;
        }

        return grades;
    }


}
