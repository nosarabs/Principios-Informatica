import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class ConvertirDolarEuro extends JFrame implements ActionListener {
  JFrame frame;
  JLabel l;
  JLabel l2;
  JLabel l3;
  JTextField t;
  JButton b;
  JComboBox cb;
  JComboBox cb1;
  private static DecimalFormat df2 = new DecimalFormat(".##");

  ConvertirDolarEuro () {
    frame = new JFrame();
    l = new JLabel("Cantidad:");
    l2 = new JLabel("Desde:");
    l3 = new JLabel("Hacia:");
    b = new JButton("Convertir");
    b.addActionListener(this);
    t = new JTextField();
    cb = new JComboBox();
    cb1 = new JComboBox();

    l.setBounds(200,105,300,100);
    l2.setBounds(200,205,300,100);
    l3.setBounds(200,305,300,100);

    t.setBounds(300,130,300,50);
    cb.setBounds(300,230,300,50);
    cb1.setBounds(300,330,300,50);

    b.setBounds(325,400,100,50);

    frame.add(l);
    frame.add(l2);
    frame.add(l3);
    frame.add(t);
    frame.add(cb);
    frame.add(cb1);
    frame.add(b);

    cb.addItem("Dolares");
    cb1.addItem("Dolares");
    cb.addItem("Euros");
    cb1.addItem("Euros");

    frame.setLayout(null);
    frame.setSize(800,500);
    frame.setVisible(true);
    frame.setTitle("CONVERSOR");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void actionPerformed(ActionEvent a) {
    double r = Double.parseDouble(t.getText());
    double z;
    String x = cb.getSelectedItem().toString();
    String y = cb1.getSelectedItem().toString();

    if (x == y) {
      JOptionPane.showMessageDialog(null, "Ambos tipos de moneda son iguales", "CONVERSOR", JOptionPane.WARNING_MESSAGE);
    } else if (x == "Dolares") {
      z = r / 1.20;
      JOptionPane.showMessageDialog(null, df2.format(r)+" Dolares = "+df2.format(z)+" Euros.", "CONVERSOR", JOptionPane.INFORMATION_MESSAGE);
    } else {
      z = r * 1.20;
      JOptionPane.showMessageDialog(null, df2.format(r)+" Euros = "+df2.format(z)+" Dolares.", "CONVERSOR", JOptionPane.INFORMATION_MESSAGE);
    }
	}

  public static void main(String args[]) {
      ConvertirDolarEuro c = new ConvertirDolarEuro();

  }
}
