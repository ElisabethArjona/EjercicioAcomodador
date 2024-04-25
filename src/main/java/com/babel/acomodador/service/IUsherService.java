package com.babel.acomodador.service;

import com.babel.acomodador.model.Cinema;
import com.babel.acomodador.model.Seat;

import java.util.List;

public interface IUsherService {
    public void positions(Cinema cinema, int numSeats);

    List<Seat[]> avilieableSeats(Cinema cinema, int numSeats);
}
