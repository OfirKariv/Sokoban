package model.data;

import java.io.OutputStream;

import model.data.util.Level;

public interface LevelSaver {

    public OutputStream saveLevel(Level level, String s);
}
