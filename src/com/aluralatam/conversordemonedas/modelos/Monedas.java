package com.aluralatam.conversordemonedas.modelos;

import java.text.DecimalFormat;

public record Monedas(String result,
                      String base_code,
                      String target_code,
                      double conversion_rate,
                      double conversion_result) {

    static DecimalFormat formatter = new DecimalFormat("###,###,###.##");

    @Override
    public String toString() {
        return "Resultado de la conversion: " + formatter.format(conversion_result) +
                "\nValor actual: " + formatter.format(conversion_rate) + " (Valor actualizado hoy a las 00:01)";
    }
}