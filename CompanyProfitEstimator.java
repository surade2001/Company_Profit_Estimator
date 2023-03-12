package Edubright;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.swing.*;

public class CompanyProfitEstimator {
    private JTextField nameField;
    private JTextField revenueField;
    private JTextField expensesField;
    private JLabel resultLabel;
    //private CompanyDAO companyDAO;

    public CompanyProfitEstimator() {
        // Connect to the MySQL database
    	System.out.println("Connect to the MySQL database");

        String url = "jdbc:mysql://localhost:3306/myhiber";
        String user = "root";
        String password = "dinga";
        try {
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

        // Create the user interface
        JFrame frame = new JFrame("Company Profit Estimator");
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        panel.add(new JLabel("Company Name:"), c);

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 20));
        c.gridx = 1;
        c.gridy = 0;
        panel.add(nameField, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(new JLabel("Revenue:"), c);

        revenueField = new JTextField();
        revenueField.setPreferredSize(new Dimension(200, 20));
        c.gridx = 1;
        c.gridy = 1;
        panel.add(revenueField, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(new JLabel("Expenses:"), c);

        expensesField = new JTextField();
        expensesField.setPreferredSize(new Dimension(200, 20));
        c.gridx = 1;
        c.gridy = 2;
        panel.add(expensesField, c);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double revenue = Double.parseDouble(revenueField.getText());
                    double expenses = Double.parseDouble(expensesField.getText());
                    //Company company = new Company(0, name, revenue, expenses);
                    //companyDAO.addCompany(company);

                    // Calculate the estimated profit
                    double profit = revenue - expenses;

                    // Display the result
                    resultLabel.setText(String.format("Estimated Profit: $%,.2f", profit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        panel.add(calculateButton, c);

        resultLabel = new JLabel(" ");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        panel.add(resultLabel, c);

        frame.setContentPane(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CompanyProfitEstimator();
            }
        });
    }
}
