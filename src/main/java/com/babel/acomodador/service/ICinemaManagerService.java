package com.babel.acomodador.service;

import com.babel.acomodador.model.Cinema;
import com.babel.acomodador.model.Seat;

import java.util.List;

public interface ICinemaManagerService {

    public Cinema getCinema();

    public void assignSeat(int numSeats);

    List<Seat[]> avilieableSeats(int numSeats);
}
