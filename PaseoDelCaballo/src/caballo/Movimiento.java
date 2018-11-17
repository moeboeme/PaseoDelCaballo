package caballo;

public class Movimiento {
	
	private int movimiento ;
	private int accesibilidad ;
	
	public Movimiento (int tipoDeMovimento, int accesibilidad )
	{
		setMovimiento(tipoDeMovimento);
		setAccesibilidad(accesibilidad);
	}

	public int getMovimiento() {
		return this.movimiento;
	}

	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}

	public int getAccesibilidad() {
		return accesibilidad;
	}

	public void setAccesibilidad(int indice) {
		this.accesibilidad = indice;
	}
	
}
