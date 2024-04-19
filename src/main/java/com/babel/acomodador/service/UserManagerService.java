package com.babel.acomodador.service;

import org.springframework.stereotype.Service;

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
            System.out.println("2. Salir");
            option = keyboardInputService.requestInt("Introduzca la opcion deseada: ");
        } while ((option < 0) || (option > 2));
        return option;
    }

    @Override
    public void asientos() {
        int numSeats = keyboardInputService.requestInt("Introduzca el numero de asientos deseados");
        cinemaManagerService.asignarAsiento(numSeats);
    }

}
