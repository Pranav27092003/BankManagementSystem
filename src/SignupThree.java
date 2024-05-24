import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {


    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel,back;
    String formno;

    SignupThree(String formno){
        this.formno = formno;

        // label for sub-heading
        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway",Font.BOLD,22));
        accountDetails.setBounds(290,30,600,30);
        add(accountDetails);

        // label for account type
        JLabel accountType = new JLabel("Account Type: ");
        accountType.setFont(new Font("Raleway",Font.BOLD,20));
        accountType.setBounds(100,100,200,30);
        add(accountType);

        // Creating option to choose account type
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,150,200,20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,150,220,20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,190,200,20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,190,250,20);
        add(r4);

        // only one category of account type should be chosed
        ButtonGroup type = new ButtonGroup();
        type.add(r1);
        type.add(r2);
        type.add(r3);
        type.add(r4);

        // label for card number
        JLabel card = new JLabel("Card Number: ");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100,240,200,30);
        add(card);

        // label for displaying demo
        JLabel cardDetails = new JLabel("Your 16 digit Card Number ");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,12));
        cardDetails.setBounds(100,270,200,30);
        add(cardDetails);

        // label for displaying demo card number
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,20));
        number.setBounds(350,240,300,30);
        add(number);

        // label for pin number
        JLabel pin = new JLabel("Pin Number: ");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100,330,200,30);
        add(pin);

        // label for displaying demo
        JLabel pinDetails = new JLabel("Your 4 digit pin Number ");
        pinDetails.setFont(new Font("Raleway",Font.BOLD,12));
        pinDetails.setBounds(100,360,200,30);
        add(pinDetails);


        // label for displaying demo pin number
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,20));
        pnumber.setBounds(350,330,300,30);
        add(pnumber);

        // label for services
        JLabel services = new JLabel("Serivces: ");
        services.setFont(new Font("Raleway",Font.BOLD,20));
        services.setBounds(100,400,300,30);
        add(services);

        // adding checkboxes for services
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,440,200,30);
        add(c1);

        // adding checkboxes for services
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,440,200,30);
        add(c2);


        // adding checkboxes for services
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,490,200,30);
        add(c3);

        // adding checkboxes for services
        c4 = new JCheckBox("Email Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,490,200,30);
        add(c4);

        // adding checkboxes for services
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,540,200,30);
        add(c5);

        // adding checkboxes for services
        c6 = new JCheckBox("E-statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,540,200,30);
        add(c6);

        // declaration checkbox
        c7 = new JCheckBox("I hereby declares that above details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,580,600,30);
        add(c7);

        // Making Buttons
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Raleway",Font.BOLD,16));
        submit.setBounds(340, 640,160,30);
        add(submit);

        // Making Buttons
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.setBounds(540, 640,160,30);
        add(cancel);

        // Making Buttons
        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.setBounds(140, 640,160,30);
        add(back);



        // frame settings
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("New Account Application Form Page 2");
        setSize(850,720);
        setLocation(350, 3);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignupThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== submit){
                String accountType = null;
                if(r1.isSelected()){
                    accountType = "Savings Account";
                }else if (r2.isSelected()){
                    accountType = "Fixed Deposit Account";
                }else if (r3.isSelected()){
                    accountType = "Current Account";
                } else if (r4.isSelected()) {
                    accountType = "Recurring Deposit Account";
                }

                Random random =  new Random();
                String cardNumber = "" + Math.abs((random.nextLong() % 90000000L)+ 5040936000000000L);
                String pinNumber = ""+Math.abs((random.nextLong() % 9000L)+ 1000L);



                String facility ="";
                if(c1.isSelected()) {
                    facility = facility + "ATM CARD";
                } else if (c2.isSelected()) {
                    facility = facility + "Internet Banking";
                } else if (c3.isSelected()) {
                    facility = facility + "Mobile Banking";
                }else if (c4.isSelected()){
                    facility = facility + "Email Alerts";
                } else if (c5.isSelected()) {
                    facility = facility + "Cheque Book";
                } else if (c6.isSelected()) {
                    facility = facility + " E-Statement";
                }




            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Select Account Type");
                }else {
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('" + formno + "','" + accountType + "','" + cardNumber + "','" + pinNumber + "','" + facility + "')";
                    String query2 = "insert into login values('" + formno + "','" + cardNumber + "','" + pinNumber + "')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number:" + cardNumber + "\n Pin :" + pinNumber);
                    setVisible(false);
                    if (e.getSource() != back) {
                        new Login().setVisible(true);
                    }
                }

            }catch(Exception ex){
                System.out.println(ex);
            }

        }else if (e.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }else if(e.getSource()== back){
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
        }else{
            setVisible(true);
        }


    }
}
