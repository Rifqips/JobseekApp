package id.rifqipadisiliwangi.jobseekapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobsItem {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("created_at")
    @Expose
    private String created_at;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("company_url")
    @Expose
    private String company_url;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("how_to_apply")
    @Expose
    private String how_to_apply;
    @SerializedName("company_logo")
    @Expose
    private String company_logo;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getCreatedAt() {
        return created_at;
    }
    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getCompanyUrl() {
        return company_url;
    }
    public void setCompany_url(String company_url) {this.company_url = company_url; }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {this.location = location; }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {this.title = title; }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {this.description = description; }

    public String getHowToApply() {
        return how_to_apply;
    }
    public void setHowToApply(String how_to_apply) {this.how_to_apply = how_to_apply; }

    public String getCompanyLogo() {
        return company_logo;
    }
    public void setCompanyLogo(String company_logo) {this.company_logo = company_logo; }
}
