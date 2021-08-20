import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        SQLAccess sql = new SQLAccess();

        //First Query(Select)
        ResultSet q1 = sql.getResultSet("SELECT * FROM user");
        while(q1.next()) {
            String name = q1.getString(1);
            String password = q1.getString(2);
            int id = q1.getInt(3);
            String mail = q1.getString(4);
            User user = new User(name,password,id,mail);
            System.out.println(user.toString());
        }

        //Second Query(Insert)
        PreparedStatement pr1 = sql.con.prepareStatement("INSERT INTO user(Name,Password,id,Email) VALUES (?,?,?,?)");
        pr1.setString(1,"Valera");
        pr1.setString(2,"hfddfjdfj");
        pr1.setInt(3,2);
        pr1.setString(4,"fasgsdg@mail.ru");
        pr1.executeUpdate();

        //Third Query(Delete)
        PreparedStatement pr2 = sql.con.prepareStatement("DELETE FROM user WHERE Name='Valera'");
        pr2.executeUpdate();

        //Fourth Query(Update)
        PreparedStatement pr3 = sql.con.prepareStatement("UPDATE user SET Name='Kirill' WHERE id=1");
        pr3.executeUpdate();
        sql.CloseConnection();
    }
}
