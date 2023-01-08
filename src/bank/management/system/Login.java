

package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
    private JButton login,clear,signup;
    private JTextField cardTextField;
    private JPasswordField pinTextField;
    Login(){
        
        setTitle("ATM");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpeg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
         JLabel cardno=new JLabel("Card NO.");
        cardno.setFont(new Font("Railway",Font.BOLD,30));
        cardno.setBounds(100,150,150,40);
        add(cardno);
        
         cardTextField=new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Ariel",Font.BOLD,14));
        add(cardTextField);  
        
         JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Railway",Font.BOLD,30));
        pin.setBounds(100,220,250,40);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Ariel",Font.BOLD,14));

        add(pinTextField); 
            
         login=new JButton("Sign In");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        add(login);
        
         clear=new JButton("Clear");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        add(clear);
        
          signup=new JButton("Sign up");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        add(signup);
        
        login.addActionListener(this);
        clear.addActionListener(this);
        signup.addActionListener(this);
        
        setSize(700,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setLocation(500,300);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            try{ 
                    Conn c=new Conn();
                    String query="select * from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Incorrect card no or pin");
                    }
                  
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        }else if(e.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(e.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
    }
    public static void main(String [] args){
        new Login();
    }
    
}
