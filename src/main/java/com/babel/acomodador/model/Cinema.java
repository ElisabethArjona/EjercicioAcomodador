package com.babel.acomodador.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Data
@AllArgsConstructor
public class Cinema {

    private int numRows;
    private int numColumns;

    private Seat[][] cinema;

    public Cinema(){
        Properties properties= new Properties();
        try {
            properties.load(new FileInputStream(new File("src/main/resources/properties/configAPP.properties")));
            numRows = Integer.parseInt(properties.getProperty("NUMROWS"));
            numColumns = Integer.parseInt(properties.getProperty("NUMCOLUMNS"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cinema = new Seat[numRows][numColumns];

        //x hace referencia a la fila
        //y hace referencia a la butaca
        for (int x=0; x < cinema.length; x++){
            for (int y=0; y < cinema[x].length; y++){
                Seat seat = null;
                switch (y){
                    case 0 -> seat = new Seat(x+1,9,false);
                    case 1 -> seat = new Seat(x+1,7,false);
                    case 2 -> seat = new Seat(x+1,5,false);
                    case 3 -> seat = new Seat(x+1,3,false);
                    case 4 -> seat = new Seat(x+1,1,false);
                    case 5 -> seat = new Seat(x+1,2,false);
                    case 6 -> seat = new Seat(x+1,4,false);
                    case 7 -> seat = new Seat(x+1,6,false);
                    case 8 -> seat = new Seat(x+1,8,false);
                    case 9 -> seat = new Seat(x+1,10,false);
                }
                cinema[x][y] = seat;
            }
        }
    }
    @Override
    public String toString() {
        String string = "";
        for (int x=0; x < cinema.length; x++){
            for (int y=0; y < cinema[x].length; y++)
                string+= "|" + cinema[x][y] + " | ";
            string+= "\n";
        }
        return string;
    }
}
