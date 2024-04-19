package com.babel.acomodador.service;

import com.babel.acomodador.model.Cinema;
import com.babel.acomodador.model.Seat;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

@Service
public class UsherService implements IUsherService{
    private final IKeyboardInputService keyboardInputService;

    public UsherService(IKeyboardInputService keyboardInputService) {
        this.keyboardInputService = keyboardInputService;
    }

    @Override
    public void positions(Cinema cinema, int numSeats) {
        Cinema cinema1 = new Cinema();

        Seat[][] seats = cinema.getCinema();
        Seat[][] seatsCopy = cinema1.getCinema();

        int numSeatsTaken = 0;
        int firstSeat;
        Properties properties= new Properties();
        try {
            properties.load(new FileInputStream(new File("src/main/resources/properties/configAPP.properties")));
            firstSeat = Integer.parseInt(properties.getProperty("NUMCOLUMNS")) /2 -1;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //x hace referencia a la fila
        //y hace referencia a la butaca
        for (int x = 8; x >= 0 && (numSeatsTaken < numSeats); x--) {
            numSeatsTaken = getNumSeatsTakenRigth(numSeats, firstSeat, seatsCopy, x, numSeatsTaken, seats);
            if(numSeatsTaken != numSeats){
                numSeatsTaken = getNumSeatsTakenLeft(numSeats, firstSeat, seatsCopy, x, numSeatsTaken, seats);
            }
        }

        String string = getString(seatsCopy, seats);

        System.out.println("Tus asientos seran: ");
        System.out.println(string);

        String decision = keyboardInputService.requestString("¿Te gustaria confirmar la reserva? (s/n)");

        if ("S".equalsIgnoreCase(decision)){
            getFinalSeats(seatsCopy, seats);
            cinema.setCinema(seatsCopy);
        }
    }

    private int getNumSeatsTakenLeft(int numSeats, int firstSeat, Seat[][] seatsCopy, int x, int numSeatsTaken, Seat[][] seats) {
        int seatsNotTaken = 0;
        int index = -1;
        for (int y = firstSeat; y >= 0 && (numSeatsTaken < numSeats); y--) {
            if (!seats[x][y].isTaken()) {
                if(seatsNotTaken == 0){
                    index = y;
                }
                seatsNotTaken++;
                if (seatsNotTaken == numSeats){
                    for (int k = 0; k < numSeats; k++){
                        seatsCopy[x][index-k].setTaken(true);
                        numSeatsTaken++;
                    }
                }
            } else {
                seatsCopy[x][y].setTaken(true);
                seatsNotTaken = 0;
                index = -1;
            }
        }
        return numSeatsTaken;
    }

    private int getNumSeatsTakenRigth(int numSeats, int firstSeat, Seat[][] seatsCopy, int x, int numSeatsTaken, Seat[][] seats) {
        int seatsNotTaken = 0;
        int index = -1;
        for (int y = firstSeat; y < seatsCopy[x].length && (numSeatsTaken < numSeats); y++) {
            if (!seats[x][y].isTaken()) {
                if(seatsNotTaken == 0){
                    index = y;
                }
                seatsNotTaken++;
                if (seatsNotTaken == numSeats){
                    for (int k = 0; k < numSeats; k++){
                        seatsCopy[x][index+k].setTaken(true);
                        numSeatsTaken++;
                    }
                }
            } else {
                seatsCopy[x][y].setTaken(true);
                seatsNotTaken = 0;
                index = -1;
            }
        }
        return numSeatsTaken;
    }

    private String getString(Seat[][] seatsCopy, Seat[][] seats) {
        String string = "";
        for (int x = 0; x < seatsCopy.length; x++){
            for (int y = 0; y < seatsCopy[x].length; y++){
                if (seatsCopy[x][y].isTaken() && !seats[x][y].isTaken()){
                    string+= "|" + "R" + " | ";
                } else {
                    string+= "|" + seatsCopy[x][y] + " | ";
                }
            }
            string+= "\n";
        }
        return string;
    }

    private void getFinalSeats(Seat[][] seatsCopy, Seat[][] seats){
        for (int x = 0; x < seatsCopy.length; x++){
            for (int y = 0; y < seatsCopy[x].length; y++){
                if (!seatsCopy[x][y].isTaken() && seats[x][y].isTaken()){
                    seatsCopy[x][y].setTaken(true);
                }
            }
        }
    }
}
