package AnimalNursery.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Animal {
    private String group;
    private String type;
    private LocalDate birthday;
    private ArrayList<String> commands = new ArrayList<>();
    private String nickname;
    private int animal_id;
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

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    @Override
    public String toString() {
        return "ID-" + getAnimal_id() + "\tкличка-" + getNickname() + " " + "\t дата рождения-" + getBirthday() + " " + " категория-" + getGroup()+ " " + " тип-" + getType();
    }
}
