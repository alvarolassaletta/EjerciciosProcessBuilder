package Ejercicio13;

/*Ejercicio 13 – Leer desde InputStream y contar líneas
Ejecuta un comando y
muestra cuántas líneas ha devuelto su salida total.*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio13 {
    public static void main(String[] args) {

        try{

            int numberOfLines = getLines("tasklist");
            //  usar el comando adecuado al SO
            System.out.println("Número de líneas  leídas: " + numberOfLines );

        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }

    }


    public static  int  getLines (String command) throws IOException, InterruptedException{
        ProcessBuilder pb;
        int counter=0;

        String os = System.getProperty("os.name").toLowerCase();

        if(os.contains("win")) {
            pb = new ProcessBuilder("cmd", "/c", command);
        } else{
            pb= new ProcessBuilder("bash","-c",command);

        }
         Process process = pb.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while((line= br.readLine()) !=null){
            System.out.println(line);
            counter++;
        }
        int exitCode = process.waitFor();
        if(exitCode==0){
            System.out.println("Comando ejecutado  " + command);
        } else{
            System.out.println("Error en la ejecución. ");
        }
        return counter;
    }
}
