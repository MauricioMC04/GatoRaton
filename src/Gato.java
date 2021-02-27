public class Gato extends Jugador{
	
	public Gato() {
		super();
		for (int i = 1; i < 10; i ++) {
			this.agregarNumeroSeleccionar(i);
		}
		this.agregarValor(1);
	}
	
	public void hacerJugada(int jugada) {
		this.sumarNumero(jugada);
	}
}