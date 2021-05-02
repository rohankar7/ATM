// package Bank;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
// import java.util.*;

public class Signup extends JFrame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 4134547950673251559L;
    // Declaring Components
    JLabel[] labels = new JLabel[15];
    JTextField[] textFields = new JTextField[8];
    JComboBox<String> c1, c2,c3;
    JRadioButton[] radioBtns = new JRadioButton[5];
    JButton button = new JButton("Next");
    final int width = 720, height = 720;
    private ButtonGroup genderGroup = new ButtonGroup();
    private ButtonGroup maritalGroup = new ButtonGroup();
    int appNo;

    Signup(int appNo) {
        
        // Assigning Label Components
        labels[0] = new JLabel("Application Form");
        labels[1] = new JLabel("Page 1: Personal Details:");
        labels[2] = new JLabel("Name:");
        labels[3] = new JLabel("Guardian's Name:");
        labels[4] = new JLabel("Date of Birth:");
        labels[5] = new JLabel("Gender:");
        labels[6] = new JLabel("Email Address:");
        labels[7] = new JLabel("Marital Status:");
        labels[8] = new JLabel("Address:");
        labels[9] = new JLabel("City:");
        labels[10] = new JLabel("Pin Code:");
        labels[11] = new JLabel("State:");
        labels[12] = new JLabel("Date");
        labels[13] = new JLabel("Month");
        labels[14] = new JLabel("Year");

        // Assigning the Radio Components
        radioBtns[0] = new JRadioButton("Male");
        radioBtns[1] = new JRadioButton("Female");
        radioBtns[2] = new JRadioButton("Other");
        radioBtns[3] = new JRadioButton("Married");
        radioBtns[4] = new JRadioButton("Unmarried");
        genderGroup.add(radioBtns[0]);
        genderGroup.add(radioBtns[1]);
        genderGroup.add(radioBtns[2]);
        maritalGroup.add(radioBtns[3]);
        maritalGroup.add(radioBtns[4]);

        for(int i=0;i<5;i++){
            radioBtns[i].setFont(new Font("Raleway", Font.BOLD, 14));
            radioBtns[i].setBackground(Color.WHITE);
            radioBtns[i].setSelected(false);
        }

        // Setting the font for each label
        int labelSize = 20;
        for(int i=0;i<15;i++){
            if(i>=12){
                labels[i].setFont(new Font("Raleway", Font.BOLD, labelSize-6));
            }
            else{
                labels[i].setFont(new Font("Raleway", Font.BOLD, labelSize));
            }
        }

        // Setting the textfields
        for(int i=0;i<8;i++){
            textFields[i] = new JTextField();
            textFields[i].setFont(new Font("Raleway", Font.BOLD, 14));
        }

        String[] day = new String[31];
        for(int i=1; i<=31; i++){
            day[i-1] = Integer.toString(i);
        }
        c1 = new JComboBox<String>(day);
        String month[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        c2 = new JComboBox<String>(month);
        
        String[] year = new String[62];
        for(int i=1960; i<=2021;i++){
            year[i-1960] = Integer.toString(i);
        }
        c3 = new JComboBox<String>(year);

        //Setting colour
        c1.setBackground(Color.WHITE);
        c2.setBackground(Color.WHITE);
        c3.setBackground(Color.WHITE);

        // Position the elements
        setSize(width, height);
        setLayout(null);
        labels[0].setBounds(140,20,600,40);
        add(labels[0]);
        textFields[7].setBounds(500, 20, 200, 40);
        textFields[7].setEditable(false);
        add(textFields[7]);
        textFields[7].setText(String.valueOf(appNo));
        this.appNo = appNo;

        labels[1].setBounds(290, 70, 600, 30);
        add(labels[1]);
        labels[2].setBounds(100, 140, 100, 30);
        add(labels[2]);
        textFields[0].setBounds(300, 140, 400, 30);
        add(textFields[0]);
        labels[3].setBounds(100, 190, 200, 30);
        add(labels[3]);
        textFields[1].setBounds(300, 190, 400, 30);
        add(textFields[1]);
        labels[4].setBounds(100, 240, 200, 30);
        add(labels[4]);
        labels[12].setBounds(300, 240, 40, 30);
        add(labels[12]);
        c1.setBounds(340, 240, 60, 30);
        add(c1);
        labels[13].setBounds(410, 240, 50, 30);
        add(labels[13]);
        c2.setBounds(460, 240, 100, 30);
        add(c2);
        labels[14].setBounds(570, 240, 40, 30);
        add(labels[14]);
        c3.setBounds(610, 240, 90, 30);
        add(c3);
        labels[5].setBounds(100, 290, 200, 30);
        add(labels[5]);
        radioBtns[0].setBounds(300, 290, 90, 30);
        add(radioBtns[0]);
        radioBtns[1].setBounds(450, 290, 90, 30);
        add(radioBtns[1]);
        radioBtns[2].setBounds(630, 290, 100, 30);
        add(radioBtns[2]);
        labels[6].setBounds(100, 340, 200, 30);
        add(labels[6]);
        textFields[2].setBounds(300, 340, 400, 30);
        add(textFields[2]);
        labels[7].setBounds(100, 390, 200, 30);
        add(labels[7]);
        radioBtns[3].setBounds(300, 390, 100, 30);
        add(radioBtns[3]);
        radioBtns[4].setBounds(450, 390, 120, 30);
        add(radioBtns[4]);
        labels[8].setBounds(100, 440, 200, 30);
        add(labels[8]);
        textFields[3].setBounds(300, 440, 400, 30);
        add(textFields[3]);
        labels[9].setBounds(100, 490, 200, 30);
        add(labels[9]);
        textFields[4].setBounds(300, 490, 400, 30);
        add(textFields[4]);
        labels[10].setBounds(100, 540, 200, 30);
        add(labels[10]);
        textFields[5].setBounds(300, 540, 400, 30);
        add(textFields[5]);
        labels[11].setBounds(100, 590, 200, 30);
        add(labels[11]);
        textFields[6].setBounds(300, 590, 400, 30);
        add(textFields[6]);

        button.setBounds(620, 640, 80, 30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);
        button.addActionListener(this);
        getContentPane().setBackground(Color.WHITE);
        radioBtns[0].setSelected(true);
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    // public static void main(String args[]){
    //     new Signup(1).setVisible(true);
    // }

    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            String name = textFields[0].getText();
            String gName = textFields[1].getText();
            String date = (String)c1.getSelectedItem();
            String month = (String)c2.getSelectedItem();
            String year = (String)c3.getSelectedItem();
            String gender = null;
            boolean flag = true;

            // Selecting the gender
            if(radioBtns[0].isSelected()){
                gender = "Male";
            }
            else if(radioBtns[1].isSelected()){
                gender = "Female";
            }
            else if(radioBtns[2].isSelected()){
                gender = "Other";
            }
            else{
                // System.out.println("Gender:" + gender);
                flag = false;
            }

            String eMail = textFields[2].getText();

            // Selecting Marital Status
            String maritalStatus = null;
            if(radioBtns[3].isSelected()){
                maritalStatus = "Married";
            }
            else if(radioBtns[4].isSelected()){
                maritalStatus = "Unmarried";
            }
            else{
                flag = false;
            }

            String address = textFields[3].getText();
            String city = textFields[4].getText();
            String pinCode = textFields[5].getText();
            String state = textFields[6].getText();

            if(address.equals("")||city.equals("")||pinCode.equals("")||state.equals("")){
                flag = false;
            }

            if(ae.getSource() == button){
                if(!flag){
                    // radioBtns[0].setSelected(false);
                    // System.out.println(address  + city + pinCode + state);
                    System.out.println("Gender:" + gender);
                    JOptionPane.showMessageDialog(null, "Fill all the details");
                    flag = true;
                }
                else{
                    try{
                        DatabaseConnection conn = new DatabaseConnection();
                        String query = "insert into signup(name, gname, date, month, year, gender, email, maritalStatus, address, city, pincode, state) values('"+name+"','"+gName+"','"+date+"','"+month+"','"+year+"','"+gender+"','"+eMail+"','"+maritalStatus+"','"+address+"','"+city+"','"+pinCode+"','"+state+"')";
                        conn.st.executeUpdate(query);
    
                        // Open new Signup page
                        new Signup2(appNo).setVisible(true);
                        setVisible(false);
                    }
                    catch(SQLException sqle){
                        sqle.printStackTrace();
                        System.out.println("Exception: "+sqle);
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception: "+e);
        }
    }

    public static String applicationNumber(){

        return "Hey";
    }

}