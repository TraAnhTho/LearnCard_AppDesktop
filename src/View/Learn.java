package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.Card_DAO;
import DAO.List_DAO;
import DAO.User_DAO;
import Model.Card;
import Model.List_Card;
import Model.User;
import design.FButton;

import javax.swing.JTextField;

public class Learn extends JFrame implements ActionListener {
	private Card card;
	private List_Card listcard;
	private User user;
	private Card_DAO cardDAO;
	private List_DAO listDAO;
	private User_DAO userDAO;
	private Login login;
	List<String> random_dapan;
	List<QuestionAnswer> randomSelection;
	static String name;
	private JTextField txt_learn;
	private FButton btn_learn;
	private FButton btn_exit;

	Learn(String name) {
		this.name = name;
		setBounds(100, 100, 1020, 510);
		getContentPane().setLayout(null);

		txt_learn = new JTextField();
		txt_learn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		txt_learn.setForeground(new Color(175, 215, 130));
		txt_learn.setBounds(43, 199, 417, 192);
		getContentPane().add(txt_learn);
		txt_learn.setColumns(10);

		btn_learn = new FButton();
		btn_learn.setFont(new Font("Tahoma", Font.BOLD, 22));
		btn_learn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_learn.setText("Đáp án");
		btn_learn.setBounds(491, 199, 167, 52);
		getContentPane().add(btn_learn);
		setUndecorated(true);
		setVisible(true);

		btn_exit = new FButton();
		btn_exit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_exit.setForeground(new Color(0, 0, 0));
		btn_exit.setText("Exit");
		btn_exit.setBounds(491, 272, 129, 45);
		getContentPane().add(btn_exit);

		JLabel lblNewLabel = new JLabel("LEARN: ");
		lblNewLabel.setForeground(new Color(175, 215, 130));
		lblNewLabel.setBackground(new Color(175, 215, 130));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 99));
		lblNewLabel.setBounds(43, 58, 602, 107);
		getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel(" " + name);
		lblNewLabel_1.setIcon(new ImageIcon(Learn.class.getResource("/IMG/account-50.png")));
		lblNewLabel_1.setBounds(843, 75, 167, 52);
		getContentPane().add(lblNewLabel_1);

		JLabel image = new JLabel("");
		image.setSize(1020, 510);
		image.setVerticalAlignment(SwingConstants.CENTER);
		image.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon i1 = new ImageIcon(Rules.class.getResource("/IMG/Frogsss.jpg"));
		Image i = i1.getImage().getScaledInstance(1020, 520, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i);
		image.setIcon(i2);
		getContentPane().add(image);

	}

	public static void main(String[] args) {
		try {
			new Learn(name);
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

		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet rs = statement
						.executeQuery("SELECT * FROM  flash_card.`Card` Where usercol='" + name + "';")) {

			// Lấy danh sách từ kết quả truy vấn
			while (rs.next()) {
				list.add(new QuestionAnswer(rs.getString("Name"), rs.getString("Dinh_Nghia")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Trộn ngẫu nhiên danh sách
		Collections.shuffle(list);

		// Chọn 10 giá trị đầu tiên từ danh sách đã được trộn
		randomSelection = list.subList(0, Math.min(10, list.size()));
		System.out.println(randomSelection);

		// Hiển thị các giá trị đã chọn
		for (QuestionAnswer qa : randomSelection) {
			System.out.println("Câu hỏi: " + qa.question);
			System.out.println("Đáp án: " + qa.answer);
		}
	}

	private int i = -1;
	private boolean isShowAnswer;
	private QuestionAnswer value;
	private JLabel lblNewLabel_1;

	@Override
	public void actionPerformed(ActionEvent ei) {
		if(ei.getSource() == btn_learn) {
			if (isShowAnswer) {
				btn_learn.setText("Câu Hỏi");
				txt_learn.setText(value.getAnswer());
				isShowAnswer = false;
			} else {
				showNextCard();
//			if() {
//				showNextCard();
//			}
			}
		} else if(ei.getSource() == btn_exit) {
			dispose();
		}

	}

	private void showNextCard() {
//		i++;
//		value = randomSelection.get(i++);
		btn_learn.setText("Đáp án");
		txt_learn.setText(value.getQuestion());
		isShowAnswer = true;

	}
}