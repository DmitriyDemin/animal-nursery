package AnimalNursery.model;

import java.util.ArrayList;
import java.util.Date;

public class Animal {
    private String group = null;
    private String type = null;
    private Date birthday = null;
    private ArrayList<String> comands = new ArrayList<>();
    private String name = null;
    private static int curent;

    public Animal() {
        curent++;

    }

    public int getCurent() {
        return curent;
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
}
