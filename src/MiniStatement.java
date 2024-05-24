import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MiniStatement extends JFrame {
    String pinNumber;
    JLabel dateTimeLabel, card, mini, balance;

    MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber;

        // heading label
        JLabel text = new JLabel("Indian Bank");
        text.setBounds(144, 40, 200, 35);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System", Font.BOLD, 16));
        add(text);

        // DateTime label
        dateTimeLabel = new JLabel();
        dateTimeLabel.setBounds(20, 70, 300, 20);
        dateTimeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(dateTimeLabel);

        // Set the current date and time
        setCurrentDateTime();

        card = new JLabel();
        card.setBounds(20, 100, 300, 20);
        add(card);

        mini = new JLabel();
        mini.setVerticalAlignment(JLabel.TOP); // Set the vertical alignment to top

        // Wrap the mini label in a JScrollPane
        JScrollPane miniScrollPane = new JScrollPane(mini);
        miniScrollPane.setBounds(20, 190, 460, 300);
        miniScrollPane.setFont(new Font("Raleway",Font.BOLD,14));

        add(miniScrollPane);

        balance = new JLabel();
        balance.setBounds(20, 500, 300, 20);
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pinNumber = '" + pinNumber + "'");
            if (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pinNumber = '" + pinNumber + "' ORDER BY date DESC");
            StringBuilder miniText = new StringBuilder("<html>");
            while (rs.next()) {
                miniText.append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type")).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("amount")).append("<br><br>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            miniText.append("</html>");
            mini.setText(miniText.toString());
            balance.setText("Your current balance is Rs." + bal);
        } catch (Exception e) {
            System.out.println(e);
        }

        // frame settings
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Mini Statement");
        setSize(500, 600);
        setLocation(20, 20);
        setVisible(true);
    }

    private void setCurrentDateTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        // Set the label with the formatted date and time
        dateTimeLabel.setText("Current date and time: " + formattedDateTime);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
