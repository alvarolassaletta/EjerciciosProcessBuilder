package Ejercicio11;
/*Ejercicio 11 – Mostrar solo la primera línea de la salida
* Ejecuta un comando y muestra solo la primera línea de su salida (por ejemplo, ipconfig).
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ejercicio11 {
    public static void main(String[] args) {

        try{

            ProcessBuilder pb = new ProcessBuilder("whoami");
            Process process = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = br.readLine();
            if(line!=null){
                System.out.println(line);
            }
            br.close();

            int exitCode = process.waitFor();
            System.out.println("Comando finalizado con código "+ exitCode);


        }catch(IOException  | InterruptedException e){
            e.printStackTrace();
        }

    }
}
