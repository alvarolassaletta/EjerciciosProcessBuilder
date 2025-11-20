package Ejercicio16;
/*Ejercicio 16 – Ejecutar un proceso con variable de entorno personalizada
Haz que el programa establezca una variable de entorno (JAVA_HOME o MI_NOMBRE) y
luego ejecute un comando que la muestre por pantalla.*/

//Establecemos ambas variables, tanto JAVA_HOME, como MI_NOMBRE
//Ejecutamos ambos comandos

import java.io.IOException;
import java.util.Map;

public class Ejercicio16 {
    public static void main(String[] args) {

        String commandLine, flag,command;
        Map <String,String> envMap;
        try{
            ProcessBuilder pb= new ProcessBuilder();
            envMap = pb.environment();

            envMap.put("USERNAME","alvar");
            envMap.put("JAVA_HOME","C:\\Users\\alvar\\jdk-23");

            String os = System.getProperty("os.name").toLowerCase();
            commandLine = (os.contains("win"))? "cmd": "bash";
            flag = (os.contains("win")) ? "/c" : "-c";
            command = (os.contains("win")) ? "echo %USERNAME%":  "echo $USERNAME";

            //Ejecutamos un  comando para mostrar USERNAME
            pb.command(commandLine,flag,command);
            pb.inheritIO();
            /*la salida del proceso hijo (el comando ejecutado) se dirige
            * a la consola. Asi, éxito tener que leer el flujo de salida */
            Process process = pb.start();
            process.waitFor();

            //salida  ->  alvar

            //Ejecutamos otro comando para mostrar JAVA_HOME
            pb.command(commandLine,flag,(os.contains("win"))?"echo %JAVA_HOME%": "echo $JAVA_HOME");
            pb.inheritIO();
            process = pb.start();
            process.waitFor();

            //salida -> C:\Users\alvar\jdk-23

        } catch (IOException  | InterruptedException e) {
            e.printStackTrace();
        }


    }
}
