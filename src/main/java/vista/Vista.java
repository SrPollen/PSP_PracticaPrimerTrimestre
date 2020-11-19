package vista;

import hilos.Insertar;

import java.util.ArrayList;
import java.util.Scanner;

public class Vista {
    public void startInsertar(){
        System.out.println("Registros a insertar: ");
        int registros = pedirNumero();
        System.out.println("Numero de hilos a utilizar: ");
        int hilos = pedirNumero();

        if(registros > 0 && hilos > 0){
            int inserts = registros / hilos;
            int insStart = 0;
            int insMax = inserts;

            int diferencia = registros - (inserts * hilos);

            ArrayList<Insertar> arrayInsertar = new ArrayList<>();
            for (int i = 0; i < hilos ; i++){
                //Para distribuir los registros sobrantes en cada hilo
                if(diferencia > 0) {
                    insMax +=1;
                    diferencia--;
                }
                arrayInsertar.add(new Insertar(insStart,insMax));
                insStart = insMax;
                insMax += inserts;
            }
            arrayInsertar.forEach(Insertar::start);
        }else{
            System.out.println("Insercción no valida");
        }
    }

    public int pedirNumero(){
        Scanner sc = new Scanner(System.in);
        String strNumero = sc.nextLine();
        try {
            int num = Integer.parseInt(strNumero);
            return num;
        } catch (NumberFormatException e){
            return -1;
        }
    }
}
