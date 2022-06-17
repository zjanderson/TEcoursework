package com.techelevator.vendingmachine.exception;

public class InvalidSlotLocationException extends RuntimeException {
	public InvalidSlotLocationException(String message) {
		super(message);
	}
}
