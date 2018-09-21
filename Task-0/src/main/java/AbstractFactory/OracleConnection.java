package AbstractFactory;

public class OracleConnection implements Connection{

    private final static String driver = "oracle.jdbc.driver.OracleDriver";
    
    private String user;
    private String password;
    
    @Override
    public void String setUser(String user){
        
        this.user = user;
        
    }
    
    @Override
    public void String setPassword(String password){
        
        this.password = password;
        
    }
    
    public String toString(){
        
        return "Connection Data: " + driver + " USER: " + user + " PASSWORD: " + password;
        
    }

}
