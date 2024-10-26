package AnimalNursery.model;

import java.time.LocalDate;

public class Camel extends PackAnimal {

    public Camel() {
        setType("Верблюд");
    }

    public Camel(String name, LocalDate birthday) {
        setNickname(name);
        setBirthday(birthday);
        setType("Верблюд");

    }


}

