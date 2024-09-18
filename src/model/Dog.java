package model;

import java.util.Date;

public class Dog extends Animal {
    protected String type = "dog";

    public Dog(String name, Date birthday) {
        super(name, birthday);
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + ' ' + getName() + ' ' + getBirthday();
    }
}