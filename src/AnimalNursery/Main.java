package AnimalNursery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException{

        // Секрет успешного подключения: драйвер всегда под рукой

// Подключение установлено!

                String query = "SELECT * FROM commands";
                String create = "CREATE TABLE dogs Dog_ID INT";


                try{
                    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                    System.out.println("Connection succesfull!");
                    Connection con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/animal_nursery", "root", "Yar_1188");
                    Statement stmt = con.createStatement();
                    System.out.println(stmt.executeQuery(query));
                    stmt.executeUpdate(create);
                }
                catch(Exception ex){
                    System.out.println("Connection failed...");
                    System.out.println(ex);
//

                }

    }
}
