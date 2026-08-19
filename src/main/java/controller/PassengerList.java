package controller;

import java.util.ArrayList;
import java.util.List;

public class PassengerList {
    List<PassengerDTO> reservation = new ArrayList<>();

    public List<PassengerDTO> getReservation() {
        return reservation;
    }

    int passengerNum=1;

    public void initializingPassengers(){ //미리 저장할 리스트의 목록. PassengerDTO 클래스에 선언된 필드의 순서대로 지정하게 된다.
        save(new PassengerDTO(passengerNum, "김채림", 24, Grade.ADULT , "Korea", "P1111", "Philippines" ));
        save(new PassengerDTO(passengerNum, "김민지", 22, Grade.ADULT, "China", "P1234", "United Kingdom"));
        save(new PassengerDTO(passengerNum, "김지환", 15, Grade.TEENAGER, "Korea", "P4536", "Philippines" ));
        save(new PassengerDTO(passengerNum, "김명준", 9, Grade.CHILD, "Japan", "P3336", "Italy" ));
        save(new PassengerDTO(passengerNum, "김상용", 60, Grade.SENIOR, "Korea", "P9513", "Vietnam" ));
        save(new PassengerDTO(passengerNum, "이우준", 45, Grade.ADULT, "Japan", "P4896", "Italy" ));
        save(new PassengerDTO(passengerNum, "이지영", 61, Grade.SENIOR, "China", "P7890", "Phillippines" ));
        save(new PassengerDTO(passengerNum, "안젤리", 14, Grade.TEENAGER, "Philippines", "P4321", "China" ));
        save(new PassengerDTO(passengerNum, "서민정", 39, Grade.ADULT, "Korea", "P0129", "Vietnam" ));
        save(new PassengerDTO(passengerNum, "박현영", 12, Grade.CHILD, "Philippines", "P5164", "Japan" ));

    }

    public void save(PassengerDTO passenger){
        //한 쌍의 리스트가 저장될 때 마다 탑승객의 번호를 자동으로 1씩 증가하도록 한다.
        passenger.setPassengerNum(passengerNum++);
        reservation.add(passenger);

    }
}
