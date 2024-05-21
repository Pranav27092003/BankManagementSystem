import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;


public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton change,back;
    JPasswordField newpin, renewpin;
    String pinNumber;

    BalanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;
        // logo image of the bank
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        //  image 2 is nothing just minimizing image 1
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);





        back = new JButton("BACK");
        back.setBounds(300, 464, 130, 25);
        back.addActionListener(this);
        image.add(back);




        Conn c =new Conn();
        int balance =0;
        try {
            ResultSet res = c.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");

            while(res.next()){
                if (res.getString("type").equals("Deposit")){
                    balance = balance + Integer.parseInt(res.getString("amount"));
                }else {
                    balance = balance - Integer.parseInt(res.getString("amount"));
                }
            }


        } catch (Exception ex) {
            System.out.println(ex);
        }

        // heading label
        JLabel text = new JLabel("Total Balance in your account is: Rs." + balance);
        text.setBounds(144, 260, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);




        // frame settings
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("");
        setSize(800, 800);
        setLocation(350, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);

    }
}

