package com.example.mohamed.clinic_app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Mohamed on 11/10/2018.
 */
interface GetDataService {
    @FormUrlEncoded
    @POST("tsetin.php")
    Call<Example> getuser(@Field("full_name") String full_name, @Field("email_address") String email_address, @Field("password") String password, @Field("image") String image, @Field("departement") String departement, @Field("dialoge_stp") String dialoge_stp,@Field("lat") String lat,@Field("lon") String lon);


    @FormUrlEncoded
    @POST("tsetin2.php")
    Call<Example> getuser2(@Field("full_name") String full_name, @Field("email_address") String email_address, @Field("password") String password);



    @GET("login.php")
    Call<entity> getuserss(@Query("username") String full_name, @Query("password") String password, @Query("flage") String flage);

    @GET("getdoctors.php")

    Call<List<getdoctors>> getAlldoctors(@Query("departement") String departement, @Query("f") String f);


    @GET("hgzcashf.php")

    Call<Example> update(@Query("doc_pass") String doc_pass, @Query("pat_pass") String pat_pass, @Query("datep") String datep);

    @GET("selectallhagz.php")

    Call<List<selectallhagz>> getAllpatients(@Query("doc_pass") String password);

    @GET("select_all_chech.php")

    Call<List<select_all_chech>> getAllchc(@Query("pat_pass") String password);

    @GET("check_patient.php")

    Call<Example>insert_check(@Query("doc_pass") String doc_pass, @Query("pat_pass") String pat_pass, @Query("checkpat") String checkpat, @Query("date") String date);


    @GET("insert_to_nota.php")

    Call<Example> add_mede(@Query("pat_pass") String patient_password, @Query("doc_pass") String doctor_password, @Query("hour") String hour, @Query("minit") String minit, @Query("time") String time, @Query("med_s") String med_s);

    @GET("select_alert.php")

    Call<List<alertnot>>get_mede(@Query("pat_pass") String pat_pass);




}
