package Ejercicio03;
/*Ejercicio 3 – Redirigir errores
Crea un programa que intente ejecutar un comando inexistente y redirija los mensajes de
error a un archivo llamado errores.txt.*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) {

        try {
            String commandLine,flag, command;
            String line;
            File file = new File("errores.txt");

            if(System.getProperty("os.name").toLowerCase().contains("win")){
                commandLine="cmd";
                flag= "/c";
                command = " no such command";
            } else{
                commandLine="/bin/bash";
                flag= "-c";
                command= " no such command";
            }

            ProcessBuilder pb = new ProcessBuilder(commandLine,flag,command);
            pb.redirectError(file);
            Process process = pb.start();
            process.waitFor();

            BufferedReader br = new BufferedReader( new FileReader(file));

            while((line= br.readLine())!=null) {
               System.out.println(line);
            }


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }catch(InterruptedException ie){
            ie.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
