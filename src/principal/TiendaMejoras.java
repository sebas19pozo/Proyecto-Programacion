package principal;

public class TiendaMejoras {

    private int nivelLechuga;
    private int nivelCarne;
    private int nivelPan;

    private double precioLechuga;
    private double precioCarne;
    private double precioPan;

    public TiendaMejoras() {
        nivelLechuga = 0;
        nivelCarne = 0;
        nivelPan = 0;
        precioLechuga = 20;
        precioCarne = 25;
        precioPan = 15;
    }

    // Métodos para comprar mejoras
    public double comprarLechuga(double dinero) {
        if(dinero >= precioLechuga) {
            dinero -= precioLechuga;
            nivelLechuga++;
            precioLechuga *= 1.5;
            System.out.println("Mejora de lechuga comprada! Nivel actual: " + nivelLechuga);
        } else {
            System.out.println("No tienes suficiente dinero.");
        }
        return dinero;
    }

    public double comprarCarne(double dinero) {
        if(dinero >= precioCarne) {
            dinero -= precioCarne;
            nivelCarne++;
            precioCarne *= 1.5;
            System.out.println("Mejora de carne comprada! Nivel actual: " + nivelCarne);
        } else {
            System.out.println("No tienes suficiente dinero.");
        }
        return dinero;
    }

    public double comprarPan(double dinero) {
        if(dinero >= precioPan) {
            dinero -= precioPan;
            nivelPan++;
            precioPan *= 1.5;
            System.out.println("Mejora de pan comprada! Nivel actual: " + nivelPan);
        } else {
            System.out.println("No tienes suficiente dinero.");
        }
        return dinero;
    }

    // Multiplicadores de pago por mejoras
    public double getMultiplicadorLechuga() { return 1 + (0.2 * nivelLechuga); }
    public double getMultiplicadorCarne() { return 1 + (0.2 * nivelCarne); }
    public double getMultiplicadorPan() { return 1 + (0.2 * nivelPan); }

    // Precios actuales
    public double getPrecioLechuga() { return precioLechuga; }
    public double getPrecioCarne() { return precioCarne; }
    public double getPrecioPan() { return precioPan; }

    // **Getters de nivel (corregidos)**
    public int getNivelLechuga() { return nivelLechuga; }
    public int getNivelCarne() { return nivelCarne; }
    public int getNivelPan() { return nivelPan; }
}
