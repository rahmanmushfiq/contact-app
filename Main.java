
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;

class Frame1 extends JFrame implements ActionListener {

    JLabel frame1WelcomeLabel;
    JLabel frame1LoginLabel;
    JLabel frame1NextLabel;
    JLabel frame1IdLabel;
    JLabel frame1PassLabel;

    JButton frame1NextButton;
    JButton frame1LoginButton;

    JTextField frame1IdTextField;
    JPasswordField frame1PassField;

    Frame1() {
        frame1WelcomeLabel = new JLabel("Welcome To Contact Application");
        frame1WelcomeLabel.setFont(new Font("Serif", Font.BOLD, 20));
        frame1WelcomeLabel.setBounds(70, 10, 350, 25);
        this.add(frame1WelcomeLabel);

        frame1LoginLabel = new JLabel("Login");
        frame1LoginLabel.setFont(new Font("Serif", Font.BOLD, 15));
        frame1LoginLabel.setBounds(10, 45, 40, 25);
        this.add(frame1LoginLabel);

        frame1NextLabel = new JLabel("Click Next to Proceed");
        frame1NextLabel.setBounds(290, 220, 250, 25);
        this.add(frame1NextLabel);

        frame1IdLabel = new JLabel("ID");
        frame1IdLabel.setBounds(10, 70, 25, 25);
        this.add(frame1IdLabel);

        frame1PassLabel = new JLabel("Password");
        frame1PassLabel.setBounds(10, 120, 60, 40);
        this.add(frame1PassLabel);

        frame1IdTextField = new JTextField("mushfiq");
        frame1IdTextField.setBounds(10, 90, 150, 25);
        this.add(frame1IdTextField);

        frame1PassField = new JPasswordField("rahman");
        frame1PassField.setBounds(10, 150, 150, 25);
        this.add(frame1PassField);

        frame1LoginButton = new JButton("Login");
        frame1LoginButton.setBackground(Color.GRAY);
        frame1LoginButton.setBounds(10, 190, 90, 25);
        this.add(frame1LoginButton);
        frame1LoginButton.addActionListener(this);

        frame1NextButton = new JButton("Next");
        frame1NextButton.setBackground(Color.GREEN);
        frame1NextButton.setBounds(330, 250, 80, 25);
        this.add(frame1NextButton);
        frame1NextButton.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(450, 450);
        this.setLayout(null);
        this.setVisible(true);
        frame1NextLabel.setVisible(false);
        frame1NextButton.setVisible(false);
    }

    public void actionPerformed(ActionEvent aef1) {

        String username = frame1IdTextField.getText();
        String password = new String(frame1PassField.getPassword());

        if (aef1.getSource() == frame1NextButton) {
            new Frame2();
            this.setVisible(false);
        } else if (aef1.getSource() == frame1LoginButton) {

            if ("mushfiq".equals(username) && "rahman".equals(password)) {
                JOptionPane.showMessageDialog(this, "Login Succesfull");
                frame1NextLabel.setVisible(true);
                frame1NextButton.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Login Unsuccessful,Try Again");
                frame1NextLabel.setVisible(false);
                frame1NextButton.setVisible(false);
            }

        }
    }
}

class Frame2 extends JFrame implements ActionListener {

    JLabel frame2NameLabel;
    JLabel frame2PhoneLabel;
    JLabel frame2EmailLabel;
    JLabel frame2AddressLabel;

    JButton frame2AddButton;
    JButton frame2MoreButton;
    JButton frame2ShowButton;

    JTextField frame2NameTextField;
    JTextField frame2PhoneTextField;
    JTextField frame2EmailTextField;
    JTextField frame2AddressTextField;

    Frame2() {

        frame2NameLabel = new JLabel("Name");
        frame2NameLabel.setBounds(10, 80, 40, 25);
        this.add(frame2NameLabel);

        frame2PhoneLabel = new JLabel("Phone ");
        frame2PhoneLabel.setBounds(10, 130, 40, 25);
        this.add(frame2PhoneLabel);

        frame2EmailLabel = new JLabel("E-Mail ");
        frame2EmailLabel.setBounds(10, 180, 40, 25);
        this.add(frame2EmailLabel);

        frame2AddressLabel = new JLabel("Address");
        frame2AddressLabel.setBounds(10, 230, 60, 25);
        this.add(frame2AddressLabel);

        frame2NameTextField = new JTextField();
        frame2NameTextField.setBounds(10, 100, 200, 25);
        this.add(frame2NameTextField);

        frame2PhoneTextField = new JTextField();
        frame2PhoneTextField.setBounds(10, 150, 200, 25);
        this.add(frame2PhoneTextField);

        frame2EmailTextField = new JTextField();
        frame2EmailTextField.setBounds(10, 200, 200, 25);
        this.add(frame2EmailTextField);

        frame2AddressTextField = new JTextField();
        frame2AddressTextField.setBounds(10, 250, 200, 25);
        this.add(frame2AddressTextField);

        frame2AddButton = new JButton("Add Contact");
        frame2AddButton.setBounds(30, 320, 125, 25);
        this.add(frame2AddButton);
        frame2AddButton.addActionListener(this);

        frame2MoreButton = new JButton("More..");
        frame2MoreButton.setBounds(290, 320, 125, 25);
        this.add(frame2MoreButton);
        frame2MoreButton.addActionListener(this);

        frame2ShowButton = new JButton("Show Table");
        frame2ShowButton.setBounds(160, 370, 125, 25);
        this.add(frame2ShowButton);
        frame2ShowButton.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent aef2) {

        String name = frame2NameTextField.getText();
        String email = frame2EmailTextField.getText();
        String phone = frame2PhoneTextField.getText();
        String address = frame2AddressTextField.getText();

        if (aef2.getSource() == frame2AddButton) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
                Statement stmt = con.createStatement();

                String query = "INSERT INTO person (name,address,phone,email) VALUES ('" + name + "', '" + address + "','" + phone + "','" + email + "')";
                if (stmt.executeUpdate(query) == 1) {
                    JOptionPane.showMessageDialog(this, "Record Added");
                } else {
                    JOptionPane.showMessageDialog(this, "Record Could not be Added");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Some Error Occured");
            }
            new Show();
        } else if (aef2.getSource() == frame2ShowButton) {
            new Show();
        } else {
            new Frame3();
            this.setVisible(false);
        }

    }

}

class Frame3 extends JFrame implements ActionListener {

    JButton frame3DeleteButton;
    JButton frame3UpdateButton;
    JButton frame3SearchButton;
    JButton frame3BackButton;
    JButton frame3FinishButton;
    JButton frame3ListButton;

    JTextField frame3NameTextField;
    JTextField frame3IdTextField;

    JLabel frame3NameLabel;
    JLabel frame3IdLabel;
    JLabel frame3InstructionLabel;
    JTable personTable;

    Frame3() {
        frame3DeleteButton = new JButton("Delete Contact");
        frame3DeleteButton.setBounds(160, 320, 125, 25);
        this.add(frame3DeleteButton);
        frame3DeleteButton.addActionListener(this);

        frame3UpdateButton = new JButton("Update Contact");
        frame3UpdateButton.setBounds(160, 360, 125, 25);
        this.add(frame3UpdateButton);
        frame3UpdateButton.addActionListener(this);

        frame3ListButton = new JButton("Show List");
        frame3ListButton.setBounds(300, 320, 125, 25);
        this.add(frame3ListButton);
        frame3ListButton.addActionListener(this);

        frame3SearchButton = new JButton("Search Contact");
        frame3SearchButton.setBounds(20, 320, 125, 25);
        this.add(frame3SearchButton);
        frame3SearchButton.addActionListener(this);

        frame3BackButton = new JButton("<- Back");
        frame3BackButton.setBounds(20, 360, 125, 25);
        this.add(frame3BackButton);
        frame3BackButton.addActionListener(this);

        frame3FinishButton = new JButton("Finish");
        frame3FinishButton.setBounds(300, 360, 125, 25);
        this.add(frame3FinishButton);
        frame3FinishButton.addActionListener(this);

        frame3IdTextField = new JTextField();
        frame3IdTextField.setBounds(10, 100, 200, 25);
        this.add(frame3IdTextField);

        frame3NameTextField = new JTextField();
        frame3NameTextField.setBounds(10, 150, 200, 25);
        this.add(frame3NameTextField);

        frame3NameLabel = new JLabel("Name");
        frame3NameLabel.setBounds(10, 130, 40, 25);
        this.add(frame3NameLabel);

        frame3IdLabel = new JLabel("ID");
        frame3IdLabel.setBounds(10, 80, 40, 25);
        this.add(frame3IdLabel);

        frame3InstructionLabel = new JLabel("Attention!! Use ID Field only to DELETE contact!");
        frame3InstructionLabel.setFont(new Font("Serif", Font.BOLD, 12));
        frame3InstructionLabel.setBounds(20, 250, 300, 25);
        this.add(frame3InstructionLabel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent aef3) {

        String name2 = frame3NameTextField.getText();
        String id2 = frame3IdTextField.getText();

        if (aef3.getSource() == frame3SearchButton) {

            Vector data = new Vector();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
                Statement stmt = con.createStatement();

                String query = "SELECT id,name,phone,address,email FROM person Where name LIKE '%" + name2 + "%'";
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    //Preparing the row
                    Vector row = new Vector();

                    row.add(rs.getInt("id"));
                    row.add(rs.getString("name"));
                    row.add(rs.getString("phone"));
                    row.add(rs.getString("address"));
                    row.add(rs.getString("email"));

                    //adding row to data
                    data.add(row);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Some Error Occured");
            }

            //Preparing the columns
            Vector columns = new Vector();

            columns.add("ID");
            columns.add("Name");
            columns.add("Phone");
            columns.add("Address");
            columns.add("Email");

            personTable = new JTable(data, columns);
            JScrollPane pnl = new JScrollPane(personTable);

            this.getContentPane().add(pnl);
            this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
            this.setSize(700, 500);
            this.setVisible(true);

        } else if (aef3.getSource() == frame3DeleteButton) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
                Statement stmt = con.createStatement();

                String query = "DELETE FROM person where id = '" + id2 + "' AND name ='" + name2 + "'";
                if (stmt.executeUpdate(query) == 1) {
                    JOptionPane.showMessageDialog(this, "Record Deleted!");
                } else {
                    JOptionPane.showMessageDialog(this, "Record Could not be Deleted");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Some Error Occured");
            }
            new Show();

        } else if (aef3.getSource() == frame3BackButton) {
            new Frame2();
            this.setVisible(false);
        } else if (aef3.getSource() == frame3FinishButton) {
            new Frame1();
            this.setVisible(false);
        } else if (aef3.getSource() == frame3UpdateButton) {

            new Frame4();
        } else {
            new Show();
        }

    }
}

class Frame4 extends JFrame implements ActionListener {

    JLabel frame4IdLabel;
    JLabel frame4NameLabel;
    JLabel frame4PhoneLabel;
    JLabel frame4EmailLabel;
    JLabel frame4AddressLabel;

    JButton frame4UpdateButton;
    JButton frame4DoneButton;

    JTextField frame4IdTextField;
    JTextField frame4NameTextField;
    JTextField frame4PhoneTextField;
    JTextField frame4EmailTextField;
    JTextField frame4AddressTextField;

    Frame4() {
        frame4IdLabel = new JLabel("Target ID ");
        frame4IdLabel.setBounds(10, 250, 60, 25);
        this.add(frame4IdLabel);

        frame4NameLabel = new JLabel("Name");
        frame4NameLabel.setBounds(10, 30, 40, 25);
        this.add(frame4NameLabel);

        frame4PhoneLabel = new JLabel("Phone ");
        frame4PhoneLabel.setBounds(10, 80, 40, 25);
        this.add(frame4PhoneLabel);

        frame4EmailLabel = new JLabel("E-Mail ");
        frame4EmailLabel.setBounds(10, 130, 40, 25);
        this.add(frame4EmailLabel);

        frame4AddressLabel = new JLabel("Address");
        frame4AddressLabel.setBounds(10, 180, 60, 25);
        this.add(frame4AddressLabel);

        frame4IdTextField = new JTextField();
        frame4IdTextField.setBounds(10, 270, 200, 25);
        this.add(frame4IdTextField);

        frame4NameTextField = new JTextField();
        frame4NameTextField.setBounds(10, 50, 200, 25);
        this.add(frame4NameTextField);

        frame4PhoneTextField = new JTextField();
        frame4PhoneTextField.setBounds(10, 100, 200, 25);
        this.add(frame4PhoneTextField);

        frame4EmailTextField = new JTextField();
        frame4EmailTextField.setBounds(10, 150, 200, 25);
        this.add(frame4EmailTextField);

        frame4AddressTextField = new JTextField();
        frame4AddressTextField.setBounds(10, 200, 200, 25);
        this.add(frame4AddressTextField);

        frame4UpdateButton = new JButton("Update");
        frame4UpdateButton.setBounds(140, 320, 125, 25);
        this.add(frame4UpdateButton);
        frame4UpdateButton.addActionListener(this);

        frame4DoneButton = new JButton("Done");
        frame4DoneButton.setBounds(350, 400, 125, 25);
        this.add(frame4DoneButton);
        frame4DoneButton.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent aef4) {
        String id4 = frame4IdTextField.getText();
        String name4 = frame4NameTextField.getText();
        String email4 = frame4EmailTextField.getText();
        String phone4 = frame4PhoneTextField.getText();
        String address4 = frame4AddressTextField.getText();

        if (aef4.getSource() == frame4UpdateButton) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
                Statement stmt = con.createStatement();

                String query = "UPDATE person SET name='" + name4 + "',address='" + address4 + "',phone='" + phone4 + "',email='" + email4 + "' WHERE id = '" + id4 + "'";
                if (stmt.executeUpdate(query) == 1) {
                    JOptionPane.showMessageDialog(this, "Record Updated");
                } else {
                    JOptionPane.showMessageDialog(this, "Record Could not be Updated");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Some Error Occured");
            }
            new Show();
        } else {
            new Frame3();
            this.setVisible(false);
        }
    }
}

class Show extends JFrame {

    JTable personTable;

    public Show() {
        //Preparing the data
        Vector data = new Vector();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "");
            Statement stmt = con.createStatement();

            String query = "SELECT id,name,phone,address,email FROM person";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                //Preparing the row
                Vector row = new Vector();

                row.add(rs.getInt("id"));
                row.add(rs.getString("name"));
                row.add(rs.getString("phone"));
                row.add(rs.getString("address"));
                row.add(rs.getString("email"));

                //adding row to data
                data.add(row);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Some Error Occured");
        }

        //Preparing the columns
        Vector columns = new Vector();

        columns.add("ID");
        columns.add("Name");
        columns.add("Phone");
        columns.add("Address");
        columns.add("Email");

        personTable = new JTable(data, columns);
        JScrollPane pnl = new JScrollPane(personTable);

        this.getContentPane().add(pnl);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(700, 500);
        this.setVisible(true);
    }
}

public class Main {

    public static void main(String[] args) {

        new Frame1();
    }
}
