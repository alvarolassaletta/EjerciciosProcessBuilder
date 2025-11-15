package Ejercicio10;
/*Ejercicio 10 – Guardar salida y errores en archivos separados
Ejecuta un comando que genere salida y errores (por ejemplo, dir /xyz) y redirige la salida a
salida.txt y los errores a errores.txt.*/


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejericio10 {

    public static void main(String[] args) {

        try{
            //creamos un directorio data en el que guardar los ficheros
            //si no existe, que se cree.
            Path dataDir= Paths.get("data");
            if(!Files.exists(dataDir)){
                Files.createDirectories(dataDir);
            }
            File outFile = dataDir.resolve("salida.txt").toFile();
            File errorFile  = dataDir.resolve("errores.txt").toFile();


            ProcessBuilder pb = new ProcessBuilder("cmd","/c","dir ");

            pb.redirectError(errorFile);
            pb.redirectOutput(outFile);

            Process process = pb.start();
            int exitCode = process.waitFor();
            System.out.println("Proceso finalizado con codigo: "+ exitCode);
            System.out.println("Ficheros creados en:  " + dataDir.toAbsolutePath());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch(InterruptedException ie){
            ie.printStackTrace();
        }


    }
}
