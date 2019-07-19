package com.techcrevices.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("/bca/users/example/")
    Call<String> postdata(@Body String s);


    @FormUrlEncoded
    @POST("/bca/users/example2")
    Call<DataModel> DATA_MODEL_CALL(@Field("id") String id,
                                    @Field("name") String name
                                    );


    @POST("/bca/users/example3")
    Call<DataModel> DATA_MODEL_CALL2(@Body DataModel data);
}
