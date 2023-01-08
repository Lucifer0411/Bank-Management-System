

package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class SignupTwo extends JFrame implements ActionListener{
    
   
    private JTextField religionTextField,categoryTextField,incomeTextField,occupationTextField,panTextField,adharTextField;
    private JButton next;
    private JRadioButton sYes,sNo,bYes,bNo;
    private JComboBox religionCombo,categoryCombo,income,educationCombo,occupationCombo;
    private String formno;
    SignupTwo(String formno){
      this.formno=formno;
        JLabel form=new JLabel("New Account application form."+formno);
        form.setFont(new Font("Railway",Font.BOLD,30));
        form.setBounds(140,40,800,30);
        add(form);
        
         JLabel additionalDetail=new JLabel("Page no.2 Additional Detail");
        additionalDetail.setFont(new Font("Railway",Font.BOLD,22));
        additionalDetail.setBounds(240,80,400,30);
        add(additionalDetail);
        
         JLabel religionLabel=new JLabel("Religion: ");
        religionLabel.setFont(new Font("Railway",Font.PLAIN,18));
        religionLabel.setBounds(100,180,100,30);
        add(religionLabel);
        
        String [] reli={"Hindu","Muslim","Christian","sikha","Jain","Other"};
        religionCombo=new JComboBox(reli);
        religionCombo.setBounds(300,180,400,30);
        religionCombo.setBackground(Color.white);
        add(religionCombo);
        
        
        JLabel categoryLabel=new JLabel("Category: ");
        categoryLabel.setFont(new Font("Railway",Font.PLAIN,18));
        categoryLabel.setBounds(100,220,200,30);
        add(categoryLabel);
        
          String []  cate={"General","OBC","SC","ST","Other"};
           categoryCombo=new JComboBox(cate);
          categoryCombo.setBackground(Color.white);
          categoryCombo.setBounds(300,220,400,30);
          add(categoryCombo);
        
        
        
        JLabel incomeLabel=new JLabel("Income: ");
        incomeLabel.setFont(new Font("Railway",Font.PLAIN,18));
        incomeLabel.setBounds(100,260,100,30);
        add(incomeLabel);
        String [] inc={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income=new JComboBox(inc);
       income.setBounds(300,260,400,30);
       income.setBackground(Color.white);
        add(income);
        
        
        JLabel qualificationLabel=new JLabel("Qualification: ");
        qualificationLabel.setFont(new Font("Railway",Font.PLAIN,18));
        qualificationLabel.setBounds(100,300,200,30);
        add(qualificationLabel);
        
            String [] ed={"Non-graduate","Graduation","Post-Graduation","Doctrate","other"};
        educationCombo=new JComboBox(ed);
       educationCombo.setBounds(300,300,400,30);
       educationCombo.setBackground(Color.white);
        add(educationCombo);

        
        JLabel existingAccountLabel=new JLabel("Existing account: ");
        existingAccountLabel.setFont(new Font("Railway",Font.PLAIN,18));
        existingAccountLabel.setBounds(100,340,200,30);
        add(existingAccountLabel);
        
         bYes=new JRadioButton("Yes");
        bYes.setBounds(300,340,80,30);
        bNo=new JRadioButton("No");
        bNo.setBounds(400,340,80,30);
        add(bYes);
        add(bNo);
        
          ButtonGroup existGroup=new ButtonGroup();
        existGroup.add(bYes);
        existGroup.add(bNo);
        
      
        
        JLabel occupationLabel=new JLabel("Occupation: ");
        occupationLabel.setFont(new Font("Railway",Font.PLAIN,18));
        occupationLabel.setBounds(100,380,150,30);
        add(occupationLabel);
        
        String [] occupation={"self-employed","Bussiness","Student","Retired","other"};
         occupationCombo=new JComboBox(occupation);
       occupationCombo.setBounds(300,380,400,30);
       occupationCombo.setBackground(Color.white);
        add(occupationCombo);
        
        JLabel panLabel=new JLabel("PAN no.: ");
        panLabel.setFont(new Font("Railway",Font.PLAIN,18));
        panLabel.setBounds(100,420,150,30);
        add(panLabel);
        
        JLabel adharLabel=new JLabel("Adhar no.: ");
        adharLabel.setFont(new Font("Railway",Font.PLAIN,18));
        adharLabel.setBounds(100,460,150,30);
        add(adharLabel);
        
        JLabel seniorLabel=new JLabel("Senior citizen: ");
        seniorLabel.setFont(new Font("Railway",Font.PLAIN,18));
        seniorLabel.setBounds(100,500,200,30);
        add(seniorLabel);
        
        sYes=new JRadioButton("Yes");
        sYes.setBounds(300,500,80,30);
         sNo=new JRadioButton("No");
        sNo.setBounds(400,500,80,30);
        add(sYes);
        add(sNo);
        
          ButtonGroup seniorGroup=new ButtonGroup();
        seniorGroup.add(sYes);
        seniorGroup.add(sNo);
        
  
         religionTextField=new JTextField();
        religionTextField.setFont(new Font("Railway",Font.BOLD,14));
        religionTextField.setBounds(300,180,400,30);
        add(religionTextField);
       
        categoryTextField=new JTextField();
        categoryTextField.setFont(new Font("Railway",Font.BOLD,14));
        categoryTextField.setBounds(300,380,400,30);
        add(categoryTextField);
        
        panTextField=new JTextField();
        panTextField.setFont(new Font("Railway",Font.BOLD,14));
        panTextField.setBounds(300,420,400,30);
        add(panTextField);
        
        adharTextField=new JTextField();
        adharTextField.setFont(new Font("Railway",Font.BOLD,14));
        adharTextField.setBounds(300,460,400,30);
        add(adharTextField);
        
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
    public static void main(String [] args){
        new SignupTwo("");
    }
    public void actionPerformed(ActionEvent e){
         
        String sReligion=(String)religionCombo.getSelectedItem();
        String sCategory=(String)categoryCombo.getSelectedItem();
         String sIncome=(String)income.getSelectedItem();
          String sEducation=(String)educationCombo.getSelectedItem();
           String sOccupation=(String)occupationCombo.getSelectedItem();
           String seniorCitizen=null;
           if(sYes.isSelected()){
               seniorCitizen="yes";
           }else if(sNo.isSelected()){
               seniorCitizen="No";
           }
             String existingAccount=null;
           if(bYes.isSelected()){
               existingAccount="yes";
           }else if(bNo.isSelected()){
               existingAccount="No";
           }
           String sPan=panTextField.getText();
           String sAdhar=adharTextField.getText();
           try{
               
                Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3307/bankmanagementsystem","root","12345");
                PreparedStatement pst=c.prepareStatement("insert into SignupTwo values(?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1,formno);
                pst.setString(2,sReligion);
                pst.setString(3,sCategory);
                pst.setString(4,sIncome);
                pst.setString(5,sEducation);
                pst.setString(6,sOccupation);
                pst.setString(7,seniorCitizen);
                pst.setString(8,existingAccount);
                pst.setString(9,sPan);
                pst.setString(10,sAdhar);
                pst.executeUpdate();
                
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
               
           }catch(Exception ex){
        ex.printStackTrace();
    }
              }
             
}
