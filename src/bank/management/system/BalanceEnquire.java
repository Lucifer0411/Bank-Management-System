

package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BalanceEnquire extends JFrame implements ActionListener{
    private String pinnumber;
    private JButton back,exit;
    BalanceEnquire(String pinnumber){
        this.pinnumber=pinnumber;
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpeg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
         back=new JButton("BACK");
        back.setBounds(170,415,150,30);
        back.setBackground(Color.white);
        back.setFont(new Font("Railway",Font.BOLD,16));
        back.addActionListener(this);
        image.add(back);
        
         exit=new JButton("EXIT");
        exit.setBounds(355,415,150,30);
        exit.setBackground(Color.white);
        exit.setFont(new Font("Railway",Font.BOLD,16));
        exit.addActionListener(this);
        image.add(exit);
        
        Conn c=new Conn();
        int balance=0;
        try{
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                if(rs.getString("type").equals("Withdrawl")){
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        JLabel bal=new JLabel("Your current account balance is "+balance);
        bal.setForeground(Color.white);
        bal.setBounds(170,300,400,30);
        image.add(bal);
        
          setTitle("Pin Change");
        setSize(900,900);
           setBackground(Color.white);
        setLayout(null);
        setLocation(600,100);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else if(e.getSource()==exit){
            System.exit(0);
        }
        
    }
    
    
    
    public static void main(String [] args){
        new BalanceEnquire("");
    }
    
}
