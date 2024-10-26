package AnimalNursery.model;

import java.time.LocalDate;

public class Donkey extends PackAnimal {

    public Donkey() {
        setType("Осел");
    }

    public Donkey(String name, LocalDate birthday) {
        setNickname(name);
        setBirthday(birthday);
        setType("Осел");

    }


}

