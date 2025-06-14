package cl.ucn.utilities;

public class RegistroClienteProducto {

    private Long rut;
    private String nombre;
    private int anhoRegistro;
    private String fechaNacimiento;
    private int idProducto;
    private String categoria;
    private String nombreProducto;
    private int precio;

    // Getters y setters (puedes generarlos automáticamente)
    public Long getRut() { return rut; }
    public void setRut(Long rut) { this.rut = rut; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getAnhoRegistro() { return anhoRegistro; }
    public void setAnhoRegistro(int anhoRegistro) { this.anhoRegistro = anhoRegistro; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
}


