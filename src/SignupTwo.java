import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panNumberTextFeild, aadharNumberTextFeild;
    JRadioButton yes,no,ha,na;
    JButton next,back;
    JComboBox religionComboBox, categoryComboBox, incomeComboBox, occupationComboBox, educationComboBox;
    String formno;

    SignupTwo(String formno){
        this.formno = formno;
        // label for sub-heading
        JLabel additional = new JLabel("Page 2: Additional Details");
        additional.setFont(new Font("Raleway",Font.BOLD,22));
        additional.setBounds(290,80,600,30);
        add(additional);

        // label for religion
        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);

        // combo box for religion
        String valReligion[] = { "Hindu", "Muslim", "Sikh", "Christian","Jainism","Buddhism","Other"};
        religionComboBox =  new JComboBox(valReligion);
        religionComboBox.setBounds(370,140,300,30);
        religionComboBox.setBackground(Color.WHITE);
        religionComboBox.setFont(new Font("Raleway",Font.BOLD,16));
        add(religionComboBox);


        // label for category
        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);

        // combo box for category
        String valCategory[] = { "General", "ST", "SC", "General-EWS","PWD"};
        categoryComboBox =  new JComboBox(valCategory);
        categoryComboBox.setBounds(370,190,300,30);
        categoryComboBox.setBackground(Color.WHITE);
        categoryComboBox.setFont(new Font("Raleway",Font.BOLD,16));
        add(categoryComboBox);



        // label for income
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);

        // combo box for income
        String valIncome[] = { "NULL", "< 1,00,000 ", " < 3,00,000", "< 5,00,00","< 7,00,000","< 10,00,000","More than 10 Lakhs"};
        incomeComboBox =  new JComboBox(valIncome);
        incomeComboBox.setBounds(370,240,300,30);
        incomeComboBox.setBackground(Color.WHITE);
        incomeComboBox.setFont(new Font("Raleway",Font.BOLD,16));
        add(incomeComboBox);



        // label for education qualifiaction
        JLabel education = new JLabel("Education qualification: ");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,240,30);
        add(education);

        // combo box for qualification
        String valeducation[] = { "P.HD", "Post-Graduate", "Graduate", "Class 12","Class 10"};
        educationComboBox =  new JComboBox(valeducation);
        educationComboBox.setBounds(370,290,300,30);
        educationComboBox.setBackground(Color.WHITE);
        educationComboBox.setFont(new Font("Raleway",Font.BOLD,16));
        add(educationComboBox);


        // label for occupation
        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,340,200,30);
        add(occupation);

        // combo box for income
        String valOccupation[] = { "Salaried", "Self-Employed ", "Business", "Student","Retired","Other"};
        occupationComboBox =  new JComboBox(valOccupation);
        occupationComboBox.setBounds(370,340,300,30);
        occupationComboBox.setBackground(Color.WHITE);
        occupationComboBox.setFont(new Font("Raleway",Font.BOLD,16));
        add(occupationComboBox);


        // label for pan number
        JLabel pan = new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,390,200,30);
        add(pan);

        //textfeid for pan number
        panNumberTextFeild = new JTextField();
        panNumberTextFeild.setFont(new Font("Arial",Font.BOLD,14));
        panNumberTextFeild.setBounds(370,390,300,30);
        add(panNumberTextFeild);



        // label for Aadhar Number
        JLabel aadhar = new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,440,200,30);
        add(aadhar);

        //textfeid for aadhar number
        aadharNumberTextFeild = new JTextField();
        aadharNumberTextFeild.setFont(new Font("Arial",Font.BOLD,14));
        aadharNumberTextFeild.setBounds(370,440,300,30);
        aadharNumberTextFeild.addKeyListener(new NumericKeyListener());
        aadharNumberTextFeild.addKeyListener(new MaxLengthKeyListener(12));
        add(aadharNumberTextFeild);



        // label for Senior Citizen
        JLabel senior = new JLabel("Senoir Citizen: ");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,490,200,30);
        add(senior);

        // Radio buttons for senior citizen
        yes =new JRadioButton("YES");
        yes.setBounds(370,490,80,30);
        yes.setBackground(Color.WHITE);
        yes.setFont(new Font("Raleway",Font.BOLD,14));
        add(yes);

        no = new JRadioButton("NO");
        no.setBounds(470,490,80,30);
        no.setBackground(Color.WHITE);
        no.setFont(new Font("Raleway",Font.BOLD,14));
        add(no);

        // only one category of maritial status should be chosed
        ButtonGroup seniorCitizen = new ButtonGroup();
        seniorCitizen.add(yes);
        seniorCitizen.add(no);






        // label for existing account
        JLabel existing = new JLabel("Existing Account: ");
        existing.setFont(new Font("Raleway",Font.BOLD,20));
        existing.setBounds(100,540,200,30);
        add(existing);


        // Radio buttons for existing account
        ha =new JRadioButton("YES");
        ha.setBounds(370,540,80,30);
        ha.setBackground(Color.WHITE);
        ha.setFont(new Font("Raleway",Font.BOLD,14));
        add(ha);

        na = new JRadioButton("NO");
        na.setBounds(470,540,80,30);
        na.setBackground(Color.WHITE);
        na.setFont(new Font("Raleway",Font.BOLD,14));
        add(na);

        // only one category of maritial status should be chosed
        ButtonGroup existingAccount = new ButtonGroup();
        existingAccount.add(ha);
        existingAccount.add(na);



        // Button
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(520,590,100,30);
        next.addActionListener(this);
        add(next);


        // Button
        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.setBounds(120,590,100,30);
        back.addActionListener(this);
        add(back);

        // frame settings
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("New Account Application Form Page 2");
        setSize(850,700);
        setLocation(350, 3);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String religion = (String) religionComboBox.getSelectedItem();
        String category = (String) categoryComboBox.getSelectedItem();
        String income   = (String) incomeComboBox.getSelectedItem();
        String education = (String) educationComboBox.getSelectedItem();
        String occupation = (String) occupationComboBox.getSelectedItem();
        String panNumber = panNumberTextFeild.getText();
        String aadharNumber = aadharNumberTextFeild.getText();

        String senior = null;
        if (yes.isSelected()){
            senior = "Yes";
        }else if(no.isSelected()){
            senior = "No";
        }
        String existing = null;
        if (ha.isSelected()){
            existing = "Yes";
        }else if(na.isSelected()){
            existing = "No";
        }


        if(e.getSource()== back){
            setVisible(false);
            new SignupOne().setVisible(true);
        }else{
            setVisible(true);
        }
        try{
            if(religion.equals("") && e.getSource()!= back){
                JOptionPane.showMessageDialog(null, "Select religion");
            }else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + panNumber + "', '" + aadharNumber + "','" + senior + "','" + existing + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                if (e.getSource() != back) {
                    new SignupThree(formno).setVisible(true);
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }




    }
}
