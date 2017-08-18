package com.webServices;

public class Temperature {
	public int changeFahrToCelsius(int Fahr) {
		return ((Fahr - 32) * 5 / 9);
	}
}
