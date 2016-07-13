package Entidades;

import java.sql.SQLException;

import BaseDeDatos.BaseDeDatos;
import Interfaz.Almacenable;

public class Lugar implements Almacenable {

	private String Nombre;
	private String Direccion;
	private String Telefono;
	
	
	public Lugar(String nombre, String direccion, String telefono) {
		super();
		Nombre = nombre;
		Direccion = direccion;
		Telefono = telefono;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String direccion) {
		Direccion = direccion;
	}


	public String getTelefono() {
		return Telefono;
	}


	public void setTelefono(String telefono) {
		Telefono = telefono;
	}


	@Override
	public void guardarEnDB() {
		// TODO Auto-generated method stub
		
		try {
			BaseDeDatos.insertarLugar(this);
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
			BaseDeDatos.modificarLugar(this, BaseDeDatos.buscarIdLugar(this.Nombre));
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
		// TODO Auto-generated method stub'
		
		try {
			BaseDeDatos.eliminarLugar(BaseDeDatos.buscarIdLugar(this.Nombre));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
