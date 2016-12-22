import org.junit.Test;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LocaleTest {

  @Test
  public void testLocale() throws Exception {
    Locale locale = new Locale("en", "US");
    Locale locale2 = Locale.CANADA;
    Locale locale3 = new Locale.Builder()
        .setLanguage("en")
        .setRegion("gb")
        .build();

    Locale locale4 = Locale.forLanguageTag("en-AU");

    System.out.println(locale.getDisplayCountry());
    System.out.println(locale2.getDisplayCountry());
    System.out.println(locale3.getDisplayCountry());
    System.out.println(locale4.getDisplayCountry());
  }

  @Test
  public void resourceBundleTest() throws Exception {
    ResourceBundle bundle = ResourceBundle.getBundle("i18n.bundle", Locale.ENGLISH);
    assertThat(bundle.getString("name"), is("Ololosha"));
  }

  @Test
  public void javaProperties() throws Exception {
    Properties properties = new Properties();
    properties.setProperty("name", "JR");
    properties.put("hello", "ololo");

    properties.store(new FileOutputStream("hello.properties"), "OLOLO");

    Properties rProperties = new Properties();
    rProperties.load(new FileReader("hello.properties"));

    assertThat(rProperties.getProperty("name"), is("JR"));

  }
}
