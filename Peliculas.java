import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Peliculas extends JFrame implements ActionListener {
  JFrame frame;
  JLabel l;
  JLabel l2;
  JTextField t;
  JButton b;
  JComboBox cb;

  Peliculas() {
  		frame = new JFrame();
      l = new JLabel("Escribe el titulo de una pelicula");
      l2 = new JLabel("Peliculas");
      t = new JTextField();
  		b = new JButton("Añadir");
      b.addActionListener(this);
      cb = new JComboBox();

      l.setBounds(105,100,300,100);
      l2.setBounds(455,100,300,100);
      t.setBounds(100,200,300,50);
      b.setBounds(100,300,100,50);
      cb.setBounds(450,200,300,50);

      frame.add(l);
      frame.add(l2);
      frame.add(t);
      frame.add(b);
      frame.add(cb);

      frame.setLayout(null);
  		frame.setSize(800,500);
  		frame.setVisible(true);
      frame.setTitle("PELICULAS");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent a) {
    String s = t.getText();
    cb.addItem(s);
	}

  public static void main(String args[]) {
      new Peliculas();
    }
}
