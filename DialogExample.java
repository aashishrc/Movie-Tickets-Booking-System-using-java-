import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
public class DialogExample //implements ActionListener  
{    
   private static JDialog d;  
    DialogExample() {  
        JFrame f= new JFrame();  
        d = new JDialog(f , "Dialog Example", true);  
        d.setLayout( new FlowLayout() );  
        JButton b = new JButton ("OK");  
        b.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
                new MyFrame();  
            }  
        });  
        d.add( new JLabel ("Click button to continue."));  
        d.add(b);   
        d.setBounds(300,300,300,300);    
        d.setVisible(true);  
    }  
  
}  

