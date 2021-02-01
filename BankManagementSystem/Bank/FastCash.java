// package Bank
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
// import java.util.*;


public class FastCash extends JFrame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 8402764067315895543L;
    JLabel l1, l2;
    JButton btns[] = new JButton[8];
    JTextField tf;

    public FastCash(){

        setTitle("Fast Cash");
        l1 = new JLabel("Select withdrawal amount");
        l1.setFont(new Font("System", Font.BOLD, 38));
        l2=  new JLabel("Enter PIN");
        l2.setFont(new Font("System", Font.BOLD, 13));

        tf = new JTextField();
        tf.setFont(new Font("System", Font.BOLD, 13));

        btns[0] = new JButton("Rs 100");
        btns[1] = new JButton("Rs 500");
        btns[2] = new JButton("Rs 1000");
        btns[3] = new JButton("Rs 2000");
        btns[4] = new JButton("Rs 5000");
        btns[5] = new JButton("Rs 10000");
        btns[6] = new JButton("Back");
        btns[7] = new JButton("Exit");

        for(int i=0;i<8;i++){
            btns[i].setFont(new Font("System", Font.BOLD, 18));
            btns[i].setBackground(Color.BLACK);
            btns[i].setForeground(Color.WHITE);
        }

        //Positioning the elements
        setLayout(null);
        
        l2.setBounds(640,10,60,40);
        add(l2);
        
        tf.setBounds(710,10,60,40);
        add(tf);
        
        l1.setBounds(100,100,700,40);
        add(l1);
        
        btns[0].setBounds(40,250,300,60);
        add(btns[0]);
        
        btns[1].setBounds(440,250,300,60);
        add(btns[1]);
        
        btns[2].setBounds(40,360,300,60);
        add(btns[2]);
        
        btns[3].setBounds(440,360,300,60);
        add(btns[3]);
        
        btns[4].setBounds(40,470,300,60);
        add(btns[4]);
        
        btns[5].setBounds(440,470,300,60);
        add(btns[5]);
        
        btns[6].setBounds(240,570,300,60);
        add(btns[6]);

        btns[7].setBounds(240,670,300,60);
        add(btns[7]);

        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the actionListener to the buttons
        for(int i=0;i<8;i++){
            btns[i].addActionListener(this);
        }
    }

    public static void main(String[] args){
        new FastCash().setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            String a = tf.getText();
            double balance = 0, withdrawnAmount = 0;

            if(ae.getSource() == btns[0]||ae.getSource() == btns[1]||ae.getSource() == btns[2]||ae.getSource() == btns[3]||ae.getSource() == btns[4]||ae.getSource() == btns[4]||ae.getSource() == btns[5]){

                DatabaseConnection conn = new DatabaseConnection();
                ResultSet rs = conn.st.executeQuery("select * from bank where pin='"+a+"'");
                if(rs.next()){
                    String pin = rs.getString("pin");
                    balance = rs.getDouble("balance");
                    
                    // Choosing the options
                    if(ae.getSource() == btns[0]){
                        withdrawnAmount = 100;
                    }
                    else if(ae.getSource() == btns[1]){
                        withdrawnAmount = 500;
                    }
                    else if(ae.getSource() == btns[2]){
                        withdrawnAmount = 1000;
                    }
                    else if(ae.getSource() == btns[3]){
                        withdrawnAmount = 2000;
                    }
                    else if(ae.getSource() == btns[4]){
                        withdrawnAmount = 5000;
                    }
                    else if(ae.getSource() == btns[4]){
                        withdrawnAmount = 10000;
                    }
                    balance -= withdrawnAmount;
                    String query = "insert into bank values('"+pin+"', null,'"+withdrawnAmount+"','"+balance+"')";
                    conn.st.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Rs. "+withdrawnAmount+" debited");
                    new Transaction().setVisible(true);
                    setVisible(false);
                }
            }
            else if(ae.getSource() == btns[6]){
                new Transaction().setVisible(true);
                setVisible(false);
            }
            else if(ae.getSource() == btns[7]){
                System.exit(0);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception: "+e);
        }
    }
}
