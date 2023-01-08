

package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class SignupThree extends Frame implements ActionListener
{
    private JRadioButton r1,r2,r3,r4;
    private JCheckBox c1,c2,c3,c4,c5,c6,c7;
    private JButton submit,cancel;
    private String formno;
    SignupThree(String formno){
        this.formno=formno;
        JLabel l1=new JLabel("Page 3:Account Detail");
        l1.setFont(new Font("Railway",Font.BOLD,22));
         l1.setBounds(250,40,800,30);
         add(l1);
         
          JLabel accountType=new JLabel("Account Type");
        accountType.setFont(new Font("Railway",Font.BOLD,18));
         accountType.setBounds(140,100,600,30);
         add(accountType);
         
         r1=new JRadioButton("Saving Account");
         r1.setFont(new Font("Railway",Font.BOLD,16));
         r1.setBackground(Color.white);
         r1.setBounds(140,140,200,30);
         add(r1);
         
         r2=new JRadioButton("Current Account");
         r2.setFont(new Font("Railway",Font.BOLD,16));
         r2.setBackground(Color.white);
         r2.setBounds(450,140,200,30);
         add(r2);
         
         r3=new JRadioButton("Recurring Deposit Account");
         r3.setFont(new Font("Railway",Font.BOLD,16));
         r3.setBackground(Color.white);
         r3.setBounds(140,180,300,30);
         add(r3);
         
         r4=new JRadioButton("Fixed Deposit Account");
         r4.setFont(new Font("Railway",Font.BOLD,16));
         r4.setBackground(Color.white);
         r4.setBounds(450,180,200,30);
         add(r4); 
         
         ButtonGroup groupAccount=new ButtonGroup();
         groupAccount.add(r1);
         groupAccount.add(r2);
         groupAccount.add(r3);
         groupAccount.add(r4);
         
         JLabel cardNo=new JLabel("Card Number:");
         cardNo.setFont(new Font("Railway",Font.BOLD,18));
         cardNo.setBounds(140,250,200,20);
         add(cardNo);
         
         JLabel number=new JLabel("XXX XXX XXX 3223");
         number.setFont(new Font("Railway",Font.BOLD,18));
         number.setBounds(350,250,400,20);
         add(number);
         
          JLabel cardDetail=new JLabel("This is your 16 digit card no.");
         cardDetail.setFont(new Font("Railway",Font.ITALIC,10));
         cardDetail.setBounds(140,270,400,20);
         add(cardDetail);
         
         
         JLabel pinNo=new JLabel("Pin:");
         pinNo.setFont(new Font("Railway",Font.BOLD,18));
         pinNo.setBounds(140,300,200,20);
         add(pinNo);
         
         JLabel pin=new JLabel("XXXX");
         pin.setFont(new Font("Railway",Font.BOLD,18));
         pin.setBounds(350,300,400,20);
         add(pin);
         
              JLabel pinDetail=new JLabel("Your 4 digit password");
         pinDetail.setFont(new Font("Railway",Font.ITALIC,10));
         pinDetail.setBounds(140,320,400,20);
         add(pinDetail);
         
          JLabel services=new JLabel("Services Required");
         services.setFont(new Font("Railway",Font.BOLD,18));
         services.setBounds(140,360,400,20);
         add(services);
         
         c1=new JCheckBox("ATM card");
         c1.setBackground(Color.white);
         c1.setFont(new Font("Railway",Font.TYPE1_FONT,14));
         c1.setBounds(140,390,100,20);
         add(c1);
         
          c2=new JCheckBox("Internet Banking");
         c2.setBackground(Color.white);
         c2.setFont(new Font("Railway",Font.TYPE1_FONT,14));
         c2.setBounds(400,390,200,20);
         add(c2);
         
          c3=new JCheckBox("Mobile Banking");
         c3.setBackground(Color.white);
         c3.setFont(new Font("Railway",Font.TYPE1_FONT,14));
         c3.setBounds(140,420,200,20);
         add(c3);
         
          c4=new JCheckBox("Email alert");
         c4.setBackground(Color.white);
         c4.setFont(new Font("Railway",Font.TYPE1_FONT,14));
         c4.setBounds(400,420,200,20);
         add(c4);
         
          c5=new JCheckBox("CheckBook");
         c5.setBackground(Color.white);
         c5.setFont(new Font("Railway",Font.TYPE1_FONT,14));
         c5.setBounds(140,450,200,20);
         add(c5);
         
          c6=new JCheckBox("E-Statemnet");
         c6.setBackground(Color.white);
         c6.setFont(new Font("Railway",Font.TYPE1_FONT,14));
         c6.setBounds(400,450,200,20);
         add(c6);
         
          c7=new JCheckBox("1 hereby declare that the above entered details are correct to the best of my knowledge review");
         c7.setBackground(Color.white);
         c7.setFont(new Font("Railway",Font.TYPE1_FONT,12));
         c7.setBounds(140,490,800,50);
         add(c7);
         
         submit=new JButton("Submit");
         submit.setBackground(Color.black);
         submit.setForeground(Color.white);
         submit.setFont(new Font("Railway",Font.BOLD,14));
         submit.setBounds(220,570,100,30);
         submit.addActionListener(this);
         add(submit);
         
         
         
          cancel=new JButton("Cancel");
         cancel.setBackground(Color.black);
         cancel.setForeground(Color.white);
         cancel.setFont(new Font("Railway",Font.BOLD,14));
         cancel.setBounds(480,570,100,30);
         cancel.addActionListener(this);
         add(cancel);
      
         
         setTitle("Application Form");
        setSize(800,700);
           setBackground(Color.white);
        setLayout(null);
        setLocation(500,300);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            String AccountType=null;
            if(r1.isSelected()){
                AccountType="Saving Account";
            }
            else if(r2.isSelected()){
                AccountType="Current Account";
            }
             else if(r3.isSelected()){
                AccountType="Recurring Deposit Account";
            }
             else if(r4.isSelected()){
                AccountType="Fixed Deposit Account";
            }
            
            Random random=new Random();
            String cardNumber=""+Math.abs((random.nextLong()%90000000l)+50409360000000l);
            String password=""+Math.abs((random.nextLong()%9000l)+1000l);
            String facility="";
            if(c1.isSelected()){
                facility=facility+" ATM Card";
            }
            else if(c2.isSelected()){
                facility=facility+" Internet Banking";
            }
             else if(c3.isSelected()){
                facility=facility+" Mobile Banking";
            }
                     else if(c4.isSelected()){
                facility=facility+" Email alert";
            }
                      else if(c5.isSelected()){
                facility=facility+" CheckBook";
            }
                      else if(c2.isSelected()){
                facility=facility+" E-statement";
            }
            
     
                    try{
                 Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/bankmanagementsystem","root","12345");
                PreparedStatement pst1=c.prepareStatement("insert into login values(?,?,?)");
                PreparedStatement pst2=c.prepareStatement("insert into signupthree values(?,?,?,?,?)");
                
                 pst1.setString(1,formno);
                pst1.setString(2,cardNumber);
                pst1.setString(3,password);
                pst1.executeUpdate();
                
                pst2.setString(1,formno);
                pst2.setString(2,AccountType);
                pst2.setString(3,cardNumber);
                pst2.setString(4, password);
                pst2.setString(5, facility);
                pst2.executeUpdate();
                
               
                
                JOptionPane.showMessageDialog(null, "Card Number "+cardNumber+"\n Pin:"+password);
                
                    setVisible(false);
                        new Deposit(password).setVisible(true);
                    
            }catch(Exception ex){
                ex.printStackTrace();
            }     
        }
        if(e.getSource()==cancel){
            System.exit(0);
            new Login().setVisible(true);
        }
        
    }
    public static void main(String [] args){
        new SignupThree("");
        
    }
    
}
