package AbstractFactory;

public class MySQLConnection implements Connection {

    private final static String DRIVER = "com.mysql.jdbc.Driver";

    private String              user;
    private String              password;

    @Override
    public void setUser(String user) {

        this.user = user;

    }

    @Override
    public void setPassword(String password) {

        this.password = password;

    }

    public String toString() {

        return "Connection Data: " + DRIVER + " USER: " + user + " PASSWORD: " + password;

    }

}
