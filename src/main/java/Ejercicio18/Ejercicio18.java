package Ejercicio18;

/*Ejercicio 18 – Esperar tiempo antes de lanzar otro proceso
Ejecuta un proceso, espera 3 segundos (Thread.sleep(3000)), y luego lanza otro.*/


import java.io.IOException;


public class Ejercicio18 {
    public static void main(String[] args) {

        try{

            //Ejecutamos  un proceso
            System.out.println("Ejecutamos el primer comando");
            String commandLine,flag,command;
            String os= System.getProperty("os.name").toLowerCase();
            commandLine= (os.contains("win"))? "cmd" :"bash";
            flag = (os.contains("win"))? "/c":"-c";
            command = (os.contains("win"))? "ipconfig" : "ip addr show";
            pbUtils.executeCommand(commandLine,flag,command);

            //El hilo main se pone a 'dormir'  durante 3000 milisegundos
            System.out.println("El hilo main se pausa durante 3 segundos");
            Thread.sleep(3000);

            // Ejecutamos el segundo proceso
            System.out.println("Ejecutamos el segundo proceso");
            pbUtils.executeCommand("whoami");


        } catch(IOException | InterruptedException e){
            e.printStackTrace();
        }



    }
}
