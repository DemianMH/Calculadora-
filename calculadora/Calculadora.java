/*Mora Hernandez Gerardo Demian*/
/*02/03/2021*/
/*Calculadora en Java RadioButton*/
package calculadora;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Calculadora extends JFrame implements KeyListener, ActionListener {
    private JLabel n1,n2,resul;
    private JTextField txtn1,txtn2,txtresul;
    private JButton calcular,salir;
    private JRadioButton suma,rest,mult,div;
    private ButtonGroup ope;
    
    
    public Calculadora(){
    super ("Calculadora (Demian Mora)");
    //Layout  Pricipal
    setLayout(new FlowLayout());
    JPanel pIz = new JPanel();
   
    //Panel Izquierdo
    pIz.setLayout(new GridLayout(4,2));
    ope = new ButtonGroup();
    n1 = new JLabel ("Numero 1: "); 
    txtn1 = new JTextField ();
    n2 = new JLabel ("Numero 2: ");
    txtn2 = new JTextField ();
    resul = new JLabel ("Resultado: ");
    txtresul = new JTextField ();
    calcular = new JButton (" Calcular ");
    salir = new JButton (" Salir ");
    
    pIz.add(n1);
    pIz.add(txtn1);
    txtn1.addKeyListener(this);
    pIz.add(n2);
    pIz.add(txtn2);
    txtn2.addKeyListener(this);
    
    pIz.add(resul);
    pIz.add(txtresul);
    
    pIz.add(calcular);
    calcular.addActionListener(this);
    pIz.add(salir);
    salir.addActionListener(this);
    
    //Panel Derecho
    JPanel pDe = new JPanel();
    pDe.setLayout(new GridLayout(4,1));
    pDe.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    suma = new JRadioButton("Sumar");
    rest = new JRadioButton("Restar");
    mult = new JRadioButton("Multiplicar");
    div= new JRadioButton("Dividir");
    
    pDe.add(suma);
    pDe.add(rest);
    pDe.add(mult);
    pDe.add(div);
    ope.add(suma);
    ope.add(rest);
    ope.add(mult);
    ope.add(div);
    
    add(pIz);
    add(pDe);
    
    pack();
    setSize(400,200);
    setLayout(null);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    }
   
    public static void main(String[] args) {
        new Calculadora();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
        if(!(ke.getKeyChar()>='0'&& ke.getKeyChar()<='9')){
            ke.consume();
            /*JOptionPane.showMessageDialog(rootPane,"Ingresar solo Numeros");*/
            }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
  
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==calcular){
      float resul1 = Float.parseFloat(txtn1.getText());
      float resul2 = Float.parseFloat(txtn2.getText());
      
      if(suma.isSelected()){
      txtresul.setText(String.valueOf(resul1+resul2));
      }else if(rest.isSelected()){
      txtresul.setText(String.valueOf(resul1-resul2));
      }else if(mult.isSelected()){
      txtresul.setText(String.valueOf(resul1*resul2));
      }else if(div.isSelected()){
      txtresul.setText(String.valueOf(resul1/resul2));
      }
      
      }else if(ae.getSource()==salir){
     System.exit(0);
     }
    }
    
}
