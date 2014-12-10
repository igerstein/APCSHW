import javax.swing.*;
import java.awt.*;
public class Converter extends JFrame{
    private Container pane;
    public Converter(){
	this.setTitle("Celsius-Fahrenheit converter");
	this.setSize(500, 300);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
    }
    public static void main(String[]args){
	Converter a = new Converter();
	a.setVisible(true);
    }
}