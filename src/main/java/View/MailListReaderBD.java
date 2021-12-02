package View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Model.Mail;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author saul
 */
public class MailListReaderBD {
    

    public MailListReaderBD() {
    }
    
    public static List<Mail> read(String name){
        
        String url = "jdbc:sqlite:KATA5.db";

        ArrayList<Mail> mails = new ArrayList<>();
        
        String sentence = "SELECT * FROM EMAIL";
        
       try (Connection conection = DriverManager.getConnection(url);
             Statement statement = conection.createStatement();
             ResultSet result = statement.executeQuery(sentence)){
            
            while(result.next()){
                String resultString = result.getString("Mail");
                
                if(resultString.contains("@")){
                    mails.add(new Mail(resultString));
                }
                
            }
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return mails;
    }
}