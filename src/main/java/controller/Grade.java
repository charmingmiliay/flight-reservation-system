package controller;

public enum Grade {
    CHILD("어린이"),
    TEENAGER("청소년"),
    ADULT("성인"),
    SENIOR("노인");

    private final String age;
    Grade(String age){this.age = age; }

    public String getAge() {
        return age;
    }
}
