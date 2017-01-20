package controller;

import java.util.List;

public abstract class Command {

    protected List<String> params;

    public abstract void execute();
}
