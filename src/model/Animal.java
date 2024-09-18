package model;

import java.util.Date;

public class Animal {
    private String name;
    private Date birthday;


    public Animal(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }
}
