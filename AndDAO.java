package DAO;

import java.sql.*;

public class AndDAO {
    private static String url = "jdbc:mysql://127.0.0.1:3306/andorid?serverTimezone=UTC";
    private static String user = "root";
    private static String password = "19970426";

    public static void add(String receive, String response) {

        String sql = "INSERT INTO andorid (receive,response) VALUES(?,?)";
        try(Connection connection = DriverManager.getConnection(url,user,password)){
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,receive);
            ps.setString(2,response);
            ps.execute();
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static void delete(int id) {

        String sql = "DELETE FROM TABLE andorid WHERE id=?";
        try(Connection connection = DriverManager.getConnection(url,user,password)){
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static String search(String text) {

        String sql = "SELECT receive,response FROM andorid";
        String comman = "i do not know";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(url,user,password)){
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String result = rs.getString("receive");
                if(text.equals(result)){
                    comman = rs.getString("response");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return comman;
    }
}
