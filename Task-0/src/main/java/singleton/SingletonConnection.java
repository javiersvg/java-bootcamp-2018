package singleton;

public class SingletonConnection {

    private String connection;
    private static SingletonConnection con;

    private SingletonConnection(String connectionString) {
        this.connection = connectionString;

    }

    public static SingletonConnection getInstance(String connectionString) {
        if (con == null) {
            con = new SingletonConnection(connectionString);
        }
        return con;

    }

    public String toString(){
        return connection;
        
    }
}

