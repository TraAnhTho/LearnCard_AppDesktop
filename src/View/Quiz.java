package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.Card_DAO;
import DAO.List_DAO;
import DAO.User_DAO;
import Model.Card;
import Model.List_Card;
import Model.User;
import design.FButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz extends JFrame implements ActionListener {

	String questions[][] = new String[10][5];
	String answers[][] = new String[10][2];
	String useranswers[][] = new String[10][1];
	JLabel qno, question;
	JRadioButton opt1, opt2, opt3, opt4;
	ButtonGroup groupoptions;
	FButton next, submit, lifeline;

	private Card card;
	private List_Card listcard;
	private User user;
	private Card_DAO cardDAO;
	private List_DAO listDAO;
	private User_DAO userDAO;
	private Login login;
	List<String> random_dapan;
	List<QuestionAnswer> randomSelection;
	public static int timer = 15;
	public static int ans_given = 0;
	public static int count = 0;
	public static int score = 0;

	static String name;

	Quiz(String name) {
		this.name = name;
		setBounds(100, 100, 1020, 510);
		getContentPane().setBackground(Color.WHITE);
		setUndecorated(true);
		getContentPane().setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/qizz.png"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 1020, 202);
		getContentPane().add(image);

		qno = new JLabel();
		qno.setHorizontalAlignment(SwingConstants.CENTER);
		qno.setBounds(66, 213, 69, 50);
		qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
		getContentPane().add(qno);

		question = new JLabel();
		question.setBounds(145, 213, 786, 50);
		question.setFont(new Font("Tahoma", Font.PLAIN, 24));
		getContentPane().add(question);

		System.out.println("123");
		LoadDBDataJTable();
		System.out.println("123");

		System.out.println(randomSelection.size());
		if (randomSelection == null || randomSelection.isEmpty()) {
			System.out.println("Data not loaded");
			return;
		}

		QuestionAnswer value = randomSelection.get(1);
		System.out.println(value);
		questions[0][0] = value.getQuestion();
		questions[0][1] = random_dapan.get(1);
		questions[0][2] = random_dapan.get(2);
		questions[0][3] = value.getAnswer();
		questions[0][4] = random_dapan.get(3);
		answers[0][1] = value.getAnswer();

		value = randomSelection.get(2);
		questions[1][0] = value.getQuestion();
		questions[1][1] = value.getAnswer();
		questions[1][2] = random_dapan.get(4);
		questions[1][3] = random_dapan.get(5);
		questions[1][4] = random_dapan.get(6);
		answers[1][1] = value.getAnswer();

		value = randomSelection.get(3);
		questions[2][0] = value.getQuestion();
		questions[2][1] = random_dapan.get(7);
		questions[2][2] = value.getAnswer();
		questions[2][3] = random_dapan.get(8);
		questions[2][4] = random_dapan.get(9);
		answers[2][1] = value.getAnswer();

		value = randomSelection.get(4);
		questions[3][0] = value.getQuestion();
		questions[3][1] = value.getAnswer();
		questions[3][2] = random_dapan.get(10);
		questions[3][3] = random_dapan.get(11);
		questions[3][4] = random_dapan.get(12);
		answers[3][1] = value.getAnswer();

		value = randomSelection.get(5);
		questions[4][0] = value.getQuestion();
		questions[4][1] = random_dapan.get(13);
		questions[4][2] = value.getAnswer();
		questions[4][3] = random_dapan.get(14);
		questions[4][4] = random_dapan.get(15);
		answers[4][1] = value.getAnswer();

		value = randomSelection.get(6);
		questions[5][0] = value.getQuestion();
		questions[5][1] = value.getAnswer();
		questions[5][2] = random_dapan.get(1);
		questions[5][3] = random_dapan.get(3);
		questions[5][4] = random_dapan.get(5);
		answers[5][1] = value.getAnswer();

		value = randomSelection.get(6);
		questions[6][0] = value.getQuestion();
		questions[6][1] = random_dapan.get(7);
		questions[6][2] = random_dapan.get(9);
		questions[6][3] = value.getAnswer();
		questions[6][4] = random_dapan.get(11);
		answers[6][1] = value.getAnswer();

		value = randomSelection.get(7);
		questions[7][0] = value.getQuestion();
		questions[7][1] = random_dapan.get(13);
		questions[7][2] = random_dapan.get(15);
		questions[7][3] = value.getAnswer();
		questions[7][4] = random_dapan.get(2);
		answers[7][1] = value.getAnswer();

		value = randomSelection.get(8);
		questions[8][0] = value.getQuestion();
		questions[8][1] = value.getAnswer();
		questions[8][2] = random_dapan.get(4);
		questions[8][3] = random_dapan.get(6);
		questions[8][4] = random_dapan.get(8);
		answers[8][1] = value.getAnswer();

		value = randomSelection.get(9);
		questions[9][0] = value.getQuestion();
		questions[9][1] = random_dapan.get(10);
		questions[9][2] = random_dapan.get(12);
		questions[9][3] = random_dapan.get(14);
		questions[9][4] = value.getAnswer();
		answers[9][1] = value.getAnswer();

		opt1 = new JRadioButton();
		opt1.setBounds(101, 276, 700, 30);
		opt1.setBackground(Color.WHITE);
		opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
		getContentPane().add(opt1);

		opt2 = new JRadioButton();
		opt2.setBounds(101, 321, 700, 30);
		opt2.setBackground(Color.WHITE);
		opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
		getContentPane().add(opt2);

		opt3 = new JRadioButton();
		opt3.setBounds(101, 367, 700, 30);
		opt3.setBackground(Color.WHITE);
		opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
		getContentPane().add(opt3);

		opt4 = new JRadioButton();
		opt4.setBounds(101, 411, 700, 30);
		opt4.setBackground(Color.WHITE);
		opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
		getContentPane().add(opt4);

		groupoptions = new ButtonGroup();
		groupoptions.add(opt1);
		groupoptions.add(opt2);
		groupoptions.add(opt3);
		groupoptions.add(opt4);

		next = new FButton();
		next.setText("Next");
		next.setBounds(392, 439, 200, 60);
		next.setFont(new Font("Tahoma", Font.PLAIN, 18));
		next.setBackground(new Color(22, 99, 54));
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		getContentPane().add(next);

		lifeline = new FButton();
		lifeline.setText("Exit");
		lifeline.setBounds(602, 439, 200, 60);
		lifeline.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lifeline.setBackground(new Color(22, 99, 54));
		lifeline.setForeground(Color.WHITE);
		lifeline.addActionListener(this);
		getContentPane().add(lifeline);

		submit = new FButton();
		submit.setText("Submit");
		submit.setBounds(812, 439, 200, 60);
		submit.setForeground(Color.BLACK);
		submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		submit.setBackground(new Color(255, 215, 0));

		submit.addActionListener(this);
		submit.setEnabled(false);
		getContentPane().add(submit);

		start(count);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == next) {
			repaint();
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);

			ans_given = 1;
			if (groupoptions.getSelection() == null) {
				useranswers[count][0] = "";
			} else {
				useranswers[count][0] = groupoptions.getSelection().getActionCommand();
			}

			if (count == 8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}

			count++;
			start(count);
		} else if (ae.getSource() == lifeline) {
			try {
				setVisible(false);
				new Home_Login(name);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (ae.getSource() == submit) {
			ans_given = 1;
			if (groupoptions.getSelection() == null) {
				useranswers[count][0] = "";
			} else {
				useranswers[count][0] = groupoptions.getSelection().getActionCommand();
			}

			for (int i = 0; i < useranswers.length; i++) {
				if (useranswers[i][0].equals(answers[i][1])) {
					score += 10;
				} else {
					score += 0;
				}
			}
			setVisible(false);
			new Score(name, score);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);

		String time = "Time left - " + timer + " seconds"; // 15
		g.setColor(Color.RED);
		g.setFont(new Font("Tahoma", Font.BOLD, 25));

		if (timer > 0) {
			g.drawString(time, 1100, 500);
		} else {
			g.drawString("Times up!!", 1100, 500);
		}

		timer--; // 14

		try {
			Thread.sleep(1000);
			repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ans_given == 1) {
			ans_given = 0;
			timer = 15;
		} else if (timer < 0) {
			timer = 15;
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);

			if (count == 8) {
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			if (count == 9) { // submit button
				if (groupoptions.getSelection() == null) {
					useranswers[count][0] = "";
				} else {
					useranswers[count][0] = groupoptions.getSelection().getActionCommand();
				}

				for (int i = 0; i < useranswers.length; i++) {
					if (useranswers[i][0].equals(answers[i][1])) {
						score += 10;
					} else {
						score += 0;
					}
				}
				setVisible(false);
				new Score(name, score);
			} else { // next button
				if (groupoptions.getSelection() == null) {
					useranswers[count][0] = "";
				} else {
					useranswers[count][0] = groupoptions.getSelection().getActionCommand();
				}
				count++; // 0 // 1
				start(count);
			}
		}

	}

	public void start(int count) {
		qno.setText("" + (count + 1) + ". ");
		question.setText(questions[count][0]);
		opt1.setText(questions[count][1]);
		opt1.setActionCommand(questions[count][1]);

		opt2.setText(questions[count][2]);
		opt2.setActionCommand(questions[count][2]);

		opt3.setText(questions[count][3]);
		opt3.setActionCommand(questions[count][3]);

		opt4.setText(questions[count][4]);
		opt4.setActionCommand(questions[count][4]);

		groupoptions.clearSelection();
	}

	public static void main(String[] args) {
		try {
			new Quiz(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void LoadDBDataJTable() {

		String jdbcUrl = "jdbc:mysql://localhost:3306/flash_card";
		String username = "TraAnhTho";
		String password = "081105";

		List<QuestionAnswer> list = new ArrayList<>();
		List<String> list_cauhoi = new ArrayList<>();
		List<String> list_dapan = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM  flash_card.`Card`")) {

			// Lấy danh sách từ kết quả truy vấn
			while (rs.next()) {
				list.add(new QuestionAnswer(rs.getString("Name"), rs.getString("Dinh_Nghia")));
				list_dapan.add(rs.getString("Dinh_Nghia"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Trộn ngẫu nhiên danh sách
		Collections.shuffle(list);
		Collections.shuffle(list_dapan);

		// Chọn 10 giá trị đầu tiên từ danh sách đã được trộn
		randomSelection = list.subList(0, Math.min(10, list.size()));
		random_dapan = list_dapan.subList(0, Math.min(16, list_dapan.size()));
		System.out.println(randomSelection);
		System.out.println(random_dapan);

		// Hiển thị các giá trị đã chọn
		for (int i = 0; i < random_dapan.size(); i++) {
			String dapan = random_dapan.get(i);
			System.out.println(dapan);
		}
		for (QuestionAnswer qa : randomSelection) {
			System.out.println("Câu hỏi: " + qa.question);
			System.out.println("Đáp án: " + qa.answer);
		}
	}
}
