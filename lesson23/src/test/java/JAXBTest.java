import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JAXBTest {
  @Test
  public void testJaxb() throws Exception {


    JAXBContext context = JAXBContext.newInstance(Person.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.marshal(new Person(), System.out);
  }

  @Test
  public void test1() throws Exception {
    Person person = new Person.Builder()
        .setId(123)
        .setName("Ololo")
        .setAge(25)
        .build();

    Writer writer = new StringWriter();

    JAXBContext context = JAXBContext.newInstance(Person.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.marshal(person, writer);

    String personXml = writer.toString();
    Reader reader = new StringReader(personXml);

    Unmarshaller unmarshaller = context.createUnmarshaller();
    Person newPerson = (Person) unmarshaller.unmarshal(reader);

    assertThat(newPerson.getAge(), is(person.getAge()));

  }
}
