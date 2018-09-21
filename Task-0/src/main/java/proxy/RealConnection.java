package proxy;

public class RealConnection implements Connection {

    private String driver;
    private String user;
    private String password;

    public RealConnection(String driver, String user, String password) {

        this.driver = driver;
        this.user = user;
        this.password = password;
    }

    @Override
    public void show() {

        System.out.println("DRIVER: " + driver);

    }
}
