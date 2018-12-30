package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import objects.Message;

public class DatabaseHandler {

	public DatabaseHandler() {

	}

	public void addPerson(String firstName, String lastName, String email, String username, String password) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MaehlumChat", "root",
					"Macbook1");
			Statement statement = (Statement) connection.createStatement();
			String sql = "insert into Person (firstName, lastName, email, username, password) values('" + firstName
					+ "','" + lastName + "','" + email + "','" + username + "','" + password + "')";
			statement.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("Something went wrong... " + e);
		}

	}

	public void addMessage(String sender, String date, String message) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MaehlumChat", "root",
					"Macbook1");
			Statement statement = (Statement) connection.createStatement();
			String sql = "insert into Message (sender, date, message) values('" + sender + "','" + date + "','"
					+ message + "')";
			statement.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("Something went wrong... " + e);
		}

	}

	public boolean exists(String username, String password) {

		boolean exists = false;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MaehlumChat", "root",
					"Macbook1");
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Person");

			while (rs.next()) {
				String u = rs.getString(4);
				String p = rs.getString(5);

				if (username.equals(u) && password.equals(p)) {
					exists = true;
				}
			}

			return exists;

		} catch (Exception e) {
			System.out.println("Something went wrong... " + e);
		}
		return exists;
	}

	public List<Message> getMessages() {

		List<Message> list = new ArrayList<Message>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MaehlumChat", "root",
					"Macbook1");
			Statement statement = (Statement) connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Message");

			while (rs.next()) {
				String a = rs.getString(1);
				String b = rs.getString(2);
				String c = rs.getString(3);

				list.add(new Message(a, b, c));

			}

		} catch (Exception e) {
			System.out.println("Something went wrong... " + e);
		}

		return list;
	}

	
}
