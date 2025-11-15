package Ejercicio12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/*Ejercicio 12 – Comando según sistema operativo
Haz que el programa detecte automáticamente si está en Windows o Linux, y ejecute un
comando diferente en cada caso (por ejemplo, ipconfig o ifconfig).*/

public class Ejercicio12 {
    public static void main(String[] args) {

        try{
            ProcessBuilder pb;

            if(System.getProperty("os.name").toLowerCase().contains("win")){
                pb = new ProcessBuilder("ipconfig");
            } else{
                List <String> command = List.of("ip","addr", "show");
                pb = new ProcessBuilder(command);
            }

            Process process =  pb.start();

            BufferedReader br =  new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while( (line= br.readLine()) !=null){
                System.out.println(line);
            }
            br.close();

            int exitCode = process.waitFor();
            System.out.println("Proceso finalizado con código:" + exitCode);

        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }







    }
}
