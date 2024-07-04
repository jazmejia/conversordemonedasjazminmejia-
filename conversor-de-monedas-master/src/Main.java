import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Double cantidadAConvertir;
        String claveMonedaOriginal = "USD";
        String claveMonedaNueva = "EUR";
        Scanner teclado = new Scanner(System.in);
        MenuUsuario menuUsuario = new MenuUsuario();
        Integer opcionUsuario;



        do{
            //Aqui debe ir el menu de usuario
            menuUsuario.imprimirMenu();

            //Aqui se lee la respuesta del usuario
            try{
                opcionUsuario = Integer.valueOf(teclado.nextLine());
                Boolean opcionValida;

                switch(opcionUsuario){
                    case 1:
                        claveMonedaOriginal = "USD";
                        claveMonedaNueva = "ARS";
                        opcionValida = true;
                        break;
                    case 2:
                        claveMonedaOriginal = "ARS";
                        claveMonedaNueva = "USD";
                        opcionValida = true;
                        break;
                    case 3:
                        claveMonedaOriginal = "USD";
                        claveMonedaNueva = "BRL";
                        opcionValida = true;
                        break;
                    case 4:
                        claveMonedaOriginal = "BRL";
                        claveMonedaNueva = "USD";
                        opcionValida = true;
                        break;
                    case 5:
                        claveMonedaOriginal = "USD";
                        claveMonedaNueva = "COP";
                        opcionValida = true;
                        break;
                    case 6:
                        claveMonedaOriginal = "COP";
                        claveMonedaNueva = "USD";
                        opcionValida = true;
                        break;
                    case 7:
                        claveMonedaOriginal = "MXN";
                        claveMonedaNueva = "ARS";
                        opcionValida = true;
                        break;
                    case 8:
                        claveMonedaOriginal = "MXN";
                        claveMonedaNueva = "USD";
                        opcionValida = true;
                        break;
                    case 9:
                        System.out.println("Finalizando el programa");
                        opcionValida = false;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        opcionValida = false;
                }

                if (opcionValida){
                    System.out.println("Ingresa el valor que deseas convertir");
                    cantidadAConvertir = Double.valueOf(teclado.nextLine());

                    // realizar consulta a la API
                    ConsultaMonedas consultaMoneda = new ConsultaMonedas();
                    Moneda monedaOriginal = consultaMoneda.buscaMoneda(claveMonedaOriginal);
                    // System.out.println(monedaOriginal);
                    // System.out.println(monedaOriginal.conversion_rates().get(claveMonedaNueva));

                    //convertir una canditad
                    ConversorDeMoneda conversorMoneda = new ConversorDeMoneda();
                    Double nuevaCantidad = conversorMoneda.converir(cantidadAConvertir, monedaOriginal, claveMonedaNueva);
                    System.out.println("La cantidad que quieres convertir es: " + cantidadAConvertir + " " + claveMonedaOriginal);
                    System.out.println("la nueva cantidad es: " + nuevaCantidad + " " + claveMonedaNueva);
                }
            }catch (Exception e){
                System.out.println("Ocurrio un error inesperado: " + e.getMessage());
                opcionUsuario = 1;
            }



        }while (opcionUsuario != 9);





    }
}