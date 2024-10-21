package AnimalNursery.model;

public class Hamster extends Pets {

    public Hamster() {
        setType("hamster");
    }

    public Hamster(String name) {
        setName(name);
        setType("hamster");

    }

    @Override
    public String toString() {
        return "кличка-" + getName()+ " " + "тип-" + getType() + " " + "категория-" + getGroup();
    }
}

