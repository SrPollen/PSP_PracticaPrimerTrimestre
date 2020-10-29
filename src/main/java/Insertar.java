import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Insertar extends Thread{
    private static Semaphore semaforo;
    private int insStart;
    private int insMax;

    public Insertar(int insStart, int insMax, Semaphore semaforo){
        this.semaforo = semaforo;
        this.insStart = insStart;
        this.insMax = insMax;
    }
    @Override
    public void run() {
        //super.run();
        for (int i = this.insStart;  i < this.insMax; i++){
            try {
                semaforo.acquire();
                ejecutar();
                semaforo.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void ejecutar (){
       // try {
            Connectionbd conbd = new Connectionbd();
            conbd.insertarEmpleados(randomEmail(), randomIngreso());
            //TimeUnit.MILLISECONDS.sleep(50);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    private String randomEmail(){
        String email = randomWord().concat("@").concat(randomOrgan()).concat(randomDot());
        return email;
    }

    private String randomWord() {
        int min = 5;
        int max = 12;
        int range = max - min + 1;
        int len = (int) ((Math.random() * range) + min);

        String word = "";
        for (int i = 0; i < len; i++) {
            int v = 1 + (int) (Math.random() * 26);
            char c = (char) (v + (i == 0 ? 'A' : 'a') - 1);
            word += c;
        }
        return word;
    }

    private String randomOrgan() {
        String organs[] = {"gmail","hotmail",".outlook","yahoo","google"};
        int min = 0;
        int max = organs.length;
        int range = max - min;

        return organs[(int) ((Math.random() * range) + min)];
    }

    private String randomDot() {
        String dots[] = {".es",".com",".net",".org",".eu",".cat"};
        int min = 0;
        int max = dots.length;
        int range = max - min;

        return dots[(int) ((Math.random() * range) + min)];
    }

    private int randomIngreso(){
        int min = 10;
        int max = 1000;
        int range = max - min + 1;
        int ingreso = (int) ((Math.random() * range) + min);
        return ingreso;
    }
}
