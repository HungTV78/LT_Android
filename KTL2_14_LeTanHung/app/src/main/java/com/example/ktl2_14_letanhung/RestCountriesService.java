package com.example.ktl2_14_letanhung;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestCountriesService {

    @GET("independent?status=true&fields=languages,capital,name,population,continents,flags")
    Call<List<Country>> getCountries();

}
