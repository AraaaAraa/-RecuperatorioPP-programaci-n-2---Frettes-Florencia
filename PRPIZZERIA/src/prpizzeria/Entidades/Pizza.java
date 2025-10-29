package prpizzeria.Entidades;

public class Pizza extends Producto implements IVendible {
    private TipoPizza sabor;
    private TamanoPizza tamano;

    // Constructor que coincide con el main
    public Pizza(String nombre, double precio, Fabricante fabricante, 
                 TipoPizza sabor, TamanoPizza tamano) {
        super(nombre, precio, fabricante);
        this.sabor = sabor;      // CORREGIDO: faltaba inicializar
        this.tamano = tamano;    // CORREGIDO: faltaba inicializar
    }
    
    @Override
    public double getPrecioTotal() {
        double precioFinal = this.precio;
        switch(this.tamano) {
            case CHICA -> precioFinal = precio * 1.05;
            case MEDIANA -> precioFinal = precio * 1.10;
            case GRANDE -> precioFinal = precio * 1.20;
        } 
        return precioFinal;
    }

    @Override
    public String toString() {
        String infoProducto = super.toString();
        return infoProducto + " | Sabor: " + this.sabor + 
               " | Tamaño: " + this.tamano + 
               " | Precio Total: $" + this.getPrecioTotal();
    }

    @Override
    public boolean equals(Object obj) {
        // CORREGIDO: primero verifica que sean productos iguales
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pizza other = (Pizza) obj;
        if (this.sabor != other.sabor) {
            return false;
        }
        return this.tamano == other.tamano;
    }
}