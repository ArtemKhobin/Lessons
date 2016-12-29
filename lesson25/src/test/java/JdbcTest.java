import org.junit.Test;

import java.sql.*;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JdbcTest {
  @Test
  public void test_nothing() throws Exception {
    Class.forName("com.mysql.jdbc.Driver");

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
    DatabaseMetaData metaData = connection.getMetaData();
    System.out.println(metaData.getDatabaseProductName());

    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_UPDATABLE);
    //statement.execute("SELECT * FROM country");
    statement.execute("SELECT * FROM country");
    statement.execute("SELECT * FROM city order by id asc");
    ResultSet resultSet = statement.getResultSet();
    //ResultSet resultSet2 = statement.getResultSet();
    System.out.println(resultSet);

    resultSet.first();
    resultSet.beforeFirst();
    resultSet.last();
    resultSet.next();
    resultSet.absolute(4);
    resultSet.relative(-2);

    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
    System.out.println(resultSetMetaData.getColumnName(1));
    System.out.println(resultSetMetaData.getColumnTypeName(3));

    System.out.println(resultSet.getString("name"));

    resultSet.updateString("name", "Ololo");
    resultSet.updateRow();

    resultSet.cancelRowUpdates();

    resultSet.moveToInsertRow();
    resultSet.updateString(2, "Ololoevsk");
    resultSet.updateString(3, "ukr");
    resultSet.updateString(4, "olololo");
    resultSet.updateInt(5, 547);
    resultSet.insertRow();

    resultSet.close();
    statement.close();
    connection.close();
    assertThat(true, is(true));
  }

  @Test
  public void testPreparedStatement() throws Exception {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");

    String sql = "SELECT * FROM city WHERE CountryCode = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, "UKR");

    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      System.out.format("%s: %s - %d\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(5));
    }
  }
}
