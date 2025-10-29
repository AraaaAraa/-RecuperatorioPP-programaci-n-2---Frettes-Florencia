package prpizzeria.Entidades;

public class Postre extends Producto implements IVendible {
    private TipoPostre tipoPostre;

    // Constructor que coincide con el main
    public Postre(String nombre, double precio, Fabricante fabricante, 
                  TipoPostre tipoPostre) {
        super(nombre, precio, fabricante);
        this.tipoPostre = tipoPostre;  // CORREGIDO: faltaba inicializar
    }
    
    @Override
    public double getPrecioTotal() {
        double precioFinal = this.precio;
        switch(this.tipoPostre) {
            case TIRAMISU -> precioFinal = precio * 1.20;
            case HELADO -> precioFinal = precio * 1.15;
            case FLAN -> precioFinal = precio * 1.10;
        } 
        return precioFinal;
    }

    @Override
    public String toString() {
        String infoProducto = super.toString();
        return infoProducto + " | Tipo: " + this.tipoPostre + 
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
        final Postre other = (Postre) obj;
        return this.tipoPostre == other.tipoPostre;
    }
}
