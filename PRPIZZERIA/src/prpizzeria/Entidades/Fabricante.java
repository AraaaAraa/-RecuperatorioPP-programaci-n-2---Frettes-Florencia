package prpizzeria.Entidades;

public class Fabricante {
    private String nombre;
    private String ciudad;  
    private int antiguedad;

    public Fabricante(String nombre, String ciudad, int antiguedad) {
        this.nombre = nombre;
        this.ciudad = ciudad; 
        this.antiguedad = antiguedad;
    }
    
    public static boolean sonIguales(Fabricante x, Fabricante y) {
        boolean m = false;
        if (x.nombre.equals(y.nombre) && 
            x.ciudad.equals(y.ciudad) &&  
            x.antiguedad == y.antiguedad) {
            m = true;
        }
        return m;
    }
    
    private String getInfoFabricante() {
        return this.nombre + " - " + this.ciudad + " - " + this.antiguedad;
    }
    
    @Override
    public String toString() {
        return this.getInfoFabricante();
    }
}