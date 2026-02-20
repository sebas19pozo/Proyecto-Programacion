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
				
				System.out.println("No puedes usar un ingrediente sin preparar");
				return false;
			}
		
			if (cliente.getPedido().equals("Ensalada")) {
				
				return true ;
			}
			return false;
		}
	
	
	
}
