package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Function {
    /*Mainscreen클래스에서 1-4번 까지의 기능을 모아 하나의 Interface를 구현합니다.
    * 이 인터페이스는 Mainscreen에서 상속받게 됩니다.
    * 그러므로 Function Interface의 모든 메소드를 사용할 수 있게 됩니다.*/

    static PassengerDTO ps = new PassengerDTO(); //PassengerDTO 클래스의 필드를 사용할 수 있도록 객체를 생성.
    PassengerList pl = new PassengerList(); //탑승객 목록을 미리 작성한 데이터로 생성될 수 있도록 객체를 생성.
    static Scanner sc = new Scanner(System.in); //스캐너를 사용하여 값을 이 프로그램을 실행한 사람으로부터 값을 받을 수 있도록 라이브러리 메소드인 스캐너 method를 선언.


    public static void register(){
        System.out.print("이름: ");
        ps.setName(sc.nextLine());
        sc.nextLine(); //이름을 입력받을 때 입력하기도 전에 나이를 입력하는 단계로 넘어가는 것을 방지하기 위한 입력메소드 호출.

        System.out.print("나이: ");
        ps.setAge(sc.nextInt());
        sc.nextLine();
        settingGrade(ps.getAge(), Grade.values());
        //settingGrade는 이 인터페이스에 정의된 메소드로, Grade라는 enum 클래스에 정의된 등급을 조건에 맞게 지정해주는 메소드이다.
        // 전달인자로는 사용자에게 입력받은 나이(정수)와, Grade enum을 전달한다.

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
        /*사용자로부터 입력받은; 나이(정수)와 Grade enum을 매개변수로 받아 메소드를 실행한다.
        Grade enum에 선언된 필드인 CHILD, TEENAGER, ADULT, SENIOR를 나이에 맞게 지정되도록 하는 메소드이다.
        13세 이하일 경우 CHILD, 19세 이하일 경우 TEENAGER, 59세 이하일 경우 ADULT, 그 이상은 SENIOR를 반환하게 된다.*/
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

        System.out.print("삭제할 데이터의 탑승객 번호를 입력하세요: ");
        int removeIndex = sc.nextInt() + 1;
        sc.nextLine(); // nextInt() 뒤 입력 버퍼 정리

        if (removeIndex >= 0 && removeIndex < passengers.size()) {
            //삭제할 인덱스를 사용자로부터 입력받고, 그 입력받은 값은 passenger 리스트의 크기보다 작아야한다. 아닐경우 else문으로 전달.

            PassengerDTO removedPassenger = passengers.remove(removeIndex);
            //입력받은 인덱스에 맞는 리스트를 찾아 삭제한다. 이때 삭제된 리스트의 인덱스로 그 뒤의 인덱스들이 앞으로 당겨지게 된다.

            System.out.printf(
                    "%d번 인덱스의 %s 데이터가 삭제되었습니다.%n",
                    removeIndex,
                    removedPassenger.getName()
            );
        } else {
            System.out.println("존재하지 않는 인덱스입니다.");
            /*PassengerDTO에 PassengerList 리스트가 생성되지 않았거나,
            * 리스트의 인덱스 범위를 벗어났을 경우 출력.*/

        }

        showPassengers(); //수정 후, 수정된 리스트를 모두 출력하는 showPassengers() 메소드를 호출한다.
    }


}
