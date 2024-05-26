package View;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("/IMG/21 Heart-Wrenching GIFs To Sam Smith's _Stay With Me_ That Will Make You Stay.gif"));
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1170, 650);
        add(image);
        setSize(1170,650);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);


        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }catch (Exception a){
            a.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}