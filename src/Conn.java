import java.sql.*;
import com. mysql. cj. jdbc.Driver;
public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankManagementSystem","root","pranav@bit.25");
            s = c.createStatement();


        }catch (Exception e){
            System.out.println(e);
        }
    }
}
