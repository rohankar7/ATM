// package Bank

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// import java.sql.*;
// import java.util.*;

public class Pin extends JFrame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 2193649788545451424L;
    JPasswordField[] passFields = new JPasswordField[3];
    JButton[] btns = new JButton[2];
    JLabel[] labels = new JLabel[4];

    public Pin(){
        setFont(new Font("System", Font.BOLD, 22));
        setTitle("PIN CHANGE");

        // Setting up the labels
        labels[0] = new JLabel("CHANGE YOUR PIN: ");
        labels[1] = new JLabel("ENTER CURRENT PIN: ");
        labels[2] = new JLabel("ENTER NEW PIN: ");
        labels[3] = new JLabel("RE-ENTER NEW PIN: ");
        for(int i=0;i<4;i++){
            if(i==0)
                labels[i].setFont(new Font("System", Font.BOLD, 35));
            else
            labels[i].setFont(new Font("System", Font.BOLD, 14));
        }

        // Setting up the password fields
        for(int i=0;i<3;i++){
            passFields[i] = new JPasswordField();
            passFields[i].setFont(new Font("System", Font.BOLD, 22));
        }

        // Setting up the JButton(s)
        btns[0] = new JButton("SAVE");
        btns[1] = new JButton("BACK");
        for(int i=0;i<2;i++){
            btns[i].setFont(new Font("System", Font.BOLD, 18));
            btns[i].setForeground(Color.BLACK);
            btns[i].setBackground(Color.WHITE);
            btns[i].addActionListener(this);
        }

        setLayout(null);

        labels[0].setBounds(220,130,800,60);
        add(labels[0]);
        
        labels[1].setBounds(100,240,150,60);
        add(labels[1]);
        
        labels[2].setBounds(100,300,150,40);
        add(labels[2]);
        
        labels[3].setBounds(100,360,200,40);
        add(labels[3]);
        
        passFields[0].setBounds(310,240,360,40);
        add(passFields[0]);
        
        passFields[1].setBounds(310,300,360,40);
        add(passFields[1]);
        
        passFields[2].setBounds(310,360,360,40);
        add(passFields[2]);
        
        btns[0].setBounds(220,460,160,50);
        add(btns[0]);
        
        btns[1].setBounds(400,460,160,50);
        add(btns[1]);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        setLocation(0, 0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new Pin().setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            String oldPin = passFields[0].getSelectedText();
            String newPin = passFields[1].getSelectedText();
            String conNewPin = passFields[2].getSelectedText();


            if(ae.getSource() == btns[0]){
                if(passFields[0].getSelectedText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter current PIN");
                }
                else if(newPin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the new password");
                }
                else if(conNewPin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please confirm your new password");
                }
                else if(!conNewPin.equals(newPin)){
                    JOptionPane.showMessageDialog(null, "Please re-enter the same new PIN");
                }
                else{
                    DatabaseConnection conn = new DatabaseConnection();
                    String query1 = "update bank set pin='"+newPin+"' where pin='"+oldPin+"'";
                    String query2 = "update login set pin='"+newPin+"' where pin='"+oldPin+"'";
                    String query3 = "update signup3 set pin='"+newPin+"' where pin='"+oldPin+"'";
                    conn.st.executeUpdate(query1);
                    conn.st.executeUpdate(query2);
                    conn.st.executeUpdate(query3);

                    // Displaying the successful message
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");

                    new Transaction().setVisible(true);
                    setVisible(false);
                }
            }
            else if(ae.getSource() == btns[1]){
                new Transaction().setVisible(true);
                setVisible(false);
            }
        }
        catch(Exception e){
            System.out.println("Exception:" + e);
        }
    }
}