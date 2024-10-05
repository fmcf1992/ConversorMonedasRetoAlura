package com.modelos;

import com.google.gson.JsonObject;

public class ConvertirMoneda {
    private String monedaIngresada;
    private String monedaAConvertir;
    private double montoAconvertir;
    private JsonObject resultado;


    public ConvertirMoneda(String monedaIngresada, String monedaAConvertir, double montoAconvertir) {
        this.monedaIngresada = monedaIngresada;
        this.monedaAConvertir = monedaAConvertir;
        this.montoAconvertir = montoAconvertir;
    }

    public double getMontoAconvertir() {
        return montoAconvertir;
    }

    public String getMonedaIngresada() {
        return monedaIngresada;
    }

    public String getMonedaAConvertir() {
        return monedaAConvertir;
    }

    public JsonObject getResultado() {
        return resultado;
    }

    public double optenerResultadoJson(){
        ConsultaAPI consulta = new ConsultaAPI();
        MonedaAPI moneda =  consulta.consultaAPI(getMonedaIngresada());
        resultado = moneda.conversion_rates();
        if(resultado.has(getMonedaAConvertir())){
            return resultado.get(getMonedaAConvertir()).getAsDouble();
        }else{
            System.out.println("Tipo de moneda a convertir no Válida");
            return 0.0;
        }
    }

    public double optenerMontoConvertido(){
        return optenerResultadoJson() * getMontoAconvertir();
    }

    @Override
    public String toString() {
        return String.format("""
                Monto ingresado     : %.2f
                Moneda ingresa      : %s
                Moneda a convertir  : %s
                Monto resultado     : %.2f
                """ , getMontoAconvertir()
                    , getMonedaIngresada()
                    , getMonedaAConvertir()
                    , optenerMontoConvertido());
    }
}
