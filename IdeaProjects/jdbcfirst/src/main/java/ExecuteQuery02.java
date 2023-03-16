import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","06012012nd");
        Statement statement=connection.createStatement();
        String sql1="SELECT company, number_of_employees FROM companies ORDER BY number_of_employees DESC OFFSET 1 ROW LIMIT 1";
        ResultSet rs1=statement.executeQuery(sql1);
        while (rs1.next()) {
            System.out.println(rs1.getString(1)+" --> "+rs1.getString(2));
        }
        String sql2 ="SELECT company, number_of_employees FROM companies WHERE number_of_employees< (SELECT AVG(number_of_employees) FROM companies)";
        ResultSet rs2=statement.executeQuery(sql2);
        while (rs2.next()){
            System.out.println(rs2.getString(1)+" -- "+rs2.getString(2));
        }
    }
}
