package co.fmauipractice.interfaces;

import co.fmauipractice.pojos.DataSetInfo;
import retrofit2.Response;

/**
 * Created by Shal on 22-09-2016.
 */
public interface NetworkDownloadCallFinished {

    void serverResult(Response<DataSetInfo> artistResponse);
}
