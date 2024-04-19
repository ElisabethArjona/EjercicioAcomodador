package com.babel.acomodador.service;

import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

@Service
public class KeyboardInputService implements IKeyboardInputService {

    public  String requestString(String cad) {
        Scanner scanner = new Scanner(System.in);

        String cadena = "";

        System.out.print(cad);
        cadena += scanner.nextLine();

        return cadena;
    }

    public char requestChar(String cad) {
        Scanner scanner = new Scanner(System.in);
        String cadena = " ";

        System.out.print(cad);

        do {
            cadena = scanner.nextLine();

            if (cadena.length() > 1) {
                System.err.println("\nHa habido un error. Por favor introduzca un solo caracter.");
            } else if (cadena.length() < 1) {
                System.err.println("\nHa habido un error. Por favor introduzca un caracter.");
            }

        } while (cadena.length() != 1);

        return cadena.toUpperCase().charAt(0);
    }

    public int requestInt(String cadena) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean error = false;

        System.out.print(cadena);

        do {
            error = false;
            try {
                num = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.err.println("\nHa habido un error, el dato introducido no es un número. Por favor vuelva a intentarlo");
                error = true;
            } finally {
                scanner.nextLine();
            }
        } while (error == true);

        return num;
    }

    public float requestFloat(String cadena) {
        Scanner scanner = new Scanner(System.in);
        float num = 0;
        boolean error = false;

        System.out.print(cadena);

        do {
            error = false;
            try {
                num = scanner.nextFloat();
            } catch (InputMismatchException ex) {
                System.err.println("\nHa habido un error, el dato introducido no es un número. Por favor vuelva a intentarlo");
                error = true;
            } finally {
                scanner.nextLine();
            }
        } while (error == true);

        return num;
    }

    public double requestDouble(String cadena) {
        Scanner scanner = new Scanner(System.in);
        double num = 0;
        boolean error = false;

        System.out.print(cadena);

        do {
            error = false;
            try {
                num = scanner.nextDouble();
            } catch (InputMismatchException ex) {
                System.err.println("\nHa habido un error, el dato introducido no es un número. Por favor vuelva a intentarlo");
                error = true;
            } finally {
                scanner.nextLine();
            }
        } while (error == true);

        return num;
    }

    public long requestLong(String cadena) {
        Scanner scanner = new Scanner(System.in);
        long num = 0;
        boolean error = false;

        System.out.print(cadena);

        do {
            error = false;
            try {
                num = scanner.nextLong();
            } catch (InputMismatchException ex) {
                System.err.println("\nHa habido un error, el dato introducido no es un número. Por favor vuelva a intentarlo");
                error = true;
            } finally {
                scanner.nextLine();
            }
        } while (error == true);

        return num;
    }

    public int requestAge(String cadena) {
        Scanner scanner = new Scanner(System.in);
        int edad = 0,
                anio = 0,
                mes = 0,
                dia = 0;
        boolean error = false;
        String fechanac = "";

        System.out.print(cadena);// el formato para la fecha ser� YYYY/MM/DD

        do {//controlamos que la cadena tenga una longitud de 10 y los posibles errores del casteo
            error = false;
            try {
                fechanac = scanner.nextLine();
                anio = Integer.parseInt(fechanac.substring(0, 4));
                mes = Integer.parseInt(fechanac.substring(5, 7));
                dia = Integer.parseInt(fechanac.substring(8, 10));
            } catch (NumberFormatException ex) {
                System.err.println("\nHa habido un error en la entrada de datos. Por favor vuelva a intentarlo");
                error = true;
            } catch (StringIndexOutOfBoundsException ex) {
                System.err.println("\nHa habido un error en la entrada de datos. Por favor vuelva a intentarlo");
                error = true;
            }
        } while (fechanac.length() != 10 || error == true);

        //Creamos un objeto calendario con la fecha actual
        GregorianCalendar hoy = new GregorianCalendar();

        int anio2 = hoy.get(GregorianCalendar.YEAR);
        int mes2 = hoy.get(GregorianCalendar.MONTH);//0 para enero y 11 para diciembre
        int dia2 = hoy.get(GregorianCalendar.DAY_OF_MONTH);

        //calculamos la edad
        edad = (anio2 - anio - 1);
        if (mes2 >= (mes - 1) && dia2 >= dia) {
            edad++;
        }

        return edad;
    }

    public boolean continuar() {
        Scanner scanner = new Scanner(System.in);
        char resp = ' ';
        boolean error = false;

        System.out.print("\n¿Desea continuar? (S/N)");

        do {
            error = false;
            try {
                resp = scanner.nextLine().toLowerCase().charAt(0);
            } catch (StringIndexOutOfBoundsException ex) {
                error = true;
                System.err.println("\nHa habido un error. Por favor introduzca S/n");
            }
        } while (resp != 's' && resp != 'n' || error == true);

        if (resp == 's'){
            return true;
        }
        return false;
    }

    public boolean requestBoolean(String cadena) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(cadena);
        String sn = this.requestString("");
        boolean valor = false;

        if (sn.toUpperCase().charAt(0) == 'S') {
            valor = true;
        } else {
            valor = false;
        }

        return valor;
    }
}
