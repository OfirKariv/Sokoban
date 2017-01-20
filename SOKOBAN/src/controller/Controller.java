package controller;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import model.Model;
import view.View;

public abstract class Controller {

    private BlockingQueue<Command> queue = null;
    private boolean stop = false;
    Model model = null;
    View view = null;

    public Controller() {

	queue = new ArrayBlockingQueue<Command>(15);
    }

    public void insertCommand(Command cmd) {

	try {
	    queue.put(cmd);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	/*
	 * public void start() {
	 * 
	 * Thread thread = new Thread(new Runnable(){
	 * 
	 * @Override public void run() { while (!stop) { try { Command cmd =
	 * queue.poll(1, TimeUnit.SECONDS); if (cmd != null) cmd.execute(); }
	 * catch (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * });
	 * 
	 * thread.start();
	 */

    }

}
