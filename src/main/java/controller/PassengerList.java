package controller;

import java.util.ArrayList;
import java.util.List;

public class PassengerList {
    List<PassengerDTO> reservation = new ArrayList<>();

    public List<PassengerDTO> getReservation() {
        return reservation;
    }

    int passengerNum=1;

    public void initializingPassengers(){
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
        passenger.setPassengerNUm(passengerNum++);
        reservation.add(passenger);

    }
}
