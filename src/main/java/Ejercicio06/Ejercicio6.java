package Ejercicio06;

    /*Ejercicio 6 – Comprobar conexión
    Haz un programa que ejecute el comando ping a una dirección (por ejemplo, ping
    google.com) y muestre si la conexión fue exitosa o no en base al código de salida del
    proceso.*/

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        try{
            String domain;
            int exitCode;

            Scanner sc= new Scanner(System.in);
            System.out.println("Introduce el dominio");
            domain = sc.nextLine();

            exitCode = runCommand(domain);
            if(exitCode ==0){
                System.out.println("Comando finalizado con éxito");
            } else{
                System.out.println("Error al ejecutar el ping");
            }



        }catch(IOException ioe){
            ioe.printStackTrace();
        } catch(InterruptedException ie){
            ie.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }



    }
    public static int runCommand(String domain) throws IOException,InterruptedException {
        String commandLine,flag,command;
        if(System.getProperty("os.name").toLowerCase().contains("win")){
            commandLine="cmd";
            flag= "/c";
            command = "ping " + domain;

        } else{
            commandLine="/bin/bash";
            flag= "-c";
            command = "ping " + domain;
        }
        ProcessBuilder pb = new ProcessBuilder(commandLine,flag,command);
        Process process = pb.start();
        int exitCode = process.waitFor();

        return exitCode;
    }

}
