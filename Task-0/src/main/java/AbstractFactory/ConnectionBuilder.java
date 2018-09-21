package AbstractFactory;

public class ConnectionBuilder {
    
    public Connection buildConnection(AbstractFactory connectionFactory, String user, String password){
        
        Connection con = connectionFactory.create();
        
        con.setUser(user);
        con.setPassword(password);
        
        return con;
        
    }
}
