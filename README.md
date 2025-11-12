# Ejercicios de Process y ProcessBuilder

[cite_start]Ejercicios propuestos para el módulo **2º Programación de Servicios y Procesos - DAM**. [cite: 3, 4, 5]

[cite_start] [cite: 1]

---

## 🚀 Listado de Ejercicios

1.  [cite_start]**Ejercicio 1 - Mostrar directorio actual:** [cite: 16] [cite_start]Crea un programa que ejecute el comando del sistema operativo que muestra el contenido del directorio actual (`dir` en Windows o `ls` en Linux) y muestre la salida por pantalla. [cite: 17]

2.  [cite_start]**Ejercicio 2 - Guardar la fecha del sistema:** [cite: 18] [cite_start]Crea un programa que ejecute el comando que muestra la fecha (`date`) y guarde la salida en un fichero llamado `fecha.txt`. [cite: 19]

3.  [cite_start]**Ejercicio 3 - Redirigir errores:** [cite: 20] [cite_start]Crea un programa que intente ejecutar un comando inexistente y redirija los mensajes de error a un archivo llamado `errores.txt`. [cite: 21]

4.  [cite_start]**Ejercicio 4 - Preguntar un comando y guardar su salida:** [cite: 22] [cite_start]Haz que el programa pida al usuario un comando del sistema, lo ejecute y guarde tanto la salida como los errores en el archivo `resultado.txt`. [cite: 23]

5.  [cite_start]**Ejercicio 5 - Mostrar variables de entorno:** [cite: 24] [cite_start]Crea un programa que utilice `pb.environment()` para listar todas las variables de entorno del sistema. [cite: 25]

6.  [cite_start]**Ejercicio 6 - Comprobar conexión:** [cite: 28] [cite_start]Haz un programa que ejecute el comando `ping` a una dirección (por ejemplo, `ping google.com`) y muestre si la conexión fue exitosa o no en base al código de salida del proceso. [cite: 29]

7.  [cite_start]**Ejercicio 7 - Llamar a un archivo externo:** [cite: 30] [cite_start]Crea un programa que ejecute un archivo externo (por ejemplo, un `.bat` o `.sh`) y muestre el código de salida del proceso una vez terminado. [cite: 31]

8.  [cite_start]**Ejercicio 8 - Abrir un programa del sistema:** [cite: 33] [cite_start]Escribe un programa que abra una aplicación del sistema (por ejemplo, Bloc de notas, Paint o la Calculadora) usando `ProcessBuilder`. [cite: 34]

9.  [cite_start]**Ejercicio 9 - Ejecutar varios procesos:** [cite: 35] [cite_start]Haz un programa que lance dos programas a la vez (por ejemplo, Notepad y Calc) y espere a que ambos terminen antes de mostrar "Todos los procesos finalizados". [cite: 36]

10. [cite_start]**Ejercicio 10 - Guardar salida y errores en archivos separados:** [cite: 37] [cite_start]Ejecuta un comando que genere salida y errores (por ejemplo, `dir /xyz`) y redirige la salida a `salida.txt` y los errores a `errores.txt`. [cite: 38]

11. [cite_start]**Ejercicio 11 - Mostrar solo la primera línea de la salida:** [cite: 39] [cite_start]Ejecuta un comando y muestra solo la primera línea de su salida (por ejemplo, `ipconfig`). [cite: 42]

12. [cite_start]**Ejercicio 12 - Comando según sistema operativo:** [cite: 43] [cite_start]Haz que el programa detecte automáticamente si está en Windows o Linux, y ejecute un comando diferente en cada caso (por ejemplo, `ipconfig` o `ifconfig`). [cite: 44]

13. [cite_start]**Ejercicio 13 - Leer desde InputStream y contar líneas:** [cite: 45] [cite_start]Ejecuta un comando y muestra cuántas líneas ha devuelto su salida total. [cite: 46]

14. [cite_start]**Ejercicio 14 - Clase utilitaria:** [cite: 47] [cite_start]Crea una clase llamada `ComandoUtils` con un método estático `ejecutar(String comando)` que devuelva la salida del comando como un String. [cite: 48]

15. [cite_start]**Ejercicio 15 - Crear copia de seguridad:** [cite: 49] [cite_start]Crea un script `.bat` o `.sh` que copie una carpeta a otra y un programa Java que lo ejecute y diga si ha sido exitoso. [cite: 50]

16. [cite_start]**Ejercicio 16 - Ejecutar un proceso con variable de entorno personalizada:** [cite: 51] [cite_start]Haz que el programa establezca una variable de entorno (`JAVA_HOME = MI_NOMBRE`) y luego ejecute un comando que la muestre por pantalla. [cite: 52]

17. [cite_start]**Ejercicio 17 - Repetir ejecución:** [cite: 55] [cite_start]Crea un programa que ejecute un mismo comando 3 veces seguidas (por ejemplo, `echo Hola mundo`) y muestre el número de ejecución. [cite: 56]

18. [cite_start]**Ejercicio 18 - Esperar tiempo antes de lanzar otro proceso:** [cite: 57] [cite_start]Ejecuta un proceso, espera 3 segundos (`Thread.sleep(3000)`) y luego lanza otro. [cite: 58]

19. [cite_start]**Ejercicio 19 - Mostrar procesos en ejecución:** [cite: 59] [cite_start]Ejecuta el comando `tasklist` (Windows) o `ps -e` (Linux) y guarda la salida en `procesos.txt`. [cite: 60]

20. [cite_start]**Ejercicio 20 - Menú interactivo:** [cite: 61] [cite_start]Haz un programa que muestre un pequeño menú con opciones: [cite: 62]
    * [cite_start]1. Ver IP del equipo [cite: 63]
    * [cite_start]2. Ver variables de entorno [cite: 64]
    * [cite_start]3. Probar conexión con Google [cite: 65]
    [cite_start]El programa ejecutará los comandos correspondientes según la opción. [cite: 66]