package AnimalNursery.service;

public interface IStorage <Animal> {
    List <Animal> getAll();
    Animal getById(int id);
    int create (Animal item);
    int update(Animal item);
    void delete (int item);

    }
