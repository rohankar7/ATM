// package Bank;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 8817565388218118952L;
    JLabel[] labels = new JLabel[11];
    JButton button[] = new JButton[2];
    JRadioButton[] radioBtns = new JRadioButton[4];
    JTextField tf = new JTextField();
    JCheckBox cbs[] = new JCheckBox[7];
    ButtonGroup bgp = new ButtonGroup();
    int formNum;

    public Signup3(int appNo){
        setTitle("New Account Application Form - Page 3");

        labels[0] = new JLabel("Page 3: Account Details");
        labels[1] = new JLabel("Account Type:");
        labels[2] = new JLabel("Card Number:");
        labels[3] = new JLabel("XXXX-XXXX-XXXX-XXXX");
        labels[4] = new JLabel("(Your 16-digit Card number)");
        labels[5] = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        labels[6] = new JLabel("PIN:");
        labels[7] = new JLabel("XXXX");
        labels[8] = new JLabel("(4-digit password)");
        labels[9] = new JLabel("Services Required:");
        labels[10] = new JLabel("Form No.:");

        for(int i=0;i<11;i++){
            labels[10].setFont(new Font("Raleway", Font.BOLD, 18));
        }

        button[0] = new JButton("Submit");
        button[1] = new JButton("Cancel");

        for(int i=0;i<2;i++){
            button[i].setFont(new Font("Raleway", Font.BOLD, 14));
            button[i].setBackground(Color.BLACK);
            button[i].setForeground(Color.WHITE);
        }

        // Initialising Checkboxes
        cbs[0] = new JCheckBox("ATM CARD");
        cbs[1] = new JCheckBox("Internet Banking");
        cbs[2] = new JCheckBox("Mobile Banking");
        cbs[3] = new JCheckBox("Email Alerts");
        cbs[4] = new JCheckBox("Cheque Book");
        cbs[5] = new JCheckBox("E-Statement");
        cbs[6] = new JCheckBox("I hereby declare that all the above details are correct to the best of my knowledge");

        for(int i=0;i<7;i++){
            cbs[i].setFont(new Font("Raleway", Font.BOLD, 12));
            cbs[i].setBackground(Color.WHITE);
        }

        // Initialising RadioButtons
        radioBtns[0] = new JRadioButton("Saving Account");
        radioBtns[1] = new JRadioButton("Fixed Deposit Account");
        radioBtns[2] = new JRadioButton("Current Account");
        radioBtns[3] = new JRadioButton("Recurring Deposit Account");

        for(int i=0;i<4;i++){
            bgp.add(radioBtns[i]);
        }

        // Initialising TextField
        tf = new JTextField();
        tf.setFont(new Font("Raleway", Font.BOLD, 12));
        tf.setEditable(false);
        tf.setText(String.valueOf(appNo));
        this.formNum = appNo;

        setLayout(null);

        labels[10].setBounds(700,10,70,30);
        add(labels[10]);
        
        tf.setBounds(770,10,40,30);
        add(tf);
        
        labels[0].setBounds(280,50,400,40);
        add(labels[0]); 
        
        labels[1].setBounds(100,140,200,30);
        add(labels[1]);
        
        radioBtns[0].setBounds(100,180,150,30);
        add(radioBtns[0]);
        
        radioBtns[1].setBounds(350,180,300,30);
        add(radioBtns[1]);
        
        radioBtns[2].setBounds(100,220,250,30);
        add(radioBtns[2]);
        
        radioBtns[3].setBounds(350,220,250,30);
        add(radioBtns[3]);
        
        labels[2].setBounds(100,300,200,30);
        add(labels[2]);
        
        labels[3].setBounds(330,300,250,30);
        add(labels[3]);
        
        labels[4].setBounds(100,330,200,20);
        add(labels[4]);
        
        labels[5].setBounds(330,330,500,20);
        add(labels[5]);
        
        labels[6].setBounds(100,370,200,30);
        add(labels[6]);
        
        labels[7].setBounds(330,370,200,30);
        add(labels[7]);
        
        labels[8].setBounds(100,400,200,20);
        add(labels[8]);
        
        labels[9].setBounds(100,450,200,30);
        add(labels[9]);
        
        cbs[0].setBounds(100,500,200,30);
        add(cbs[0]);
        
        cbs[1].setBounds(350,500,200,30);
        add(cbs[1]);
        
        cbs[2].setBounds(100,550,200,30);
        add(cbs[2]);
        
        cbs[3].setBounds(350,550,200,30);
        add(cbs[3]);
        
        cbs[4].setBounds(100,600,200,30);
        add(cbs[4]);
        
        cbs[5].setBounds(350,600,200,30);
        add(cbs[5]);
        
        cbs[6].setBounds(100,680,600,20);
        add(cbs[6]);
        
        button[0].setBounds(300,720,100,30);
        add(button[0]);
        
        button[1].setBounds(420,720,100,30);
        add(button[1]);

        button[0].addActionListener(this);
        button[1].addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 800);
        setLocation(0, 0);
        
    }

    public static void main(String[] args){
        new Signup3(1).setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String a = null;
        if(radioBtns[0].isSelected()){
            a = "Savng Account";
        }
        else if(radioBtns[1].isSelected()){
            a = "Fixed Deposit Account";
        }
        else if(radioBtns[2].isSelected()){
            a = "Current Account";
        }
        else if(radioBtns[3].isSelected()){
            a = "Recurring Deposit Account";
        }

        Random random = new Random();
        long first7 = (random.nextLong() % 90000000L) + 5040936000000000L;
        long first8 = Math.abs(first7);

        long first3 = (random.nextLong() % 9000L) + 1000L;
        long first4 = Math.abs(first3);

        String b = "";
        if(cbs[0].isSelected()){
            b += cbs[0].getText();
        }
        if(cbs[1].isSelected()){
            b += cbs[1].getText();
        }
        if(cbs[2].isSelected()){
            b += cbs[2].getText();
        }
        if(cbs[3].isSelected()){
            b += cbs[3].getText();
        }
        if(cbs[4].isSelected()){
            b += cbs[4].getText();
        }
        if(cbs[5].isSelected()){
            b += cbs[5].getText();
        }

        // String c = tf.getText();

        try{

            if(ae.getSource() == button[0]){
                if(b.equals("") || !cbs[6].isSelected()){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields!");
                }
                else{
                    System.out.println(b);
                    DatabaseConnection conn = new DatabaseConnection();
                    String q1 = "insert into signup3 values('"+formNum+"','"+a+"','"+b+"')";
                    String q2 = "insert into login values('"+first8+"','"+first4+"')";
                    System.out.println("Card No.: " + first8 + "Pin:" + first4);
                    conn.st.executeUpdate(q1);
                    conn.st.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: "+first8+"\n"+"PIN: "+first4);

                    new Deposit().setVisible(true);
                    setVisible(false);
                }
            }
            else if(ae.getSource() == button[1]){
                System.exit(0);
            }
            
        }
        catch(Exception e){
            System.out.println("Exception: "+e);
        }
    }
}
