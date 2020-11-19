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
