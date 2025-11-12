package Ejercicio4;

/*Ejercicio 4 – Preguntar un comando y guardar su salida
Haz que el programa pida al usuario un comando del sistema, lo ejecute y guarde tanto la
salida como los errores en el archivo resultado.txt.*/



import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {

        try{
            File file = new File("resultado.txt");
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce el comando");
            String comando = sc.nextLine().trim();

            int exitCode = redirectCommand(comando,file);
            if(exitCode==0){
                System.out.println("Proceso finalizado y salida rediriga en; " + file.getAbsolutePath());
            } else{
                System.out.println("Error de ejecución");
            }
            sc.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }catch(InterruptedException ie){
            ie.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }



    }

    public static int redirectCommand(String command, File file ) throws IOException,InterruptedException {
        String commandLine,flag;
        if(System.getProperty("os.name").toLowerCase().contains("win")){
            commandLine="cmd";
            flag= "/c";

        } else{
            commandLine="/bin/bash";
            flag= "-c";
        }
        ProcessBuilder pb = new ProcessBuilder(commandLine,flag,command);
        pb.redirectErrorStream(true);
        pb.redirectOutput(file);
        Process process = pb.start();
        int exitCode = process.waitFor();
        return exitCode;
    }


}
