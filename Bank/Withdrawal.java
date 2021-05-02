// package Bank
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

public class Withdrawal extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JTextField tfs[] = new JTextField[2];
    JButton buttons[] = new JButton[3];
    JLabel l1, l2, l3, l4;

    public Withdrawal() {

        // l1 = new JLabel("MAXIMUM DAILY WITHDRAWAL");
        // l1.setFont(new Font("Raleway", Font.BOLD, 40));
        
        // l2 = new JLabel("IS RS.10,000");
        // l2.setFont(new Font("Raleway", Font.BOLD, 40));
        
        l3 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l3.setFont(new Font("Raleway", Font.BOLD, 35));
        
        l4 = new JLabel("Enter Pin");
        l4.setFont(new Font("Raleway", Font.BOLD, 14));

        //Setting up the textfields
        for(int i=0;i<2;i++){
            tfs[i] = new JTextField();
            tfs[i].setFont(new Font("Raleway", Font.BOLD, 22));
        }

        //Setting up the buttons
        buttons[0] = new JButton("WITHDRAW");
        buttons[1] = new JButton("BACK");
        buttons[2] = new JButton("EXIT");

        for(int i=0;i<3;i++){
            buttons[i].setFont(new Font("Raleway", Font.BOLD, 18));
            buttons[i].setBackground(Color.BLACK);
            buttons[i].setForeground(Color.WHITE);
        }
        // Designing the UI
        setLayout(null);
        
        l4.setBounds(620,10,80,30);
        add(l4);
        
        tfs[1].setBounds(700,10,40,30);
        add(tfs[1]);
        
        // l1.setBounds(90,100,800,60);
        // add(l1);
        
        // l2.setBounds(270,160,800,60);
        // add(l2);
        
        l3.setBounds(120,260,800,60);
        add(l3);
        
        tfs[0].setBounds(210,340,360,50);
        add(tfs[0]);
        
        buttons[0].setBounds(220,400,160,50);
        add(buttons[0]);
        
        buttons[1].setBounds(400,400,160,50);
        add(buttons[1]);
        
        buttons[2].setBounds(300,550,200,50);
        add(buttons[2]);
        
        
        for(int i=0;i<3;i++){
            buttons[i].addActionListener(this);
        }
        
        
        getContentPane().setBackground(Color.WHITE);

        setTitle("WITHDRAWAL");
        setLocation(0, 0);
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        new Withdrawal().setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            String a = tfs[0].getText();
            String b = tfs[1].getText();

            if(ae.getSource() == buttons[0]){
                DatabaseConnection conn = new DatabaseConnection();
                DatabaseConnection conn1 = new DatabaseConnection();
                ResultSet result = conn.st.executeQuery("select * from login where pin='"+b+"'");
                
                if(result.next()){
                    ResultSet rs = conn1.st.executeQuery("select * from bank where pin = '"+b+"' order by(slno) desc limit 1");

                    double newBalance = 0, balance = 0;
                    if(rs.next()){
                        String pin = rs.getString("pin");
                        balance = rs.getDouble("balance");
                        double wm = Double.parseDouble(a);
                        if(balance >= wm){
                            newBalance = balance - wm;
                            String updateQuery = "insert into bank(cardno, pin, credit, debit, balance) values('"+result.getString("cardno")+"','"+pin+"', null, '"+wm+"', '"+newBalance+"')";
    
                            conn.st.executeUpdate(updateQuery);
                            JOptionPane.showMessageDialog(null, "Rs. "+a+" was successfully debited.");
                            new Transaction().setVisible(true);
                            setVisible(false);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Insufficient bank balance");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Please deposit a sum before requesting a withdrawal");
                    }
                }
                else if(!result.next()){
                    JOptionPane.showMessageDialog(null, "Please enter a valid PIN to continue");
                }
                else if(b.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter a valid PIN to continue");
                }
                else if(a.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                }
            }
            else if(ae.getSource() == buttons[1]){
                new Transaction().setVisible(true);
                setVisible(false);
            }
            else{
                System.exit(0);
            }
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception "+e);
        }
    }
}