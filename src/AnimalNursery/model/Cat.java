package AnimalNursery.model;

public class Cat extends Pets {

    public Cat() {
        setType("dog");
    }

    public Cat(String name) {
        setName(name);
        setType("cat");

    }

    @Override
    public String toString() {
        return "кличка-" + getName()+ " " + "тип-" + getType() + " " + "категория-" + getGroup();
    }
}

