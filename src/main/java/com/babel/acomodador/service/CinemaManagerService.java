package com.babel.acomodador.service;

import com.babel.acomodador.model.Cinema;
import com.babel.acomodador.model.Seat;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void assignSeat(int numSeats) {
        usherService.positions(cinema,numSeats);
    }

    @Override
    public List<Seat[]> avilieableSeats(int numSeats){
        return usherService.avilieableSeats(cinema,numSeats);
    }
}
