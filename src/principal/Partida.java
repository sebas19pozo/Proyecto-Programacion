package principal;

public class Partida {

	Cliente cliente;
	int puntuacion;
	Inventario inventario;
	
	static int clientesAtendidos;
	
	
	public Partida(Cliente cliente, int puntuacion, Inventario inventario) {
		this.cliente = cliente;
		this.puntuacion = puntuacion;
		this.inventario = inventario;
	}

	
	

	public String atenderCliente() {
		
		cliente = new Cliente("Cliente " + clientesAtendidos, "");
		cliente.hacerPedido();
	
		
		System.out.println(cliente.getNombre() +" Ha pedido "+cliente.getPedido());
		clientesAtendidos++;
		return cliente.getPedido();
		
	}
	
	
	public boolean ingredienteLavadoC(Ingrediente ingrediente) {
		
		return ingrediente.isPreparado();
	}
	
	
	public boolean prepararEnsalada(Lechuga lechuga) {
			
			if(ingredienteLavadoC(lechuga)==false) {
				
				
				return false;
			}
		
			if (cliente.getPedido().contains("Ensalada")) {
				inventario.consumirIngrediente(lechuga);
				return true ;
			}
			return false;
		}
	
	public boolean prepararHamburguesa(Carne carne, Pan pan) {
		
		if(ingredienteLavadoC(carne)==false) {
			
			System.out.println("No puedes usar una carne cruda");
			return false;
		}else if(ingredienteLavadoC(pan)==false) {
			System.out.println("No puedes usar pan sin tostarr");
			return false;
		}
		
		if (cliente.getPedido().contains("Hamburguesa")) {
			inventario.consumirIngrediente(pan);
			inventario.consumirIngrediente(carne);
			return true ;
		}
		return false;
	}

	public boolean prepararCombo(Lechuga lechuga, Carne carne, Pan pan) {
	    // Validar todos los ingredientes primero
	    if (!ingredienteLavadoC(lechuga)) {
	        System.out.println("Lechuga no lavada.");
	        return false;
	    }
	    if (!ingredienteLavadoC(carne)) {
	        System.out.println("Carne cruda.");
	        return false;
	    }
	    if (!ingredienteLavadoC(pan)) {
	        System.out.println("Pan no tostado.");
	        return false;
	    }

	    // Consumir todos al mismo tiempo
	    inventario.consumirIngrediente(lechuga);
	    inventario.consumirIngrediente(carne);
	    inventario.consumirIngrediente(pan);

	    return true;
	}
	
	
}
