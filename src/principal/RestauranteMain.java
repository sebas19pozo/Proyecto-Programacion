package principal;

import java.util.Scanner;

public class RestauranteMain {
//NO SE ATIENDEN A LOS CLIENTES
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	        int opcion;
	        Cliente cliente = new Cliente("Cliente1", "pedidoEjemplo");
	        Inventario inventario = new Inventario();
	        int puntuacionInicial = 0;
	        Partida partida = new Partida(cliente, puntuacionInicial, inventario);

	        do {
	            menuInicio();
	            System.out.print("👉 Elige una opción: ");
	            opcion = sc.nextInt();

	            switch (opcion) {
	                case 1:
	                	boolean compra=true;
	                    menuTienda();
	                   opcion = sc.nextInt();
	                   switch (opcion) {
                       case 1: // Comprar Lechuga
                           Lechuga lechuga = new Lechuga("Lechuga", false, 1);
                           partida.getInventario().agregarIngrediente(lechuga, 1);
                           System.out.println("Compraste 1 unidad de lechuga.");
                           break;
                       case 2: // Comprar Carne
                           Carne carne = new Carne("Carne", false, 1);
                           partida.getInventario().agregarIngrediente(carne, 1);
                           System.out.println("Compraste 1 unidad de carne.");
                           break;
                       case 3: // Comprar Pan
                           Pan pan = new Pan("Pan", false, 1);
                           partida.getInventario().agregarIngrediente(pan, 1);
                           System.out.println("Compraste 1 unidad de pan.");
                           break;
                       case 4: // Volver al menú principal
                           compra = false;
                           break;
                       default:
                           System.out.println("❌ Opción inválida en tienda, intenta de nuevo.");
                   }
//	                   Lechuga l = new Lechuga();
//	                  // partida.ingredientesDisponibles.add(l,1);
//	                   partida.getInventario().agregarIngrediente(l, puntuacionInicial);
//	                   switch(opcion) {
//	                   
//	                   case 1: System.out.println("");
//	                       
//	                   }
	                case 2:
	                    System.out.println("\n⭐ Mostrando puntuación del restaurante...\n");
	                    break;
	                case 3:
	                	//HAY QUE MIRAR COMO HACEMOS PARA ATENDER AL CLIENTE
	                    
	                	cliente.hacerPedido();
	                	partida.clientesAtendidos++;
	                	
	                	System.out.println("Ha llegado el cliente");
	                	System.out.println("Pedido: " + cliente.getPedido());
	                	
	                	String pedido = cliente.getPedido();
	                	
	                	 if (pedido.equals("Ensalada") || pedido.equals("Hamburgesa")) {
	                		 for (Ingrediente i : partida.getInventario().getInventario()) {
	                	            if (i instanceof Lechuga) {
	                	            	 Lechuga lechuga = new Lechuga("Lechuga", false, 1);
	                	            	 lechuga.lavar(true);//creo que hay que quitar lo de boolean preparado
	                	            	 	
	                	            	 if (partida.prepararEnsalada(lechuga, cliente)) {
	                                         System.out.println("✅ Ensalada preparada correctamente para " + cliente.getNombre());//nombre? se lo vamos a pedir en algún nomento
	                                         partida.getInventario().consumirIngrediente(lechuga);
	                                         partida.puntuacion += 10;
	                                         break;
	                                     }
	                                 }
	                             }
	                	
	                	//HAY QUE HACER LO MISMO PARA HAMBURGUESA, yo vería si es mas facil hacerlo con la hamburguesa en stock sin necesidad de tener que hacerlo con ingredientes sueltos
	                	
	                	
	                	System.out.println("\n👋 Cerrando el restaurante... ¡Hasta mañana!\n");
	                    break;
	                default:
	                    System.out.println("\n❌ Opción no válida, intenta otra vez.\n");
	            }

	        } while (opcion != 3);

	        sc.close();
	    }

	    public static void menuInicio() {
	    	
	    	
	    	System.out.println("====================================");
	    	System.out.println("         BIENVENIDO AL RESTAURANTE");
	    	System.out.println("====================================");
	    	System.out.println();
	    	System.out.println("1 - Comprar ingredientes");
	    	System.out.println("2 - Mejorar ingredientes/equipo");
	    	System.out.println("3 - Abrir restaurante");
	    	System.out.println("4 - Salir");
	    	System.out.println();
	    	System.out.println("====================================");
	    	System.out.print("Elige una opción: ");

	    }
	    
	    public static void menuTienda() {
	    	System.out.println("====================================");
	    	System.out.println("           TIENDA DEL RESTAURANTE");
	    	System.out.println("====================================");
	    	System.out.println();
	    	System.out.println("1 - Comprar Lechuga");
	    	System.out.println("2 - Comprar Carne");
	    	System.out.println("3 - Comprar Pan");
	    	System.out.println("4 - Volver al menú principal");
	    	System.out.println();
	    	System.out.println("====================================");
	    	System.out.print("Elige una opción: ");

	    }
	}