public class NumeroSeleccionado {
	
	private int numero;
	private boolean seleccionado;
	
	public NumeroSeleccionado(int _numero) {
		this.numero = _numero;
		this.seleccionado = false;
	}
	
	public boolean estaSeleccionado() {
		return this.seleccionado;
	}
	
	public int obtenerNumero() {
		return this.numero;
	}
	
	public void seleccionar() {
		this.seleccionado = true;
	}
}