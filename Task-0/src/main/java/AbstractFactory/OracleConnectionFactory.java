package AbstractFactory;

public class OracleConnectionFactory implements AbstractFactory {

    @Override
    public Connection create() {

        return new OracleConnection();

    }

}
