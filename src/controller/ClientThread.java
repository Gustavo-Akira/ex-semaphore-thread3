package controller;

import java.util.concurrent.Semaphore;

import exception.TimeOutException;

public class ClientThread extends Thread {
	private TicketsController controller;
	private Semaphore semaphore;
	private int numberOfTickets = (int) (1 + Math.random() * 4);

	public ClientThread(TicketsController controller, Semaphore semaphore) {
		this.controller = controller;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		for (int x = 0; x < 3; x++) {
			try {
				calculateTime(x);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		interrupt();
	}

	private void calculateTime(int method) throws InterruptedException {
		String operation = "";
		long init = System.currentTimeMillis();
		long maxTime = 0;
		switch (method) {
		case 0:
			loginAndPurchase(0);
			maxTime = 1000;
			operation = "login";
			break;
		case 1:
			loginAndPurchase(1);
			maxTime = 2500;
			operation = "session";
			break;
		case 2:
			validation();
			operation = "validation";
			break;
		}
		long totalTime = System.currentTimeMillis() - init;
		if (totalTime > maxTime && maxTime != 0) {
			throw new TimeOutException(operation);
		} else {
			System.out.println(
					operation + " was successfull in " + ((double) totalTime / 1000) + "seconds in thread " + getId());
		}
	}

	private void loginAndPurchase(int method) throws InterruptedException {
		long time = 0;
		if (method == 0) {
			time = (long) (50 + Math.random() * 2000);
		} else {
			time = (long) (1000 + Math.random() * 3000);
		}
		sleep(time);
	}

	private void validation() throws InterruptedException {
		semaphore.acquire();
		controller.reduceTicket(numberOfTickets);
		semaphore.release();
	}
}
