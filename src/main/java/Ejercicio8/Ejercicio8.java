package Ejercicio8;

/*Ejercicio 8 – Abrir un programa del sistema
Escribe un programa que abra una aplicación del sistema (por ejemplo, Bloc de notas, Paint
o la Calculadora) usando ProcessBuilder.

El ejecutable de la calculadores se llama calc.exe y esta uan de las ubicaciones
para ejecutables en windows C:\Windows\System32
*/


import java.io.IOException;

public class Ejercicio8 {
    public static void main(String[] args) {

        try{
            ProcessBuilder pb = new ProcessBuilder("calc.exe");
            Process process = pb.start();
            System.out.println("Calculadora abierta");
            int exitCode = process.waitFor();
            System.out.println("Proceso finalizado con codigo: "+ exitCode);
            System.out.println("Calculadora Cerrada");

        }catch(IOException ioe){
            //excepcion requerida por pb.start()
            ioe.printStackTrace();
        } catch (InterruptedException ie){
            //excepcion requerida por waitFor()
            ie.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
