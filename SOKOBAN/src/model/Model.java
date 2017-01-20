package model;

import model.data.Level;

public interface Model {

    public Level load();

    public void save();

    public Level getCurrentLevel();

    public Level move();

}
