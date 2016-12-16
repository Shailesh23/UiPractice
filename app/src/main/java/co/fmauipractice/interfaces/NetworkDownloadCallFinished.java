package co.fmauipractice.interfaces;

import co.fmauipractice.pojos.Artist;
import retrofit2.Response;

/**
 * Created by Shal on 22-09-2016.
 */
public interface NetworkDownloadCallFinished {

    void serverResult(Response<Artist> artistResponse);
}
