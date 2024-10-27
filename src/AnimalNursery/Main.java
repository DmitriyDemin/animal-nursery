package AnimalNursery;

import AnimalNursery.Controller.AnimalController;
import AnimalNursery.service.Repository;
import AnimalNursery.view.ConsoleMenu;


public class Main {
    public static void main(String[] args) {

        new ConsoleMenu(new AnimalController(new Repository())).start();
    }
}



