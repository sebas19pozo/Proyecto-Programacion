package principal;

public class Cliente {
	//Definimos los atributos: Como nombre entendemos el número de cliente del día.
	String nombre;
	String pedido;
	
	//Inicializamos el constructor
	public Cliente(String nombre, String pedido) {
		this.nombre = nombre;
		this.pedido = pedido;
	}
	
	//Obtenemos los getters y setters.
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

	//Método con el cual el cliente hace pedidos de forma aleatoria.
	public void hacerPedido() {
		int opcion = (int)(Math.random() * 100);

	    if (opcion < 25) {
	        pedido = "Ensalada";
	    } else if (opcion < 50){
	        pedido = "Hamburguesa";
	    }else {
	    	pedido = "Hamburguesa + Ensalada";
	    }
	    
	}


}
