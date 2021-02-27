import java.util.Scanner;

public class Juego {
	
	private boolean jugando;
	private Gato gato;
	private Raton raton;
	private boolean turno;
	
	public Juego() {
		this.jugando = false;
		this.gato = new Gato();
		this.raton = new Raton();
		this.turno = false;
	}
	
	public void iniciar() {
		this.jugando = true;
		this.jugar();
	}
	
	private void jugar() {
		Scanner scanner = new Scanner(System.in);
		while (this.jugando) {
			System.out.println("<---------------------------------->");
			System.out.println("        Gato     |     Raton        ");
			System.out.println("------------------------------------");
			for (int i = 0; i < 10; i++) {
				System.out.println(
					"  " + 
					this.gato.obtenerNumeroSeleccion(i) + 
					"   |   " + 
					this.gato.obtenerValor(i) + 
					"    |   " +
					this.raton.obtenerValor(i) + 
					"    |   " +
					this.raton.obtenerNumeroSeleccion(i) +
					"   "
				);
			}
			System.out.println("Juega " + (this.turno ? "Gato" : "Raton") + ": ");
			boolean esValido = false;
			int jugada = 0;
			while (!esValido) {
				jugada = scanner.nextInt();
				if (this.turno) {
					if (this.gato.numeroValido(jugada)) {
						if (this.gato.numeroYaSeleccionado(jugada)) {
							System.out.println("Gato numero ya seleccionado");
						} else {
							esValido = true;
						}
					} else {
						System.out.println("Gato numero no valido");
					}
				} else {
					if (this.raton.numeroValido(jugada)) {
						if (this.raton.numeroYaSeleccionado(jugada)) {
							System.out.println("Raton numero ya seleccionado");
						} else {
							esValido = true;
						}
					} else {
						System.out.println("Raton numero no valido");
					}
				}
			}
			if (this.turno) {
				this.gato.hacerJugada(jugada);
				if (this.ganaGato()) {
					System.out.println("Gana Gato");
					this.jugando = false;
				}
			} else {
				this.raton.hacerJugada(jugada);
				if (this.ganaRaton()) {
					System.out.println("Gana Raton");
					this.jugando = false;
				}
			}
			if (this.empate()) {
				System.out.println("Empate");
				this.jugando = false;
			}
			this.turno = !this.turno;
			System.out.println("<---------------------------------->");
		}
		scanner.close();
	}
	
	private boolean ganaGato() {
		return this.gato.valorActual() == this.raton.valorActual();
	}
	
	private boolean ganaRaton() {
		return this.raton.valorActual() < 1;
	}
	
	private boolean empate() {
		return !this.gato.numerosDisponibles() && !this.raton.numerosDisponibles();
	}
}