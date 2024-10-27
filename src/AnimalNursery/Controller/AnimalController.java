package AnimalNursery.Controller;

import AnimalNursery.model.*;
import AnimalNursery.service.IRepository;
import AnimalNursery.view.ConsoleView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AnimalController {

    private IRepository<Animal> DB;
    private Animal animal;
    private final ConsoleView view = new ConsoleView();
    private Validator validator;

    public AnimalController (IRepository<Animal> repository) {
        this.DB = repository;
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

    public void getAllAnimal() {
        try {
            view.printAll(DB.getAll(), Animal.class);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }

    public List<Integer> getAllAnimalId() {
        List<Integer> listAnimalId = new ArrayList<>();

        try {
            List<Animal> list = DB.getAll();
            for (Animal item: list){
                listAnimalId.add(item.getAnimal_id());
            }

        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
        return listAnimalId;
    }

    public boolean learnСommand(int animal_id, int command_id) {
        String commandName = DB.getCommandNameById(command_id);

        try {
            if (DB.getCommandsByID(animal_id).contains(command_id))
                view.showMessage("команде " + "'"+commandName+"'" + " животное уже обучено");
            else {
                DB.learnСommand(animal_id, command_id);
                view.showMessage("командa " + "'"+commandName+"'" + " изучена");
            }
            return true;

        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
        return false;
    }

    public Animal getById(int animal_id) {
        try {
            return DB.getById(animal_id);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
        return null;
    }

    public void delete(int id) {
        try {
            DB.delete(id);
            view.showMessage("запись удалена");
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }


  public void getCommandsByID (int animal_id) {
        List<String> commandsSrt = new ArrayList<>();

        try {
            List<Integer> commans = DB.getCommandsByID(animal_id);
            for (int i = 0; i <commans.size(); i++){
                commandsSrt.add(DB.getCommandNameById(commans.get(i)));
            }
                    view.printAll(commandsSrt, String.class);

        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }

    public List<Command> getAllCommands () {
        List<Command> commans = new ArrayList<>();
        try {
            commans = DB.getAllCommands();
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
        return commans;

    }

}
