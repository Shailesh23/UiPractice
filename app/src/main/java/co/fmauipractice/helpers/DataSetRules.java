package co.fmauipractice.helpers;

import android.text.TextUtils;

import java.util.List;

import co.fmauipractice.pojos.Artists;

/**
 * Created by Shal on 25-12-2016.
 */

public class DataSetRules {

    public static List<Artists> getCleanArtistsDataSet(List<Artists> dataList){
        for(int index =dataList.size() -1 ;index >= 0; index--){
            Artists artist = dataList.get(index);
            String bio = artist.getArtistBio();
            String name = artist.getArtistName();

            if(TextUtils.isEmpty(bio) || TextUtils.isEmpty(name)){
                dataList.remove(index);
            }
        }
        return dataList;
    }
}
