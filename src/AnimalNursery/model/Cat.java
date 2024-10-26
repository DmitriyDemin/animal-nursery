package AnimalNursery.model;

import java.time.LocalDate;

public class Cat extends Pet {

    public Cat() {
        setType("Кошка");
    }

    public Cat(String name, LocalDate birthday) {
        setNickname(name);
        setBirthday(birthday);
        setType("Кошка");
    }

    public Cat(String name) {
        setNickname(name);
        setType("Кошка");

    }


}

