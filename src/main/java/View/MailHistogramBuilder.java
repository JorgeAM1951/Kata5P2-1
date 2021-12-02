
package View;

/**
 *
 * @author saul
 */
import java.util.List;
import Model.Histogram;
import Model.Mail;

public class MailHistogramBuilder {

    public static Histogram<String> build(List<Mail> mails){
        
        Histogram<String> histo = new Histogram<>();
        
        for(Mail m : mails)
            histo.increment(m.getDomain());
        
        return histo;
    }
    
}