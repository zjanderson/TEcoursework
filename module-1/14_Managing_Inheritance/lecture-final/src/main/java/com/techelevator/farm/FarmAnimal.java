package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean isAsleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public String getName( ) {
		return name;
	}

	public final String getSound( ) {
		if (isAsleep) {
			return "Zzzzzzz";
		}

		return sound;
	}

	public abstract String eat();

	public void sleep() {
		isAsleep = true;
	}

	public void wakeUp() {
		isAsleep = false;
	}

	public static FarmAnimal create(String type) {
		switch(type.toUpperCase()) {
			case "COW":
				return new Cow();
			case "PIG":
				return new Pig();
			case "CHICKEN":
				return new Chicken();
			default:
				return null;
		}
	}

	@Override
	public String toString() {
		return getName() + " " + getSound();
	}
}