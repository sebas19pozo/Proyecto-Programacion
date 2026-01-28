package principal;

import java.util.ArrayList;

public class Partida {

	Cliente cliente;
	ArrayList<Ingrediente> ingredientesDisponibles;
	int puntuacion;
	
	static int clientesAtendidos;
	static int puntuacionMaxima;
	
	public void atenderCliente() {
		
		String pedido = "";
		Cliente c = null;
		c = new Cliente("Cliente" + clientesAtendidos, pedido);
		c.hacerPedido(pedido);
		
		
	}
	
	public void prepararPedido(Cliente c) {
		
		System.out.println(c.getPedido());
		
		
		
	}
	
}
