package View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Model.Mail;

/**
 *
 * @author saul
 */
public class MailListReader {
    
    public static List<Mail> readed;

    public MailListReader() {
    }
    
     public static List<Mail> read(String name){
         
        ArrayList<Mail> mails = new ArrayList<>();
        
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
            
            String current;
            
            while((current = bufferedReader.readLine()) != null)
            {
                if(current.contains("@"))
                    mails.add(new Mail(current));
            }
            
        } 
        
        catch(FileNotFoundException e) {}
        catch(IOException e) {}
        
        return mails; 
    }
}