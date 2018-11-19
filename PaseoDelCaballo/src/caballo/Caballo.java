package caballo;

import tablero.*;

public class Caballo {
	
	private Posicion posicion ;
	private TableroHistorial tableroHistorial ;
	private TableroAccesibilidad tableroAccesibilidad ;
	private Movimiento[] mejoresMovimientos ;
	
	public Caballo(Posicion posicionInicial)
	{
		if ( posicionInicial.esPosicionValida() )
		{
			inicializar(posicionInicial) ;
		}
	}
	
	private void inicializarMejoresMovimientos()
	{
		final int PEOR_ACCESIBILIDAD = 8 ;
		final int MOV_RANDOM = 0 ;
		mejoresMovimientos = new Movimiento[Tablero.CANTIDAD_MOVIMIENTOS] ;
		Movimiento peorMovimiento = new Movimiento( MOV_RANDOM, PEOR_ACCESIBILIDAD) ;
		for ( int i = 0 ; i < Tablero.CANTIDAD_MOVIMIENTOS ; i++)
		{
			mejoresMovimientos[i] = peorMovimiento ;
		}
	}
	
	private void inicializar(Posicion posicionInicial)
	{
		inicializarMejoresMovimientos() ;
		setTableroHistorial(new TableroHistorial(posicionInicial));
		setTableroAccesibilidad( new TableroAccesibilidad(posicionInicial) ) ;
		setPosicion( posicionInicial ) ;
	}
	
	private void setTableroAccesibilidad(TableroAccesibilidad tableroAccesibilidad) {
		this.tableroAccesibilidad = tableroAccesibilidad ;
	}

	public Movimiento[] getMejoresMovimientos() {
		return mejoresMovimientos;
	}
	
	public void realizaElMejorMovimiento()
	{
		determinarCualesSonLosMejoresMovimientos() ;
		moverCaballoSiEsPosible(getMejoresMovimientos()[0].getMovimiento()) ;
	}

	public void setMejoresMovimientos(Movimiento[] mejoresMovimientos) {
		this.mejoresMovimientos = mejoresMovimientos;
	}

	public TableroAccesibilidad getTableroAccesibilidad() {
		return tableroAccesibilidad;
	}

	public String imprimirPosicion()
	{
		return posicion.toString() ;
	}
	
	public void determinarCualesSonLosMejoresMovimientos()
	{
		for ( int movimiento = 0 ; movimiento < Tablero.CANTIDAD_MOVIMIENTOS ; movimiento++)
		{
			Posicion posAux = new Posicion(getPosicion()) ;
			posAux.hacerMovimientoSiEsPosible(movimiento);
			int indice = getTableroAccesibilidad().getIndiceDePosicion(posAux) ;
			if ( indice > 0 )
			{
				insertarMovimientoOrdenado(movimiento, indice) ;
			}
 		}
	}
	
	public void insertarMovimientoOrdenado( int tipoDeMovimiento, int accesibilidad )
	{
		
		Movimiento movimiento = new Movimiento ( tipoDeMovimiento, accesibilidad) ;
		boolean esElMejorMovHastaAhora = false ;
		
		for ( int indice = 0 ; indice < Tablero.CANTIDAD_MOVIMIENTOS && !esElMejorMovHastaAhora ; indice++ )
		{
			if ( mejoresMovimientos[indice].getAccesibilidad() > accesibilidad)
			{
				moverPosicionesIndiceHaciaAbajo(indice);
				insertarEnPosElMovimiento(indice, movimiento) ;
				esElMejorMovHastaAhora = true ;
			}
		}
	}
	
	public void insertarEnPosElMovimiento(int pos, Movimiento movimiento)
	{
		this.getMejoresMovimientos()[pos] = movimiento ;
	}
	
	public void moverPosicionesIndiceHaciaAbajo(int pos)
	{
		for ( int i = Tablero.CANTIDAD_MOVIMIENTOS - 1 ; i > pos ; i-- )
		{
			getMejoresMovimientos()[i] = getMejoresMovimientos()[i-1] ;
		}
	}
	
	public void moverCaballoSiEsPosible( int tipoDeMovimiento )
	{
		if ( posicion.esMovimientoValido(tipoDeMovimiento) ) 
		{
			posicion.hacerMovimientoSiEsPosible(tipoDeMovimiento);
			setPosicionCaballoEnTableroHistorial(posicion);
			setPosicionCaballoEnTableroAccesibilidad(posicion) ;
			inicializarMejoresMovimientos() ;
		}
	}
	
	private void setPosicionCaballoEnTableroAccesibilidad(Posicion posicion) {
		getTableroAccesibilidad().setPosicionActual(posicion);
	}

	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setPosicionCaballoEnTableroHistorial( Posicion pos )
	{
		getTableroHistorial().setPosicionActual(pos);
	}
	
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
		setPosicionCaballoEnTableroHistorial(posicion);
	}
	
	public TableroHistorial getTableroHistorial() {
		return tableroHistorial;
	}
	
	public void setTableroHistorial(TableroHistorial tableroHistorial) {
		this.tableroHistorial = tableroHistorial;
	}
}