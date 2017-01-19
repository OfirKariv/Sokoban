package model;

import java.io.OutputStream;

public interface LevelSaver {

    public OutputStream SaveLevel(Level level, String s);
}
