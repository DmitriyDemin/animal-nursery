package AnimalNursery.service;

import AnimalNursery.model.Animal;

import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;



public class Repository implements IRepository <Animal> {

    private String SQLquery;
    private Statement sqlStr;
    private ResultSet resultSet;
    private List<Animal> nursery = new ArrayList<Animal>();

    public Repository (){

    }

    @Override
    public List<Animal> getAll() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection dbConnection = DriverManager.getConnection("jdbc:MySQL://localhost:3306/human_friends", "root", "Yar_1188")) {

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

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    }
//
//
//
//
//
//
//
//
//    @Override
//    public Animal getById(int id) {
//        return null;
//    }
//
//    @Override
//    public int create(Animal item) {
//        return 0;
//    }
//
//    @Override
//    public int update(Animal item) {
//        return 0;
//    }
//
//    @Override
//    public void delete(int item) {
//
//    }
//}

