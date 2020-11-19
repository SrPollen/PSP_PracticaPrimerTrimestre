import connectionbd.Connectionbd;
import vista.Vista;

public class Controlador {
    public static void main(String[] args) {
        Connectionbd conbd = new Connectionbd();
        Vista vista = new Vista();
        int opcion;

        System.out.println("EJERCIO 1 INSERTAR");
        do{
            System.out.println("1. Insertar");
            System.out.println("2. Leer tabla");
            System.out.println("3. Borrar tabla");
            System.out.println("0. Salir");

            opcion = vista.pedirNumero();
            switch (opcion){
                case 1:
                    vista.startInsertar();
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
}