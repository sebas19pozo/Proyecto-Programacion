package principal;

public class Cliente {

	String nombre;
	String pedido;
	
	
	public Cliente(String nombre, String pedido) {
		super();
		this.nombre = nombre;
		this.pedido = pedido;
	}
	
	
	
	
	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getPedido() {
		return pedido;
	}




	public void setPedido(String pedido) {
		this.pedido = pedido;
	}




	public void hacerPedido(String pedido) {
	  
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
