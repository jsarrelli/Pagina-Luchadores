package Entidades;

import java.sql.SQLException;

import BaseDeDatos.BaseDeDatos;
import Interfaz.Almacenable;

public class Tipo implements Almacenable {

	private String Rol;

	public Tipo(String rol) {
		super();
		Rol = rol;
	}

	public String getRol() {
		return Rol;
	}

	public void setRol(String rol) {
		Rol = rol;
	}

	@Override
	public void guardarEnDB() {
		// TODO Auto-generated method stub
		
		try {
			BaseDeDatos.insertarTipo(this);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void modificarEnDB() {
		// TODO Auto-generated method stub
		try {
			BaseDeDatos.modificarTipo(this, BaseDeDatos.buscarIdTipo(this.Rol));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void eliminarEnDB() {
		// TODO Auto-generated method stub
		
		try {
			
			if(BaseDeDatos.tieneJusticia(BaseDeDatos.buscarIdTipo(this.Rol))){
				BaseDeDatos.borrarJusticiasSegunTipo(BaseDeDatos.buscarIdTipo(this.Rol));
			BaseDeDatos.eliminarTipo(BaseDeDatos.buscarIdTipo(this.Rol));
			}
			
			else BaseDeDatos.eliminarTipo(BaseDeDatos.buscarIdTipo(this.Rol));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
