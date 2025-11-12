package Ejercicio1;
/*
* Mostrar directorio actual
Crea un programa que ejecute el comando del sistema operativo que muestra el contenido
del directorio actual (dir en Windows o ls en Linux) y muestre la salida por pantalla.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {
    public static void main(String[] args) {

        try{
            String line;
            int exitCode;
            String commandLine, flag,command;
            if(System.getProperty("os.name").toLowerCase().contains("wind")){
                commandLine= "cmd";
                flag= "/c";
                command = "dir";
            } else{
                commandLine ="/bin/bash";
                flag = "-c";
                command="ls";
            }

            ProcessBuilder pb = new ProcessBuilder(commandLine,flag,command);
            Process process = pb.start();
            exitCode= process.waitFor();

            BufferedReader br = new BufferedReader( new InputStreamReader(process.getInputStream()));

            while((line=br.readLine())!=null){
                System.out.println("Directorio actual: "+ line);
            }
            //Directorio actual: C:\Users\alvar\ServiciosProcesos\EjerciciosProcessBuilder

            System.out.println("Proceso finalizado  con código: " + exitCode);
            //Proceso finalizado  con código: 0
            br.close();

        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
