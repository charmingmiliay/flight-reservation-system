package controller;

import java.util.ArrayList;
import java.util.List;
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
        System.out.println("탑승객의 번호: " + ps.getPassengerNum());
        System.out.println("이름: " + ps.getName());
        System.out.println("나이: " + ps.getAge());
        System.out.println("등급: " + settingGrade(ps.getAge(), Grade.values()));
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
        System.out.println("탑승객의 번호: " + p.getPassengerNum());
        System.out.println("이름: " + p.getName());
        System.out.println("나이: " + p.getAge());
        System.out.println("등급: " + p.getGrade());
        System.out.println("국적: " + p.getCountry());
        System.out.println("여권번호: " + p.getPassportNum());
        System.out.println("도착지: " + p.getArrivals());
    }

    public static void renameInfo() {
        List<PassengerDTO> passengers = pl.getReservation();

        System.out.print("수정할 탑승객 번호를 입력하세요 (목록 조회: 0): ");
        int passengerNum = sc.nextInt();
        sc.nextLine(); // nextInt 뒤 개행 제거

        if (passengerNum == 0) {
            showPassengers();
            return;
        }

        PassengerDTO selectedPassenger = null;

        for (PassengerDTO p : passengers) {
            if (p.getPassengerNum() == passengerNum) {
                selectedPassenger = p;
                break;
            }
        }

        if (selectedPassenger == null) {
            System.out.println("해당 번호의 탑승객이 없습니다.");
            return;
        }

        System.out.print("새 이름: ");
        selectedPassenger.setName(sc.nextLine());

        System.out.print("새 나이: ");
        selectedPassenger.setAge(sc.nextInt());
        sc.nextLine();

        selectedPassenger.setGrade(
                settingGrade(selectedPassenger.getAge(), Grade.values())
        );

        System.out.print("새 국적: ");
        selectedPassenger.setCountry(sc.nextLine());

        System.out.print("새 여권번호: ");
        selectedPassenger.setPassportNum(sc.nextLine());

        System.out.println("현재 항공의 결항으로 목적지가 한정되어있습니다. 아래 보기에서 선택 가능합니다.");
        System.out.println("United Kingdom, Philippines, Italy, Vietnam, Japan, China ");
        System.out.print("새 도착지: ");
        selectedPassenger.setArrivals(sc.nextLine());

        System.out.println("탑승객 정보가 수정되었습니다.");
        showPrintPassengers(selectedPassenger);
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

    public static void removeInfo() {
        List<PassengerDTO> passengers = pl.getReservation();

        System.out.print("삭제할 데이터의 인덱스 번호를 입력하세요: ");
        int removeIndex = sc.nextInt();
        sc.nextLine(); // nextInt() 뒤 입력 버퍼 정리

        if (removeIndex >= 0 && removeIndex < passengers.size()) {
            PassengerDTO removedPassenger = passengers.remove(removeIndex);

            System.out.printf(
                    "%d번 인덱스의 %s 데이터가 삭제되었습니다.%n",
                    removeIndex,
                    removedPassenger.getName()
            );
        } else {
            System.out.println("존재하지 않는 인덱스입니다.");
        }

        showPassengers();
    }


}
