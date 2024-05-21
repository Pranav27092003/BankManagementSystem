import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Deposits extends JFrame implements ActionListener {
    JButton deposit, back;
    JTextField amount;
    String pinNumber;
    Deposits(String pinNumber){
        this.pinNumber = pinNumber;
        // logo image of the bank
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        //  image 2 is nothing just minimizing image 1
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);


        // heading label
        JLabel text = new JLabel("Enter the amount to deposit");
        text.setBounds(180,260,400,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setBounds(190,330,200,25);
        amount.addKeyListener(new NumericKeyListener());
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(300, 436, 130, 25);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back ");
        back.setBounds(300,464,130,25);
        back.addActionListener(this);
        image.add(back);


        // frame settings
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("");
        setSize(800,800);
        setLocation(350, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Deposits("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Enter a valid amount to deposit");
            }else {
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Deposit', '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + number + "Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }catch(Exception ex){
                    System.out.println(ex);
                }

            }
        }else if (e.getSource()== back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }

        try{

        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
