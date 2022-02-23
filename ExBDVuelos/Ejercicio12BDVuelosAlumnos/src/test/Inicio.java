package test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import modelo.*;
import modeloDAO.*;

public class Inicio {


	public static void main(String[] args) {
		int opcion = 0;
		do{
			try{
				opcion = Integer.parseInt(JOptionPane.showInputDialog(
						"1º) Para fomentar el turismo se quiere regalar un viaje al cliente o "
								+ "clientes que más viajes haya realizado (el que tenga 3 o más tarjetas de embarque)." 
								+ " Mostrar el nombre completo del cliente y el nº de viaje realizados.\n"
								+ "2.- Mostrar los aviones que no hayan realizado ningún vuelo desde la ciudad Vigo\n"
								+ "3.- Listar los clientes que tienen que salir del aeropuerto de Vigo en "
								+ "una determinada fecha que introduciremos por teclado. (Por ejemplo hoy).\n"
								+ "4.- Queremos sacar una tarjeta de embarque, para ello introduciremos el Nº de la tarjeta, "
								+ "el Nº de Vuelo, el nombre completo del pasajero y le asignamos un asiento. "
								+ "Actualizaremos las tablas necesarias. Los datos que podemos utilizar son:\n" 
								+ "Nº Tarjeta:20\n"  
								+ "Pasajero : Iciar Aguirre Guisasola\n" 
								+ "Nº Vuelo: 700\n"  
								+ "Nº Asiento: 19\n"  
								+ "5.- Salir\n"
								+ "Elegir opción"));

				switch(opcion){
				case 1:
					consulta01();
					break;
				case 2:
					consulta02();
					break;
				case 3:
					consulta03();
					break;
				case 4:
					consulta04();
					break;
				case 5:
					System.exit(0);
				default:
					System.out.println("Opcion erronea");
				}// fin switch
			}catch(NumberFormatException e){
				System.out.println("La opcion tiene que ser un numero");
			}
		}while(opcion != 5);

	}

	private static void consulta04() {
		/*
		 * 4.- Queremos sacar una tarjeta de embarque, para ello introduciremos el Nº de la tarjeta, "
			+ "el Nº de Vuelo, el nombre completo del pasajero y le asignamos un asiento. "
			+ "Actualizaremos las tablas necesarias. Los datos que podemos utilizar son:\n" 
			+ "Nº Tarjeta:20\n"  
			+ "Pasajero : Iciar Aguirre Guisasola\n" 
			+ "Nº Vuelo: 700\n"  
			+ "Nº Asiento: 19\n" 
		 */



	}

	private static void consulta03() {
		/*
		 * 3.- Listar los clientes que tienen que salir del aeropuerto de Vigo en "
						+ "una determinada fecha que introduciremos por teclado. (Por ejemplo hoy).
		 */



	}

	private static void consulta02() {
		// 2.- Mostrar los aviones que no hayan realizado ningún vuelo desde la ciudad Vigo



	}

	private static void consulta01() {
		/*
		 * "1º) Para fomentar el turismo se quiere regalar un viaje al cliente o "
			+ "clientes que más viajes haya realizado (el que tenga 3 o más tarjetas de embarque)." 
			+ " Mostrar el nombre completo del cliente y el nº de viaje realizados.\n"
		 */




	}

}
