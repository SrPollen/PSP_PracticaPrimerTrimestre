import java.sql.*;

public class Connectionbd {
    private static String DB_CONNECTION = "jdbc:mysql://localhost/BBDD_PSP_1";
    private static String USER_NAME = "DAM2020_PSP";
    private static String USER_PASSWORD= "DAM2020_PSP";

    public void leerEmpleados() {
        try {
            Connection connection = DriverManager.getConnection(DB_CONNECTION, USER_NAME, USER_PASSWORD);
            Statement consulta = connection.createStatement();
            ResultSet registro = consulta.executeQuery("SELECT * FROM EMPLEADOS;");
            while(registro.next()){
                System.out.println("ID: " + registro.getInt("ID") + " | Email: " + registro.getString("EMAIL") + " | Ingresos: " + registro.getInt("INGRESOS"));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void borrarEmpleados() {
        try {
            Connection connection = DriverManager.getConnection(DB_CONNECTION, USER_NAME, USER_PASSWORD);
            Statement consulta = connection.createStatement();
            consulta.executeUpdate("DELETE FROM EMPLEADOS;");
            consulta.executeUpdate("ALTER TABLE EMPLEADOS AUTO_INCREMENT = 1;");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
