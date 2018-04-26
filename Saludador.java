import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Saludador extends JFrame implements ActionListener {
  JFrame frame;
  JLabel l;
  JTextField t;
  JButton b;

    Saludador() {
  		frame = new JFrame();
      l = new JLabel("Escribe un nombre para saludar");
      t = new JTextField();
  		b = new JButton("¡Saludar!");
      b.addActionListener(this);

      l.setBounds(300,100,300,100);
      t.setBounds(250,200,300,50);
      b.setBounds(350,300,100,50);

      frame.add(l);
      frame.add(t);
      frame.add(b);

      frame.setLayout(null);
  		frame.setSize(800,500);
  		frame.setVisible(true);
      frame.setTitle("SALUDADOR");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent a) {
    String s = t.getText();
    JOptionPane.showMessageDialog(null, "¡Hola "+s+"!", "SALUDADOR", JOptionPane.INFORMATION_MESSAGE);
	}

  public static void main(String args[]) {
      new Saludador();
    }
}
