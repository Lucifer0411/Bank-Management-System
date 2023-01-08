

package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class SignupOne extends Frame implements ActionListener{
    private long random;
    private JTextField nameTextField,fatherName,emailText,cityText,stateText,pincodeText,addressText;
    private JButton next;
    private JRadioButton male ,female,other,maried,unmaried;
    private JDateChooser dateChooser;
    SignupOne(){
        Random rand=new Random();
        random=Math.abs(rand.nextLong()%9000l)+1000l;
        JLabel form=new JLabel("APPLICATION FORM NO."+ random);
        form.setFont(new Font("Railway",Font.BOLD,30));
        form.setBounds(140,40,800,30);
        add(form);
        
         JLabel personalDetail=new JLabel("Page no.1 Persnal Detail");
        personalDetail.setFont(new Font("Railway",Font.BOLD,22));
        personalDetail.setBounds(240,80,400,30);
        add(personalDetail);
        
         JLabel name=new JLabel("Name: ");
        name.setFont(new Font("Railway",Font.PLAIN,18));
        name.setBounds(100,140,100,30);
        add(name);
        
        JLabel fatherNameLabel=new JLabel("Father's Name: ");
        fatherNameLabel.setFont(new Font("Railway",Font.PLAIN,18));
        fatherNameLabel.setBounds(100,180,200,30);
        add(fatherNameLabel);
        
        JLabel dob=new JLabel("DOB: ");
        dob.setFont(new Font("Railway",Font.PLAIN,18));
        dob.setBounds(100,220,100,30);
        add(dob);
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,220,200,30);
        add(dateChooser);
        
        JLabel genderLabel=new JLabel("Gender: ");
        genderLabel.setFont(new Font("Railway",Font.PLAIN,18));
        genderLabel.setBounds(100,260,100,30);
        add(genderLabel);
         male=new JRadioButton("Male");
        male.setBounds(300,260,60,30);
        male.setBackground(Color.white);
        add(male);
         female=new JRadioButton("Female");
                female.setBackground(Color.white);

        female.setBounds(400,260,80,30);
        add(female);
        
        ButtonGroup genderLabelgroup=new ButtonGroup();
        genderLabelgroup.add(male);
        genderLabelgroup.add(female);
        
        
        JLabel email=new JLabel("Email: ");
        email.setFont(new Font("Railway",Font.PLAIN,18));
        email.setBounds(100,300,100,30);
        add(email);
        
        JLabel marital=new JLabel("Marital Statues: ");
        marital.setFont(new Font("Railway",Font.PLAIN,18));
        marital.setBounds(100,340,200,30);
        add(marital);
        
         maried=new JRadioButton("Married");
        maried.setBounds(300,340,80,30);
        maried.setBackground(Color.white);
        add(maried);
         unmaried=new JRadioButton("Unmarried");
        unmaried.setBackground(Color.white);

        unmaried.setBounds(400,340,100,30);
        add(unmaried);
         other=new JRadioButton("Other");
        other.setBounds(525,340,80,30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(maried);
        maritalgroup.add(unmaried);
        maritalgroup.add(other);
        
        
        JLabel address=new JLabel("Address: ");
        address.setFont(new Font("Railway",Font.PLAIN,18));
        address.setBounds(100,380,100,30);
        add(address);
        
        JLabel city=new JLabel("City: ");
        city.setFont(new Font("Railway",Font.PLAIN,18));
        city.setBounds(100,420,100,30);
        add(city);
        
        JLabel state=new JLabel("State: ");
        state.setFont(new Font("Railway",Font.PLAIN,18));
        state.setBounds(100,460,100,30);
        add(state);
        
        JLabel pincode=new JLabel("Pincode: ");
        pincode.setFont(new Font("Railway",Font.PLAIN,18));
        pincode.setBounds(100,500,100,30);
        add(pincode);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Railway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
         fatherName=new JTextField();
        fatherName.setFont(new Font("Railway",Font.BOLD,14));
        fatherName.setBounds(300,180,400,30);
        add(fatherName);
        
        emailText=new JTextField();
        emailText.setFont(new Font("Railway",Font.BOLD,14));
        emailText.setBounds(300,300,400,30);
        add(emailText);
        
        addressText=new JTextField();
        addressText.setFont(new Font("Railway",Font.BOLD,14));
        addressText.setBounds(300,380,400,30);
        add(addressText);
        
        cityText=new JTextField();
        cityText.setFont(new Font("Railway",Font.BOLD,14));
        cityText.setBounds(300,420,400,30);
        add(cityText);
        
        stateText=new JTextField();
        stateText.setFont(new Font("Railway",Font.BOLD,14));
        stateText.setBounds(300,460,400,30);
        add(stateText);
        
        pincodeText=new JTextField();
        pincodeText.setFont(new Font("Railway",Font.BOLD,14));
        pincodeText.setBounds(300,500,400,30);
        add(pincodeText);
        
        JButton next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(620,550,80,30);
        next.addActionListener(this);
        add(next);
        
        
       
           setSize(800,700);
           setBackground(Color.white);
        setLayout(null);
        setLocation(500,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){

        String formno=""+random;
        String name=nameTextField.getText();
        String father_name=fatherName.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String genderLabel=null;
        if(male.isSelected()){
            genderLabel="male";
        }else if(female.isSelected()){
            genderLabel="female";
        }   
        String email=emailText.getText();
        String marital=null;
        if(maried.isSelected()){
            marital="married";
        }else if(unmaried.isSelected()){
            marital="Unmarried";
        }else if(other.isSelected()){
            marital="Other";
        }
        String address=addressText.getText();
        String city=cityText.getText();
        String state=stateText.getText();
         String pincode=pincodeText.getText();
         
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
                
            }else if(father_name.equals("")){
                JOptionPane.showMessageDialog(null,"Father's Name is required");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Date of birth required");
            }
//            else if(genderLabel.equals("")){
//                JOptionPane.showMessageDialog(null,"Select genderLabel");
//         }
        else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is required");
            }
//        else if(marital.equals("")){
//                JOptionPane.showMessageDialog(null,"Select marital statues");
//            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Addresss is required");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City Name ");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State Name ");
            }else if(pincode.equals("")){
                JOptionPane.showMessageDialog(null,"Pincode is required");
            }
            else{
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/bankmanagementsystem","root","12345");
                PreparedStatement pst=c.prepareStatement("insert into signup values(?,?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1,formno);
                pst.setString(2,name);
                pst.setString(3,father_name);
                pst.setString(4,dob);
                pst.setString(5,genderLabel);
                pst.setString(6,email);
                pst.setString(7,marital);
                pst.setString(8,address);
                pst.setString(9,city);
                pst.setString(10,state);
                pst.setString(11,pincode);
                pst.executeUpdate();
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
            
        
    }
    public static void main(String [] args){
        new SignupOne();
    }
    
}
