package controller;

import exception.TicketsInsufficientException;

public class TicketsController {
	private int tickets = 9000;

	public void reduceTicket(int retireTickets) {
		if (retireTickets > tickets) {
			throw new TicketsInsufficientException();
		}
		tickets = tickets - retireTickets;
	}
}
