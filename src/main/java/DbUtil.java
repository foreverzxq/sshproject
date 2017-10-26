import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
    private static String DRIVER_DB2_CLASS = "oracle.jdbc.driver.OracleDriver";
    private static String USERNAME_DB2 = "testdb";
    private static String PWD_DB2 = "testdb";
    private static String URL_DB2 = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";


    static {
        try {
            Class.forName(DRIVER_DB2_CLASS);
        } catch (ClassNotFoundException e) {

        }
    }


    public static Connection getConn(String str) throws SQLException {
        if ("oralce".equals(str)) {
            return DriverManager.getConnection(URL_DB2, USERNAME_DB2, PWD_DB2);
        }
        return null;
    }


    public static void closeConnQuietly(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ioe) {
            // ignore
        }
    }



    public static void closeRsQuietly(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ioe) {
            // ignore
        }
    }

    public static void main(String str[]) {
        Connection conn = null;
        try{
            conn = DbUtil.getConn("oralce");
            System.out.println(conn);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbUtil.closeConnQuietly(conn);
        }

    }
}
