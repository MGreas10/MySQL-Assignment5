package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.Cardao;
import entity.Car;

public class App {
	
	static Scanner scanner = new Scanner (System.in);
	private static String[] options = {"Create a new car","Display cars", "Update car", "Delete car"};
	public static Cardao cardao = new Cardao();
	
	public static void printOptions(){
		for (int i =0; i<options.length; i++) {
			System.out.println (i+1 +") " + options[i]);
		}	
		
	}
	
	public static void start() {
		String selection = " ";		
		do {	
			printOptions();
			System.out.println("Please Enter a selection number: ");
			selection = scanner.nextLine();	
			try {
				switch (selection){
				case "1":
					creatAnewCar();
					break;
				case "2":
					displayCars();
					break;
				case "3":
					updateCar();
					break;
				case "4":
					deleteCar();
					break;	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
			System.out.println("  Please press enter to continue");
			scanner.nextLine();
	
			
		} while (!selection.equals("-1"));
		
		
	}
	
	
	private static void creatAnewCar() throws SQLException {
		System.out.print("Please Enter Car Number");
		int carNum = scanner.nextInt();
		System.out.print("Please Enter Vn Number");
		String vnNum = scanner.next();
		System.out.print("Please Enter color");
		String color = scanner.next();
		System.out.print("Please Enter car make");
		String make = scanner.next();
		System.out.print("Please Enter year");
		int year = scanner.nextInt();
		cardao.creatAnewCar(carNum, vnNum, color, make, year);
	}
	
	private static void displayCars() throws SQLException {
		List<Car> cars = cardao.getCars();
		for (Car car : cars) {
			System.out.println("Car#: " + car.getCarNum() + " VN# " + car.getVnNum() 
			+ " Color: " + car.getColor() + " Car make: " + car.getMake() + " Year: " + car.getYear());
		}
		
	}
	
	private static void updateCar() throws SQLException {
	System.out.print("Please enter the number of the car you want to update");
	int id = scanner.nextInt();
	System.out.print("Please enter the new make: ");
	String newMake = scanner.next();
	cardao.updateCar(id, newMake);	
	}
	
	private static void deleteCar() throws SQLException {
		System.out.println("Please enter the number of the car you want to delete: ");
		int carNumber = scanner.nextInt();
		cardao.deleteCar(carNumber);
	}


	public static void main(String[] args) {
		App.start();

	}

}
