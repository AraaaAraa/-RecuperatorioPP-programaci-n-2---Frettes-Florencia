package prpizzeria.Entidades;

import java.util.ArrayList;
import java.util.Iterator;

public class Pizzeria implements Iterable<Producto> {
    private String nombre;
    private int capacidad;
    private ArrayList<Producto> productos;

    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.capacidad = 3;
        this.productos = new ArrayList<>();
    }

    public Pizzeria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }
    
    private boolean sonIguales(Producto p) {
        for (Producto producto : this.productos) {
            if (producto.equals(p)) {
                return true;
            }
        }
        return false;
    }
    
    public void agregar(Producto p) {
        if (this.sonIguales(p)) {
            System.out.println("ERROR: El producto ya existe en la pizzería.");
        } else if (this.productos.size() >= this.capacidad) {
            System.out.println("ERROR: No se puede agregar el producto. Capacidad máxima alcanzada.");
        } else {
            this.productos.add(p);
        }
    }
    
    private double getPrecioProductos(TipoProducto tipo) {
        switch(tipo) {
            case PIZZAS:
                return this.getPrecioDePizzas();
            case POSTRES:
                return this.getPrecioDePostres();
            case TODOS:
                return this.getPrecioTotal();
            default:
                return 0.0;
        }
    }
    
    private double getPrecioDePizzas() {
        double total = 0.0;
        for (Producto p : this.productos) {
            if (p instanceof Pizza) {
                total += ((Pizza) p).getPrecioTotal();
            }
        }
        return total;
    }
    
    private double getPrecioDePostres() {
        double total = 0.0;
        for (Producto p : this.productos) {
            if (p instanceof Postre) {
                total += ((Postre) p).getPrecioTotal();
            }
        }
        return total;
    }
    
    private double getPrecioTotal() {
        return this.getPrecioDePizzas() + this.getPrecioDePostres();
    }
    
    @Override
    public Iterator<Producto> iterator() {
        return this.productos.iterator();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPizzería: ").append(this.nombre);
        sb.append("\nCapacidad: ").append(this.capacidad);
        sb.append("\nCantidad de productos: ").append(this.productos.size());
        sb.append("\n\n----- DETALLE DE PRODUCTOS -----\n");
        
        for (Producto p : this.productos) {
            sb.append(p.toString()).append("\n");
        }
        
        sb.append("\n----- PRECIOS TOTALES -----");
        sb.append("\nTotal Pizzas: $").append(String.format("%.2f", this.getPrecioDePizzas()));
        sb.append("\nTotal Postres: $").append(String.format("%.2f", this.getPrecioDePostres()));
        sb.append("\nTotal General: $").append(String.format("%.2f", this.getPrecioTotal()));
        
        return sb.toString();
    }
}
