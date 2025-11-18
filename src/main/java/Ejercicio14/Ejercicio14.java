package Ejercicio14;

/*Crea una clase llamada ComandoUtils con un método estático ejecutar(String comando)
que devuelva la salida del comando como un String*/

import java.io.IOException;

public class Ejercicio14 {
    public static void main(String[] args) {
        try {

            String command = System.getProperty("os.name").toLowerCase().contains("win")? "tasklist" : "ps -e";
            String out =ComandoUtils.ejecutar(command);
            System.out.println("Salida del comando " + command+ ": " + "\n" + out);

        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
