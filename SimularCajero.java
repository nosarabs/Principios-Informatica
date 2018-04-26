import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimularCajero extends JFrame implements ActionListener {

  private int sA = 10000;
  private String pass = "123";

  SimularCajero () {
    logIn();
  }

  public void logIn() {
    JFrame frame = new JFrame();
    JLabel l1 = new JLabel("Usuario:");
    JLabel l2 = new JLabel("Contraseña:");
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JButton b = new JButton(new AbstractAction("Log-In") {
        int i = 3;
        @Override
        public void actionPerformed( ActionEvent e ) {
            if (t1.getText().equals("admin") && t2.getText().equals(pass) && i > 0) {
              menu();
              frame.dispose();
            } else {
              JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta", "CAJERO", JOptionPane.ERROR_MESSAGE);
              --i;
            }
            if (i == 0) {
              JOptionPane.showMessageDialog(null, "No se permiten mas intentos.", "CAJERO", JOptionPane.ERROR_MESSAGE);
              System.exit(0);
            }
          }
        });

      JButton b1 = new JButton(new AbstractAction("Cambiar Contraseña") {
          @Override
          public void actionPerformed( ActionEvent e ) {
              cambio();
              frame.dispose();
            }
      });

    l1.setBounds(100,100,100,100);
    l2.setBounds(100,150,100,100);

    t1.setBounds(200,120,300,50);
    t2.setBounds(200,180,300,50);

    b.setBounds(200,250,100,50);
    b1.setBounds(350,250,150,50);

    frame.add(l1);
    frame.add(l2);
    frame.add(t1);
    frame.add(t2);
    frame.add(b);
    frame.add(b1);

    frame.setLayout(null);
    frame.setSize(700,400);
    frame.setVisible(true);
    frame.setTitle("CAJERO");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  public void cambio () {
    JFrame frame = new JFrame();
    JLabel l1 = new JLabel("Contraseña Actual:");
    JLabel l2 = new JLabel("Contraseña Nueva:");
    JLabel l3 = new JLabel("Confirmar Contraseña:");
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JButton b = new JButton(new AbstractAction("Finalizar") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            if (t1.getText().equals(pass)) {
              if (t2.getText().equals(t3.getText())) {
                JOptionPane.showMessageDialog(null, "Cambio de Contraseña Exitoso!", "CAJERO", JOptionPane.INFORMATION_MESSAGE);
                pass = t2.getText();
                logIn();
                frame.dispose();
              } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.", "CAJERO", JOptionPane.WARNING_MESSAGE);
              }
            } else {
              JOptionPane.showMessageDialog(null, "Contraseña Actual Incorrecta", "CAJERO", JOptionPane.ERROR_MESSAGE);
            }
          }
        });

        l1.setBounds(75,50,200,100);
        l2.setBounds(75,100,200,100);
        l3.setBounds(50,150,200,100);

        t1.setBounds(200,70,300,50);
        t2.setBounds(200,130,300,50);
        t3.setBounds(200,190,300,50);

        b.setBounds(300,250,100,50);

        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        frame.add(b);

        frame.setLayout(null);
        frame.setSize(700,400);
        frame.setVisible(true);
        frame.setTitle("CAJERO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  public void menu() {
    JFrame frame = new JFrame();
    JLabel l1 = new JLabel("Seleccionar:");
    JComboBox cb = new JComboBox();
    JButton b = new JButton(new AbstractAction("Continuar") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            String x = cb.getSelectedItem().toString();
            if (x.equals("Retiro")) {
              retiro();
              frame.dispose();
            }
            if (x.equals("Deposito")) {
              deposito();
              frame.dispose();
            }
            if (x.equals("Consultar Saldo")) {
              consulta();
              frame.dispose();
            }
          }
        });

    l1.setBounds(100,100,100,100);
    cb.setBounds(200,127,300,50);
    b.setBounds(300,250,100,50);

    cb.addItem("Retiro");
    cb.addItem("Deposito");
    cb.addItem("Consultar Saldo");

    frame.add(l1);
    frame.add(cb);
    frame.add(b);

    frame.setLayout(null);
    frame.setSize(700,400);
    frame.setVisible(true);
    frame.setTitle("CAJERO");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  public void retiro() {
    JFrame frame = new JFrame();
    JLabel l1 = new JLabel("Monto a Retirar:");
    JTextField t1 = new JTextField();
    JButton b = new JButton(new AbstractAction("Continuar") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            int r = Integer.parseInt(t1.getText());
            if (r > sA) {
              JOptionPane.showMessageDialog(null, "Fondos Insuficientes", "CAJERO", JOptionPane.WARNING_MESSAGE);
            }
            if (r % 1000 != 0) {
              JOptionPane.showMessageDialog(null, "Monto Invalido", "CAJERO", JOptionPane.WARNING_MESSAGE);
            } else {
              if (r <= sA) {
                JOptionPane.showMessageDialog(null, "Retiro Exitoso", "CAJERO", JOptionPane.INFORMATION_MESSAGE);
                sA -= r;
              }
            }
            menu();
            frame.dispose();
          }
        });

    l1.setBounds(75,100,100,100);
    t1.setBounds(200,120,300,50);
    b.setBounds(300,250,100,50);

    frame.add(l1);
    frame.add(t1);
    frame.add(b);

    frame.setLayout(null);
    frame.setSize(700,400);
    frame.setVisible(true);
    frame.setTitle("CAJERO");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void deposito() {
    JFrame frame = new JFrame();
    JLabel l1 = new JLabel("Monto a Debitar:");
    JTextField t1 = new JTextField();
    JButton b = new JButton(new AbstractAction("Continuar") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            int d = Integer.parseInt(t1.getText());
            JOptionPane.showMessageDialog(null, "Deposito Exitoso", "CAJERO", JOptionPane.INFORMATION_MESSAGE);
            sA += d;
            menu();
            frame.dispose();
          }
        });

    l1.setBounds(75,100,200,100);
    t1.setBounds(200,120,300,50);
    b.setBounds(300,250,100,50);

    frame.add(l1);
    frame.add(t1);
    frame.add(b);

    frame.setLayout(null);
    frame.setSize(700,400);
    frame.setVisible(true);
    frame.setTitle("CAJERO");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  public void consulta() {
    JFrame frame = new JFrame();
    JLabel l1 = new JLabel("Saldo Actual:");
    JTextField t1 = new JTextField("$"+sA);
    t1.setEditable(false);
    JButton b = new JButton(new AbstractAction("Atras") {
        @Override
        public void actionPerformed( ActionEvent e ) {
            menu();
            frame.dispose();
          }
        });

    l1.setBounds(100,100,100,100);
    t1.setBounds(200,127,300,50);
    b.setBounds(300,250,100,50);

    frame.add(l1);
    frame.add(t1);
    frame.add(b);

    frame.setLayout(null);
    frame.setSize(700,400);
    frame.setVisible(true);
    frame.setTitle("CAJERO");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  }

  public void actionPerformed(ActionEvent a) {}

  public static void main(String args[]) {
      SimularCajero s = new SimularCajero();

  }
}
