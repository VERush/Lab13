package com.roshambo.gc;

public abstract class Player {
	private String name;

	enum roshambo {
		Rock, Paper, Scissors
	};

	public abstract roshambo generateRoshambo();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

