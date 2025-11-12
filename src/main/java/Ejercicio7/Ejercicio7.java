package Ejercicio7;
/*
* Llamar a un archivo externo
Crea un programa que ejecute un archivo externo (por ejemplo, un .bat o .sh) y muestre el
código de salida del proceso una vez terminado.
* */

/*
ver en claude

Terminar los argumentos de procesBuilbder aqui esan mal  se pasa directamente elk archivio como String

y ncesitas la movida esa de inherint Idd
* */


import java.io.File;
import java.io.IOException;

public class Ejercicio7 {

    public static void main(String[] args) {

        try{
            File file = new File("comandos.bat");

            if(!file.exists()){
                System.out.println("El archivo no existe en: " + file.getAbsolutePath());
                return;
            }
            int exitCode = executeExternalFile(file.getAbsolutePath());

            if(exitCode==0){
                System.out.println("Codigo de salida: " + exitCode + ". Comandos ejecutados con éxito");
            } else{
                System.out.println("Código de salida "+ exitCode + ". Error en la ejecución del archivo externo");
            }
            /*Esto no e imprime quizas el promeba esta en al ruta */

        }catch(IOException ioe){
            ioe.printStackTrace();
        } catch (InterruptedException ie){
            ie.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }


    }

    public static int executeExternalFile(String externalFile) throws  IOException, InterruptedException{
        int exitCode;
        ProcessBuilder pb;

        if(System.getProperty("os.name").toLowerCase().contains("win")){
            pb = new ProcessBuilder(externalFile);
        }else{
            pb = new ProcessBuilder("/bin/bash","-c",externalFile);
        }

        pb.inheritIO();
        Process process = pb.start();
        exitCode = process.waitFor();
        return exitCode;
    }
}
