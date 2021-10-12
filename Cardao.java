package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Car;

public class Cardao {
	
	private final static String CREATE_QUERY = "INSERT INTO car values(?,?,?,?,?)";
	private final String SELECT_QUERY = "SELECT* FROM car";
	private final String UPDATE_QUERY = "UPDATE car SET make =? WHERE carNum =?";
	private final String DELETE_Query = "Delete from car WHERE carNum = ? ";
	private Connection con;
	
	public Cardao() {
		try {
			this.con = DBconnection.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void creatAnewCar (int carNum, String vnNum, String color, String make, int year) throws SQLException {
		PreparedStatement ps = con.prepareStatement(CREATE_QUERY);
		ps.setInt(1, carNum);
		ps.setString(2, vnNum);
		ps.setString(3, color);
		ps.setString(4, make);
		ps.setInt(5, year);
		ps.executeUpdate();
	}
	
	public List<Car> getCars() throws SQLException{
		PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
		ResultSet rs = ps.executeQuery();
		List<Car> cars = new ArrayList<Car>();
		while (rs.next()) {
			cars.add(new Car (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
		}
		return cars;
	}
	
	public void updateCar(int carNum, String make) throws SQLException {
		PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
		ps.setString(1, make);
		ps.setInt(2, carNum);
		ps.executeUpdate();
	}
	
	public void deleteCar(int carNum) throws SQLException {
		PreparedStatement ps = con.prepareStatement(DELETE_Query);
		ps.setInt(1,carNum);
		ps.executeUpdate();
	}
}
