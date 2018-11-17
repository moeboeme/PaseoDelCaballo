package caballo;

import tablero.Tablero;

public class Posicion {
	
	private int posicionHorizontal ;
	private int posicionVertical ;
	
	private final int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 } ;
	private final int[] vertical = { -1, -2, -2, -1, 1, 2, 2, 1 } ;
	
	public Posicion( int posicionH, int posicionV )
	{
		setPosicionHorizontal(posicionH);
		setPosicionVertical(posicionV);
	}
	
	public Posicion(Posicion posicion)
	{
		setPosicionHorizontal(posicion.getPosicionHorizontal());
		setPosicionVertical(posicion.getPosicionVertical());
	}
	
	public boolean esMovimientoValido( int tipoDeMovimiento )
	{
		int fila = getPosicionHorizontal() ;
		int columna = getPosicionVertical() ;
		
		Posicion posAux = new Posicion ( fila, columna) ;
		posAux.hacerMovimiento(tipoDeMovimiento) ;
		
		return posAux.esPosicionValida() ;
	}
	
	public void hacerMovimiento (int tipoDeMovimiento)
	{
		setPosicionHorizontal(getPosicionHorizontal()+horizontal[tipoDeMovimiento]);
		setPosicionVertical(getPosicionVertical()+vertical[tipoDeMovimiento]);
	}
	
	public void hacerMovimientoSiEsPosible(int tipoDeMovimiento)
	{
		if ( esMovimientoValido (tipoDeMovimiento))
		{
			hacerMovimiento(tipoDeMovimiento);
		}
	}
	
	
	public boolean esPosicionValida()
	{
		return getPosicionHorizontal() < Tablero.LIMITE_SUPERIOR 
				&& getPosicionHorizontal() >= Tablero.LIMITE_INFERIOR
				&& getPosicionVertical() < Tablero.LIMITE_SUPERIOR
				&& getPosicionVertical() >= Tablero.LIMITE_INFERIOR ;
	}

	public int getPosicionHorizontal() {
		return posicionHorizontal;
	}
	
	public void setPosicionHorizontal(int posicionHorizontal) {
		this.posicionHorizontal = posicionHorizontal;
	}

	public int getPosicionVertical() {
		return posicionVertical;
	}

	public void setPosicionVertical(int posicionVertical) {
		this.posicionVertical = posicionVertical;
	}
	
	@Override
	public String toString()
	{
		return "posicion horizontal: " + getPosicionHorizontal() 
		+ "\nposicionVertical: " + getPosicionVertical() 
		+ "\n_________________________";
		
	}
	
}