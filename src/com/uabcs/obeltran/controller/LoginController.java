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
import com.uabcs.obeltran.view.Login;
import com.uabcs.obeltran.util.*;

public class LoginController implements ActionListener{

	private Login login;
	
	public LoginController(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("login")){
			User user = User.findByEmail(this.login.jtfEmail.getText());
			if(user != null){
				try {
					String password = Util.hash256(String.valueOf(this.login.jpfPassword.getPassword()));
					if(user.getPassword().equals(password)){
						Calendar calendario = Calendar.getInstance();
						Date fecha = new Date(calendario.getTime().getTime());
						Time hora = new Time(calendario.getTime().getTime());
						Log log = new Log();
						log.setFecha(fecha);
						log.setHora(hora);
						log.setIdUser(user.getId());
						log.create();
						JOptionPane.showMessageDialog(this.login, "Bienvenido");
					}else {
						JOptionPane.showMessageDialog(this.login, "Usuario o contraseña incorrecta");
					}
					}catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			
		
			}else {
				JOptionPane.showMessageDialog(this.login, "Usuario o contraseña incorrecta");
			}
		}
		if(e.getActionCommand().equals("registrar")) {
			RegistroController registro = new RegistroController();
			registro.init();
			this.login.dispose();
		}
		
			/*ArrayList<User> usuarios = User.findALL();
			for(User u : usuarios){
				System.out.println("Email:"+ u.getEmail());
			}
		}
		else if(e.getActionCommand().equals("registrar")){
			System.out.println("Registrar");
			}*/
			
	}
	
	public void init(){
		this.login= new Login();
		this.login.init(this);
		this.login.setVisible(true);
		//this.login.ingresar
		
	}
	
	

}
