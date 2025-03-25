
class ClienteInicial {
    public String nombre;
    public String tarjetaCredito;

    public ClienteInicial(String nombre, String tarjetaCredito) {
        this.nombre = nombre;
        this.tarjetaCredito = tarjetaCredito;

    }
}

class HotelInicial {
    public void hacerReserva(ClienteInicial ClienteInicial) {
        System.out.println("Reserva realizada para " + ClienteInicial.nombre);
        System.out.println("Procesando pago con tarjeta:" + ClienteInicial.tarjetaCredito);

    }
}

public class CodigoInicial {
    public static void main(String[] args) {
        ClienteInicial ClienteInicial = new ClienteInicial("JuanyPerez", "1234-5678-9012-3456");
        HotelInicial HotelInicial = new HotelInicial();
        HotelInicial.hacerReserva(ClienteInicial);
    }
}
