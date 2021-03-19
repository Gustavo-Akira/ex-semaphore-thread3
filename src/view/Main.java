package view;

import java.util.concurrent.Semaphore;

import controller.ClientThread;
import controller.TicketsController;

public class Main {
	public static void main(String[] args) {
		TicketsController controller = new TicketsController();
		Semaphore semaphore = new Semaphore(1);
		for (int x = 0; x < 300; x++) {
			ClientThread thread = new ClientThread(controller, semaphore);
			thread.start();
		}
	}
}
