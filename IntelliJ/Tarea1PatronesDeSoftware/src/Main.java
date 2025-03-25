
import java.util.ArrayList;
import java.util.Scanner;


interface MetodoDePagoStrategy {
    public boolean realizar(Hotel hotel, Cliente cliente);

    public void cancelar(Hotel hotel, Cliente cliente);
}


class PagoConCredito implements MetodoDePagoStrategy {
    public boolean realizar(Hotel hotel, Cliente cliente) {
        return false;
    }

    public void cancelar(Hotel hotel, Cliente cliente) {
    }

}

class PagoConDebito implements MetodoDePagoStrategy {
    public boolean realizar(Hotel hotel, Cliente cliente) {
        return false;
    }

    public void cancelar(Hotel hotel, Cliente cliente) {
    }

}

class Reserva {
    String id;
    Hotel hotel;
    Cliente cliente;
    MetodoDePagoStrategy metodoDePago;
    estadoReserva estado;

    public Reserva(Hotel hotel, Cliente cliente, MetodoDePagoStrategy metodoDePago) {
        this.hotel = hotel;
        this.cliente = cliente;
        this.metodoDePago = metodoDePago;
        estado = estadoReserva.noPagado;
    }

    public boolean ejecutarMetodoDePagoStrategy() {

        metodoDePago.realizar(hotel, cliente);
        // si true el estado es "pagada"
        // si false el estado es "no pagada".
        return false;
    }

    public estadoReserva getEstado() {
        return estado;
    }

    public void setEstado(estadoReserva estado) {
        this.estado = estado;
    }
}

enum estadoReserva {
    pagado,
    noPagado,


}

class Cliente {
    private String nombre;
    private String tarjetaDeCredito; // se asume para el ejemplo que deja de ser solamente una tarjeta de credito

    public Cliente(String nombre, String tarjetaDeCredito) {
        this.nombre = nombre;
        this.tarjetaDeCredito = tarjetaDeCredito;

    }

    // getters & setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    public void setTarjetaDeCredito(String tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }
}

class Hotel {
    private String nombre;
    private String direccion;

    public Hotel(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }


}


class SistemaBibliotecaSingleton {


    ArrayList<Reserva> reservas;
    ArrayList<Cliente> clientes;
    ArrayList<Hotel> hoteles;
    Reserva reservaSeleccionada;
    private static SistemaBibliotecaSingleton instance;

    private SistemaBibliotecaSingleton() {
    }

    ;

    public static SistemaBibliotecaSingleton getInstance() {
        if (instance == null) {
            instance = new SistemaBibliotecaSingleton();
        }
        return instance;
    }

    public void crearReserva(String hotel, String cliente) {
        // se busca si existe el hotel, cliente y el metodo de pago.
        // se crea una instancia de reserva y se añade al cliente como al hotel y el metodo de pago.
        // se settea el estado como "no pagado"


    }

    public void crearCliente(String nombre, String tarjetaDeCredito) {
        // se verifica si esta repetido
        // se añade si no existe
    }

    public void crearHotel(String nombre, String direccion) {
        // se verifica si esta repetido
    }

    public String procesarReserva(String hotel, String cliente) {
        // se busca la reserva que coincida el hotel y cliente en las reservas.
        // se verifica si la reserva esta pagada o no.
        // se llama el metodo realizarMetodoDePago()
        // en este caso se retorna una respuesta en torno al metodo reserva.ejecutarMetodoDePagoStrategy(), si es true se printea exitoso si es false se printea error ;
        return "";
    }

    public boolean procesarReserva(String reservaID) {
        // se busca la reserva con el id
        // se llama el metodo realizarMetodoDePago()
        return false; // en este caso se retorna el metodo reserva.ejecutarMetodoDePagoStrategy(), si es true se printea exitoso si es false se printea error ;
    }

    public boolean cambiarMetodoDePagoCliente(String clienteID) {
        //se busca al cliente y se cambia su metodo de Pago como string y tambien en las reservas.
        return false;
    }

    public MetodoDePagoStrategy obtenerMetodoDePago(String metodo) {
        // se retorna una Strategy de pago apartir del string del metodo
        return null;
    }

    public void cancelarReserva(String hotel, String cliente) {
        // se busca la reserva que tenga ese hotel como cliente y se elimina la reserva
    }

    public String listarReservas() {
        return "";
    }

    public String listarReservas(estadoReserva estado) {
        return "";
    }

    public void seleccionarReserva(String hotel, String cliente) {
        // se settea la reservaSeleccionada
    }

    public void seleccionarReserva(String reservaID) {
        // se settea la reservaSeleccionada.
    }

}


public class Main {
    public static void main(String[] args) {
        // proceso de datos con SistemaBibliotecaSingleton
        // y ejecuciones necesario para el modelo de vista controlador del usuario (inputs) .
        Scanner sc = new Scanner(System.in);


    }
}