
package Controller;

import Model.Histogram;
import Model.Mail;
import View.HistogramDisplay;
import View.MailHistogramBuilder;
import View.MailListReaderBD;
import java.util.List;

/**
 *
 * @author saul
 */
public class Kata5 {

    private String filename;
    private List<Mail> maillist;
    private Histogram<String> histogram;
    private HistogramDisplay histogramd;
    

    public Kata5(String filename){
        this.filename = filename;
    }
    
    public void execute(){
        input();
        process();
        output();
    }
    
    public void input(){
        maillist = MailListReaderBD.read(filename);
    }
    
    public void process(){
        histogram = MailHistogramBuilder.build(maillist);
    }
    
    public void output(){
        histogramd = new HistogramDisplay(histogram);
        histogramd.execute(); 
    }
    
    public static void main(String[] args) {
        Kata5 control = new Kata5("email.txt");
        control.execute();   
    }

    
}

