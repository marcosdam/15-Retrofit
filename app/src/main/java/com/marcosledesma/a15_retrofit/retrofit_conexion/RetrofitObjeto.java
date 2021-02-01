package com.marcosledesma.a15_retrofit.retrofit_conexion;

import com.marcosledesma.a15_retrofit.configuraciones.Configuracion;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObjeto {
    // 1. URL BASE DEL SERVIDOR: https://reqres.in
    // 2. CONVERTER -> converter-gson

    public static Retrofit getConexion(){
        return new Retrofit.Builder()
                .baseUrl(Configuracion.urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
