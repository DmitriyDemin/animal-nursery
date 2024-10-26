package AnimalNursery.service;


import java.util.List;

public interface IRepository<Animal> {

    List<Animal> getAll();
    /*Animal getById(int id);
    int create (Animal item);
    int update(Animal item);
    void delete (int item);*/

    }
