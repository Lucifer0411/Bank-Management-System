

package bank.management.system;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MiniStatement extends JFrame {
    private String pinnumber;
    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        JLabel text=new JLabel("Indian Bank");
        text.setBounds(150,20,100,20);
        add(text);
        
           JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);

           JLabel cardno=new JLabel();
        cardno.setBounds(20,80,400,20);
        add(cardno);
        
        JLabel bal=new JLabel();
        bal.setBounds(20,400,320,20);
        add(bal);
        try{
            Conn c=new Conn();
            String q1="select * from login where pin='"+pinnumber+"'";
            ResultSet rs=c.s.executeQuery(q1);
            while(rs.next()){
                cardno.setText("Card Number"+rs.getString("cardnumber").substring(0,4)+" XXXXXXXX "+rs.getString("cardnumber").substring(10));
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        try{
            Conn con=new Conn();
            ResultSet result=con.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            int balance=0;
            while(result.next()){
                mini.setText(mini.getText()+"<html>"+result.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+result.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+result.getString("amount")+"<br>");
                      if(result.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(result.getString("amount"));
                }
                if(result.getString("type").equals("Withdrawl")){
                    balance-=Integer.parseInt(result.getString("amount"));
                }
            }
            bal.setText("Your current account balance is Rs."+balance);
        }catch(Exception ex){
            ex.printStackTrace();
        }
                add(mini);

         setTitle("Pin Change");
        setSize(400,600);
        setBackground(Color.white);
        setLayout(null);
        setLocation(20,20);
        setVisible(true);
        
    }
    public static void main(String [] args){
        new MiniStatement("");
    }
    
}
