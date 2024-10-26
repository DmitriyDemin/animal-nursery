package AnimalNursery.model;

import java.time.LocalDate;

public class Dog extends Pet {

    public Dog(String name, LocalDate birthday) {
        setNickname(name);
        setBirthday(birthday);
        setType("Собака");
    }

    public Dog(String name) {
        setNickname(name);
        setType("Собака");
    }
}

