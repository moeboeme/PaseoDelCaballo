package tablero;

import caballo.Posicion;

public class TableroHistorial extends Tablero {
	
	private int[][] historial ;
	private int contador ;
	
	private final int LIMITEMAX = 8 ;
	
	public TableroHistorial()
	{		
		inicializarHistorial() ;
	}
	
	public void setHistorial(int[][] historial) {
		this.historial = historial;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public TableroHistorial( Posicion posInicial)
	{
		inicializarHistorial() ;
		setPosicionActual(posInicial) ;
	}
	
	public void incrementarContador()
	{
		contador ++ ;
	}
	
	public void setPosicionActual(Posicion pos)
	{
		int fila = pos.getPosicionHorizontal() ;
		int columna = pos.getPosicionVertical() ;
		historial[fila][columna] = contador ;
		incrementarContador() ;
	}
	
	public void setPosicionActual(Posicion pos, int valor)
	{
		int fila = pos.getPosicionHorizontal() ;
		int columna = pos.getPosicionVertical() ;
		historial[fila][columna] = 0 ;
	}
	
	private void inicializarHistorial()
	{
		setContador(0) ;
		historial = new int[Tablero.LIMITE_SUPERIOR][Tablero.LIMITE_SUPERIOR] ;
		for ( int i = 0 ; i < Tablero.LIMITE_SUPERIOR ; i++ )
		{
			for ( int j = 0 ; j < LIMITEMAX ; j++ )
			{
				Posicion posicion = new Posicion (i, j) ;
				setPosicionActual(posicion, 0) ;
			}
		}
	}
	
	@Override
	public String toString()
	{
		return imprimirTablero(getTablero()) ;
	}

	@Override
	public int[][] getTablero() {
		return historial;
	}
	
}