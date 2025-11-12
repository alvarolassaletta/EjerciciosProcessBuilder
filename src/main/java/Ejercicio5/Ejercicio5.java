package Ejercicio5;

import java.util.Map;

/*  Ejercicio 5 – Mostrar variables de entorno
    Crea un programa que utilice pb.environment() para listar todas las variables de entorno
    del sistema.
* */

public class Ejercicio5 {
    public static void main(String[] args) {
        try{
            ProcessBuilder pb = new ProcessBuilder();
            Map<String,String> enviromentVariables= pb.environment();

            for(String variable: enviromentVariables.keySet()){
                System.out.println(variable +":"+enviromentVariables.get(variable));
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
