package principal;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RestauranteMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===== CREAR INVENTARIO =====
        ArrayList<Ingrediente> lista = new ArrayList<>();
        lista.add(new Lechuga());
        lista.add(new Lechuga());
        lista.add(new Carne());
        lista.add(new Pan());

        Inventario inventario = new Inventario(lista, 50);

        // ===== CREAR PARTIDA =====
        Partida partida = new Partida(null, 0, inventario);


