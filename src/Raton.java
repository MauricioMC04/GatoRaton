public class Raton extends Jugador{

	public Raton() {
		super();
		for (int i = 1; i < 10; i ++) {
			this.agregarNumeroSeleccionar(i);
		}
		this.agregarValor(30);
	}
	
	public void hacerJugada(int jugada) {
		this.restarNumero(jugada);
	}
}