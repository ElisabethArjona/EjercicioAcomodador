package com.babel.acomodador.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    private int row;
    private int numSeat;
    private boolean taken;

    @Override
    public String toString() {
        if (taken){
            return "T";
        }
        return numSeat+"";
    }
}
