package tests;

import caballo.Caballo;
import caballo.Posicion;

public class TestPaseoDelCaballo {
	public static void main(String[] args) {
		
		Posicion posicion = new Posicion ( 3, 3 ) ;
		
		Caballo caballo = new Caballo(posicion) ;
		
		for ( int i = 1 ; i < 64 ; i++)
		{
			System.out.println(caballo.imprimirPosicion());
			caballo.realizaElMejorMovimiento();
		}
		
		System.out.println(caballo.getTableroHistorial());
		System.out.println(caballo.getTableroAccesibilidad());
	}
}
