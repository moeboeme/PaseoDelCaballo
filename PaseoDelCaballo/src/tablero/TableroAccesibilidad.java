package tablero;

import caballo.Posicion;

public class TableroAccesibilidad extends Tablero {
	
	private int[][] accesibilidad ;
	private Posicion posicionActual ;
	private final int CANT_MOVIMIENTOS = 8 ;
	
	public TableroAccesibilidad( Posicion posicionInicial )
	{
		inicializarHistorial() ;
		setPosicionActual(posicionInicial) ;
	}
	
	public int getIndiceDePosicion(Posicion pos)
	{
		int fila = pos.getPosicionHorizontal() ;
		int columna = pos.getPosicionVertical() ;
		return this.accesibilidad[fila][columna] ;
	}

	public void setAccesibilidad(int[][] accesibilidad) {
		this.accesibilidad = accesibilidad;
	}

	public Posicion getPosicionActual() {
		return posicionActual;
	}
	
	private void decrementarAccesibilidadDeMovimiento(Posicion pos, int tipoDeMovimiento)
	{
		
		int fila ;
		int columna ;
		
		pos.hacerMovimientoSiEsPosible(tipoDeMovimiento);

		fila = pos.getPosicionHorizontal() ;
		columna = pos.getPosicionVertical() ;
		decrementarAccesibilidadDeCelda(fila, columna) ;
	}
	
	public void decrementarAccesibilidadDeCelda( int fila, int columna)
	{
		if ( posicionNoFueVisitada (fila, columna ) )
		{
			disminuirAccesibilidadEnUno(fila,columna) ;
		}
	}
	
	private void disminuirAccesibilidadEnUno(int fila, int columna)
	{
		this.accesibilidad[fila][columna] -- ; 
	}
	
	public boolean posicionNoFueVisitada( int fila, int columna )
	{
		return ( this.accesibilidad[fila][columna] > 1 ) ;
	}
	
	public void actualizarAccesibilidades(Posicion pos)
	{
		
		int fila ;
		int columna ;
		
		for ( int tipoDeMovimiento = 0 ; tipoDeMovimiento < CANT_MOVIMIENTOS ; tipoDeMovimiento++ )
		{
			fila = pos.getPosicionHorizontal();
			columna = pos.getPosicionVertical() ;
			
			Posicion posAux = new Posicion( fila, columna) ;
			
			decrementarAccesibilidadDeMovimiento(posAux, tipoDeMovimiento) ;
		}
	}

	public void setPosicionActual ( Posicion posicion)
	{
		posicionActual = posicion ;
		setAccesibilidad (posicion, Tablero.POSICION_VISITADA) ;
		actualizarAccesibilidades(posicion) ;
	}
	
	private void setAccesibilidad ( Posicion pos, int acc)
	{
		int fila = pos.getPosicionHorizontal() ;
		int columna = pos.getPosicionVertical() ;
		getTablero()[fila][columna] = acc ;
	}

	private void inicializarHistorial() 
	{
		accesibilidad = new int[][]
		{
			{ 2, 3, 4, 4, 4, 4, 3, 2 }, 
			{ 3, 4, 6, 6, 6, 6, 4, 3 },
			{ 4, 6, 8, 8, 8, 8, 6, 4 },
			{ 4, 6, 8, 8, 8, 8, 6, 4 },
			{ 4, 6, 8, 8, 8, 8, 6, 4 },
			{ 4, 6, 8, 8, 8, 8, 6, 4 },
			{ 3, 4, 6, 6, 6, 6, 4, 3 },
			{ 2, 3, 4, 4, 4, 4, 3, 2 }
		} ;
	}
	
	@Override
	public String toString()
	{
		return imprimirTablero(getTablero()) ;
	}

	@Override
	public int[][] getTablero() {
		return accesibilidad;
	}
}