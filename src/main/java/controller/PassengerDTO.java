package controller;

import javax.print.DocFlavor;

public class PassengerDTO {
    private int passengerNum=1;   //탑승객 번호
    private String name;        //탑승객 이름
    private int age;            //탑승객 나이
    private Grade grade;
    private String country;     // 탑승객의 국적
    private String passportNum; //탑승객의 여권번호
    private String arrivals;    //탑승객의 목적지

    public PassengerDTO(){}

    public PassengerDTO(int passengerNum, String name, int age, Grade grade, String country, String passportNum, String arrivals){
        this.passengerNum=passengerNum;
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.country=country;
        this.passportNum=passportNum;
        this.arrivals=arrivals;
    }

    public int getPassengerNum() {
        return passengerNum;
    }

    public void setPassengerNum(int passengerNum) {
        this.passengerNum = passengerNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    public String getArrivals() {
        return arrivals;
    }

    public void setArrivals(String arrivals) {
        this.arrivals = arrivals;
    }

    /*탑승객의 번호에는 setter 메소드를 만들지 않습니다
    왜냐하면, 탑승객의 번호는 등록 순서에 따라 결정되며 변경되지 않기 떄문입니다.*/

    @Override
    public String toString() {
        return "Passenger [passenger numger = " + passengerNum +
                ", name = " + name +
                ", age = " + age +
                ", country = " + country +
                ", passport number = " + passportNum + "]";
    }

    public void removeIf(Object o) {
    }
}
