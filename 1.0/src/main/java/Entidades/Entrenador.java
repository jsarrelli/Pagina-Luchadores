package Entidades;

import java.sql.SQLException;

import BaseDeDatos.BaseDeDatos;
import Interfaz.Almacenable;

public class Entrenador implements Almacenable{
	
	private String DNI_Entrenador;
	private String Nombre;
	private String Telefono;
	private String Direccion;
	
	
	public Entrenador(String dNI_Entrenador, String nombre, String telefono,
			String direccion) {
		super();
		DNI_Entrenador = dNI_Entrenador;
		Nombre = nombre;
		Telefono = telefono;
		Direccion = direccion;
	}


	public String getDNI_Entrenador() {
		return DNI_Entrenador;
	}


	public void setDNI_Entrenador(String dNI_Entrenador) {
		DNI_Entrenador = dNI_Entrenador;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getTelefono() {
		return Telefono;
	}


	public void setTelefono(String telefono) {
		Telefono = telefono;
	}


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String direccion) {
		Direccion = direccion;
	}


	@Override
	public void guardarEnDB() {
		// TODO Auto-generated method stub
		
		try {
			BaseDeDatos.insertarEntrenador(this);
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
			BaseDeDatos.modificarEntrenador(this, BaseDeDatos.buscarIdEntrenador(this.DNI_Entrenador));
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
			if(BaseDeDatos.tienePeleador(BaseDeDatos.buscarIdEntrenador(this.DNI_Entrenador)))
			{
				BaseDeDatos.borrarPeleadoresSegunEntranador(BaseDeDatos.buscarIdEntrenador(this.DNI_Entrenador));
				BaseDeDatos.eliminarEntrenador(BaseDeDatos.buscarIdEntrenador(this.DNI_Entrenador));
			}
			
			else BaseDeDatos.eliminarEntrenador(BaseDeDatos.buscarIdEntrenador(this.DNI_Entrenador));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
