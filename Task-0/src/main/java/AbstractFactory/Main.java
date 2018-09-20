package AbstractFactory;

public class Main {

    public static void main(String[] args) {

        ConnectionBuilder builder = new ConnectionBuilder();

        AbstractFactory connectionFactory;

        String user = "admin";
        String password = "password";
        String dbType = "ORACLEDB";

        Connection con;

        if (dbType == "ORACLEDB") {

            connectionFactory = new OracleConnectionFactory();

        } else if (dbType == "MySQLDB") {

            connectionFactory = new MySQLConnectionFactory();

        } else {

            connectionFactory = new MySQLConnectionFactory();
        }

        con = builder.buildConnection(connectionFactory, user, password);

        System.out.prinln(con.toString());

    }
}
