package prpizzeria.Entidades;

import java.util.Random;

public abstract class Producto {
    protected Fabricante fabricante;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;
    protected static Random generadorAleatorio;

    // Constructor principal
    public Producto(String nombre, double precio, Fabricante fabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
        this.calorias = 0;
        this.tiempoPreparacion = 0;
    }

    // Constructor alternativo con nombre de fabricante
    public Producto(String nombre, double precio, String nombreFabricante, 
                    String ciudadFabricante, int antiguedadFabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = new Fabricante(nombreFabricante, ciudadFabricante, 
                                          antiguedadFabricante);
        this.calorias = 0;
        this.tiempoPreparacion = 0;
    }
    
    static {
        generadorAleatorio = new Random();
    }
    
    public int getCalorias() {
        if (this.calorias == 0) {
            int min = 200;
            int max = 800;
            this.calorias = generadorAleatorio.nextInt(max - min + 1) + min;
        }
        return this.calorias;
    }
    
    public int getTiempoPreparacion() {
        if (this.tiempoPreparacion == 0) {
            int min = 5;
            int max = 20;
            this.tiempoPreparacion = generadorAleatorio.nextInt(max - min + 1) + min;
        }
        return this.tiempoPreparacion;
    }
    
    private static String mostrar(Producto p) {
        return "Producto: " + p.nombre + 
               " | Precio Base: $" + p.precio +
               " | Calorías: " + p.getCalorias() +
               " | Tiempo Prep: " + p.getTiempoPreparacion() + " min" +
               " | Fabricante: (" + p.fabricante.toString() + ")";
    }
    
    private static boolean sonIguales(Producto p1, Producto p2) {
        boolean nombresIguales = p1.nombre.equals(p2.nombre);
        boolean fabricantesIguales = Fabricante.sonIguales(p1.fabricante, p2.fabricante);
        return nombresIguales && fabricantesIguales;
    }

    @Override
    public boolean equals(Object obj) {
        // CORREGIDO: según enunciado, solo compara nombre y fabricante
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Producto)) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Producto.sonIguales(this, other);
    }
    
    @Override
    public String toString() {
        return Producto.mostrar(this);
    }
}
