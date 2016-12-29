import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MainTest {
  @Test
  public void name() throws Exception {
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
    Statement statement = connection.createStatement();
    statement.execute("SELECT * FROM city");
    ResultSet result = statement.getResultSet();

    while (result.next()) {
      String res = String.format("{id=%d; name=%s}", result.getInt("id"), result.getString("Name"));
      System.out.println(res);
    }

    result.close();
    statement.close();
    connection.close();
  }

  @Test
  public void testJoiner() throws Exception {
    StringJoiner joiner = new StringJoiner(",", "[", "]");
    for (int i = 1; i <= 5; i++) {
      joiner.add(Integer.toString(i));
    }

    System.out.println(joiner.toString());
  }
}
