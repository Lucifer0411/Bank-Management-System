

package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;



public class Transactions extends Frame implements ActionListener{
    private JButton depositButton,withdrawlButton,miniStatement,balanceEnquire,exit,pinChange;
    private String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpeg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(235,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Railway",Font.BOLD,14));
        image.add(text);
        
        depositButton=new JButton("Deposit");
        depositButton.setBounds(170,415,150,30);
        depositButton.setBackground(Color.white);
        depositButton.setFont(new Font("Railway",Font.BOLD,16));
        depositButton.addActionListener(this);
        image.add(depositButton);
        
         withdrawlButton=new JButton("CashWithdraw");
        withdrawlButton.setBounds(355,415,150,30);
        withdrawlButton.setBackground(Color.white);
        withdrawlButton.setFont(new Font("Railway",Font.BOLD,16));
        withdrawlButton.addActionListener(this);
        image.add(withdrawlButton);
        
        miniStatement=new JButton("Mini Statement");
        miniStatement.setBounds(170,450,150,30);
        miniStatement.setBackground(Color.white);
        miniStatement.setFont(new Font("Railway",Font.BOLD,16));
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange=new JButton("Pin Change");
        pinChange.setBounds(355,450,150,30);
        pinChange.setBackground(Color.white);
        pinChange.setFont(new Font("Railway",Font.BOLD,16));
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquire=new JButton("Bal_Enquire");
        balanceEnquire.setBounds(170,485,150,30);
        balanceEnquire.setBackground(Color.white);
        balanceEnquire.setFont(new Font("Railway",Font.BOLD,16));
        balanceEnquire.addActionListener(this);
        image.add(balanceEnquire);
        
        exit=new JButton("Exit");
        exit.setBounds(355,485,150,30);
        exit.setBackground(Color.white);
        exit.setFont(new Font("Railway",Font.BOLD,16));
        exit.addActionListener(this);
        image.add(exit);
     
         setTitle("Transaction");
        setSize(900,900);
           setBackground(Color.white);
           setUndecorated(true);
        setLayout(null);
        setLocation(600,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==exit){
            System.exit(0);
        }
        else if(e.getSource()==depositButton){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(e.getSource()==withdrawlButton){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }
        else if(e.getSource()==pinChange){
                setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(e.getSource()==balanceEnquire){
            setVisible(false);
            new BalanceEnquire(pinnumber).setVisible(true);
        }else if(e.getSource()==miniStatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
        
        
    }
    public static void main(String [] args){
        new Transactions("");
    }
    
}
