// package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import java.sql.ResultSet;
// import java.sql.SQLException;


public class Signup2 extends JFrame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 7635033210247755576L;

    final int width = 720, height = 720;
    JLabel[] labels = new JLabel[12];
    JRadioButton[] radioBtns = new JRadioButton[4];
    JTextField[] textFields = new JTextField[3];
    JComboBox<String> c1, c2, c3, c4, c5;
    ButtonGroup btngrp1 = new ButtonGroup();
    ButtonGroup btngrp2 = new ButtonGroup();
    JButton btn = new JButton("Next");
    Signup2() {
        

        // Assign the JLabel components
        labels[0] = new JLabel("Page 2: Additional Details");
        labels[1] = new JLabel("Religion:");
        labels[2] = new JLabel("Category:");
        labels[3] = new JLabel("Income:");
        labels[4] = new JLabel("Education:");
        labels[5] = new JLabel("Occupation:");
        labels[6] = new JLabel("PAN Number:");
        labels[7] = new JLabel("Aadhaar Number:");
        labels[8] = new JLabel("Senior Citizen:");
        labels[9] = new JLabel("Existing Account:");
        labels[10] = new JLabel("Qualification");
        labels[11] = new JLabel("Form No.:");

        for(int i=0;i<12;i++){
            labels[i].setFont(new Font("Raleway", Font.BOLD, 18));
        }

        // Assigning JButton
        btn.setFont(new Font("Raleway", Font.BOLD, 14));
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);

        // Assigning JTextField
        for(int i=0;i<3;i++){
            textFields[i]= new JTextField();
            textFields[i].setFont(new Font("Raleway", Font.BOLD, 14));
        }

        // Assigning JRadioButton Components
        radioBtns[0] = new JRadioButton("Yes");
        radioBtns[1] = new JRadioButton("No");
        radioBtns[2] = new JRadioButton("Yes");
        radioBtns[3] = new JRadioButton("No");

        for(int i=0;i<4;i++){
            radioBtns[i].setFont(new Font("Raleway", Font.BOLD, 14));
            radioBtns[i].setBackground(Color.WHITE);
        }

        // Combo boxes
        String religion[]= {"", "Hindu", "Muslim", "Sikh", "Christian", "Buddhist", "Other"};
        c1 = new JComboBox<String>(religion);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 14));

        String category[] = {"", "General", "OBC", "SC", "ST", "Other"};
        c2 = new JComboBox<String>(category);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 14));

        String income[] = {"","< 1,50,000","< 2,50,000","< 5,00,000","< 10,00,000","> 10,00,000"};
        c3 = new JComboBox<String>(income);
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String education[] = {"", "Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        c4 = new JComboBox<String>(education);
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String occupation[] = {"", "Employed","Self-Employmed","Business","Student","Retired","Others"};
        c5 = new JComboBox<String>(occupation);
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 14));

        setLayout(null);
        labels[11].setBounds(700, 10, 60, 30);
        add(labels[11]);
        textFields[2].setBounds(760, 10, 60, 30);
        add(textFields[2]);
        labels[0].setBounds(280, 30, 600, 40);
        add(labels[0]);
        labels[1].setBounds(100, 120, 100, 30);
        add(labels[1]);
        c1.setBounds(350,120,320,30);
        add(c1);
        labels[2].setBounds(100,170,100,30);
        add(labels[2]);
        c2.setBounds(350,170,320,30);
        add(c2);        
        labels[3].setBounds(100,220,100,30);
        add(labels[3]);        
        c3.setBounds(350,220,320,30);
        add(c3);        
        labels[4].setBounds(100,270,150,30);
        add(labels[4]);        
        c4.setBounds(350,270,320,30);
        add(c4);        
        labels[10].setBounds(100,290,150,30);
        add(labels[10]);        
        labels[5].setBounds(100,340,150,30);
        add(labels[5]);        
        c5.setBounds(350,340,320,30);
        add(c5);        
        labels[6].setBounds(100,390,150,30);
        add(labels[6]);        
        textFields[0].setBounds(350,390,320,30);
        add(textFields[0]);        
        labels[7].setBounds(100,440,180,30);
        add(labels[7]);        
        textFields[1].setBounds(350,440,320,30);
        add(textFields[1]);        
        labels[8].setBounds(100,490,150,30);
        add(labels[8]);        
        radioBtns[0].setBounds(350,490,100,30);
        add(radioBtns[0]);        
        radioBtns[1].setBounds(460,490,100,30);
        add(radioBtns[1]);        
        labels[9].setBounds(100,540,180,30);
        add(labels[9]);        
        radioBtns[2].setBounds(350,540,100,30);
        add(radioBtns[2]);        
        radioBtns[3].setBounds(460,540,100,30);
        add(radioBtns[3]);        
        btn.setBounds(570,600,100,30);
        add(btn);        
        btn.addActionListener(this);
        btngrp1.add(radioBtns[0]);
        btngrp1.add(radioBtns[1]);
        btngrp2.add(radioBtns[2]);
        btngrp2.add(radioBtns[3]);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setSize(width, height);
        setLocation(0, 0);
    }
    
    public static void main(String[] args){
        new Signup2().setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String religion = (String)c1.getSelectedItem();
        String category = (String)c2.getSelectedItem();
        String income = (String)c3.getSelectedItem();
        String education = (String)c4.getSelectedItem();
        String occupation = (String)c5.getSelectedItem();
        String pan = textFields[0].getText();
        String aadhaar = textFields[1].getText();
        String seniorAged = "";
        if(radioBtns[0].isSelected()){
            seniorAged = "Yes";
        }
        else if(radioBtns[1].isSelected()){
            seniorAged = "No";
        }
        String existing = "";
        if(radioBtns[2].isSelected()){
            existing = "Yes";
        }
        else if(radioBtns[3].isSelected()){
            existing = "No";
        }

        String j = textFields[2].getText();
        try{
            if(ae.getSource() == btn){
                if(religion.equals("")||category.equals("")||income.equals("")||education.equals("")||occupation.equals("")||pan.equals("")||aadhaar.equals("")||j.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter all the details!");
                }
                else{
                    DatabaseConnection conn = new DatabaseConnection();
                    String query = "insert into values('"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhaar+"','"+seniorAged+"','"+existing+"')";
                    conn.st.executeUpdate(query);
                    new Signup3().setVisible(true);
                    setVisible(false);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
