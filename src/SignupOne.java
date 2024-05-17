import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
         long random;
         JTextField nameTextFeild, fnameTextFeild, emailTextFeild, addressTextFeild,cityTextFeild, stateTextFeild, pincodeTextFeild;
         JRadioButton male,female,other,married,unmarried,dontknow;
         JButton next;
         JDateChooser datechooser;

    SignupOne(){

        //  we have to generate a random form number of four digits
        Random ran = new Random();
        random = Math.abs((ran.nextLong()% 9000L +1000L));

        // label for heading
        JLabel formno = new JLabel("APPLICATION FORM NO.  "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(120,30,600,40);
        add(formno);

        // label for sub-heading
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,600,30);
        add(personalDetails);

        // label for name
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        //textfiled for name
        nameTextFeild = new JTextField();
        nameTextFeild.setFont(new Font("Arial",Font.BOLD,14));
        nameTextFeild.setBounds(330,140,300,30);
        add(nameTextFeild);

        // label for fathers name
        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        //textfiled for fathers name
        fnameTextFeild = new JTextField();
        fnameTextFeild.setFont(new Font("Arial",Font.BOLD,14));
        fnameTextFeild.setBounds(330,190,300,30);
        add(fnameTextFeild);

        // label for DOB
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        // choosing date here
        datechooser = new JDateChooser();
        datechooser.setBounds(330,240,300,30);
        datechooser.setForeground(Color.BLACK);
        datechooser.setFont(new Font("Arial",Font.BOLD,14));
        add(datechooser);

        // label for Gender
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);

        // Radio buttons for gender
        male =new JRadioButton("Male");
        male.setBounds(330,290,80,30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Raleway",Font.BOLD,14));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(430,290,80,30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Raleway",Font.BOLD,14));
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(560,290,80,30);
        other.setBackground(Color.WHITE);
        other.setFont(new Font("Raleway",Font.BOLD,14));
        add(other);

        // only one category of gender should be chosed
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);


        // label for email address
        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);

        //textfiled for emailaddress
        emailTextFeild = new JTextField();
        emailTextFeild.setFont(new Font("Arial",Font.BOLD,14));
        emailTextFeild.setBounds(330,340,300,30);
        add(emailTextFeild);

        // label for maritial status
        JLabel maritial = new JLabel("Maritial Status: ");
        maritial.setFont(new Font("Raleway",Font.BOLD,20));
        maritial.setBounds(100,390,200,30);
        add(maritial);

        // Radio buttons for choosing maritial status
        married =new JRadioButton("Married");
        married.setBounds(330,390,80,30);
        married.setBackground(Color.WHITE);
        married.setFont(new Font("Raleway",Font.BOLD,14));
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(430,390,100,30);
        unmarried.setBackground(Color.WHITE);
        unmarried.setFont(new Font("Raleway",Font.BOLD,14));
        add(unmarried);

        dontknow = new JRadioButton("Other");
        dontknow.setBounds(560,390,80,30);
        dontknow.setBackground(Color.WHITE);
        dontknow.setFont(new Font("Raleway",Font.BOLD,14));
        add(dontknow);

        // only one category of maritial status should be chosed
        ButtonGroup maritialgroup = new ButtonGroup();
        maritialgroup.add(married);
        maritialgroup.add(unmarried);
        maritialgroup.add(dontknow);

        // label for Address
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);

        //textfiled for Address
        addressTextFeild = new JTextField();
        addressTextFeild.setFont(new Font("Arial",Font.BOLD,14));
        addressTextFeild.setBounds(330,440,300,30);
        add(addressTextFeild);

        // label for city
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);

        //textfiled for city
        cityTextFeild = new JTextField();
        cityTextFeild.setFont(new Font("Arial",Font.BOLD,14));
        cityTextFeild.setBounds(330,490,300,30);
        add(cityTextFeild);

        // label for State
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);

        //textfiled for state
         stateTextFeild = new JTextField();
        stateTextFeild.setFont(new Font("Arial",Font.BOLD,14));
        stateTextFeild.setBounds(330,540,300,30);
        add(stateTextFeild);

        // label for pincode
        JLabel pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        //textfiled for pincode
        pincodeTextFeild = new JTextField();
        pincodeTextFeild.setFont(new Font("Arial",Font.BOLD,14));
        pincodeTextFeild.setBounds(330,590,300,30);
        add(pincodeTextFeild);

        // Button
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(520,640,100,30);
        next.addActionListener(this);
        add(next);

        // frame settings
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("New Account Application Form Page 1");
        setSize(850,730);
        setLocation(350, 3);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignupOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = ""+ random; // "" is applied to convert the random number generated into String
        String name = nameTextFeild.getText();
        String fname = fnameTextFeild.getText();
        String email = emailTextFeild.getText();
        String address = addressTextFeild.getText();
        String city = cityTextFeild.getText();
        String state = stateTextFeild.getText();
        String pinCode = pincodeTextFeild.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        // First date is converted to text and then retieved
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        } else if(other.isSelected()) {
            gender = "Other";
        }

        String maritialStatus = null;
        if (married.isSelected()){
            maritialStatus = "Married";
        }else if(unmarried.isSelected()){
            maritialStatus = "Unmarried";
        } else if(dontknow.isSelected()) {
            maritialStatus = "Other";
        }

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else{
                Conn c =new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"', '"+maritialStatus+"','"+address+"','"+city+"','"+state+"', '"+pinCode+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        }catch(Exception ex){
            System.out.println(ex);
        }




    }
}
