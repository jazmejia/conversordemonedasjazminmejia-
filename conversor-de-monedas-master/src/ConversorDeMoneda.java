public class ConversorDeMoneda {
    Double converir(Double cantidad, Moneda monedaOriginal, String claveMonedaNueva){
        // String claveMonedaOriginal = monedaOriginal.base_code();
        return  cantidad * monedaOriginal.conversion_rates().get(claveMonedaNueva);
    }

}
