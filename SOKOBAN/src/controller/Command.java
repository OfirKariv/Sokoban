package controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.data.Level;

public interface Command {
    Level execute(String[] args, Level mylevel) throws FileNotFoundException, ClassNotFoundException, IOException;

}
