package com.marcosledesma.a15_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.marcosledesma.a15_retrofit.pojo.ResponseUsers;
import com.marcosledesma.a15_retrofit.pojo.User;
import com.marcosledesma.a15_retrofit.retrofit_conexion.ApiConexion;
import com.marcosledesma.a15_retrofit.retrofit_conexion.RetrofitObjeto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Conector de tipo Retrofit
        Retrofit conector = RetrofitObjeto.getConexion();
        // Coge la API e implementa los métodos
        ApiConexion conexion = conector.create(ApiConexion.class);

        // Preparar la llamada
        Call<ResponseUsers> responseUsersCall = conexion.doGetUsers();

        // Llamar
        // 1. Poner en cola la petición
        responseUsersCall.enqueue(new Callback<ResponseUsers>() {
            @Override
            public void onResponse(Call<ResponseUsers> call, Response<ResponseUsers> response) {
                // Si tod0 ha ido bien (código 200 http)
                if (response.code() == 200){
                    ResponseUsers responseUsers = response.body();
                    Log.d("USERS", "PAGINA: " + responseUsers.getPage());
                    List<User> list = responseUsers.getData();
                    for (User u : list) {
                        Log.d("USERS", "Nombre: " + u.getFirstName());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseUsers> call, Throwable t) {

            }
        });



        /**
         * Nuevo Call para el doGetUsersPage() (va a obtener la page 2)
         */
        Call<ResponseUsers> responseUsersCallPage = conexion.doGetUsersPage("2");
        responseUsersCallPage.enqueue(new Callback<ResponseUsers>() {
            @Override
            public void onResponse(Call<ResponseUsers> call, Response<ResponseUsers> response) {
                // Si tod0 ha ido bien (código 200 http)
                if (response.code() == 200){
                    ResponseUsers responseUsers = response.body();
                    Log.d("USERS", "PAGINA: " + responseUsers.getPage());
                    List<User> list = responseUsers.getData();
                    for (User u : list) {
                        Log.d("USERS", "Nombre: " + u.getFirstName());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseUsers> call, Throwable t) {

            }
        });
    }
}