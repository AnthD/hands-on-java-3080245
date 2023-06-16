package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {

  public static Connection connect() {

    String db_file = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;

    try {
      connection = DriverManager.getConnection(db_file);

      System.out.println("we'r connected");

    } catch (SQLException e) {

      e.printStackTrace();

    }

    return connection;

  }

  // Fetch Customer data from DB
  public static Customer getCustomer(String username) {

    String sql = "select * from customers where username = ?";

    Customer customer = null;

    try (Connection connection = connect();
        PreparedStatement statment = connection.prepareStatement(sql)) {

      // SQL variable - ? - column added
      statment.setString(1, username);

      // Query results
      try (ResultSet resultSet = statment.executeQuery()) {

        customer = new Customer(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("username"),
            resultSet.getString("password"),
            resultSet.getInt("account_id")

        );

      }

    } catch (SQLException e) {

      e.printStackTrace();
    }

    return customer;
  }

  // Fetch account data from DB
  public static Account getAccount(int id) {

    Account account = null;
    String sql = "select * from accounts where id = ?";

    try (Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, id);

      try (ResultSet resultSet = statement.executeQuery()) {

        account = new Account(
            resultSet.getInt("id"),
            resultSet.getString("type"),
            resultSet.getDouble("balance"));

      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return account;

  }

  public static void main(String[] args) {
    Customer customer = getCustomer("twest8o@friendfeed.com");

    System.out.println(customer.getName());

    Account account = getAccount(90431);

    System.out.println(account.getBalance());

  }

}
