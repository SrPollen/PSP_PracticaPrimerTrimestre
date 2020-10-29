import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connectionbd conbd = new Connectionbd();
        int opcion;
        do{
            System.out.println("1. Insertar");
            System.out.println("2. Leer");
            System.out.println("3. Borrar");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    ejercicioInsertar();
                    break;
                case 2:
                    conbd.leerEmpleados();
                    break;
                case 3:
                    conbd.borrarEmpleados();
                    break;
                case 0:
                    System.out.println("Adios!");
                    break;
            }
        }while(opcion != 0);
    }

    public static void ejercicioInsertar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Registros a insertar: ");
        int registros = sc.nextInt();
        System.out.println("Numero de hilos a utilizar: ");
        int hilos = sc.nextInt();

        int inserts = registros / hilos;
        int insStart = 0;
        int insMax = inserts;

        int diferencia = registros - (inserts * hilos);

        ArrayList<Insertar> arrayInsertar = new ArrayList<>();
        for (int i = 0; i < hilos ; i++){
            if(diferencia > 0) {
                insMax +=1;
                diferencia--;
            }
            arrayInsertar.add(new Insertar(insStart,insMax));
            insStart = insMax;
            insMax += inserts;
        }


        /* for (int i = 0; i < arrayInsertar.size() ; i++){
            System.out.println("start " +arrayInsertar.get(i).getInsStart());
            System.out.println("max " + arrayInsertar.get(i).getInsMax());
        }*/
    /*    int diferencia = 0;
        //int addInsHilo = 0;
        if(registros % hilos != 0) {
            diferencia = registros - (inserts * hilos);
            //addInsHilo = diferencia/hilos;
            int count = 0;
            while(diferencia != 0){

                for (int i = 0; i < arrayInsertar.size() ; i++){
                    arrayInsertar.get(count).setInsMax(arrayInsertar.get(count).getInsMax()+1);

                    // System.out.println(count + "setInmax" + arrayInsertar.get(count).getInsMax());

                    if(count != 0){
                        arrayInsertar.get(count).setInsStart(arrayInsertar.get(count-1).getInsMax());
                        // System.out.println(count + "setInStart" + arrayInsertar.get(count).getInsStart());
                    }
                }


                //System.out.println("diferencia: " + diferencia );

                diferencia--;
                count++;
                if(count > arrayInsertar.size()){
                    count = 0;
                }
            }
        }*/


        for (int i = 0; i < arrayInsertar.size() ; i++){
            arrayInsertar.get(i).start();
           // arrayInsertar.get(i).join();
        }
        //arrayInsertar.forEach(Insertar::start);
    }
            /*
        Desarrollar dos aplicaciones en Java que cumplan los siguientes requisitos:
        1. Aplicación 1:
        1.1 A través de consola, solicita al usuario un número de registros a insertar.
        1.2 A través de consola, solicita al usuario un número de hilos.
        1.3 Inserta el número de registros introducido en una base de datos utilizando el número de hilos indicado. Los datos se generarán de forma aleatoria, debiendo estar los ingresos comprendidos entre 10 y 1000.


        2. Aplicación 2:
        2.1 Paso 1:
        Leer de manera secuencial todos los registros y mostrar el tiempo
        empleado en la lectura y la suma (sin usar sentencias SQL de suma) del
        campo INGRESOS.
        2.2 Paso 2:
        Leer la base de datos anterior con cinco hilos de ejecución concurrentes
        y mostrar el tiempo empleado en la lectura y la suma (sin usar
        sentencias SQL de suma) del campo INGRESOS


        Diseño de la base de datos:
        Database: BBDD_PSP_1
        Table: EMPLEADOS
        DB_USER: DAM2020_PSP
        DB_PASSWORD: DAM2020_PSP
        - ID: PK. Integer. Autoincremental
        - EMAIL: varchar(100)
        - INGRESOS: Integer



        Se debe subir a GIT (Github o Gitlab) y cada repositorio deberá tener:
        - El jar de la aplicación, en la raiz.
        - El código de cada aplicación.
        - Un fichero "README.md" con las instrucciones de ejecución.

        Se tendrá en cuenta entre otros:
        - Nombres descriptivos
        - Uso de CamelCase
        - Control de excepciones.
        - Nombre de las variables, métodos y clases.
        - Estructura de paquetes/código.
        - Código repetido.
        - Código comentado.
        - Comentarios basura.
        - Practica individual.*/

}
