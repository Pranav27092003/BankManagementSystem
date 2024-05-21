import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;


public class Withdrawl extends JFrame implements ActionListener {
    JButton withdraw, back;
    JTextField amount;
    String pinNumber;
    Withdrawl(String pinNumber){
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
        JLabel text = new JLabel("Enter the amount to withdraw");
        text.setBounds(180,260,400,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setBounds(190,330,200,25);
        amount.addKeyListener(new NumericKeyListener());
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(300, 436, 130, 25);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        new Withdrawl("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Enter a valid amount to withdraw");
            }else {
                try {
                    Conn conn = new Conn();
                    ResultSet res = conn.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");

                    int balance =0;
                    while(res.next()){
                        if (res.getString("type").equals("Deposit")){
                            balance = balance + Integer.parseInt(res.getString("amount"));
                        }else {
                            balance = balance - Integer.parseInt(res.getString("amount"));
                        }
                    }
                    if ((e.getSource() != back) && (balance < Integer.parseInt(number))){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Withdraw', '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + number + "Withdrawl Successfully");
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


    }
}
