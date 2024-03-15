class DBConfiguration {
    String user;
    String password;
}


public class DBHandler
{

    DBConfiguration configureDB (String uname, String password){
        return DBConfiguration;
    }

        public static void main(String[] args) {
            DBHandler r = new DBHandler();
            DBConfiguration dbConf = r.configureDB("manager", "manager");
        }
}
