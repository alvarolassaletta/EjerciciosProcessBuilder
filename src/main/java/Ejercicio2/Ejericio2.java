package Ejercicio2;
/*Ejercicio 2 – Guardar la fecha del sistema
Crea un programa que ejecute el comando que muestra la fecha (date) y guarde la salida
en un fichero llamado fecha.txt.*/

/**Comando para obtener la fecha
 * Linux  -> date
 * Windows Cmd  -> date -t  o tambien  echo %date% */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejericio2 {
    public static final Path PATH  = Paths.get("fecha.txt");

    public static void main(String[] args) {

        try{
            File file = PATH.toFile();
            int exitCode =  obtainDate(file);
            if(exitCode==0){
                System.out.println("Proceso finalizado con éxito");
            } else{
                System.out.println("Error en la ejecución");
            }

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while((line=br.readLine())!=null){
                System.out.println("Fecha: "+ line);
            }
            br.close();

        }catch(InterruptedException ie){
            ie.printStackTrace();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static  int obtainDate( File file) throws IOException, InterruptedException {
        String commandLine, flag, command;

        int exitCode;
        if(System.getProperty("os.name").toLowerCase().contains("win")){
            commandLine="cmd";
            flag= "/c";
            command = "echo %date%";
        } else{
            commandLine="/bin/bash";
            flag= "-c";
            command= "date";
        }

        ProcessBuilder pb = new ProcessBuilder(commandLine,flag,command);
        pb.redirectErrorStream(true);
        pb.redirectOutput(file);
        Process process = pb.start();
        exitCode = process.waitFor();
        return exitCode;

    }

}
