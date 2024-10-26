package AnimalNursery.model;

public class Command {

    private int command_id;
    private String command_name;
    private String description;

    public int getCommand_id() {
        return command_id;
    }

    public void setCommand_id(int command_id) {
        this.command_id = command_id;
    }

    public String getCommand_name() {
        return command_name;
    }

    public void setCommand_name(String command_name) {
        this.command_name = command_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString (){
        return "id=" + getCommand_id() + "\t" + "'"+ getCommand_name()+"'"+ "\t-" + getDescription()+"\n";
    }
}
