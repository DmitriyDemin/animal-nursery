package AnimalNursery.service;

import AnimalNursery.model.Animal;
import AnimalNursery.model.Command;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;
import java.util.Properties;


public class Repository implements IRepository <Animal>  {


    private String SQLquery;
    private Statement sqlStr;
    private ResultSet resultSet;
    private List<Animal> nursery = new ArrayList<Animal>();
    private List<Command> commandsAll = new ArrayList<>();



    public Repository (){
    }

    @Override
    public List<Animal> getAll() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection dbConnection = getConnection()) {

                sqlStr = dbConnection.createStatement();
                SQLquery = "SELECT A.animal_id, A.nickname, A.birthday, B.name FROM animals_nursery AS A INNER JOIN animals_type AS B ON A.animal_type = B.id ORDER BY A.animal_id";
                resultSet = sqlStr.executeQuery(SQLquery);
                while (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    LocalDate birthday = resultSet.getDate(3).toLocalDate();
                    String type_id = resultSet.getString(4);
                    Animal animal = new Animal();
                    animal.setAnimal_id(id);
                    animal.setNickname(name);
                    animal.setBirthday(birthday);
                    animal.setType(type_id);

                    nursery.add(animal);
                }
            }
            return nursery;

        } catch (ClassNotFoundException |IOException| SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }


    @Override
    public Animal getById(int animal_Id) {
        Animal animal = new Animal();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection dbConnection = getConnection()) {

                SQLquery = "SELECT A.animal_id, A.nickname, A.birthday, B.name FROM animals_nursery AS A INNER JOIN animals_type AS B ON A.animal_type = B.id WHERE A.animal_id = ?";
                PreparedStatement prepStr = dbConnection.prepareStatement(SQLquery);
                prepStr.setInt(1, animal_Id);
                resultSet = prepStr.executeQuery();

                if (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    LocalDate birthday = resultSet.getDate(3).toLocalDate();
                    String type_id = resultSet.getString(4);
//                    Animal animal = new Animal();
                    animal.setAnimal_id(id);
                    animal.setNickname(name);
                    animal.setBirthday(birthday);
                    animal.setType(type_id);
                }
                return animal;
            }
        } catch (ClassNotFoundException |IOException| SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public int create(Animal animal) {
        int rows;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection dbConnection = getConnection()) {

                SQLquery = "INSERT INTO animals_nursery (nickname, birthday, animal_type) SELECT ?, ?, (SELECT id FROM animals_type WHERE name = ?)";
                PreparedStatement prepSt = dbConnection.prepareStatement(SQLquery);
                prepSt.setString(1, animal.getNickname());
                prepSt.setDate(2, Date.valueOf(animal.getBirthday()));
                prepSt.setString(3, animal.getType());

                rows = prepSt.executeUpdate();
                return rows;
            }
        } catch (ClassNotFoundException |IOException| SQLException ex) {
           throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void delete (int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection dbConnection = getConnection()) {
                SQLquery = "DELETE FROM animals_nursery WHERE Id = ?";
                PreparedStatement prepSt = dbConnection.prepareStatement(SQLquery);
                prepSt.setInt(1,id);
                prepSt.executeUpdate();
            }
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public List<Command> getAllCommands() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection dbConnection = getConnection()) {

                sqlStr = dbConnection.createStatement();
                SQLquery = "SELECT command_id, title, description FROM commands ORDER BY command_id";
                resultSet = sqlStr.executeQuery(SQLquery);
                while (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String desc = resultSet.getString(3);
                    Command com = new Command();
                    com.setCommand_id(id);
                    com.setCommand_name(title);
                    com.setDescription(desc);

                    commandsAll.add(com);
                }
            }
            return commandsAll;

        } catch (ClassNotFoundException |IOException| SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public List<Integer> getCommandsByID (int animal_id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            List<Integer> commands = new ArrayList<>();
            try (Connection dbConnection = getConnection()) {

                SQLquery = "SELECT command_id FROM skills WHERE animal_id = ?";
                PreparedStatement prepStr = dbConnection.prepareStatement(SQLquery);
                prepStr.setInt(1, animal_id);
                resultSet = prepStr.executeQuery();

                while (resultSet.next()) {
                    int command_id = resultSet.getInt(1);
                    commands.add(command_id);
                }
            }
                return commands;

            } catch (ClassNotFoundException | IOException | SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }

    }

















    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties() ;
        try (FileInputStream fis = new FileInputStream("src/AnimalNursery/resources/database.properties"))  {
            props.load(fis);
            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            return DriverManager.getConnection(url, username, password);
        }
    }
}


//    @Override
//    public int update(Animal item) {
//        return 0;
//    }
//