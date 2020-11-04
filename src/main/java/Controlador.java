import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {
    public static void main(String[] args) {
        /*
        1. Aplicación 1:
        1.1 A través de consola, solicita al usuario un número de registros a insertar.
        1.2 A través de consola, solicita al usuario un número de hilos.
        1.3 Inserta el número de registros introducido en una base de datos utilizando el número de hilos indicado. Los datos se generarán de forma aleatoria, debiendo estar los ingresos comprendidos entre 10 y 1000.
        */

        Scanner sc = new Scanner(System.in);
        Connectionbd conbd = new Connectionbd();
        int opcion;
        do{
            System.out.println("1. Insertar");
            System.out.println("2. Leer tabla");
            System.out.println("3. Borrar tabla");
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
        //Semaphore semaforo =  new Semaphore(1,true);
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


        /*for (int i = 0; i < arrayInsertar.size() ; i++){
            arrayInsertar.get(i).start();
           // arrayInsertar.get(i).join();
        }*/
        arrayInsertar.forEach(Insertar::start);
    }
}
