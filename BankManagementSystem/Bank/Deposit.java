// package Bank;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
// import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 248640684596646651L;
    JTextField[] tf = new JTextField[2];
    JButton[] b = new JButton[3];
    JLabel[] l = new JLabel[3];

    public Deposit(){
        setTitle("DEPOSIT");
        l[0] = new JLabel("Enter the amount to deposit:");
        l[1] = new JLabel("Enter PIN:");

        for(int i=0;i<2;i++){
            l[i].setFont(new Font("System", Font.BOLD, 22));
        }

        //Defining the textfields
        for(int i=0;i<2;i++){
            tf[i] = new JTextField();
            tf[i].setFont(new Font("Raleway", Font.BOLD, 22));
        }
        //Defining the buttons
        b[0] = new JButton("Deposit");
        b[1] = new JButton("Back");
        b[2] = new JButton("Exit");
        for(int i=0;i<3;i++){
            b[i].setFont(new Font("System", Font.BOLD, 18));
            b[i].setBackground(Color.BLACK);
            b[i].setForeground(Color.WHITE);
        }
        setLayout(null);

        /////////////////////////////////////
        l[1].setBounds(500,10,300,30);
        add(l[1]);
        
        tf[1].setBounds(700,10,40,30);
        add(tf[1]);
        
        l[0].setBounds(150,150,800,60);
        add(l[0]);
        
        // l[1].setBounds(290,210,800,60);
        // add(l[1]);
        
        tf[0].setBounds(250, 240, 300, 50);
        add(tf[0]);
        
        b[0].setBounds(260,380,125,50);
        add(b[0]);
        
        b[1].setBounds(415,380,125,50);
        add(b[1]);
        
        b[2].setBounds(300,550,200,50);
        add(b[2]);
        /////////////////////////////////////
        for(int i=0;i<3;i++){
            b[i].addActionListener(this);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 800);
        setLocation(500,90);
    }

    public static void main(String args[]){
        new Deposit().setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String a = tf[0].getText();
            String b = tf[1].getText();
            if(ae.getSource() == this.b[0]){
                if(a.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the amount to be deposited");

                }
                else if(b.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the pin");
                }
                else{
                    DatabaseConnection conn = new DatabaseConnection();
                    String query = "select * from bank where pin='"+b+"'";
                    ResultSet rs = conn.st.executeQuery(query);
                    
                    double balance = 0;
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        balance = rs.getDouble("balance");

                        Double credit = Double.parseDouble(a);
                        balance += credit;
                        conn.st.executeUpdate("insert into bank values('"+pin+"', '"+credit+"', null, '"+balance+"')");
                        JOptionPane.showMessageDialog(null, "Rs. "+a+" has been credited successfully");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Please check your details and try again");
                    }
                    new Transaction().setVisible(true);
                    setVisible(false);
                }
            }
            else if(ae.getSource() == this.b[1]){
                new Transaction().setVisible(true);
                setVisible(false);
            }
            else if(ae.getSource() == this.b[2]){
                System.exit(0);
            }

        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error: " + e);
        }
    }
}