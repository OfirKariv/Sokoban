package model.data;

import java.io.OutputStream;

public interface LevelSaver {

    public OutputStream SaveLevel(Level level, String s);
}
