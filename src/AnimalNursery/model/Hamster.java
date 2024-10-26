package AnimalNursery.model;

import java.time.LocalDate;

public class Hamster extends Pet {

    public Hamster() {
        setType("Хомяк");
    }

    public Hamster(String name, LocalDate birthday) {
        setNickname(name);
        setBirthday(birthday);
        setType("Хомяк");

    }


}

