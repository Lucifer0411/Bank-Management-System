

package bank.management.system;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Withdraw extends JFrame implements ActionListener{
      private JTextField amount;
    private JButton withdrawl,back;
    private String pinnumber;
    Withdraw(String pinnumber){
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpeg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.white);
        text.setBounds(170,300,400,20);
        text.setFont(new Font("Railway",Font.BOLD,16));
        image.add(text);
        
                amount=new JTextField();
                amount.setFont(new Font("Railway",Font.BOLD,22));
                amount.setBounds(170,350,320,25);
                image.add(amount);
                
        withdrawl=new JButton("Withdraw");
        withdrawl.setBounds(355,485,150,30);
        withdrawl.addActionListener(this);
        
        image.add(withdrawl);
        
        back=new JButton("Back");
        back.setBounds(170,485,150,30);
                back.addActionListener(this);

        image.add(back);
        
        setTitle("Transaction");
        setSize(900,900);
           setBackground(Color.white);
//           setUndecorated(true);
        setLayout(null);
        setLocation(600,100);
        setVisible(true);
      
}
       public void actionPerformed(ActionEvent e){
        if(e.getSource()==withdrawl){
            String amt=amount.getText();
            Date date=new Date();
            if(amt.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
                
            }else{
                try{Conn c=new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amt+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amt+" Withdraw");
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                
            }
            
            
        }else if(e.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
    public static void main(String [] args){
        new Deposit("");
    }
}
