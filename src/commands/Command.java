package commands;

import java.util.ArrayList;
import java.io.Serializable;

public abstract class Command implements Serializable {

    private static final long serialVersionUID = 2L;
    public String name;
    public int argsAmount;

    public abstract void execute();

    public abstract void execute(ArrayList<String> args);

}
