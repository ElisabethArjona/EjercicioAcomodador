package com.babel.acomodador.service;

import com.babel.acomodador.model.Cinema;
import com.babel.acomodador.model.Seat;
import org.springframework.stereotype.Service;

@Service
public class CinemaManagerService implements ICinemaManagerService {

    private final IUsherService usherService;
    private Cinema cinema = new Cinema();

    public CinemaManagerService(IUsherService usherService) {
        this.usherService = usherService;
    }

    @Override
    public Cinema getCinema() {
        return cinema;
    }

    @Override
    public void asignarAsiento(int numSeats) {
        usherService.positions(cinema,numSeats);
    }
}
