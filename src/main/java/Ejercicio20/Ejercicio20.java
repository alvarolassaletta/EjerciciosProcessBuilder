package Ejercicio20;

/*Ejercicio 20 – Menú interactivo
    Haz un programa que muestre un pequeño menú con opciones:
    1. Ver IP del equipo
    2. Ver variables de entorno
    3. Probar conexión con Google
    El programa ejecutará los comandos correspondientes según la opción.*/



public class Ejercicio20 {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        taskManager.displayMenu();

    }
}

