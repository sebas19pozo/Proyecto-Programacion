package principal;

import java.util.ArrayList;

public class Inventario {

    ArrayList<Ingrediente> inventario = new ArrayList<>();
    double dinero;

    public Inventario(ArrayList<Ingrediente> inventario, double dinero) {
        this.inventario = inventario;
        this.dinero = dinero;
    }

    public void agregarIngrediente(Ingrediente ingrediente, int cantidad) {
        for(int i = 0; i < cantidad; i++) {
            inventario.add(ingrediente);
        }
    }

    public boolean consumirIngrediente(Ingrediente cualquiera) {
        for(int i = 0; i < inventario.size(); i++) {
            if(inventario.get(i).getClass() == cualquiera.getClass()) {
                inventario.remove(i);
                System.out.println("Usaste 1x " + cualquiera.getNombre());
                return true;
            }
        }
        return false;
    }

    // Método para comprar ingredientes
    public void comprarIngrediente(String tipo, int cantidad) {
        double precioUnitario = 0;
        Ingrediente nuevoIngrediente = null;

        switch(tipo.toLowerCase()) {
            case "lechuga":
                precioUnitario = 5;
                nuevoIngrediente = new Lechuga("Lechuga", false, 1);
                break;
            case "carne":
                precioUnitario = 7;
                nuevoIngrediente = new Carne("Carne", false, 1);
                break;
            case "pan":
                precioUnitario = 3;
                nuevoIngrediente = new Pan("Pan", false, 1);
                break;
            default:
                System.out.println("Ingrediente inválido.");
                return;
        }

        double costoTotal = precioUnitario * cantidad;
        if(dinero >= costoTotal) {
            agregarIngrediente(nuevoIngrediente, cantidad);
            dinero -= costoTotal;
            System.out.println("Compraste " + cantidad + " " + tipo + "(s) por $" + costoTotal);
        } else {
            System.out.println("No tienes suficiente dinero para comprar " + cantidad + " " + tipo + "(s).");
        }
    }
}
//ASDHAJVDA
