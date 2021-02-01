// package Bank
// import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
// import java.util.*;

public class MiniStatement extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JTable table;
    JButton button;
    String x[] = {"Customer Name", "Date", "Deposit", "Withdraw", "Balance"};
    String y[][] = new String[20][5];

    public MiniStatement() {
        setTitle("Mini Statement");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0, 0);
        String pin = JOptionPane.showInputDialog(null, "Enter your PIN");
        try{
            DatabaseConnection conn = new DatabaseConnection();
            ResultSet rs = conn.st.executeQuery("select * from bank where pin='"+pin+"'");
            int i=0, j=0;
            if(rs.next()){
                while(rs.next()){
                    y[i][j++] = rs.getString("customerName");
                    y[i][j++] = rs.getString("date");
                    y[i][j++] = rs.getString("deposit");
                    y[i][j++] = rs.getString("withdraw");
                    y[i][j++] = rs.getString("balance");
                    ++i;
                    j=0;
                }
                table = new JTable(y, x);
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception: "+e);
        }
        button = new JButton("Print");
        add(button, "South");
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        button.addActionListener(this);
    }
    public static void main(String[] args){
        new MiniStatement().setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            table.print();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
