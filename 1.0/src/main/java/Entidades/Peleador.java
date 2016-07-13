package Entidades;

import java.sql.SQLException;

import BaseDeDatos.BaseDeDatos;
import Interfaz.Almacenable;

public class Peleador implements Almacenable {

	
	private String Nombre;
	private String Apodo;
	private float Peso;
	private float Altura;
	private String Categoria;
	private String Modalidad;
	private int Edad;
	private String Direccion;
	private String DNI_Peleador;
	private int idEntrenador;
	
	public Peleador(String nombre, String apodo, float peso, float altura,
			String categoria, String modalidad, int edad, String direccion,
			String dNI_Peleador, int idEntrenador) {
		super();
		Nombre = nombre;
		Apodo = apodo;
		Peso = peso;
		Altura = altura;
		Categoria = categoria;
		Modalidad = modalidad;
		Edad = edad;
		Direccion = direccion;
		DNI_Peleador = dNI_Peleador;
		this.idEntrenador = idEntrenador;
	}
	
	

	public String getNombre() {
		return Nombre;
	}



	public void setNombre(String nombre) {
		Nombre = nombre;
	}



	public String getApodo() {
		return Apodo;
	}



	public void setApodo(String apodo) {
		Apodo = apodo;
	}



	public float getPeso() {
		return Peso;
	}



	public void setPeso(float peso) {
		Peso = peso;
	}



	public float getAltura() {
		return Altura;
	}



	public void setAltura(float altura) {
		Altura = altura;
	}



	public String getCategoria() {
		return Categoria;
	}



	public void setCategoria(String categoria) {
		Categoria = categoria;
	}



	public String getModalidad() {
		return Modalidad;
	}



	public void setModalidad(String modalidad) {
		Modalidad = modalidad;
	}



	public int getEdad() {
		return Edad;
	}



	public void setEdad(int edad) {
		Edad = edad;
	}



	public String getDireccion() {
		return Direccion;
	}



	public void setDireccion(String direccion) {
		Direccion = direccion;
	}



	public String getDNI_Peleador() {
		return DNI_Peleador;
	}



	public void setDNI_Peleador(String dNI_Peleador) {
		DNI_Peleador = dNI_Peleador;
	}



	public int getIdEntrenador() {
		return idEntrenador;
	}



	public void setIdEntrnador(int idEntrnador) {
		this.idEntrenador = idEntrnador;
	}



	@Override
	public void guardarEnDB() {
		// TODO Auto-generated method stub
		try {
			BaseDeDatos.insertarPeleador(this);
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
			BaseDeDatos.modificarPeleador(this, BaseDeDatos.buscarIdPeleador(this.DNI_Peleador));
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
		
		try {
			BaseDeDatos.eliminarPeleador(BaseDeDatos.buscarIdPeleador(this.DNI_Peleador));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
