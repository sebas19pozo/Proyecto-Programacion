package principal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RestauranteMain2 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int dia = 1;
		boolean juegoActivo = true;

		// Crear inventario inicial de los ingredientes
		ArrayList<Ingrediente> ingredientes = new ArrayList<>();
		Inventario inventario = new Inventario(ingredientes, 50.0);
		inventario.agregarIngrediente(new Lechuga("Lechuga", false, 1), 5);
		inventario.agregarIngrediente(new Carne("Carne", false, 1), 5);
		inventario.agregarIngrediente(new Pan("Pan", false, 1), 5);

		TiendaMejoras tienda = new TiendaMejoras();

		System.out.println("=== ¡Bienvenido a tu juego de cocina! ===");

		while (juegoActivo) {
			System.out.println("\n--- Día " + dia + " ---");

			// Clientes que incrementan por día. El primer día tenemos 2 clientes y aumenta
			// progresivamente.
			int clientesHoy = 2 + (dia - 1);
			Partida partida = new Partida(null, 0, inventario);
			System.out.println(clientesHoy);
			for (int i = 0; i < clientesHoy; i++) {
				System.out.println("\nCliente " + (i + 1) + " entra.");

				String pedido = partida.atenderCliente();
				boolean pedidoCompletado = false;
				// Mostramos el menú de nuevo si el pedido no está completo.
				while (!pedidoCompletado) {
					System.out.println("\nDinero: " + inventario.dinero + " €.");
					mostrarInventario(inventario);
					System.out.println("Pedido del cliente: " + pedido);
					System.out.println("\n¿Qué quieres hacer?");
					System.out.println("1. Lavar Lechuga");
					System.out.println("2. Cocinar Carne");
					System.out.println("3. Tostar Pan");
					System.out.println("4. Servir Pedido");
					System.out.println("5. Comprar Ingredientes");

					int opcion = 0;
					// Lanzamos la excepción.
					try {
						opcion = teclado.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("Error: Debes introducir un número.");
						teclado.next();
					}
					// Creamos todos los casos de nuestro menú.
					switch (opcion) {

					// Lavamos la lechuga.
					case 1:
						boolean lavada = false;
						for (Ingrediente ing : inventario.inventario) {
							if (ing instanceof Lechuga && !ing.isPreparado()) {
								Lechuga l = (Lechuga) ing;
								l.lavar(true);
								l.setPreparado(true);
								System.out.println("Lavaste una lechuga.");
								lavada = true;
								break;
							}
						}
						if (!lavada)
							System.out.println("No hay lechugas disponibles para lavar.");
						break;
					// Cocinamos la carne.
					case 2:
						boolean cocida = false;
						for (Ingrediente ing : inventario.inventario) {
							if (ing instanceof Carne && !ing.isPreparado()) {
								Carne c = (Carne) ing;
								c.cocinar(true);
								c.setPreparado(true);
								System.out.println("Cocinaste una carne.");
								cocida = true;
								break;
							}
						}
						if (!cocida)
							System.out.println("No hay carne disponible para cocinar.");
						break;
					// Tostamos el pan.
					case 3:
						boolean tostado = false;
						for (Ingrediente ing : inventario.inventario) {
							if (ing instanceof Pan && !ing.isPreparado()) {
								Pan p = (Pan) ing;
								p.tostar(true);
								p.setPreparado(true);
								System.out.println("Tostaste un pan.");
								tostado = true;
								break;
							}
						}
						if (!tostado)
							System.out.println("No hay pan disponible para tostar.");
						break;
					// Servimos el pedido al cliente
					case 4:

						// Lanzamos la excepción si se intenta entregar al cliente un pedido que no esté completo.
						try {
							Lechuga lechugaLista = null;
							Carne carneLista = null;
							Pan panListo = null;

							// Buscamos la lechuga lavada
							for (Ingrediente ing : inventario.inventario) {
								if (ing instanceof Lechuga && ing.isPreparado()) {
									lechugaLista = (Lechuga) ing;
									break;
								}
							}

							// Buscamos la carne y pan preparados
							for (Ingrediente ing : inventario.inventario) {
								if (ing instanceof Carne && ing.isPreparado() && carneLista == null)
									carneLista = (Carne) ing;

								if (ing instanceof Pan && ing.isPreparado() && panListo == null)
									panListo = (Pan) ing;
							}

							// Validamos si el pedido contiene todos los platos. Si no está preparado, lanzamos al excepción.

							if (pedido.contains("Hamburguesa") && pedido.contains("Ensalada")) {

								if (lechugaLista == null || carneLista == null || panListo == null)
									throw new PedidoIncompletoException("El combo no está completamente preparado.");

								// Consumimos los ingredientes del pedido
								inventario.inventario.remove(lechugaLista);
								inventario.inventario.remove(carneLista);
								inventario.inventario.remove(panListo);
							}

							else if (pedido.contains("Hamburguesa")) {

								if (carneLista == null || panListo == null)
									throw new PedidoIncompletoException("La hamburguesa no está preparada.");

								inventario.inventario.remove(carneLista);
								inventario.inventario.remove(panListo);
							}

							else if (pedido.contains("Ensalada")) {

								if (lechugaLista == null)
									throw new PedidoIncompletoException("La ensalada no está preparada.");

								inventario.inventario.remove(lechugaLista);
							}

							// Cobramos el pedido entregado
							double pago = 10;

							if (pedido.equals("Ensalada"))
								pago *= tienda.getMultiplicadorLechuga();

							if (pedido.equals("Hamburguesa"))
								pago *= tienda.getMultiplicadorCarne() * tienda.getMultiplicadorPan();

							if (pedido.equals("Hamburguesa + Ensalada"))
								pago *= tienda.getMultiplicadorCarne() * tienda.getMultiplicadorPan()
										* tienda.getMultiplicadorLechuga();

							inventario.dinero += pago;

							System.out.println("¡Pedido completado! Ganaste: " + pago + " €.");
							partida.puntuacion++;
							pedidoCompletado = true;

						} catch (PedidoIncompletoException e) {
							System.out.println("Error: " + e.getMessage());
						}

						break;
					// Compramos ingredientes en la tienda de mejoras
					case 5:
						boolean comprando = true;
						while (comprando) {
							System.out.println("\n--- Comprar Ingredientes ---");
							System.out.println("Dinero disponible:" + inventario.dinero + " €.");
							System.out.println("1. Comprar Lechuga (5€ cada unidad)");
							System.out.println("2. Comprar Carne (7€ cada unidad)");
							System.out.println("3. Comprar Pan (3€ cada unidad)");
							System.out.println("4. Salir");

							int cantidad;
							// Excepción para asegurar el funcionamiento correcto
							try {
								int comprar = teclado.nextInt();

								// Compramos la cantidad de ingrediente que necesitamso para nuestro
								// restaurante.
								switch (comprar) {
								case 1:
									System.out.println("Cantidad a comprar:");
									cantidad = teclado.nextInt();
									inventario.comprarIngrediente("lechuga", cantidad);
									break;
								case 2:
									System.out.println("Cantidad a comprar:");
									cantidad = teclado.nextInt();
									inventario.comprarIngrediente("carne", cantidad);
									break;
								case 3:
									System.out.println("Cantidad a comprar:");
									cantidad = teclado.nextInt();
									inventario.comprarIngrediente("pan", cantidad);
									break;
								case 4:
									comprando = false;
									break;
								default:
									System.out.println("Opción inválida.");
								}

							} catch (InputMismatchException e) {
								System.out.println("Error: Debes introducir un número.");
								teclado.next();
							}
						}
					}
				}
			}

			// Fin del día
			System.out.println("\nFin del día " + dia);
			System.out.println("Clientes atendidos hoy: " + partida.puntuacion);
			System.out.println("Dinero disponible: " + inventario.dinero + " €.");

			// Acceso a la tienda de mejoras
			System.out.println("\n¿Quieres entrar a la tienda de mejoras? (1 = Sí, 2 = No)");
			int tiendaOpcion = 0;
			boolean entradaValida = false;

			// Excepción para asegurar el funcionamiento correcto
			try {
				tiendaOpcion = teclado.nextInt();
				if (tiendaOpcion == 1 || tiendaOpcion == 2) {
					entradaValida = true;
				} else {
					System.out.println("Opción inválida. Introduce 1 o 2.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Debes introducir un número.");
				teclado.next();
			}
			if (tiendaOpcion == 1) {
				boolean enTienda = true;
				while (enTienda) {
					System.out.println("\n=== Tienda de mejoras ===");
					System.out.println("Dinero disponible: " + inventario.dinero + " €.");
					System.out.println("1. Mejorar la calidad de la lechuga (Nivel " + tienda.getNivelLechuga()
							+ ") Precio: " + tienda.getPrecioLechuga() + " €.");
					System.out.println("2. Mejorar la calidad de la carne (Nivel " + tienda.getNivelCarne()
							+ ") Precio: " + tienda.getPrecioCarne() + " €.");
					System.out.println("3. Mejorar la calidad del pan (Nivel " + tienda.getNivelPan() + ") Precio: "
							+ tienda.getPrecioPan() + " €.");
					System.out.println("4. Salir de la tienda");

					// Lanzamos la excepción si no se intruduce un número
					try {
						int op = teclado.nextInt();

						switch (op) {
						case 1:
							inventario.dinero = tienda.comprarLechuga(inventario.dinero);
							break;
						case 2:
							inventario.dinero = tienda.comprarCarne(inventario.dinero);
							break;
						case 3:
							inventario.dinero = tienda.comprarPan(inventario.dinero);
							break;
						case 4:
							enTienda = false;
							break;
						default:
							System.out.println("Opción inválida.");
						}
					} catch (InputMismatchException e) {
						System.out.println("Error: Debes introducir un número.");
						teclado.next();
					}
				}
			}
			// Menú para hacer las mejoras en el restaurante
			boolean entradaValida1 = false;

			while (!entradaValida1) {
				System.out.println("\n¿Quieres continuar al siguiente día? (1 = Sí, 2 = No)");
				// Lanzamos la excepción si no se introduce un número
				try {
					int continuar = teclado.nextInt();

					if (continuar == 1) {
						dia++;
						entradaValida1 = true;
					} else if (continuar == 2) {
						juegoActivo = false;
						entradaValida1 = true;
					} else {
						System.out.println("Opción inválida.");
					}

				} catch (InputMismatchException e) {
					System.out.println("Error: Debes introducir un número.");
					teclado.next();
				}
			}
			// Si el juego no está activo sale del restaurante. Salimos del while principal.
			if (!juegoActivo) {
				break;
			}
		}

		System.out.println("\n¡Gracias por jugar! Ganaste un total de " + inventario.dinero + " €.");
		teclado.close();
	}

	// Método con el que mostramos el inventario del restaurante
	public static void mostrarInventario(Inventario inventario) {
		System.out.println("\n--- Inventario ---");
		int lech = 0, carne = 0, pan = 0;
		for (Ingrediente ing : inventario.inventario) {
			if (ing instanceof Lechuga)
				lech++;
			else if (ing instanceof Carne)
				carne++;
			else if (ing instanceof Pan)
				pan++;
		}
		System.out.println("Lechugas: " + lech);
		System.out.println("Carnes: " + carne);
		System.out.println("Panes: " + pan);
	}

}
