package com.babel.acomodador.service;

import com.babel.acomodador.model.Cinema;

public interface ICinemaManagerService {

    public Cinema getCinema();

    public void asignarAsiento(int numSeats);
}
