import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;


public class MiniStatement extends JFrame {
    JButton change,back;
    JPasswordField newpin, renewpin;
    String pinNumber;

    MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber;

        // heading label
        JLabel text = new JLabel("Indian Bank");
        text.setBounds(144, 40, 100, 35);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System", Font.BOLD, 16));
        add(text);


        JLabel card = new JLabel();
        card.setBounds(20,100,300,20);
        add(card);

        JLabel mini = new JLabel();
        add(mini);


        JLabel balance = new JLabel();
        balance.setBounds(20,500,300,20);
        add(balance);

        try{
            Conn conn = new Conn();
           ResultSet rs= conn.s.executeQuery("select * from login where pinNumber = '"+pinNumber+"'");
           while (rs.next()){
               card.setText("Card Number: "+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardNumber").substring(12));
           }
        }catch(Exception e){
            System.out.println(e);
        }

        try{
            Conn conn = new Conn();
            int bal =0;
            ResultSet rs= conn.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
            while (rs.next()){
                mini.setText(mini.getText()+"<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if (rs.getString("type").equals("Deposit")){
                    bal = bal + Integer.parseInt(rs.getString("amount"));
                }else {


                    bal = bal - Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current balance is Rs." + bal);
        }catch(Exception e){
            System.out.println(e);
        }
        mini.setBounds(20,140,500,300);


        // frame settings
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Mini Statement");
        setSize(500, 600);
        setLocation(20, 20);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }


}

