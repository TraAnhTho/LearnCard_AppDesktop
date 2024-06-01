package View;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

	JButton start, back;
	static String name;

	Rules(String name) {

		this.name = name;

		JLabel heading = new JLabel("Welcome" + name + "to QUIZ TEST");
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setBounds(143, 86, 700, 30);
		heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
		heading.setForeground(new Color(22, 99, 54));
		getContentPane().add(heading);

		JLabel rules = new JLabel();
		rules.setBounds(237, 127, 624, 271);
		rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rules.setForeground(new Color(22, 99, 54));
		rules.setText("<html>" + "1. Participation in the quiz is free and open to all persons."
				+ "<br><br>" + "2. There are a total 10 questions. " + "<br><br>"
				+ "3. You only have 15 seconds to answer the question." + "<br><br>"
				+ "4. No cell phones or other secondary devices in the room or test area." + "<br><br>"
				+ "5. No talking." + "<br><br>" + "6. No one else can be in the room with you." + "<br><br>"
				+ "<html>");
		getContentPane().add(rules);

		back = new JButton("Back");
		back.setBounds(260, 409, 100, 30);
		back.setBackground(new Color(22, 99, 54));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		getContentPane().add(back);

		start = new JButton("Start");
		start.setBounds(431, 409, 100, 30);
		start.setBackground(new Color(22, 99, 54));
		start.setForeground(Color.WHITE);
		start.addActionListener(this);
		getContentPane().add(start);

		JLabel image = new JLabel("");
		image.setSize(1020, 510);
		image.setVerticalAlignment(SwingConstants.CENTER);
		image.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon i1 = new ImageIcon(Rules.class.getResource("/IMG/Frogsss.jpg"));
		Image i = i1.getImage().getScaledInstance(1020, 520, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i);
		image.setIcon(i2);
		getContentPane().add(image);

		setBounds(100, 100, 1020, 510);
		getContentPane().setLayout(null);
		setUndecorated(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			setVisible(false);
			new Quiz(name);
		} else {
			try {
				setVisible(false);
				new Home_Login(name);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Rules(name);
	}
}
