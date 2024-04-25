package com.babel.acomodador.service;

import com.babel.acomodador.model.Seat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagerService implements IUserManagerService {


    private final IKeyboardInputService keyboardInputService;
    private final ICinemaManagerService cinemaManagerService;

    public UserManagerService(IKeyboardInputService iKeyboardInputService, ICinemaManagerService cinemaManagerService) {
        this.keyboardInputService = iKeyboardInputService;
        this.cinemaManagerService = cinemaManagerService;
    }


    @Override
    public int menu() {
        int option;
        do {
            System.out.println(cinemaManagerService.getCinema());
            System.out.println(" -- MENU --");
            System.out.println("1. Adquirir Asiento");
            System.out.println("2. Asientos Posibles");
            System.out.println("3. Salir");
            option = keyboardInputService.requestInt("Introduzca la opcion deseada: ");
        } while ((option < 0) || (option > 3));
        return option;
    }

    @Override
    public void asientos() {
        int numSeats = keyboardInputService.requestInt("Introduzca el numero de asientos deseados");
        cinemaManagerService.assignSeat(numSeats);
    }

    @Override
    public void avilieableSeats(){
        int numSeats = keyboardInputService.requestInt("Introduzca el numero de asientos deseados");
        List<Seat[]> list = cinemaManagerService.avilieableSeats(numSeats);
        System.out.println("El conjunto de asientos posibles es:");
        for (Seat[] seats : list){
            System.out.println("Conjunto: ");
            for (Seat seat : seats){
                System.out.print(seat.getRow() + "-" + seat.getNumSeat() + "  ");
            }
            System.out.println(" ");

        }
    }

}
