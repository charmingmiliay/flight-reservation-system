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
        save(new PassengerDTO(passengerNum, "김채림", 24, "Korea", "P1111", "Philippines" ));
        save(new PassengerDTO(passengerNum, "김민지", 22, "China", "P1234", "United Kingdom"));
        save(new PassengerDTO(passengerNum, "김지환", 25, "Korea", "P4536", "Philippines" ));
        save(new PassengerDTO(passengerNum, "김명준", 22, "Japan", "P3336", "Italy" ));
        save(new PassengerDTO(passengerNum, "김상용", 60, "Korea", "P9513", "Vietnam" ));
        save(new PassengerDTO(passengerNum, "이우준", 45, "Japan", "P4896", "Italy" ));
        save(new PassengerDTO(passengerNum, "이지영", 61, "China", "P7890", "Phillippines" ));
        save(new PassengerDTO(passengerNum, "안젤리", 54, "Philippines", "P4321", "China" ));
        save(new PassengerDTO(passengerNum, "서민정", 39, "Korea", "P0129", "Vietnam" ));
        save(new PassengerDTO(passengerNum, "박현영", 32, "Philippines", "P5164", "Japan" ));

    }

    public void save(PassengerDTO passenger){
        passenger.setPassengerNUm(passengerNum++);
        reservation.add(passenger);

    }
}
