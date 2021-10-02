package diceRoll;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Dice {

	private JFrame frame;
	Random random = new Random();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dice window = new Dice();
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
	public Dice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.BLACK);
		JLabel lblNewLabel = new JLabel();
		
		JLabel label = new JLabel("");
		label.setBounds(34, 59, 139, 116);
		ImageIcon img=new ImageIcon(new ImageIcon(getClass().getResource("/diceRoll/images/1.png")).getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH));
		label.setIcon(img);
		
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(261, 59, 139, 116);
		ImageIcon img_1=new ImageIcon(new ImageIcon(getClass().getResource("/diceRoll/images/1.png")).getImage().getScaledInstance(label_1.getWidth(),label_1.getHeight(),Image.SCALE_SMOOTH));
		label_1.setIcon(img_1);
		frame.getContentPane().add(label_1);
		JButton btnRoll = new JButton("Roll");
		btnRoll.setBackground(Color.BLACK);
		btnRoll.setForeground(Color.white);
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n="1",n_1="1";
				n=String.valueOf(random.nextInt(6)+1);
				n_1=String.valueOf(random.nextInt(6)+1);
				ImageIcon img=new ImageIcon(new ImageIcon(getClass().getResource("/diceRoll/images/"+n+".png")).getImage().getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_SMOOTH));
				label.setIcon(img);
				ImageIcon img_1=new ImageIcon(new ImageIcon(getClass().getResource("/diceRoll/images/"+n_1+".png")).getImage().getScaledInstance(label_1.getWidth(),label_1.getHeight(),Image.SCALE_SMOOTH));
				label_1.setIcon(img_1);
			}
		});
		btnRoll.setBounds(159, 206, 117, 25);
		frame.getContentPane().add(btnRoll);
		
		
		
		JLabel lblPressRollButton = new JLabel("Press Roll Button To Roll the Dice");
		lblPressRollButton.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPressRollButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblPressRollButton.setBounds(12, 12, 426, 35);
		lblPressRollButton.setForeground(Color.white);
		frame.getContentPane().add(lblPressRollButton);
		
		
	}
}
