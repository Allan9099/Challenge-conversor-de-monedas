import com.aluralatam.conversordemonedas.modelos.Monedas;
import com.aluralatam.conversordemonedas.modelos.Solicitud;
import com.aluralatam.conversordemonedas.modelos.Utilidades;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Solicitud solicitud = new Solicitud();
        String monedaUno = "";
        String monedaDos = "";
        double cantidad = 0;

        var busqueda = 1;
        while (busqueda != 0) {

            System.out.println(solicitud.solMenu());
            busqueda = Utilidades.leerEnteroValidado(lectura, 0, 3);
            lectura.nextLine();

            if (busqueda == 0) {
                break;

            } else if (busqueda == 1) {

                System.out.println("""
                        **********************************************************
                         CONVERSION DE MONEDAS (Pares predeterminados)
                         Elija el par deseado para la conversion:
                         1 - Dolar Estado Unidense (USD) ----> Peso Chileno (CLP)
                         2 - Peso Chileno (CLP) ----> Dolar Estado Unidense (USD)
                         3 - Dolar Estado Unidense (USD) --> Peso Argentino (ARS)
                         4 - Peso Argentino (ARS) --> Dolar Estado Unidense (USD)
                         5 - Dolar Estado Unidense (USD) --> Peso Boliviano (BOB)
                         6 - Peso Boliviano (BOB) --> Dolar Estado Unidense (USD)
                        **********************************************************""");

                var opcionPar = Utilidades.leerEnteroValidado(lectura, 1, 6);

                switch (opcionPar) {
                    case 1:
                        monedaUno = "USD";
                        monedaDos = "CLP";
                        break;
                    case 2:
                        monedaUno = "CLP";
                        monedaDos = "USD";
                        break;
                    case 3:
                        monedaUno = "USD";
                        monedaDos = "ARS";
                        break;
                    case 4:
                        monedaUno = "ARS";
                        monedaDos = "USD";
                        break;
                    case 5:
                        monedaUno = "USD";
                        monedaDos = "BOB";
                        break;
                    case 6:
                        monedaUno = "BOB";
                        monedaDos = "USD";
                        break;
                }

                System.out.println(monedaUno + " --> " + monedaDos + "\nIngrese la cantidad de " + monedaUno + " que desea convertir a " + monedaDos + ":");
                cantidad = Utilidades.leerDoubleValidado(lectura, 0, Double.MAX_VALUE);

                Solicitud solicitudMoneda = new Solicitud();
                Monedas monedas = solicitudMoneda.solMoneda(monedaUno, monedaDos, cantidad);
                System.out.println(monedas.toString());

                if (!Utilidades.continuarOpcion(lectura)) {
                    busqueda = 0;
                }
            } else if (busqueda == 2) {

                System.out.println("**********************************************************\nCONVERSION DE MONEDAS (MANUAL)\nIngrese la primera moneda:");
                monedaUno = Utilidades.leerNombreMoneda(lectura);
                System.out.println("Ingrese la segunda moneda:");
                monedaDos = Utilidades.leerNombreMoneda(lectura);
                System.out.println(monedaUno + " --> " + monedaDos + "\nIngrese la cantidad de " + monedaUno + " que desea convertir a " + monedaDos + ":");
                cantidad = Utilidades.leerDoubleValidado(lectura, 0, Double.MAX_VALUE);

                Solicitud solicitudMoneda = new Solicitud();
                Monedas monedas = solicitudMoneda.solMoneda(monedaUno, monedaDos, cantidad);
                System.out.println(monedas.toString());

                if (!Utilidades.continuarOpcion(lectura)) {
                    busqueda = 0;
                }
            } else if (busqueda == 3) {

                Solicitud solicitudCodigo = new Solicitud();
                List<List<String>> codigo = solicitudCodigo.solListaCodigos();

                for (List<String> lista : codigo) {
                    System.out.println(lista.get(0) + " - " + lista.get(1));
                }

                if (!Utilidades.continuarOpcion(lectura)) {
                    busqueda = 0;
                }
            }
            System.out.println("Finalizando el programa.");
        }
    }
}