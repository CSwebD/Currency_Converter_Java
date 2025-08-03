package eCurrency_3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingConstants;



public class Currency_3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField jtxtAmount;
	private JTextField jtxtAmountConverted;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Currency_3 frame = new Currency_3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Currency_3() {
		getContentPane().setBackground(new Color(240, 228, 217));
		setBackground(new Color(240, 228, 217));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 186, 158));
		panel.setBorder(new LineBorder(new Color(189, 138, 91), 8));
		panel.setBounds(22, 25, 825, 106);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Currency Converter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(34, 25, 746, 56);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 186, 158));
		panel_1.setBounds(22, 184, 825, 214);
		getContentPane().add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(189, 138, 91), 8));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Amount");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(33, 26, 207, 31);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("From Currency");
		lblNewLabel_1_1.setForeground(new Color(108, 108, 108));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(33, 68, 207, 31);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("To Currency");
		lblNewLabel_1_2.setForeground(new Color(108, 108, 108));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(33, 108, 207, 31);
		panel_1.add(lblNewLabel_1_2);
		
		jtxtAmount = new JTextField();
		jtxtAmount.setFont(new Font("Tahoma", Font.PLAIN, 30));
		jtxtAmount.setBounds(356, 22, 430, 34);
		panel_1.add(jtxtAmount);
		jtxtAmount.setColumns(10);
		
		JComboBox jcmbFromCurrency = new JComboBox();
		jcmbFromCurrency.setFont(new Font("Tahoma", Font.PLAIN, 25));
		jcmbFromCurrency.setModel(new DefaultComboBoxModel(new String[] {"GBP - Britain", "CAD - Canadian", "USD - United States Dollar", "NGN - Nigerian Naria", "MXN - Mexican Peso", "EUR - Euro", "CHF - Swiss Franc", "AUD - Australian", "CNY - Chinese Yuan", "INR - Indian Rupee"}));
		jcmbFromCurrency.setBounds(356, 68, 430, 31);
		panel_1.add(jcmbFromCurrency);
		
		JComboBox jcmbToCurrency = new JComboBox();
		jcmbToCurrency.setModel(new DefaultComboBoxModel(new String[] {"GBP - Britain", "CAD - Canadian", "USD - United States Dollar", "NGN - Nigerian Naria", "MXN - Mexican Peso", "EUR - Euro", "CHF - Swiss Franc", "AUD - Australian", "CNY - Chinese Yuan", "INR - Indian Rupee"}));
		jcmbToCurrency.setFont(new Font("Tahoma", Font.PLAIN, 25));
		jcmbToCurrency.setBounds(356, 108, 430, 31);
		panel_1.add(jcmbToCurrency);
		
		JLabel lblNewLabel_1_3 = new JLabel("Converted Amount:");
		lblNewLabel_1_3.setBounds(33, 150, 325, 31);
		panel_1.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		jtxtAmountConverted = new JTextField();
		jtxtAmountConverted.setBounds(356, 150, 430, 34);
		panel_1.add(jtxtAmountConverted);
		jtxtAmountConverted.setFont(new Font("Tahoma", Font.PLAIN, 30));
		jtxtAmountConverted.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(216, 186, 158));
		panel_3.setBorder(new LineBorder(new Color(189, 138, 91), 8));
		panel_3.setBounds(22, 457, 825, 106);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnConverter = new JButton("Convert");
		btnConverter.setBackground(new Color(189, 138, 91));
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				double amount, convertAmount;
				String fromCurrency, toCurrency;
				
				try {
					amount = Double.parseDouble(jtxtAmount.getText());
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number", "Exclamation", JOptionPane.ERROR_MESSAGE);
					jtxtAmount.setText("");
					jtxtAmount.requestFocus();
					return;
				}
				
				fromCurrency = jcmbFromCurrency.getSelectedItem().toString().substring(0, 3);
				toCurrency = jcmbToCurrency.getSelectedItem().toString().substring(0, 3);
				
				convertAmount = convertCurrency(amount, fromCurrency, toCurrency);
				
				jtxtAmountConverted.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, convertAmount, toCurrency));
			}
		});
		btnConverter.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnConverter.setBounds(32, 35, 191, 40);
		panel_3.add(btnConverter);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(189, 138, 91));
		btnExit.addActionListener(new ActionListener() {
			private JFrame frame;
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Currency Converter", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit.setBounds(592, 35, 191, 40);
		panel_3.add(btnExit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(189, 138, 91));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtxtAmount.setText("");
				jtxtAmountConverted.setText("");
				jcmbFromCurrency.setSelectedIndex(-1);
				jcmbToCurrency.setSelectedIndex(-1);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnReset.setBounds(314, 35, 191, 40);
		panel_3.add(btnReset);
		
		setTitle("Currency Converter");
		setSize(880, 620);

	}
	
	public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
		Map<String, Double> conversionRate = new HashMap<>();
		
		conversionRate.put("GBP", 1.0);
		conversionRate.put("USD", 1.34);
		conversionRate.put("NGN", 2040.0);
		conversionRate.put("MXN", 25.0);
		conversionRate.put("EUR", 1.15);
		conversionRate.put("CHF", 1.08);
		conversionRate.put("AUD", 2.08);
		conversionRate.put("CNY", 9.72);
		conversionRate.put("INR", 8.0);
		
		if (!conversionRate.containsKey(fromCurrency)|| !conversionRate.containsKey(toCurrency)) {
			throw new IllegalArgumentException("Invalid currency code.");
		}
		return amount * conversionRate.get(toCurrency)/conversionRate.get(fromCurrency);
	}
}
