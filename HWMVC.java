import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HWMVC  {

	private JFrame frame;
	private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	
public long getFirst() {
	try{return Long.parseLong(textField.getText());
	}
	catch(Exception e) {
		JOptionPane.showMessageDialog(null, "Please enter a numeric value only.");
		return 0;	
	}
	
	}
public long getSecond() {
	try{return Long.parseLong(textField_1.getText());
	}
	catch(Exception e) {
		JOptionPane.showMessageDialog(null, "Please enter a numeric value only.");
		return 0;	
	}
}
public void setResult(Long Result) {
	textField_2.setText(Long.toString(Result));
}
public void setResult1(Double result) {
	textField_2.setText(Double.toString(result));
}
JButton btnNewButton_1;
JButton btnNewButton ;
JButton btnNewButton_2 ;
JButton btnNewButton_3 ;
JButton btnNewButton_4 ;
JButton btnNewButton_5 ;
private JLabel lblNewLabel;
	/**
	 * Create the application.
	 */
	public HWMVC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("vrygud Calculator Design | MVC");
		frame.setBounds(100, 100, 497, 251);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(22, 31, 127, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		 btnNewButton_1 = new JButton("%");
	
		btnNewButton_1.setBounds(45, 104, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		 btnNewButton = new JButton("-");
	
		btnNewButton.setBounds(190, 70, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		 btnNewButton_2 = new JButton("*");
		
		btnNewButton_2.setBounds(190, 104, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		 btnNewButton_3 = new JButton("/");
		
		btnNewButton_3.setBounds(45, 141, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		 btnNewButton_4 = new JButton("+");
		
		btnNewButton_4.setBounds(45, 70, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Sqrrt");
		btnNewButton_5.setBounds(190, 143, 89, 21);
		frame.getContentPane().add(btnNewButton_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 31, 127, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(334, 31, 127, 28);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFirstNumber = new JLabel("First Number");
		lblFirstNumber.setBounds(24, 6, 80, 14);
		frame.getContentPane().add(lblFirstNumber);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setBounds(334, 5, 46, 14);
		frame.getContentPane().add(lblResult);
		
		JLabel lblSecondNumber = new JLabel("Second Number");
		lblSecondNumber.setBounds(170, 6, 109, 14);
		frame.getContentPane().add(lblSecondNumber);
		
		lblNewLabel = new JLabel("* Leave Second Number blank for Sqrrt operation.");
		lblNewLabel.setBounds(22, 176, 287, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("=");
		label.setBounds(312, 37, 55, 16);
		frame.getContentPane().add(label);
		
		
	}
	public void addListeners1(ActionListener listen) {
		btnNewButton.addActionListener(listen);
		
		}
	public void addListeners2(ActionListener listen) {
		btnNewButton_1.addActionListener(listen);
		
		}
	public void addListeners3(ActionListener listen) {
		btnNewButton_2.addActionListener(listen);
		
		}
	public void addListeners4(ActionListener listen) {
		btnNewButton_3.addActionListener(listen);
		
		}
	public void addListeners5(ActionListener listen) {
		btnNewButton_4.addActionListener(listen);
		
		}
	public void addListeners6(ActionListener listen) {
		btnNewButton_5.addActionListener(listen);
		
		}
	public void show() {
		frame.setVisible(true);
	}
}
