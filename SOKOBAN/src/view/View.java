package view;

import model.data.util.Level;

public interface View {

    public void Display(Level myLevel);

    public void DisplayMess(String s);

    public void start();

    public void stop();

}
