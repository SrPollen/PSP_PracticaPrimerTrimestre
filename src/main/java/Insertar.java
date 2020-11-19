import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertar extends Thread{
    private static String DB_CONNECTION = "jdbc:mysql://localhost/BBDD_PSP_1";
    private static String USER_NAME = "DAM2020_PSP";
    private static String USER_PASSWORD= "DAM2020_PSP";
    private int insStart;
    private int insMax;

    public Insertar(int insStart, int insMax){
        this.insStart = insStart;
        this.insMax = insMax;
    }
    @Override
    public void run() {
        super.run();
        for (int i = this.insStart;  i < this.insMax; i++){
            insertarEmpleados(randomEmail(), randomIngreso());
        }
    }

    private synchronized void insertarEmpleados(String email, int ingresos) {
        try {
            Connection connection = DriverManager.getConnection(DB_CONNECTION, USER_NAME, USER_PASSWORD);
            Statement consulta = connection.createStatement();
            consulta.executeUpdate("INSERT INTO EMPLEADOS (EMAIL, INGRESOS) VALUES ('" + email + "', " + ingresos + ");");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private String randomEmail(){
        String email = randomWord().concat("@").concat(randomOrgan()).concat(randomDot());
        return email;
    }

    private String randomWord() {
        int min = 7;
        int max = 14;
        int range = max - min + 1;
        int len = (int) ((Math.random() * range) + min);

        String AlphaNumericString = "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    private String randomOrgan() {
        String organs[] = {"gmail","hotmail","outlook","yahoo","google"};
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
