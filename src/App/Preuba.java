package App;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Preuba {

	private JFrame frame;
	private JPanel pOriginal, pCopia;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Preuba window = new Preuba();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Preuba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		pOriginal = new JPanel();
		frame.getContentPane().add(pOriginal);
		
		textField = new JTextField();
		pOriginal.add(textField);
		textField.setColumns(10);
		
		pCopia = new JPanel();
		frame.getContentPane().add(pCopia);
		
		textField_1 = new JTextField();
		pCopia.add(textField_1);
		textField_1.setColumns(10);
		setPanelEnabled(pCopia, false);
	}
	
	void setPanelEnabled(JPanel panel, boolean isEnabled) {
		panel.setEnabled(isEnabled);
		Component[] components = panel.getComponents();
		
		for (Component component : components) {
			if (component instanceof JPanel) setPanelEnabled((JPanel) component, isEnabled);
			component.setEnabled(isEnabled);
		}
		
	}

}
