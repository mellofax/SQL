import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Tests {
    SQLAccess db;
    {
        try {
            db = new SQLAccess();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    User user = new User("Valera", "hfddfjdfj", 2, "fasgsdg@mail.ru");

    @Description("SqlInsertTest")
    @Test
    public void InsertTest() throws SQLException {

        Assert.assertEquals(java.util.Optional.of(db.Result("SELECT * FROM user WHERE Name ='" + user.getName() + "'")), java.util.Optional.of(false));

        PreparedStatement pr1 = db.con.prepareStatement("INSERT INTO user(Name,Password,id,Email) VALUES (?,?,?,?)");
        pr1.setString(1, user.getName());
        pr1.setString(2,user.getPassword());
        pr1.setInt(3,user.getId());
        pr1.setString(4,user.getMail());
        pr1.executeUpdate();

        Assert.assertEquals(java.util.Optional.of(db.Result("SELECT * FROM user WHERE Name ='"+ user.getName() + "'")), java.util.Optional.of(true));

    }
    @Description("SqlDeleteTest")
    @Test
    public void DeleteTest() throws SQLException {
        Assert.assertEquals(java.util.Optional.of(db.Result("SELECT * FROM user WHERE Name ='" + user.getName() + "'")), java.util.Optional.of(true));

        PreparedStatement pr2 = db.con.prepareStatement("DELETE FROM user WHERE Name = (?)");
        pr2.setString(1, user.getName());
        pr2.executeUpdate();

        Assert.assertEquals(java.util.Optional.of(db.Result("SELECT * FROM user WHERE Name ='" + user.getName() + "'")), java.util.Optional.of(false));
    }
}
