package AnimalNursery.model;

public class Dog extends Pets {

    public Dog() {
        setType("dog");
    }

    public Dog(String name) {
        setName(name);
        setType("dog");

    }

    @Override
    public String toString() {
        return "кличка-" + getName()+ " " + "тип-" + getType() + " " + "категория-" + getGroup();
    }
}

