package com.babel.acomodador.controller;

import com.babel.acomodador.model.Cinema;
import com.babel.acomodador.service.IUserManagerService;
import org.springframework.stereotype.Component;

@Component
public class AcomodadorApp {

    private final IUserManagerService userManagerService;

    public AcomodadorApp(IUserManagerService iuserManagerService) {
        this.userManagerService = iuserManagerService;
    }

    public void run(){
        Cinema cinema = new Cinema();
        System.out.println(cinema);
        int optionUser;

        do {
            optionUser = userManagerService.menu();
            switch (optionUser) {
                case 1 -> {
                    userManagerService.asientos();
                }
                case 2 -> {
                    userManagerService.avilieableSeats();
                }
            }
        } while (optionUser != 3);
    }

}
