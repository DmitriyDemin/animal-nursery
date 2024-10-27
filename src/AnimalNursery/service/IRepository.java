package AnimalNursery.service;


import AnimalNursery.model.Command;

import java.util.List;

public interface IRepository<Animal> {

    List<Animal> getAll();
    Animal getById(int id);
    int create (Animal item);
//    int update(Animal item);
    void delete (int item);
    List<Command> getAllCommands();
    List<Integer> getCommandsByID(int animal_id);
    void learnСommand (int animal_id, int command_id);
    String getCommandNameById(int command_id);

    }
