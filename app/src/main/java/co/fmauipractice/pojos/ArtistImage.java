
package co.fmauipractice.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArtistImage {

    @SerializedName("image_id")
    @Expose
    private String imageId;
    @SerializedName("image_file")
    @Expose
    private String imageFile;
    @SerializedName("image_title")
    @Expose
    private String imageTitle;
    @SerializedName("image_caption")
    @Expose
    private String imageCaption;
    @SerializedName("image_copyright")
    @Expose
    private String imageCopyright;
    @SerializedName("image_source")
    @Expose
    private String imageSource;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getImageCaption() {
        return imageCaption;
    }

    public void setImageCaption(String imageCaption) {
        this.imageCaption = imageCaption;
    }

    public String getImageCopyright() {
        return imageCopyright;
    }

    public void setImageCopyright(String imageCopyright) {
        this.imageCopyright = imageCopyright;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

}
