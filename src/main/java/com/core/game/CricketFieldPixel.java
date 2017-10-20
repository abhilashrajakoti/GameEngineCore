package com.core.game;

public class CricketFieldPixel extends CricketGround {
	private int id;
	private String name;
	private int cssTop;
	private int cssLeft;

	public int getCssTop() {
		return cssTop;
	}

	public void setCssTop(int cssTop) {
		this.cssTop = cssTop;
	}

	public int getCssLeft() {
		return cssLeft;
	}

	public void setCssLeft(int cssLeft) {
		this.cssLeft = cssLeft;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}