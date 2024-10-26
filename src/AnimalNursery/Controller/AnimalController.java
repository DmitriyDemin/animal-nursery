package AnimalNursery.Controller;

import AnimalNursery.model.*;
import AnimalNursery.service.IRepository;
import AnimalNursery.view.ConsoleView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AnimalController {
    private IRepository<Animal> DB;
//    private Creator petCreator;
    private Animal animal;
    private final ConsoleView view = new ConsoleView();
    private Validator validator;

    public AnimalController (IRepository<Animal> Repository) {
        this.DB = Repository;
//        this.petCreator = new PetCreator();
//        this.view = new ConsoleView();
        this.validator = new Validator();
    }

    public void createAnimal(int type_id) {

        String[] data = new String[] {view.getName(), view.getBirthday()};
        validator.validate(data);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = LocalDate.parse(data[1], formatter);
        try {
            switch (type_id) {
                case 1:
                    animal = new Dog(data[0], birthday);
                    break;
                case 2:
                    animal = new Cat(data[0], birthday);
                    break;
                case 3:
                    animal = new Hamster(data[0], birthday);
                    break;
                case 4:
                    animal = new Horse(data[0], birthday);
                    break;
                case 5:
                    animal = new Camel(data[0], birthday);
                    break;
                case 6:
                    animal = new Donkey(data[0], birthday);
                    break;
            }
        int res = DB.create(animal);
            view.showMessage(String.format("%d запись добавлена", res));
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }

    }
/*
    public void updatePet(int id) {

        Pet pet = getById(id);
        String[] data = new String[] { view.getName(), view.getBirthday() };

        validator.validate(data);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = LocalDate.parse(data[1], formatter);
        pet.setName(data[0]);
        pet.setBirthday(birthday);
        try {
            int res = petRepository.update(pet);
            view.showMessage(String.format("%d запись изменена \n", res));
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }

    }

    public void getAllPet() {
        try {
            view.printAll(petRepository.getAll(), Pet.class);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }

    public boolean trainPet(int id, String command) {
        try {

            if (((PetRepository) petRepository).getCommandsById(id, 1).contains(command))
                view.showMessage("это мы уже умеем");
            else {
                if (!((PetRepository) petRepository).getCommandsById(id, 2).contains(command))
                    view.showMessage("невыполнимая команда");
                else {
                    ((PetRepository) petRepository).train(id, command);
                    view.showMessage("команда разучена\n");
                    return true;
                }
            }
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
        return false;
    }

    public Pet getById(int id) {
        try {
            return petRepository.getById(id);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
        return null;
    }

    public void delete(int id) {
        try {
            petRepository.delete(id);
            view.showMessage("запись удалена");
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }

    public void getCommands(int id) {
        try {
            view.printAll(((PetRepository) petRepository).getCommandsById(id, 1), String.class);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }*/
}
