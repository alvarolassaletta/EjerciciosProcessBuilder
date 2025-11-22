package Ejercicio18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class pbUtils {
    public static  void executeCommand(String ...command) throws IOException,InterruptedException {

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
}


