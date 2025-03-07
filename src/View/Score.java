package View;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarFile;

public class Score extends JFrame {
	static String name;

	Score(String name, int score) {
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/score.png"));
		Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(28, 175, 315, 272);
		getContentPane().add(image);

		JLabel heading = new JLabel("Thankyou " + name + " for Playing QUIZ Test ");
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBounds(152, 134, 700, 30);
		heading.setFont(new Font("Tahoma", Font.BOLD, 26));
		getContentPane().add(heading);

		JLabel Score = new JLabel("Your Score is " + score);
		Score.setHorizontalAlignment(SwingConstants.CENTER);
		Score.setBounds(352, 192, 300, 30);
		Score.setFont(new Font("Tahoma", Font.BOLD, 30));
		getContentPane().add(Score);

		JButton exit = new JButton("EXIT");
		exit.setBounds(448, 252, 120, 30);
		exit.setBackground(new Color(22, 99, 54));
		exit.setForeground(Color.WHITE);
		getContentPane().add(exit);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					new Home_Login(name);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("img/Frogsss.jpg"));
		Image i22 = i11.getImage().getScaledInstance(1020, 510, Image.SCALE_DEFAULT);
		ImageIcon i33 = new ImageIcon(i22);
		JLabel imagee = new JLabel(i33);
		imagee.setHorizontalAlignment(SwingConstants.CENTER);
		imagee.setBounds(0, 0, 1020, 510);
		getContentPane().add(imagee);

		this.setBounds(100, 100, 1020, 510);
		getContentPane().setLayout(null);
		setUndecorated(true);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Score(name, 0);
	}
}
