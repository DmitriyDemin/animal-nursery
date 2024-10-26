package AnimalNursery.model;

import java.time.LocalDate;

public class Horse extends PackAnimal {

    public Horse() {
        setType("Лошадь");
    }

    public Horse(String name, LocalDate birthday) {
        setNickname(name);
        setBirthday(birthday);
        setType("Лошадь");

    }


}

