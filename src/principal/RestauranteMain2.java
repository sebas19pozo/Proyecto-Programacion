package principal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RestauranteMain2 {

    // Método para mostrar inventario de manera claraa
    public static void mostrarInventario(Inventario inventario) {
        System.out.println("\n--- Inventario ---");
        int lech = 0, carne = 0, pan = 0;
        for (Ingrediente ing : inventario.inventario) {
            if (ing instanceof Lechuga) lech++;
            else if (ing instanceof Carne) carne++;
            else if (ing instanceof Pan) pan++;
        }
        System.out.println("Lechugas: " + lech);
        System.out.println("Carnes: " + carne);
        System.out.println("Panes: " + pan);
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int dia = 1;
        boolean juegoActivo = true;

        // Crear inventario inicial
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        Inventario inventario = new Inventario(ingredientes, 50.0);
        inventario.agregarIngrediente(new Lechuga("Lechuga", false, 1), 5);
        inventario.agregarIngrediente(new Carne("Carne", false, 1), 5);
        inventario.agregarIngrediente(new Pan("Pan", false, 1), 5);

        TiendaMejoras tienda = new TiendaMejoras();

        System.out.println("=== ¡Bienvenido a tu juego de cocina! ===");

        while (juegoActivo) {
            System.out.println("\n--- Día " + dia + " ---");

            // Clientes incrementales por día
            int clientesHoy = 2 + (dia - 1); 
            Partida partida = new Partida(null, 0, inventario);

            for (int i = 0; i <= clientesHoy; i++) {
                System.out.println("\nCliente " + i + " entra.");
                String pedido = partida.atenderCliente();
                boolean pedidoCompletado = false;

                while (!pedidoCompletado) {
                    System.out.println("\nDinero: " + inventario.dinero + " €." );
                    mostrarInventario(inventario);
                    System.out.println("Pedido del cliente: " + pedido);
                    System.out.println("\n¿Qué quieres hacer?");
                    System.out.println("1. Lavar Lechuga");
                    System.out.println("2. Cocinar Carne");
                    System.out.println("3. Tostar Pan");
                    System.out.println("4. Servir Pedido");
                    System.out.println("5. Comprar Ingredientes");

                    int opcion = 0;
                    try {
                        opcion = teclado.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Debes introducir un número.");
                        teclado.next(); 
                        
                    }
                    switch (opcion) {
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
                            if (!lavada) System.out.println("No hay lechugas disponibles para lavar.");
                            break;

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
                            if (!cocida) System.out.println("No hay carne disponible para cocinar.");
                            break;

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
                            if (!tostado) System.out.println("No hay pan disponible para tostar.");
                            break;

                        case 4:

                            try {

                                Lechuga lechugaLista = null;
                                Carne carneLista = null;
                                Pan panListo = null;

                                // Buscar lechuga lavada
                                for (Ingrediente ing : inventario.inventario) {
                                    if (ing instanceof Lechuga && ing.isPreparado()) {
                                        lechugaLista = (Lechuga) ing;
                                        break;
                                    }
                                }

                                // Buscar carne y pan preparados
                                for (Ingrediente ing : inventario.inventario) {
                                    if (ing instanceof Carne && ing.isPreparado() && carneLista == null)
                                        carneLista = (Carne) ing;

                                    if (ing instanceof Pan && ing.isPreparado() && panListo == null)
                                        panListo = (Pan) ing;
                                }

                                // Validamos si el pedido contiene todos los platos

                                if (pedido.contains("Hamburguesa") && pedido.contains("Ensalada")) {

                                    if (lechugaLista == null || carneLista == null || panListo == null)
                                        throw new PedidoIncompletoException("El combo no está completamente preparado.");

                                    // Consumir ingredientes
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

                                // Cobrar el pedido

                                double pago = 10;

                                if (pedido.equals("Ensalada"))
                                    pago *= tienda.getMultiplicadorLechuga();

                                if (pedido.equals("Hamburguesa"))
                                    pago *= tienda.getMultiplicadorCarne() * tienda.getMultiplicadorPan();

                                if (pedido.equals("Hamburguesa + Ensalada"))
                                    pago *= tienda.getMultiplicadorCarne()
                                            * tienda.getMultiplicadorPan()
                                            * tienda.getMultiplicadorLechuga();

                                inventario.dinero += pago;

                                System.out.println("¡Pedido completado! Ganaste: " + pago + " €.");
                                partida.puntuacion++;
                                pedidoCompletado = true;

                            } catch (PedidoIncompletoException e) {
                                System.out.println("Error: " + e.getMessage());
                            }

                            break;
                    
//                            boolean sePuedeServir = true;
//
//                            // --- Preparar ensalada si está en el pedido ---
//                            if (pedido.contains("Ensalada")) {
//                  
//                            	boolean ensaladaLista = false;
//                                for (Ingrediente ing : inventario.inventario) {
//                                    if (ing instanceof Lechuga) {
//                                        ensaladaLista = partida.prepararEnsalada((Lechuga) ing);
//                                        if (ensaladaLista) break; // consumimos solo la lechuga necesaria
//                                    }
//                                }
//                                if (!ensaladaLista) {
//                                    System.out.println("No tienes ensalada lista.");
//                                    sePuedeServir = false;
//                                }
//                            }
//
//                            // --- Preparar hamburguesa si está en el pedido ---
//                            if (pedido.contains("Hamburguesa")) {
//                                Carne carneLista = null;
//                                Pan panListo = null;
//
//                                // Buscar carne y pan listos
//                                for (Ingrediente ing : inventario.inventario) {
//                                    if (ing instanceof Carne && ing.isPreparado() && carneLista == null) {
//                                        carneLista = (Carne) ing;
//                                    }
//                                    if (ing instanceof Pan && ing.isPreparado() && panListo == null) {
//                                        panListo = (Pan) ing;
//                                    }
//                                    if (carneLista != null && panListo != null) break;
//                                }
//
//                                // Llamar a prepararHamburguesa solo si ambos están listos
//                                if (carneLista != null && panListo != null) {
//                                    partida.prepararHamburguesa(carneLista, panListo); // aquí se consumen carne y pan
//                                } else {
//                                    System.out.println("Te falta carne o pan para la hamburguesa.");
//                                    sePuedeServir = false;
//                                }
//                            }
//
//                            // --- Cobrar al cliente si todo está listo ---
//                            if (sePuedeServir) {
//                                double pago = 10;
//                                if (pedido.equals("Ensalada")) pago *= tienda.getMultiplicadorLechuga();
//                                if (pedido.equals("Hamburguesa")) pago *= tienda.getMultiplicadorCarne() * tienda.getMultiplicadorPan();
//                                if	(pedido.equals("Hamburguesa + Ensalada"))
//                                inventario.dinero += pago;
//                                System.out.println("¡Pedido completado! Ganaste: " + pago + " €.");
//                                partida.puntuacion++;
//                            }
//                            break;
                        case 5:
                            boolean comprando = true;
                            while (comprando) {
                                System.out.println("\n--- Comprar Ingredientes ---");
                                System.out.println("Dinero disponible:" + inventario.dinero + " €.");
                                System.out.println("1. Comprar Lechuga (5€ cada unidad)");
                                System.out.println("2. Comprar Carne (7€ cada unidad)");
                                System.out.println("3. Comprar Pan (3€ cada unidad)");
                                System.out.println("4. Salir");
                                int comprar = teclado.nextInt();
                                int cantidad;
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
                            }
                            break;

                        default:
                            System.out.println("Opción inválida.");
                    }
                }
            }

            // Fin del día
            System.out.println("\nFin del día " + dia);
            System.out.println("Clientes atendidos hoy: " + partida.puntuacion);
            System.out.println("Dinero disponible: " + inventario.dinero + " €.");

            // Tienda de mejoras
            System.out.println("\n¿Quieres entrar a la tienda de mejoras? (1 = Sí, 2 = No)");
            int tiendaOpcion = teclado.nextInt();
            if (tiendaOpcion == 1) {
                boolean enTienda = true;
                while (enTienda) {
                    System.out.println("\n=== Tienda de mejoras ===");
                    System.out.println("Dinero disponible: $" + inventario.dinero);
                    System.out.println("1. Mejorar la calidad de la lechuga (Nivel " + tienda.getNivelLechuga() + ") Precio: " + tienda.getPrecioLechuga() + " €.");
                    System.out.println("2. Mejorar la calidad de la carne (Nivel " + tienda.getNivelCarne() + ") Precio: " + tienda.getPrecioCarne()+  " €.");
                    System.out.println("3. Mejorar la calidad del pan (Nivel " + tienda.getNivelPan() + ") Precio: " + tienda.getPrecioPan()+ " €.");
                    System.out.println("4. Salir de la tienda");
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
                }
            }

            System.out.println("\n¿Quieres continuar al siguiente día? (1 = Sí, 2 = No)");
            int continuar = teclado.nextInt();
            if (continuar != 1) juegoActivo = false;
            dia++;
        }

        System.out.println("\n¡Gracias por jugar! Ganaste un total de " + inventario.dinero + " €.");
        teclado.close();
    }
}

