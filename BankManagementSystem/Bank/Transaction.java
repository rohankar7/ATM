// package Bank;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
// import java.util.logging.Level;
// import java.util.logging.Logger;

public class Transaction extends JFrame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 568962381941527750L;
    JLabel l1;
    JButton[] buttons = new JButton[7];
    
    public Transaction(){

        setTitle("TRANSACTION");
    
        l1 = new JLabel("Please Select Your Transaction");
        l1.setFont(new Font("System", Font.BOLD, 38));

        buttons[0]= new JButton("DEPOSIT");
        buttons[1]= new JButton("CASH WITHDRAWL");
        buttons[2]= new JButton("FAST CASH");
        buttons[3]= new JButton("MINI STATEMENT");
        buttons[4]= new JButton("PIN CHANGE");
        buttons[5]= new JButton("CHECK BALANCE");
        buttons[6]= new JButton("EXIT");

        for(int i=0;i<7;i++){
            buttons[i].setFont(new Font("System", Font.BOLD, 18));
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setForeground(Color.WHITE);
        }
        
        
        setLayout(null);
        
        l1.setBounds(100,100,700,40);
        add(l1);        
        buttons[0].setBounds(40,250,300,60);
        add(buttons[0]);        
        buttons[1].setBounds(440,250,300,60);
        add(buttons[1]);        
        buttons[2].setBounds(40,360,300,60);
        add(buttons[2]);        
        buttons[3].setBounds(440,360,300,60);
        add(buttons[3]);        
        buttons[4].setBounds(40,470,300,60);
        add(buttons[4]);        
        buttons[5].setBounds(440,470,300,60);
        add(buttons[5]);
        buttons[6].setBounds(240,600,300,60);
        add(buttons[6]);
        
        for(int i=0;i<7;i++){
            buttons[i].addActionListener(this);
        }

        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,800);
        setLocation(0,0);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==buttons[0]){ 
            new Deposit().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==buttons[1]){ 
            new Withdrawal().setVisible(true);
            setVisible(false);
            
        }
        else if(ae.getSource()==buttons[2]){ 
            new FastCash().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==buttons[3]){
            new MiniStatement().setVisible(true);
            setVisible(false);
        }
        else if(ae.getSource()==buttons[4]){ 
            
            new Pin().setVisible(true);
            setVisible(false);
            
        }else if(ae.getSource()==buttons[5]){ 
            
            String pinn = JOptionPane.showInputDialog("Enter PIN"); 
            
                    
            try {
                DatabaseConnection c1 = new DatabaseConnection();
                ResultSet rs = c1.st.executeQuery(" SELECT balance FROM bank ORDER BY pin  = '"+pinn+"' DESC LIMIT 1");
                
                if(rs.next()){
                
                String balance = rs.getString("balance");
                
                JOptionPane.showMessageDialog(null,"Your Account Balance is "+balance);
                } 
            } catch (Exception e) {
                e.printStackTrace();
            }   
        }
        else if(ae.getSource()==buttons[6]){ 
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new Transaction().setVisible(true);
    }
}