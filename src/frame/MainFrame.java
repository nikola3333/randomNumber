package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.RandomizeNumbers;

public class MainFrame extends JFrame{

	private static MainFrame instance = null;
	private RandomizeNumbers rn = new RandomizeNumbers();
	String string1,string2,string3 = "";
	
	public MainFrame() {
		// TODO Auto-generated constructor stub
	}
	
	public static MainFrame getInstance(){
		if(instance == null){
			instance = new MainFrame();
			instance.initialise();
		}
		return instance;
	}

	public void initialise(){
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(screenWidth / 4 *3 , screenHeight / 4 * 3);
		setTitle("Zadatak za finalne Java Developer kandidate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //zatvarenja prozora totalno
		setLocationRelativeTo(null);	//centriranje prozora
		setVisible(true);
		
		JPanel panel1 = new JPanel(new GridLayout(4,1));
		panel1.setBackground(Color.WHITE);
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel1,panel2);
		split.setBackground(Color.WHITE);
		split.setDividerLocation(screenWidth/10);
		
		JLabel label1 = new JLabel();
		label1.setText("Unesite broj cifara:");
		
		JTextField text1 = new JTextField(10);
		
		JLabel label2 = new JLabel();
		label2.setText("Unesite minimalnu cifru:");
		
		JTextField text2 = new JTextField(3);
		
		JLabel label3 = new JLabel();
		label3.setText("Unesite maksimalnu cifru:");
		
		JTextField text3 = new JTextField(3);
		
		JButton button = new JButton("Randomize");
		button.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {				  
			string1 = text1.getText();
			string2 = text2.getText();
			string3 = text3 .getText();
				 
				try {
					rn.doRandomize(string1,string2,string3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
				  
			  }
			});
		
		text1.setHorizontalAlignment(SwingConstants.RIGHT);
		text2.setHorizontalAlignment(SwingConstants.RIGHT);
		text3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel p1 = new JPanel(new FlowLayout(20));
		p1.add(label1);
		p1.add(text1);

		JPanel p2 = new JPanel(new FlowLayout(20));
		p2.add(label2);
		p2.add(text2);

		JPanel p3 = new JPanel(new FlowLayout(20));
		p3.add(label3);
		p3.add(text3);

		JPanel p4 = new JPanel(new FlowLayout(20));
		p4.add(button);

		panel1.add(p1);
		panel1.add(p2);
		panel1.add(p3);
		panel1.add(p4);
		
		add(split);
		
		validate();
		
	}

}
