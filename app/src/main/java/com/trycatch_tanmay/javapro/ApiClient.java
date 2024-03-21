package com.trycatch_tanmay.javapro;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ApiClient {
    public static JavaPro javapro;

    public static JavaPro getJavapro() {
        if (javapro == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(80, TimeUnit.SECONDS)
                    .connectTimeout(80, TimeUnit.SECONDS).build();
            Gson gson = new GsonBuilder()
                    .setLenient().create();


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://mapi.trycatchtech.com/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();
            javapro = retrofit.create(JavaPro.class);
        }
        return javapro;

    }

    public interface JavaPro {
        //        topic are calling
        @GET("/v3/javapro/chapters_list")
        Call<ArrayList<chppojo>> gettransdata();
//        topic are called

        //        call this 1
        @GET("/v3/javapro/quiz_category_list")
        Call<ArrayList<PojoQuizLevel>> getQuizLevel(@Query("quiz_cat_name") String name);

        // call this 1 ended`
//        Call 2
        @GET("v3/javapro/quiz_list?category_id")
        Call<PojoLevel1_B> getlevel1data(@Query("category_id") int category_id);

        @GET("v3/javapro/quiz_list?category_id")
        Call<PojoLevel2_B> getLevel2Data(@Query("category_id") int category_id);

        @GET("v3/javapro/quiz_list?category_id")
        Call<PojoLevel3_A> getlevel3data(@Query("category_id") int category_id);

        @GET("v3/javapro/quiz_list?category_id")
        Call<PojoIntermediate_1_A> getinterlvl1Data(@Query("category_id") int category_id);

        @GET("v3/javapro/quiz_list?category_id")
        Call<PojoIntermediate_level_2_A> getinterlvl2Data(@Query("category_id") int category_id);
//        All quiz are ended here

@GET("v3/javapro/interview_questions_list")
        Call<ArrayList<PojoInterview>>getInterviewData();
//Interview Question;
//        Program
        @GET("/v3/javapro/programs_list")
        Call<ArrayList<Pojo_Program>>getProgramData();

    }
}
