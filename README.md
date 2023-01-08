# Bank-Management-System
This is mini bank management system with mini ATM machine
I developed this java application using following resources.
    1.JDK
    2.netbeans8.2
    3.Mysql
To run the project download it form the given link then run the login.java file which in the src.bank.management.system
There are 11 java file which perform different tasks
    1.Login.java=Login the user if he is already registered and signup if want to create new account in bank.
    2.SignupOne.java=Takes user personal data such as name,email,address,gender etc.
    3.SignupTwo.java=Anther form which uses JComboBox of java swing.
    4.SignupThree.java=This will provide user account number and pin by choosing account type and bank services.
    5.Transaction.java=After filling signup form user will directed to trasaction where 6 option are available as in the ATM machine
          a.Deposit
          b.Withdrawl
          c.Mini Statement
          d.Balance Enquire
          e.Pin Change 
          f.Exit
     After that i created all different files for the above tasks except exit
     
In the database i created different table for logins the table are:
    login=Having data of only register users.
    signup=Having data of every user who filled first form.
    signuptwo=Having data of every user who filled second form.
    signupthree=Having data of every user who allform.
    bank=It has user bank details like amount,pin,date of deposit and withdrawl.
    
