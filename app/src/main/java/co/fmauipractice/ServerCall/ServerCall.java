package co.fmauipractice.ServerCall;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.fmauipractice.FMARetrofitServer;
import co.fmauipractice.interfaces.NetworkDownloadCallFinished;
import co.fmauipractice.pojos.Artists;
import co.fmauipractice.pojos.DataSetInfo;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Shal on 11-09-2016.
 */
public class ServerCall {

    private Retrofit retrofit;
    FMARetrofitServer fmaRetrofitServer;

    public ServerCall() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl("https://freemusicarchive.org/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        fmaRetrofitServer = retrofit.create(FMARetrofitServer.class);
    }

    public void getArtistsTypeList(Callback<DataSetInfo<Artists>> callback) {
        Call<DataSetInfo<Artists>> artistCall = fmaRetrofitServer.getArtistFromFMAServer();
        artistCall.enqueue(callback);
    }
}
