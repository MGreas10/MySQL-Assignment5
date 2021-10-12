package entity;

public class Car {

	private int carNum;
	private String vnNum;
	private String color;
	private String make;
	private int year;
	
	
	
	public Car(int carNum, String vnNum, String color, String make, int year) {
		this.setCarNum(carNum);
		this.setVnNum(vnNum);
		this.setColor(color);
		this.setMake(make);
		this.setYear(year);
	}


	public int getCarNum() {
		return carNum;
	}


	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}


	public String getVnNum() {
		return vnNum;
	}


	public void setVnNum(String vnNum) {
		this.vnNum = vnNum;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}
	
	
}

