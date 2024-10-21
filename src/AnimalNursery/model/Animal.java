package AnimalNursery.model;

import java.util.ArrayList;
import java.util.Date;

public class Animal {
    private String group;
    private String type;
    private Date birthday;
    private ArrayList<String> comands = new ArrayList<>();
    private String name;
    private static int counter;

    public Animal() {
        counter++;

    }

    public int getCounter() {
        return counter;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public ArrayList<String> getComands() {
        return comands;
    }

    public void setComands(ArrayList<String> comands) {
        this.comands = comands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "кличка-" + getName() + " " + "тип-" + getType() + " " + "категория-" + getGroup();
    }
}
