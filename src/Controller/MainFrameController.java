package Controller;


import View.TimeTabling;
import View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainFrameController {
    private MainFrame mainF;
    
    public MainFrameController(MainFrame mainF){
        this.mainF = mainF;
        mainF.addCreateTimeTablingListener(new MainFrameListener());             
    }
    
    class MainFrameListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                TimeTabling timeTabling = new TimeTabling();
                timeTabling.setVisible(true);
                timeTabling.setLocationRelativeTo(null);
                
            } catch (Exception ex) {
            }
        }
        

        
        
    }
    
    
    
}
