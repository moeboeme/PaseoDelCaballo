package tablero;

public abstract class Tablero {

	public abstract int[][] getTablero() ;
	
	public static final int CANTIDAD_MOVIMIENTOS = 8 ;
	public static final int LIMITE_INFERIOR = 0 ;
	public static final int POSICION_VISITADA = 0 ;
	public static final int LIMITE_SUPERIOR = 8 ;

	
	public static String imprimirTablero( int[][] tablero)
	{
		StringBuilder st = new StringBuilder() ;
		st.append("-----------------------------------------\n");
		for ( int i = 0 ; i < Tablero.LIMITE_SUPERIOR ; i++ )
		{
			st.append("| ");
			for ( int j = 0 ; j < Tablero.LIMITE_SUPERIOR ; j++ )
			{
				if ( tablero[i][j] < 10 )
				{
					st.append("0" + tablero[i][j]);
				}
				else
				{
					st.append(tablero[i][j]); ;
				}
				st.append(" | ");
			}
			st.append("\n-----------------------------------------\n");
		}
		return st.toString() ;
	}
	
	
}
