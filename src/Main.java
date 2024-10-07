import model.Animal;
import model.Cat;
import model.Dog;
import model.Nursery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Dog dog1 = new Dog();

        dog1.setName("bob");
        Dog dog2 = new Dog("martin");

        Cat cat1 = new Cat();
        Cat cat2 = new Cat("vasil");

        System.out.println(dog1.getName() + dog2.getName());
        System.out.println(dog1.getType() + " " + dog1.getGroup());
        System.out.println(dog1.getCurent());
        System.out.println(dog2);


        Nursery nursery_1 = new Nursery("Grom");
        nursery_1.add_animal(dog1);
        nursery_1.add_animal(dog2);
        nursery_1.add_animal(cat1);

        System.out.println((nursery_1.size_nursery()));






    }
}
