package principal;

public class Partida {

	Cliente cliente;
	int puntuacion;
	Inventario inventario;
	
	static int clientesAtendidos;
	static int puntuacionMaxima;
	
	
	public Partida(Cliente cliente, int puntuacion, Inventario inventario) {
		this.cliente = cliente;
		this.puntuacion = puntuacion;
		this.inventario = inventario;
	}


	// Método para atender al cliente
	public void atenderCliente() {
		
		String pedido = "";
		Cliente c = null;
		c = new Cliente("Cliente" + clientesAtendidos, pedido);
		c.hacerPedido();
		
	}
	
	
	public boolean ingredienteLavadoC(Ingrediente ingrediente) {
		if(ingrediente.isPreparado()) {
			return true;
		}
		return false;
	}
	
	public Inventario getInventario() {
	    return inventario;
	}
  
	
	public boolean prepararEnsalada(Lechuga lechuga, Cliente c) {
			String pedido="";
			//comprobamos si el ingrediente está lavado
			if(ingredienteLavadoC(lechuga)) {
				pedido="Ensalada";
			}else {
				pedido="No puedes usar un ingrediente sin preparar";
			}
			
			
			if (c.getPedido().equals(pedido)) {
				
				
				return true ;
			}
			return false;
		}

			public boolean prepararHamburguesa(Lechuga lechuga, Carne carne, Pan pan, Cliente c) {
			    String pedido = "";

			    // Verificamos si la lechuga está lavada
			    if (ingredienteLavadoC(lechuga)) {
			        pedido = "Hamburguesa"; 
			    } else {
			        pedido = "No puedes usar un ingrediente sin preparar";
			    }

			    // Verificamos si la carne está cocinada
			    if (!carne.isPreparado()) {
			        pedido = "No puedes usar un ingrediente sin preparar";
			    }

			    // Verificamos si el pan está tostado
			    if (!pan.isPreparado()) {
			        pedido = "No puedes usar un ingrediente sin preparar";
			    }

			    // Comprobamos si el pedido del cliente coincide con los ingredientes preparados
			    if (c.getPedido().equals("Hamburguesa") && pedido.equals("Hamburguesa")) {
			        return true; // Todo listo, hamburguesa preparada
			    }

			    return false; // Algún ingrediente no estaba preparado

	}
	
	public void incrementarPuntuacion(int puntos) {
	    this.puntuacion += puntos;
	}

	
}
