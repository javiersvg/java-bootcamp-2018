package Builder;

public interface ConnectionBuilder {

    void buildDriver();
    void buildUser();
    void buildPassword();
    
    Connection getConnection();

}
