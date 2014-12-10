import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Converter extends JFrame implements ActionListener{
    private Container pane;
    private JTextField text;
    private JButton CtoF, FtoC;
    public Converter(){
	this.setTitle("Celsius-Fahrenheit converter");
	this.setSize(500, 300);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	text = new JTextField(20);
	CtoF = new JButton("Convert from Fahrenheit to Celsius");
	FtoC = new JButton("Convert from Celsius to Fahrenheit");
	
	CtoF.setActionCommand("CtoF");
	CtoF.addActionListener(this);
	FtoC.setActionCommand("FtoC");
	FtoC.addActionListener(this);
	
	pane.add(text);
	pane.add(CtoF);
	pane.add(FtoC);
    }
    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	System.out.println(action);
    }
    public static void main(String[]args){
	Converter a = new Converter();
	a.setVisible(true);
    }	
}
