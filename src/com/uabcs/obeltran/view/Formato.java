package com.uabcs.obeltran.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Formato extends JPanel {
	
	
	Color fondo = new Color(54,57,63);
	Color CuadroTexto= new Color(49,51,57);
	Color letrasCuadroTexto = new Color(233,233,234);
	Color textoLabel = new Color(185,187,190);
	Font myFont = new Font("Helvetica", Font.BOLD, 12);
	
	public Formato() {
		
	}
	
	public JTextField nuevoJText(int x,int y,int w,int h) {
        JTextField textField = new JTextField();
        textField.setBackground(CuadroTexto);
        textField.setForeground(letrasCuadroTexto);
        textField.setBounds(x, y, w, h);

        return textField;
    }
	
	public JTextField nuevoJText() {
        JTextField textField = new JTextField();
        textField.setBackground(CuadroTexto);
        textField.setForeground(letrasCuadroTexto);

        return textField;
    }
	
	public JPasswordField nuevoJPass(int x,int y,int w,int h) {
		JPasswordField pass = new JPasswordField();
		pass.setBackground(CuadroTexto);
		pass.setBounds(x, y, w, h);

        return pass;
    }
	
	public JPasswordField nuevoJPass() {
		JPasswordField pass = new JPasswordField();
		pass.setBackground(CuadroTexto);

        return pass;
    }
	
	public JLabel nuevoJLabel(String s,int x,int y,int w,int h) {
		JLabel label = new JLabel(s);
		label.setFont(myFont);
		label.setForeground(textoLabel);
		label.setBounds(x, y, w, h);

        return label;
    }
	
	public JLabel nuevoJLabel(String s) {
		JLabel label = new JLabel(s);
		label.setFont(myFont);
		label.setForeground(textoLabel);

        return label;
    }
	

		
	
}
