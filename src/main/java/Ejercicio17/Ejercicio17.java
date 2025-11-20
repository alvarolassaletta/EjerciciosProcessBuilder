package Ejercicio17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/*
    * Ejercicio 17 – Repetir ejecución
    Crea un programa que ejecute un mismo comando 3 veces seguidas (por ejemplo, echo
    Hola mundo) y muestre el número de ejecución.
    *
    * //Ejecutamos tasklist o ps, dependiento del sistema operativo
* */

public class Ejercicio17 {
    public static void main(String[] args) {
        try{
            String commandLine,flag,command;
            String os = System.getProperty("os.name").toLowerCase();

            commandLine = (os.contains("win"))? "cmd" : "bash";
            flag= (os.contains("win"))? "/c":"-c";
            command= (os.contains("win"))? "tasklist" : "ps -e";

            for(int i=1;i<=3;i++){
                System.out.println("\n------ Ejecución numero " +i+" ------ \n");
                ejecutarComando(commandLine,flag,command);
            }

        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }

    }
    /**
     * Método  ejecuta un comando con ProcessBuilder. Para recibir el comando
     * se usa la estructura  varargs, similar al args de Python y JavaScript.
     * Permite recibir un número indeterminado de argumentos. Internamente se reciben
     * como un array, que es convertido en una List para que puede ser recibido por ProcessBuilder.
     * Uno de los constructores de ProcessBuilder admite una List de Strings.
     * Se ejecuta el comando, espera a que el proceso finalice
     * y se lee el flujo de salida. El método también muestra un mensaje
     * indicando el éxito del comando.
     *
     * @param command elementos que componen el comando a ejecutar; .
     * @throws IOException si ocurre un error al iniciar el proceso.
     * @throws InterruptedException si el hilo es interrumpido mientras espera
     *         la finalización del proceso.
     * @return no devuelve ningún valor; el método imprime la salida del proceso.
     */

    public static void ejecutarComando(String ...command) throws IOException ,InterruptedException {
        List<String>  commandList = Arrays.asList(command);
        String line,message;
        int exitCode;

        ProcessBuilder pb =  new ProcessBuilder();
        pb.command(commandList);
        Process process = pb.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

        while((line=br.readLine())!=null){
            System.out.println(line);
        }

        exitCode = process.waitFor();
        System.out.println("Comando: " + Arrays.toString(command) + " ejecutado con código " + exitCode);
        message = (exitCode==0)?"Proceso finalizado" :"Error en la ejecución del comando";

    }
}
