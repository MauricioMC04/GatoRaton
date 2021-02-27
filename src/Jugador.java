import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	private List<NumeroSeleccionado> numerosSeleccionar;
	private List<Integer> valoresJuego;
	
	public Jugador() {
		this.numerosSeleccionar = new ArrayList<NumeroSeleccionado>();
		this.valoresJuego = new ArrayList<Integer>();
	}
	
	public void agregarNumeroSeleccionar(int numero) {
		this.numerosSeleccionar.add(new NumeroSeleccionado(numero));
	}
	
	public String obtenerNumeroSeleccion(int posicion) {
		if (posicion > this.numerosSeleccionar.size() - 1) {
			return "  ";
		}
		NumeroSeleccionado numeroSeleccionadoEnPosicion = this.numerosSeleccionar.get(posicion);
		if (numeroSeleccionadoEnPosicion.estaSeleccionado()) {
			return "x";
		}
		return Integer.toString(numeroSeleccionadoEnPosicion.obtenerNumero());
	}
	
	public void agregarValor(int valor) {
		this.valoresJuego.add(valor);
	}
	
	public String obtenerValor(int posicion) {
		if (posicion > this.valoresJuego.size() - 1) {
			return "  ";
		}
		return Integer.toString(this.valoresJuego.get(posicion));
	}
	
	public boolean numeroYaSeleccionado(int numero) {
		for (int i = 0; i < this.numerosSeleccionar.size(); i++) {
			NumeroSeleccionado numeroSeleccionar = this.numerosSeleccionar.get(i);
			if (numeroSeleccionar.obtenerNumero() == numero && numeroSeleccionar.estaSeleccionado()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean numeroValido(int numero) {
		return numero > 0 && numero < 10;
	}
	
	public void sumarNumero(int numero) {
		this.seleccionarNumero(numero);
		this.valoresJuego.add(this.valoresJuego.get(this.valoresJuego.size() - 1) + numero);
	}
	
	public void restarNumero(int numero) {
		this.seleccionarNumero(numero);
		this.valoresJuego.add(this.valoresJuego.get(this.valoresJuego.size() - 1) - numero);
	}
	
	private void seleccionarNumero(int numero) {
		System.out.println(this.numerosSeleccionar.get(8).obtenerNumero());
		for (int i = 0; i < this.numerosSeleccionar.size(); i++) {
			NumeroSeleccionado numeroSeleccionar = this.numerosSeleccionar.get(i);
			if (numeroSeleccionar.obtenerNumero() == numero) {
				numeroSeleccionar.seleccionar();
			}
		}
	}
	
	public int valorActual() {
		return this.valoresJuego.get(this.valoresJuego.size() - 1);
	}
	
	public boolean numerosDisponibles() {
		for (int i = 0; i < this.numerosSeleccionar.size(); i++) {
			NumeroSeleccionado numeroSeleccionar = this.numerosSeleccionar.get(i);
			if (!numeroSeleccionar.estaSeleccionado()) {
				return true;
			}
		}
		return false;
	}
}