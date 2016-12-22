import java.io.*;
import java.util.Base64;

public class User implements Externalizable {
  String username;
  String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public User() {
  }

  private String encrypt(String password) {
    return new String(Base64.getEncoder().encode(password.getBytes()));
  }

  private String decrypt(String password) {
    return new String(Base64.getDecoder().decode(password));
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeObject(username);
    out.writeObject(encrypt(password));
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    username = (String) in.readObject();
    password = decrypt((String) in.readObject());
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}