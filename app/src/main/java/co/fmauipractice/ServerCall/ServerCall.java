package co.fmauipractice.ServerCall;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.fmauipractice.FMARetrofitServer;
import co.fmauipractice.pojos.Artist;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shal on 11-09-2016.
 */
public class ServerCall implements Callback<Artist> {
    private Retrofit retrofit;

    public ServerCall() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new StethoInterceptor()).build();

        retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl("https://freemusicarchive.org/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public void getTypeList() {
        FMARetrofitServer fmaRetrofitServer = retrofit.create(FMARetrofitServer.class);
        Call<Artist> artistCall = fmaRetrofitServer.getTypeFromFMAServer("artists");
        artistCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<Artist> call, Response<Artist> response) {
        System.out.println(response.body());
    }

    @Override
    public void onFailure(Call<Artist> call, Throwable t) {
        System.out.println(t);
    }
}
