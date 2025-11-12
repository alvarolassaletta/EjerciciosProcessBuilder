package Ejercicio9;

/*Ejercicio 9 – Ejecutar varios procesos
Haz un programa que lance dos programas a la vez (por ejemplo, Notepad y Calc) y espere
a que ambos terminen antes de mostrar “Todos los procesos finalizados”.*/


import java.io.IOException;

public class Ejericicio9 {
    public static void main(String[] args) {

        try{
            /* Abro Notepad++ en vez notepad.exe.
            En mi dispositivo notepad++ esta en esta ruta "C:\\Program Files\\Notepad++\\notepad++.exe")
            Se requiere indicar la ruta para este ejecutable, pues su ubicación no se encuentra en la variable PATH
            Si se usara el ejecutable notepad.exe , no haría falta indicar la ruta
            */

            ProcessBuilder notepadPb = new ProcessBuilder("C:\\Program Files\\Notepad++\\notepad++.exe");
            Process notepadProcess = notepadPb.start();
            System.out.println("Notepad ++ abierto");

            ProcessBuilder caldPb= new ProcessBuilder("calc.exe");
            Process calcProcess = caldPb.start();
            System.out.println("Calculadora abierta");

            int notepadExitCode = notepadProcess.waitFor();
            int  calcExitCode = calcProcess.waitFor();

            System.out.println("Notepad ++ cerrado con código: " +notepadExitCode);
            System.out.println("Calculadora cerrada con cádigo: " +calcExitCode);
            System.out.println("Todos los procesos finalizados ");


        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch(InterruptedException ie){
            ie.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }


    }
}
