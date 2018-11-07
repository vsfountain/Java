package reorder;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

public class LoginPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{101, 121, 121, 0};
		gridBagLayout.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnCustomerLogin = new JButton("Customer Login");
		btnCustomerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerPanel cp = new CustomerPanel();
				ApplicationGUI.changeTo(cp);
				cp.setVisible(true);
			}
		});
		
		JLabel lblBankingApplicatino = new JLabel("Banking Application");
		GridBagConstraints gbc_lblBankingApplicatino = new GridBagConstraints();
		gbc_lblBankingApplicatino.insets = new Insets(0, 0, 5, 5);
		gbc_lblBankingApplicatino.gridx = 1;
		gbc_lblBankingApplicatino.gridy = 1;
		add(lblBankingApplicatino, gbc_lblBankingApplicatino);
		GridBagConstraints gbc_btnCustomerLogin = new GridBagConstraints();
		gbc_btnCustomerLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCustomerLogin.anchor = GridBagConstraints.NORTH;
		gbc_btnCustomerLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnCustomerLogin.gridx = 1;
		gbc_btnCustomerLogin.gridy = 3;
		add(btnCustomerLogin, gbc_btnCustomerLogin);
		
		JButton btnEmployeeLogin = new JButton("Employee Login");
		btnEmployeeLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeePanel ep = new EmployeePanel();
				ApplicationGUI.changeTo(ep);
				ep.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnEmployeeLogin = new GridBagConstraints();
		gbc_btnEmployeeLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEmployeeLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnEmployeeLogin.anchor = GridBagConstraints.NORTH;
		gbc_btnEmployeeLogin.gridx = 1;
		gbc_btnEmployeeLogin.gridy = 4;
		add(btnEmployeeLogin, gbc_btnEmployeeLogin);

	}

}
