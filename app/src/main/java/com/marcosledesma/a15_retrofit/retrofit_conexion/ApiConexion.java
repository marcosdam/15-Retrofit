package com.marcosledesma.a15_retrofit.retrofit_conexion;

import com.marcosledesma.a15_retrofit.pojo.ResponseUsers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiConexion {

    // Call<OBJETO> -> llamada a una API que recibe un Objeto -> Genera PARSE del String al Objeto

    // Get de todos los users en la api
    @GET("/api/users")
    Call<ResponseUsers> doGetUsers();

    // GET de users/id
    @GET("/api/users?")
    Call<ResponseUsers> doGetUsersPage(@Query("page") String page);

}
