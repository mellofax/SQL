import java.sql.*;

public class SQLAccess {

    private String user = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/test";

    Connection con;
    Statement statement;

    public SQLAccess() throws SQLException {
        con = DriverManager.getConnection(url,user,password);
        if(con!=null)
        {
            System.out.println("Connection Success!");
            statement = con.createStatement();
        }
    }

    public Boolean Result(String Query) throws SQLException {
        ResultSet q1 = getResultSet(Query);
        return q1.next();
    }
    public ResultSet getResultSet(String Query) throws SQLException {
        return statement.executeQuery(Query);
    }

    public void CloseConnection() throws SQLException {
        con.close();
        System.out.println("Connection has been closed!");
    }
}
