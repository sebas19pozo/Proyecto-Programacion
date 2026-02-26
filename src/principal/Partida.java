package principal;

public class Partida {
	// Definimos los atributos de nuestra clase.
	Cliente cliente;
	int puntuacion;
	Inventario inventario;

	// Lo declaramos static porque el recuento de Clientes Atendidos es global del juego.
	static int clientesAtendidos;

	// Inicializamos el constructor
	public Partida(Cliente cliente, int puntuacion, Inventario inventario) {
		this.cliente = cliente;
		this.puntuacion = puntuacion;
		this.inventario = inventario;
	}

	// Entra el cliente y hace el pedido(lo hacemos con el método hacerPedido())
	public String atenderCliente() {
		cliente = new Cliente("Cliente " + clientesAtendidos, "");
		cliente.hacerPedido();

		System.out.println("Ha pedido " + cliente.getPedido());
		clientesAtendidos++;
		return cliente.getPedido();
	}

	// Nos devuelve true o false en función de si el ingrediente está preparado
	public boolean ingredientePreparado(Ingrediente ingrediente) {
		return ingrediente.isPreparado();
	}

	// Preparamos la ensalada
	public boolean prepararEnsalada(Lechuga lechuga) {
		if (ingredientePreparado(lechuga) == false) {
			return false;
		}

		if (cliente.getPedido().contains("Ensalada")) {
			inventario.consumirIngrediente(lechuga);
			return true;
		}
		return false;
	}

	// Preparamos la hamburguesa
	public boolean prepararHamburguesa(Carne carne, Pan pan) {
		if (ingredientePreparado(carne) == false) {
			System.out.println("No puedes usar una carne cruda");
			return false;
		} else if (ingredientePreparado(pan) == false) {
			System.out.println("No puedes usar pan sin tostarr");
			return false;
		}

		if (cliente.getPedido().contains("Hamburguesa")) {
			inventario.consumirIngrediente(pan);
			inventario.consumirIngrediente(carne);
			return true;
		}
		return false;
	}

	// Preparamos todos los ingredientes del combo
	public boolean prepararCombo(Lechuga lechuga, Carne carne, Pan pan) {
		if (!ingredientePreparado(lechuga)) {
			System.out.println("Lechuga no lavada.");
			return false;
		}
		if (!ingredientePreparado(carne)) {
			System.out.println("Carne cruda.");
			return false;
		}
		if (!ingredientePreparado(pan)) {
			System.out.println("Pan no tostado.");
			return false;
		}

		// Reducimos el inventario de los ingredientes
		inventario.consumirIngrediente(lechuga);
		inventario.consumirIngrediente(carne);
		inventario.consumirIngrediente(pan);

		return true;
	}

}
