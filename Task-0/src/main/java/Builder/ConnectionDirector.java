package Builder;

public class ConnectionDirector {

    private ConnectionBuilder connectionBuilder = null;

    public ConnectionDirector(ConnectionBuilder connectionBuilder) {

        this.connectionBuilder = connectionBuilder;

    }

    public void makeConneciton() {

        connectionBuilder.buildDriver();
        connectionBuilder.buildUser();
        connectionBuilder.buildPassword();

    }

    public Connection getConnection() {

        return connectionBuilder.getConnection();

    }
}
