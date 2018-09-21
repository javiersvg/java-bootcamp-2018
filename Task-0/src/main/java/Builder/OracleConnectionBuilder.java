package Builder;

public class OracleConnectionBuilder implements ConnectionBuilder {

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

        con.setDriver("oracle.jdbc.driver.OracleDriver");

    }

    public Connection getConnection() {

        return con;
    }

}
