import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Transactions extends JFrame implements ActionListener {
    JButton deposit, withdrawl, miniStatement, pinchange, fastcash, balance, exit;
    String pinNumber;

    Transactions(String pinNumber) {
        this.pinNumber = pinNumber;
        // logo image of the bank
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        //  image 2 is nothing just minimizing image 1
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);


        // heading label
        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(180, 260, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(155, 372, 130, 25);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(300, 372, 130, 25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(155, 404, 130, 25);
        fastcash.addActionListener(this);
        image.add(fastcash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(300, 404, 130, 25);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(155, 436, 130, 25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance = new JButton(" Check Balance");
        balance.setBounds(300, 436, 130, 25);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(300, 464, 130, 25);
        exit.addActionListener(this);
        image.add(exit);


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
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            setVisible(false);
            new Login().setVisible(true);
        } else if (e.getSource() == deposit) {
            setVisible(false);
            new Deposits(pinNumber).setVisible(true);
        } else if (e.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }else if (e.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if (e.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if (e.getSource() == balance) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if (e.getSource() == miniStatement) {
            new MiniStatement(pinNumber).setVisible(true);
        }

            try {

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

