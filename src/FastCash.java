import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;


public class FastCash extends JFrame implements ActionListener {
    JButton hundred, fiveHundred, thosuand, twoThousand, fiveThousand, tenThousand, back;
    String pinNumber;

    FastCash(String pinNumber) {
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
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(180, 260, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        hundred = new JButton("Rs.100");
        hundred.setBounds(155, 372, 130, 25);
        hundred.addActionListener(this);
        image.add(hundred);

        fiveHundred = new JButton("Rs.500");
        fiveHundred.setBounds(300, 372, 130, 25);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        thosuand = new JButton("Rs.1000");
        thosuand.setBounds(155, 404, 130, 25);
        thosuand.addActionListener(this);
        image.add(thosuand);

        twoThousand = new JButton("Rs.2000");
        twoThousand.setBounds(300, 404, 130, 25);
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        fiveThousand = new JButton("Rs.5000");
        fiveThousand.setBounds(155, 436, 130, 25);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand = new JButton(" Rs.10000");
        tenThousand.setBounds(300, 436, 130, 25);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        back = new JButton("BACK");
        back.setBounds(300, 464, 130, 25);
        back.addActionListener(this);
        image.add(back);


        // frame settings
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("");
        setSize(800, 800);
        setLocation(350, 0);
//        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FastCash("pinNumber");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
           String amount = ((JButton)e.getSource()).getText().substring(3);
            Conn c =new Conn();
            try {
                ResultSet res = c.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
                int balance =0;
                while(res.next()){
                    if (res.getString("type").equals("Deposit")){
                        balance = balance + Integer.parseInt(res.getString("amount"));
                    }else {
                        balance = balance - Integer.parseInt(res.getString("amount"));
                    }
                }
                if (e.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }else{
                    Date date = new Date();
                    String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Withdrawl', '" + amount + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+ "Debited Successfully");

                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }
}

