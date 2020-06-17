import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MovieProj extends javax.swing.JFrame implements ActionListener
{
    // these are the components we need.
    private final JSplitPane splitPane;  // split the window in top and bottom
    private final JPanel topPanel;       // container panel for the top
    private final JPanel bottomPanel;    // container panel for the bottom
    private final JPanel panel;      
    private final JButton button;         
    private final JPanel inputPanel;
    private JLabel label;
    private JLabel l1;
    private JLabel la;
    private final JLabel ltext;
    private JPanel panel1; 
    private JButton tbutton;
    
    int i;
    int selected[];
    int amt;
    int cost;
    private JButton[] bu=new JButton[3];
   private JLabel[] l=new JLabel[3];
   private JPanel[] p=new JPanel[3]; 
    JButton[] buttons = new JButton[100];
    public MovieProj()
    {
       
       selected=new int[100];
       panel1=new JPanel();
       panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
       
       
        splitPane = new JSplitPane();
        topPanel = new JPanel( );         // our top component
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        bottomPanel = new JPanel();      // our bottom component
        label=new JLabel();      //label //for inputpanel
        ltext=new JLabel("TOTAL AMOUNT = Rs.");
        
        inputPanel = new JPanel();
        button = new JButton("Done");        
        topPanel.setBackground(Color.white);

       la=new JLabel("COLOR CODES:");
       for(int i=0;i<3;i++)
        {
            p[i]=new JPanel();
            p[i].setLayout(new BoxLayout(p[i], BoxLayout.X_AXIS) );
            p[i].setBackground(Color.white);
            bu[i]=new JButton();
 
        }
        
        bu[0].setSize(20, 80);
        bu[0].setBackground(Color.blue);
        l[0]= new JLabel("GENERAL");        
        p[0].add(bu[0]);        
        p[0].add(l[0]);
        
        bu[1].setSize(20, 80);
        bu[1].setBackground(Color.green);
        l[1]= new JLabel("SILVER");       
        p[1].add(bu[1]);
        p[1].add(l[1]);   
        
        bu[2].setSize(10, 80);
        bu[2].setBackground(Color.yellow);
        l[2]=new JLabel("GOLD");        
        p[2].add(bu[2]);
        p[2].add(l[2]);
        
        topPanel.add(la);
        topPanel.add(Box.createHorizontalGlue());         
        topPanel.add(p[0]);
        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(p[1]);
        topPanel.add(Box.createHorizontalGlue());
        topPanel.add(p[2]);
        topPanel.add(Box.createHorizontalGlue());
        
        
         panel=new JPanel();
        // now lets define the default size of our window and its layout:
        setPreferredSize(new Dimension(400, 400));     // let's open the window with a default size of 400x400 pixels
        // the contentPane is the container that holds all our components
        getContentPane().setLayout(new GridLayout());  // the default GridLayout is like a grid with 1 column and 1 row,
        // we only add one element to the window itself
        getContentPane().add(splitPane);               // due to the GridLayout, our splitPane will now fill the whole window
        // let's configure our splitPane:
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window verticaly
        splitPane.setDividerLocation(50);                    // the initial position of the divider is 200 (our window is 400 pixels high)
        splitPane.setTopComponent(topPanel);                  // at the top we want our "topPanel"
        splitPane.setBottomComponent(bottomPanel);            // and at the bottom we want our "bottomPanel
        // our topPanel doesn't need anymore for this example. Whatever you want it to contain, you can add it here
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS)); // BoxLayout.Y_AXIS will arrange the content vertically
        panel.setLayout(new GridLayout(10,10,10,10));
        panel.setLocation(120,120);
        panel.setBackground(Color.white);
        String b[]=new String[100];
        for(i=0;i<100;i++)
        {
            b[i]=String.valueOf(i+1);
        }
        Icon icon = new ImageIcon("E:\\im.png");
        for( i = 0; i < 40; i++)
        {          //start of general class
            buttons[i] = new JButton();
            buttons[i].setSize(80, 80);
            buttons[i].setBackground(Color.white);
            buttons[i].setActionCommand(b[i]);
            buttons[i].setBorder(BorderFactory.createLineBorder(Color.blue));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
            }
            for( i = 40; i < 70; i++) 
            {      //start of silver class
               buttons[i] = new JButton();
               buttons[i].setSize(80, 80);
               buttons[i].setBackground(Color.white);
               buttons[i].setActionCommand(b[i]);
               buttons[i].setBorder(BorderFactory.createLineBorder(Color.green));
               buttons[i].addActionListener(this);
               panel.add(buttons[i]);
            }
            for( i = 70; i < 100; i++) 
            {     //start of gold class
               buttons[i] = new JButton();
               buttons[i].setSize(80, 80);
               buttons[i].setBackground(Color.white);
               buttons[i].setActionCommand(b[i]);
               buttons[i].setBorder(BorderFactory.createLineBorder(Color.yellow));
               buttons[i].addActionListener(this);
               panel.add(buttons[i]);
            }

        panel1.add(Box.createRigidArea(new Dimension(350,0)));
        panel1.add(panel);
        panel1.add(Box.createRigidArea(new Dimension(350,0)));
        panel1.setBackground(Color.white);
        bottomPanel.add(panel1);                
        button.addActionListener(this);

        inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));     // we set the max height to 75 and the max width to (almost) unlimited
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));   // X_Axis will arrange the content horizontally
        inputPanel.add(ltext);
        inputPanel.add(label);
        inputPanel.add(Box.createHorizontalGlue());        // left will be the textField
        inputPanel.add(button);        // and right the "send" button
        bottomPanel.add(inputPanel);
        this.setTitle("TICKET BOOKING");
       pack();   // calling pack() at the end, will ensure that every layout and size we just defined gets applied before the stuff becomes visible
       
    }//end of constructor
                                 
               
    public void actionPerformed(ActionEvent e)
    {    
         int k;
         if(e.getSource()==button)
         {   
            amt=0;
             new DialogExample(); 
         }
         String choice = e.getActionCommand();
         int x=Integer.valueOf(choice);
         String y="general";
         try
         {
            if(selected[x-1]!=0)
               k=1/0;
         }
         catch(ArithmeticException m)
         {
              JOptionPane.showMessageDialog(null,"THE SEAT IS ALREADY BOOKED"+"\nPLEASE BOOK ANOTHER");
         }
         if(x>0 && x<=40 && selected[x-1]==0)
         {
            buttons[x-1].setBackground(Color.blue);
            amt+=100;cost=100;y="GENERAL";selected[x-1]=1;
         }
          if(x>40 && x<=70 && selected[x-1]==0)
         {
            buttons[x-1].setBackground(Color.green);
            amt+=200;cost=200;y="GOLD";selected[x-1]=1;
         }
          if(x>70 && x<=100 && selected[x-1]==0)
         {
            buttons[x-1].setBackground(Color.yellow);
            amt+=300;cost=300;y="PLATINUM";selected[x-1]=1;
         }   
         JOptionPane.showMessageDialog(null,"Seat number: "+choice+"\nCLASS:"+y+"\nCost of the ticket =Rs."+cost);
         label.setText(String.valueOf(amt));
    }
               
    public static void main(String args[]){
        
        EventQueue.invokeLater(new Runnable(){
            //@Override
            public void run(){
                new MovieProj().setVisible(true);
            }
        });
    }
}