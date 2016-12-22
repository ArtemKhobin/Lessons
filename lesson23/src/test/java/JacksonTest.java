import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class JacksonTest {
  @Test
  public void jacksonSimpleTest() throws Exception {
    User user = new User("Vasya", "123");

    ObjectMapper objectMapper = new ObjectMapper();

    objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    String userStr = objectMapper.writeValueAsString(user);

    objectMapper.readValue(userStr, User.class);

    System.out.println(objectMapper.writeValueAsString(user));
  }
}
