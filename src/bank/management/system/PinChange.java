

package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class PinChange extends JFrame implements ActionListener{
    private JButton change,back;
    private JPasswordField pinField,rpinField;
    private String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpeg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
          JLabel text=new JLabel("Change your pin");
        text.setBounds(260,300,400,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Railway",Font.BOLD,14));
        image.add(text);
        
        JLabel pinText=new JLabel("New Pin:");
        pinText.setBounds(200,360,100,20);
         pinText.setForeground(Color.white);
        pinText.setFont(new Font("Railway",Font.BOLD,14));
        image.add(pinText);
        
           pinField=new JPasswordField();
        pinField.setBounds(350,360,100,20);
         pinField.setForeground(Color.black);
        pinField.setFont(new Font("Railway",Font.BOLD,14));
        image.add(pinField);
        
        
         JLabel rpinText=new JLabel("Re-enter new Pin:");
        rpinText.setBounds(200,400,200,20);
         rpinText.setForeground(Color.white);
        rpinText.setFont(new Font("Railway",Font.BOLD,14));
        image.add(rpinText);
        
          rpinField=new JPasswordField();
        rpinField.setBounds(350,400,100,20);
         rpinField.setForeground(Color.black);
       rpinField.setFont(new Font("Railway",Font.BOLD,14));
        image.add(rpinField);
        
        
        change=new JButton("CHANGE");
        change.setBounds(355,450,100,20);
         change.setForeground(Color.black);
       change.setFont(new Font("Railway",Font.BOLD,14));
              change.addActionListener(this);

        image.add(change);
        
        back=new JButton("BACK");
        back.setBounds(200,450,100,20);
         back.setForeground(Color.black);
       back.setFont(new Font("Railway",Font.BOLD,14));
       back.addActionListener(this);
        image.add(back);
        
        
          setTitle("Pin Change");
        setSize(900,900);
           setBackground(Color.white);
        setLayout(null);
        setLocation(600,100);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==change){ try{
            String pin=pinField.getText();
            String rpin=rpinField.getText();
            if(!(pin.equals(rpin))){
                JOptionPane.showMessageDialog(null, "Enter pin does not match");
                return;
            }
            if(pin.equals("") || rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter pin");
                return;
            }
            Conn c=new Conn();
                        System.out.println("pinnumber:"+pinnumber);

            String query1="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
            String query3="update SignupThree set pin='"+rpin+"' where pin='"+pinnumber+"'";
            System.out.println("pinnumber:"+pinnumber);
            String query2="update Login set pin='"+rpin+"' where pin='"+pinnumber+"'";
            
            c.s.executeUpdate(query1);
             c.s.executeUpdate(query2);
              c.s.executeUpdate(query3);
              JOptionPane.showMessageDialog(null, "Pin changed successfull");
              
              setVisible(false);
              new Transactions(rpin).setVisible(true);

                 
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
       }
       else{
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
       }
        
    }
    public static void main(String [] args){
            new PinChange("");

    }
}
