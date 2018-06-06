package com.uabcs.obeltran.controller;

import com.uabcs.obeltran.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import com.uabcs.obeltran.model.Log;
import com.uabcs.obeltran.model.User;
import com.uabcs.obeltran.view.Registro;
import com.uabcs.obeltran.util.*;

public class RegistroController implements ActionListener{
	
	private Registro registro;
	
	public RegistroController() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand().equals("registrar")) {
			User user = User.findByEmail(this.registro.jtfEmail.getText());
			User user2 = User.findByUsername(this.registro.jtfUser.getText());
			if(user!=null) {
				JOptionPane.showMessageDialog(this.registro, "Este correo ya esta tomado");
			}else if(user2!=null){
				JOptionPane.showMessageDialog(this.registro, "Este username ya esta tomado");
			}
			else {
				
				try {
					String password = Util.hash256(String.valueOf(this.registro.jpfPassword.getPassword()));
					if(User.insertUser(this.registro.jtfEmail.getText(),password,this.registro.jtfUser.getText(),this.registro.jtfName.getText(),this.registro.jtfLastN.getText())!=0) {
						JOptionPane.showMessageDialog(this.registro, "Cuenta creada Exitosamente");
					}
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
			
			
	}
	
	
	public void init(){
		this.registro= new Registro();
		this.registro.init(this);
		this.registro.setVisible(true);
		//this.login.ingresar
		
	}

}
