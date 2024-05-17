import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class PinChange extends JFrame implements ActionListener {
    JButton change,back;
    JPasswordField newpin, renewpin;
    String pinNumber;

    PinChange(String pinNumber) {
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
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(230, 260, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel pintext = new JLabel("New Pin:");
        pintext.setBounds(145, 300, 150, 35);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);

        newpin = new JPasswordField(4);
        newpin.setBounds(310, 300, 150, 35);
        newpin.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(newpin);

        JLabel repintext = new JLabel("Re-Enter New Pin:");
        repintext.setBounds(145, 350, 150, 35);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(repintext);

        renewpin = new JPasswordField(4);
        renewpin.setBounds(310, 350, 150, 35);
        renewpin.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(renewpin);


        change = new JButton(" CHANGE");
        change.setBounds(300, 436, 130, 25);
        change.addActionListener(this);
        image.add(change);

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
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            try {
                String npin = newpin.getText();
                String rpin = renewpin.getText();

                if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered Pin Does not match");
                    return;
                } else if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter new Pin");
                    return;
                }else if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                    return;
                }
                Conn conn =new Conn();
                // as pin is being effected in three tables login, bank and  signupthree
                String query1 ="update bank set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";
                String query2 ="update login set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";
                String query3 ="update signupThree set pinNumber = '"+rpin+"' where pinNumber = '"+pinNumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }


    }
}

