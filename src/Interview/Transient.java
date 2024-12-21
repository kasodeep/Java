package Interview;

import java.io.*;

public class Transient {

    public static void main(String[] args) {
        User user = new User("Deep", "Secret");

        try {
            // Serialize the user object.
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("company.ser"));
            outputStream.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Serialize the user object.
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("company.ser"));
            User deserializedUser = (User) inputStream.readObject();
            System.out.println(deserializedUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class User implements Serializable {

    private String username;

    private transient String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
