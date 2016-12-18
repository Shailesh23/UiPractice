package co.fmauipractice.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Shal on 16-12-2016.
 */

public class Genres {

    @SerializedName("genre_id")
    @Expose
    private String genreId;

    @SerializedName("genre_parent_id")
    @Expose
    private String genreParentId;

    @SerializedName("genre_title")
    @Expose
    private String genreTitle;

    @SerializedName("genre_handle")
    @Expose
    private String genreHandle;

    @SerializedName("genre_color")
    @Expose
    private String genreColor;


    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public String getGenreParentId() {
        return genreParentId;
    }

    public void setGenreParentId(String genreParentId) {
        this.genreParentId = genreParentId;
    }

    public String getGenreTitle() {
        return genreTitle;
    }

    public void setGenreTitle(String genreTitle) {
        this.genreTitle = genreTitle;
    }

    public String getGenreHandle() {
        return genreHandle;
    }

    public void setGenreHandle(String genreHandle) {
        this.genreHandle = genreHandle;
    }

    public String getGenreColor() {
        return genreColor;
    }

    public void setGenreColor(String genreColor) {
        this.genreColor = genreColor;
    }
}
