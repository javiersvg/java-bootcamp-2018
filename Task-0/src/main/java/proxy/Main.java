package proxy;

public class Main {

    public static void main(String[] args) {
        Connection conn = new ProxyConnection("ejemplo.driver", "user", "password");

        conn.show();
    }
}
