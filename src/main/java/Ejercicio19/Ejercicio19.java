package Ejercicio19;
/*Ejercicio 19 – Mostrar procesos en ejecución
Ejecuta el comando tasklist (Windows) o ps -e (Linux) y guarda la salida en procesos.txt*/

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Ejercicio19 {
    public static final Path PATH = Paths.get("data","procesos.txt");

    public static void main(String[] args) {
        try{

            File file = PATH.toFile();
            File parentDir= file.getParentFile();
            //devuele null , si la ruta no tiene directorio padre

            if(parentDir!=null && !parentDir.exists()) {
                //necesitas ambas comprobaciones, porque si el diretorio padre es null
                // y compruebas su exitencia , obtenendras NullPointerException
                if (parentDir.mkdirs()) {
                    //mkdirs devuelve un boolean
                    System.out.println("Directorio creado en " + parentDir.getAbsolutePath());
                } else {
                    System.out.println("No se puedo crear el directorio");
                    return;
                }
            }

            String commandLine,flag,command;
            String os = System.getProperty("os.name").toLowerCase();

            commandLine = (os.contains("win"))? "cmd" : "bash";
            flag= (os.contains("win"))? "/c":"-c";
            command= (os.contains("win"))? "tasklist" : "ps -e";

            executeRedirectOutput(file,commandLine,flag,command);

        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }


    }

    public static void  executeRedirectOutput(File file,String ...command) throws IOException,InterruptedException {
        int exitCode;

        List <String> commandList = Arrays.asList(command);
        ProcessBuilder pb = new ProcessBuilder();
        pb.command(commandList);
        pb.redirectErrorStream(true);
        pb.redirectOutput(file);

        Process process= pb.start();
        exitCode=process.waitFor();
        if(exitCode==0){
            System.out.println("Comando ejecutado  con codigo "+exitCode+ ". Salida redirigida a  "
                    +file.getAbsolutePath());
        } else{
            System.out.println("Error en el ejecución del comando. Código " + exitCode);
        }


    }
}
