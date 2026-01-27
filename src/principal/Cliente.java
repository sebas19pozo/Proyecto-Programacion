package principal;

public class Cliente {

	String nombre;
	String pedido;
	
	
	public Cliente(String nombre, String pedido) {
		super();
		this.nombre = nombre;
		this.pedido = pedido;
	}
	
	
	
	public void hacerPedido() {
	  
		int opcion = (int)(Math.random() * 100);

	    if (opcion < 25) {
	        pedido = "ensalada";
	    } else if (opcion < 50){
	        pedido = "hamburguesa";
	    }else {
	    	pedido = "Hamburgesa + Ensalada";
	    }
	}


}
