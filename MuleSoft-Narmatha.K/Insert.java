import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
   
public class Insert {  
   
    private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/movie.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void insert(String movieName, String actor,String actress,String director,String yearOfRelease ) {  
        String sql = "INSERT INTO movie(movieName,actor,actress,director,yearOfRelease) VALUES(?,?,?,?,?)";  
   
        try{  
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, movieName);  
            pstmt.setString(2, actor);  
            pstmt.setString(3, actress);
            pstmt.setString(4, director);  
            pstmt.setString(5, yearOfRelease);    
            pstmt.executeUpdate();  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    public static void main(String[] args) {  
   
        Insert app = new Insert();  
        // insert three new rows  
        app.insert("Intrusion","Robert John Burke","Megan Elisabeth Kelly","Adam Salky","2021");
        app.insert("The Unholy","Jeffrey Dean Morgan","Katie Aselton","Evan Spiliotopoulos","2021");
        app.insert("The Vampire Diaries","Joseph Morgan","Candice King","Julie Plec","2016");
        app.insert("The Originals","Joseph Morgan","Phoebe Tonkin","Julie Plec","2018");
        app.insert("Squid Game","Lee Jung Jae","Wi Ha Jun","Hwang Dong Hyuk","2021");
        app.insert("All Of Us Are Dead","Park Ji Hu","Yoo In Soo","Lee JQ","2022");
        
        
         
    }  
   
}  