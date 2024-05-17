import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    // these declarations are done here so that these can be use globally
    JButton login, signup, clear;
    JTextField cardTextFeild;
    JPasswordField pinTextFeild;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        // logo image of the bank
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
       //  image 2 is nothing just minimizing image 1
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,80,80);
        add(label);

        // adding label for heading
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Osward",Font.BOLD,38));
        add(text);

        // adding label for cardno
        JLabel cardno = new JLabel("Card No:");
        cardno.setBounds(120,150,200,40);
        cardno.setFont(new Font("Raleway",Font.BOLD,30));
        add(cardno);

        // adding textfeild for cardnumber
         cardTextFeild =  new JTextField();
        cardTextFeild.setBounds(300,150,230,38);
        cardTextFeild.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextFeild);

        // adding label for PIN
        JLabel pin = new JLabel("PIN: ");
        pin.setBounds(120,220,400,40);
        pin.setFont(new Font("Raleway",Font.BOLD,30));
        add(pin);

        // adding textfeild for entering PIN
        pinTextFeild =  new JPasswordField();
        pinTextFeild.setBounds(300,220,230,38);
        pinTextFeild.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextFeild);

        // button to sign in
        login = new JButton("LOGIN");
        login.setBounds(300,300,100,30);
        login.addActionListener(this);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        // button to clear credentials
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        add(clear);
        clear.addActionListener(this);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);

        // button to signup
         signup = new JButton("SIGN-UP");
        signup.setBounds(300,360,230,30);
        add(signup);
        signup.addActionListener(this);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);

        // frame settings
        getContentPane().setBackground(Color.WHITE);
        setSize(800,500);
        setVisible(true);
        setLocation(350,100);
    }

    public static void main(String[] args) {
        new Login();
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextFeild.setText("");
            pinTextFeild.setText("");
        } else if (ae.getSource()==login) {
            Conn conn = new Conn();
            String cardNumber = cardTextFeild.getText();
            String pinNumber = pinTextFeild.getText();

            String query = "select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"' ";
            try {
                ResultSet res = conn.s.executeQuery(query); // as the query has executed and has fetched some data from databse and now we will check that data
                if(res.next()){
                    setVisible(false); // if the data is true, close the current screen and open up atm machine for transactions
                    new Transactions(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Cardnumber or Pin");
                }

            }catch (Exception e){
                System.out.println(e);
            }
        } else if (ae.getSource()== signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
}

// a image connot he direcltly placed on an frame first it is put in a label and then that label is added to the  frame.
