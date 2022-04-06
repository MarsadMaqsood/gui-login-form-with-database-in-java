import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.logging.*;
import java.sql.*;

public class LoginForm extends JFrame {

    private JButton btnLogin;
    private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6;
    private JPanel panel1;
    private JPasswordField txtPwd;
    private JTextField txtUsername, txtEmail, txtDate, txtGender;

    public LoginForm() {
        initComponents();

        setTitle("Form");

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (txtUsername.getText().isEmpty() || txtUsername.getText().matches(".*\\d.*")) {
                    JOptionPane.showMessageDialog(LoginForm.this, "Invalid username");

                }

                else if (!txtEmail.getText().contains("@")) {
                    JOptionPane.showMessageDialog(LoginForm.this, "Invalid email");
                }

                else if (txtPwd.getPassword().length < 8 || txtPwd.getPassword().length > 32) {
                    JOptionPane.showMessageDialog(LoginForm.this, "Invalid Password");
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this, "Success");
                    try {
                        pushDataToDatabase();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

    }

    void pushDataToDatabase() throws SQLException {

        
        final String server = "localhost/";
        final String db_name = "users";
        final String user = "root";
        final String pass = "";

        Connection con = DriverManager.getConnection("jdbc:mysql://" + server + db_name, user, pass);

        String username = txtUsername.getText();
        String email = txtUsername.getText();
        String gender = txtGender.getText();
        String dob = txtDate.getText();
        String password = txtPwd.getPassword().toString();

        String query = "INSERT INTO users (username, email, gender, dob, password) VALUES (" +
                username + "," + email + "," + gender + "," + dob + "," + password + ")";

        Statement stmt = con.createStatement();
        int id = stmt.executeUpdate(query);

        System.out.println(id);

        con.close(); // close the connection
    }

    /// Function to initialize
    private void initComponents() {

        panel1 = new JPanel();

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();

        btnLogin = new JButton();
        txtUsername = new JTextField();
        txtEmail = new JTextField();
        txtGender = new JTextField();
        txtDate = new JTextField();
        txtPwd = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout jPanel1Layout = new GroupLayout(panel1);

        createPannel(jPanel1Layout, panel1);

        jLabel2.setText("Username");
        jLabel3.setText("Email");
        jLabel4.setText("Gender");
        jLabel5.setText("Date of Birth");
        jLabel6.setText("Password");

        btnLogin.setText("login");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(GroupLayout.Alignment.LEADING, layout
                                                .createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addGroup(layout
                                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6))

                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtUsername)
                                                        .addComponent(txtEmail)
                                                        .addComponent(txtGender)
                                                        .addComponent(txtDate)
                                                        .addComponent(txtPwd)))

                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 76,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addGap(54, 54, 54)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtUsername, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtGender, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtDate, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(txtPwd, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))

                                .addGap(18, 18, 18)
                                .addComponent(btnLogin)
                                .addContainerGap(66, Short.MAX_VALUE)));

        pack();
    }

    void createPannel(GroupLayout pannelLayout, JPanel pannel) {

        jLabel1.setText("Form");

        pannel.setLayout(pannelLayout);

        pannelLayout.setHorizontalGroup(
                pannelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pannelLayout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(180, 180, 180)));
        pannelLayout.setVerticalGroup(
                pannelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pannelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(34, 34, 34)));
    }

    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        // create and display form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

}