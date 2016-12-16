
package co.fmauipractice.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dataset {

    @SerializedName("artist_id")
    @Expose
    private String artistId;
    @SerializedName("artist_handle")
    @Expose
    private String artistHandle;
    @SerializedName("artist_url")
    @Expose
    private String artistUrl;
    @SerializedName("artist_name")
    @Expose
    private String artistName;
    @SerializedName("artist_bio")
    @Expose
    private String artistBio;
    @SerializedName("artist_members")
    @Expose
    private Object artistMembers;
    @SerializedName("artist_website")
    @Expose
    private Object artistWebsite;
    @SerializedName("artist_wikipedia_page")
    @Expose
    private Object artistWikipediaPage;
    @SerializedName("artist_donation_url")
    @Expose
    private Object artistDonationUrl;
    @SerializedName("artist_contact")
    @Expose
    private Object artistContact;
    @SerializedName("artist_active_year_begin")
    @Expose
    private Object artistActiveYearBegin;
    @SerializedName("artist_active_year_end")
    @Expose
    private Object artistActiveYearEnd;
    @SerializedName("artist_related_projects")
    @Expose
    private Object artistRelatedProjects;
    @SerializedName("artist_associated_labels")
    @Expose
    private Object artistAssociatedLabels;
    @SerializedName("artist_comments")
    @Expose
    private String artistComments;
    @SerializedName("artist_favorites")
    @Expose
    private String artistFavorites;
    @SerializedName("artist_date_created")
    @Expose
    private String artistDateCreated;
    @SerializedName("artist_flattr_name")
    @Expose
    private Object artistFlattrName;
    @SerializedName("artist_paypal_name")
    @Expose
    private Object artistPaypalName;
    @SerializedName("artist_latitude")
    @Expose
    private Object artistLatitude;
    @SerializedName("artist_longitude")
    @Expose
    private Object artistLongitude;
    @SerializedName("artist_image_file")
    @Expose
    private String artistImageFile;
    @SerializedName("artist_location")
    @Expose
    private Object artistLocation;
    @SerializedName("tags")
    @Expose
    private List<Object> tags = null;
    @SerializedName("artist_images")
    @Expose
    private List<ArtistImage> artistImages = null;

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getArtistHandle() {
        return artistHandle;
    }

    public void setArtistHandle(String artistHandle) {
        this.artistHandle = artistHandle;
    }

    public String getArtistUrl() {
        return artistUrl;
    }

    public void setArtistUrl(String artistUrl) {
        this.artistUrl = artistUrl;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistBio() {
        return artistBio;
    }

    public void setArtistBio(String artistBio) {
        this.artistBio = artistBio;
    }

    public Object getArtistMembers() {
        return artistMembers;
    }

    public void setArtistMembers(Object artistMembers) {
        this.artistMembers = artistMembers;
    }

    public Object getArtistWebsite() {
        return artistWebsite;
    }

    public void setArtistWebsite(Object artistWebsite) {
        this.artistWebsite = artistWebsite;
    }

    public Object getArtistWikipediaPage() {
        return artistWikipediaPage;
    }

    public void setArtistWikipediaPage(Object artistWikipediaPage) {
        this.artistWikipediaPage = artistWikipediaPage;
    }

    public Object getArtistDonationUrl() {
        return artistDonationUrl;
    }

    public void setArtistDonationUrl(Object artistDonationUrl) {
        this.artistDonationUrl = artistDonationUrl;
    }

    public Object getArtistContact() {
        return artistContact;
    }

    public void setArtistContact(Object artistContact) {
        this.artistContact = artistContact;
    }

    public Object getArtistActiveYearBegin() {
        return artistActiveYearBegin;
    }

    public void setArtistActiveYearBegin(Object artistActiveYearBegin) {
        this.artistActiveYearBegin = artistActiveYearBegin;
    }

    public Object getArtistActiveYearEnd() {
        return artistActiveYearEnd;
    }

    public void setArtistActiveYearEnd(Object artistActiveYearEnd) {
        this.artistActiveYearEnd = artistActiveYearEnd;
    }

    public Object getArtistRelatedProjects() {
        return artistRelatedProjects;
    }

    public void setArtistRelatedProjects(Object artistRelatedProjects) {
        this.artistRelatedProjects = artistRelatedProjects;
    }

    public Object getArtistAssociatedLabels() {
        return artistAssociatedLabels;
    }

    public void setArtistAssociatedLabels(Object artistAssociatedLabels) {
        this.artistAssociatedLabels = artistAssociatedLabels;
    }

    public String getArtistComments() {
        return artistComments;
    }

    public void setArtistComments(String artistComments) {
        this.artistComments = artistComments;
    }

    public String getArtistFavorites() {
        return artistFavorites;
    }

    public void setArtistFavorites(String artistFavorites) {
        this.artistFavorites = artistFavorites;
    }

    public String getArtistDateCreated() {
        return artistDateCreated;
    }

    public void setArtistDateCreated(String artistDateCreated) {
        this.artistDateCreated = artistDateCreated;
    }

    public Object getArtistFlattrName() {
        return artistFlattrName;
    }

    public void setArtistFlattrName(Object artistFlattrName) {
        this.artistFlattrName = artistFlattrName;
    }

    public Object getArtistPaypalName() {
        return artistPaypalName;
    }

    public void setArtistPaypalName(Object artistPaypalName) {
        this.artistPaypalName = artistPaypalName;
    }

    public Object getArtistLatitude() {
        return artistLatitude;
    }

    public void setArtistLatitude(Object artistLatitude) {
        this.artistLatitude = artistLatitude;
    }

    public Object getArtistLongitude() {
        return artistLongitude;
    }

    public void setArtistLongitude(Object artistLongitude) {
        this.artistLongitude = artistLongitude;
    }

    public String getArtistImageFile() {
        return artistImageFile;
    }

    public void setArtistImageFile(String artistImageFile) {
        this.artistImageFile = artistImageFile;
    }

    public Object getArtistLocation() {
        return artistLocation;
    }

    public void setArtistLocation(Object artistLocation) {
        this.artistLocation = artistLocation;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public List<ArtistImage> getArtistImages() {
        return artistImages;
    }

    public void setArtistImages(List<ArtistImage> artistImages) {
        this.artistImages = artistImages;
    }

}
