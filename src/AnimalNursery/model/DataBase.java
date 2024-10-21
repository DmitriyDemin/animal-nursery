package AnimalNursery.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class DataBase {

    public DataBase() throws SQLDataException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/animal_nursery", "root", "Yar_1188");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
