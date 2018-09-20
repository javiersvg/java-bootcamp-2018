package AbstractFactory;

public class MySQLConnectionFactory implements AbstractFactory {

    @Override
    public Connection create() {

        return new MySQLConnection();

    }

}
