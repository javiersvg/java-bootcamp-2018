package proxy;

public class ProxyConnection implements Connection {

    private RealConnection realConnection;
    private String         driver;
    private String         user;
    private String         password;

    public ProxyConnection(String driver, String user, String password) {

        this.driver = driver;
        this.user = user;
        this.password = password;
    }

    @Override
    public void show() {
        if (realConnection == null) {
            realConnection = new RealConnection(driver, user, password);
        }
        realConnection.show();

    }
}
