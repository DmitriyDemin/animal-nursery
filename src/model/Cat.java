package model;

import java.util.Date;

public class Cat extends Animal{

    public String type = "cat";

    public Cat(String name, Date birthday) {
        super(name, birthday);
    }

    public String getType() {
        return type;
    }
}
