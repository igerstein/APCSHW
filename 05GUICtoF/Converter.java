import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Converter extends JFrame implements ActionListener{
    private Container pane;
    private JTextField text;
    private JButton CtoF, FtoC;
    private JLabel l;
    public Converter(){
	this.setTitle("Celsius-Fahrenheit converter");
	this.setSize(250, 280);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new GridLayout(4, 1));

	text = new JTextField(20);
	l = new JLabel("", null, JLabel.LEFT);
	CtoF = new JButton("Convert from Celsius to Fahrenheit");
	FtoC = new JButton("Convert from Fahrenheit to Celsius");
	
	CtoF.setActionCommand("CtoF");
	CtoF.addActionListener(this);
	FtoC.setActionCommand("FtoC");
	FtoC.addActionListener(this);
	
	pane.add(text);
	pane.add(l);
	pane.add(CtoF);
	pane.add(FtoC);
    }
    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	String input = text.getText();
	if (action.equals("CtoF")){
	    l.setText(Double.toString((double)Math.round((Integer.parseInt(input) * (9.0 / 5) + 32) * 10) / 10));
	}else if (action.equals("FtoC")){
	    l.setText(Double.toString((double)Math.round(((Integer.parseInt(input) - 32) * (5.0 / 9)) * 10) / 10));
	}
    }
    public static void main(String[]args){
	Converter a = new Converter();
	a.setVisible(true);
    }	
}
