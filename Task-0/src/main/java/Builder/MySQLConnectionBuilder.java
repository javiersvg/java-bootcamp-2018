package Builder;

public class MySQLConnectionBuilder implements ConnectionBuilder {

    private Connection con;

    @Override
    public void buildUser() {

        con.setUser("admin");

    }

    @Override
    public void buildPassword() {

        con.setPassword("password");
    }

    @Override
    public void buildDriver() {

        con.setDriver("com.mysql.jdbc.Driver");

    }

    public Connection getConnection() {

        return con;

    }
}
