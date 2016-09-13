package co.fmauipractice;

import co.fmauipractice.pojos.Artist;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Shal on 11-09-2016.
 */
public interface FMARetrofitServer {
    @GET("api/get/{type}.json?api_key=7Y8CNHXREY4GJ9W6")
    Call<Artist> getTypeFromFMAServer(@Path("type") String type);
}
