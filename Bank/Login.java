// package Bank;
// import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
// import java.util.*;

public class Login extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JLabel label1, label2, label3;
    JTextField tf1, tf2;
    JButton signinBtn, signupBtn;
    JPasswordField pf;

    Login(){
        setTitle("Automated Teller Machine");
        // Labels
        
        label1 = new JLabel("Welcome to ATM");
        label2 = new JLabel("Card Number");
        label3 = new JLabel("PIN");

        // TextFields
        int width = 720, height = 720;

        // Buttons
        
        signinBtn = new JButton("SIGN IN");
        signupBtn = new JButton("SIGN UP");
        signinBtn.addActionListener(this);
        signupBtn.addActionListener(this);
        
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tf1 = new JTextField(19);
        pf = new JPasswordField(4);

        //Positioning the elements before adding
        label1.setBounds(10, 10, 200, 20);
        label2.setBounds(100, 100, 200, 20);
        label3.setBounds(100, 200, 200, 20);

        tf1.setBounds(200, 100, 200, 20);
        pf.setBounds(200, 200, 200, 20);

        signinBtn.setBounds(200, 300, 200, 20);
        signupBtn.setBounds(200, 400, 200, 20);
        // Adding components before making visible
        add(label1);
        add(label2);
        
        add(tf1);
        add(label3);
        add(pf);
        add(signinBtn);
        add(signupBtn);

        // Displaying the frame
        setLayout(null);
        setSize(width, height);

        ///////////////////////////////////////////////////////////
    }
    
    public static void main(String args[]){
        new Login().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            DatabaseConnection conn = new DatabaseConnection();
            String cardNumber = tf1.getText();
            char[] pass = pf.getPassword();
            String pin = new String(pass);
            String query = "select * from login where cardno='"+cardNumber+"' and pin='"+pin+"'";
            ResultSet rs = conn.st.executeQuery(query);

            if(ae.getSource() == signinBtn){
                if(rs.next()){
                    new Transaction().setVisible(true);
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "INVALID LOGIN details. Create a NEW ACCOUNT by signing up!");
                }
            }
            else if(ae.getSource() == signupBtn){
                String query2 = "select appNo from signup order by(appNo) desc limit 1";
                rs = conn.st.executeQuery(query2);
                if(rs.next()){
                    String val = rs.getString("appNo");
                    int num = Integer.parseInt(val) + 1;
                    new Signup(num).setVisible(true);
                    
                }
                else{
                    new Signup(1).setVisible(true);
                }
                setVisible(false);
            }
            
        }
        catch(Exception e){
            // e.printStackTrace();
            System.out.println("Exception: "+e);
        }
    }
}