package co.fmauipractice;

import co.fmauipractice.pojos.Artists;
import co.fmauipractice.pojos.DataSetInfo;
import co.fmauipractice.pojos.Genres;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Shal on 11-09-2016.
 */
public interface FMARetrofitServer {
    @GET("api/get/artists.json?api_key=7Y8CNHXREY4GJ9W6&limit=50")
    Call<DataSetInfo<Artists>> getArtistFromFMAServer();

    @GET("api/get/artists.json?api_key=7Y8CNHXREY4GJ9W6&limit=50")
    Call<DataSetInfo<Artists>> getArtistFromFMAServerWithPage(@Query("page") int page);

    @GET("api/get/genres.json?api_key=7Y8CNHXREY4GJ9W6&limit=2")
    Call<DataSetInfo<Genres>> getGenresFromFMAServer();
}
