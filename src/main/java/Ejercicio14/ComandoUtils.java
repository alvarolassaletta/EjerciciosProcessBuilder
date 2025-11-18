package Ejercicio14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class ComandoUtils {
    // impido herencia
    private ComandoUtils(){}
    //impido creación de instancias

    /**
     * Ejecuta un comando del sistema operativo y devuelve toda su salida como una cadena.
     * El comando se ejecuta mediante la terminal correspondiente al sistema operativo:
     * cmd /c en Windows y bash -c en sistemas Unix (Linux y macOS).
     * La salida estándar y la salida de error se combinan en un único flujo utilizando
     * redirectErrorStream(true), por lo que cualquier mensaje de error también formará
     * parte del String devuelto.
     *
     * @param comando el comando del sistema operativo que se desea ejecutar
     * @return la salida completa del comando, incluyendo mensajes de error si los hubiera
     * @throws IOException si ocurre un error al iniciar el proceso o al leer su salida
     * @throws InterruptedException si el hilo es interrumpido mientras espera la finalización del proceso
     */
    public static String ejecutar(String comando) throws IOException,InterruptedException{

        int exitCode;
        ProcessBuilder pb;
        StringBuilder sb = new StringBuilder();

        String os = System.getProperty("os.name").toLowerCase();
        pb = (os.contains("win") ) ? new ProcessBuilder("cmd","/c",comando) : new ProcessBuilder("bash","-c",comando);

        pb.redirectErrorStream(true);
        //salida estandar y erros se dirigen al flujo de sálida estándar

        Process process = pb.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while((line=br.readLine())!=null){
            sb.append(line).append(System.lineSeparator());
        }

        exitCode= process.waitFor();
        if(exitCode==0){
            System.out.println("Proceso ejecutado: " + comando);
        } else{
            System.out.println("Error en la ejecución. Usa un comando adecuado para sistema operativo");
        }
        return sb.toString();

    }
}
