package Ejercicio20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TaskManager {
    public TaskManager(){}

    public void executeCommand(String ...command) throws IOException,InterruptedException {

        int exitCode;
        String line;
        List<String> commandList = Arrays.asList(command);
        ProcessBuilder pb = new ProcessBuilder();
        pb.command(commandList);
        Process process = pb.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("Comando: " + Arrays.toString(command) + " ejecutado con código " + exitCode);
        } else {
            System.out.println("Fallo en la ejecucion " + exitCode);
        }
    }

    public void displayEnviromentVariables() {
        ProcessBuilder pb = new ProcessBuilder();
        Map <String,String>  mapEnv= pb.environment();
        for(String key: mapEnv.keySet()){
            System.out.println(key + ":" + mapEnv.get(key));
        }
    }

    public void displayMenu(){
        Scanner sc = new Scanner(System.in);
        int option=0;
        String commandLine, flag,command;

        do{
            System.out.println("Menu Interactivo");
            System.out.println("1.Ver IP del equipo");
            System.out.println("2.Comprobar variables de Entorno");
            System.out.println("3.Probar conexión con Google");
            System.out.println("4.Fin del programa");
            boolean right=true;
            do{
                System.out.println("Elije una opción");
                if(sc.hasNextInt()){
                    option = sc.nextInt();
                    right=false;
                }else{
                    System.out.println("Para elegir uan opción debes introducir un número entero");
                    sc.next();
                }
            }while(right);

            switch(option){
                case 1:
                    try{
                        System.out.println("Ver IP del equipo");

                        String os= System.getProperty("os.name").toLowerCase();
                        commandLine= (os.contains("win"))? "cmd" :"bash";
                        flag = (os.contains("win"))? "/c":"-c";
                        command = (os.contains("win"))? "ipconfig" : "ip addr show";

                        executeCommand(commandLine,flag,command);

                    }catch(IOException|InterruptedException e){
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("Comprobar variables de Entorno");
                    displayEnviromentVariables();

                    break;
                case 3:

                    System.out.println("Probar conexión con Google");
                    try {
                        executeCommand("ping", "google.com");
                    } catch(IOException| InterruptedException e){
                        e.printStackTrace();
                    }

                    break;
                case 4:
                    System.out.println("Fin del programa");
                    return;
                default:
                    System.out.println("Opcion no válida");
            }

        }while(true);


    }

}
