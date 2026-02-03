package principal;

import java.util.ArrayList;

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
	
	
	public boolean prepararEnsalada(Lechuga lechuga, Cliente c) {
			String pedido="";
			
			if(ingredienteLavadoC(lechuga)) {
				pedido="Enselada";
			}else {
				pedido="No puedes usar un ingrediente sin preparar";
			}
			
			
			
			if (c.getPedido().equals(pedido)) {
				
				
				return true ;
			}
			return false;
		}
	
}
