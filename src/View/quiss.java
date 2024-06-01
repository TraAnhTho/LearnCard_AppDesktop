package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;

import design.FButton;

public class quiss extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    FButton next, submit, lifeline;

    List<String> random_dapan;
    List<QuestionAnswer> randomSelection;
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    static String name ="admin";

    quiss(String name) {
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
        question.setForeground(new Color(175, 215, 130));
        question.setBounds(145, 213, 786, 50);
        question.setFont(new Font("Tahoma", Font.BOLD, 20));
        getContentPane().add(question);

        LoadDBDataJTable();

        System.out.println(randomSelection.size());
        if (randomSelection == null || randomSelection.isEmpty()) {
            System.out.println("Data not loaded");
            return;
        }

        for (int i = 0; i < randomSelection.size(); i++) {
            QuestionAnswer value = randomSelection.get(i);
            questions[i][0] = value.getQuestion();
            questions[i][1] = random_dapan.get(i * 4);
            questions[i][2] = random_dapan.get(i * 4 + 1);
            questions[i][3] = value.getAnswer();
            questions[i][4] = random_dapan.get(i * 4 + 2);
            answers[i][1] = value.getAnswer();
        }

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

        String time = "Time left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (timer > 0) {
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }

        timer--;

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
            if (count == 9) {
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
            } else {
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++;
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

    public void LoadDBDataJTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flash_card", "TraAnhTho", "081105");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM  flash_card.`Card` Where usercol='" + name + "';");

            randomSelection = new ArrayList<>();
            List<String> answers = new ArrayList<>();

            while (rs.next()) {
                String question = rs.getString("Name");
                String answer = rs.getString("Dinh_Nghia");
                QuestionAnswer qa = new QuestionAnswer(question,answer);
                qa.setQuestion(question);
                qa.setAnswer(answer);
                randomSelection.add(qa);
                answers.add(answer);
            }

            Collections.shuffle(randomSelection);

            while (randomSelection.size() < 10) {
                randomSelection.add(randomSelection.get(randomSelection.size() - 1));
            }

            random_dapan = new ArrayList<>();
            rs = st.executeQuery("SELECT Dinh_Nghia FROM flash_card.`Card`");
            while (rs.next()) {
                random_dapan.add(rs.getString("Dinh_Nghia"));
            }

            Collections.shuffle(random_dapan);
            while (random_dapan.size() < 40) {
                random_dapan.add(random_dapan.get(random_dapan.size() - 1));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new quiss(name);
    }
}
