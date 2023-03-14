package tests.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPostResponse {
    private String id;
    private String name;
    private String desc;
    private String descData;
    private String closed;
    private String idOrganization;
    private String idEnterprise;
    private String pinned;
    private String url;
    private String shortUrl;

    public GetPostResponse() { }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getDescData() {
        return descData;
    }

    public String getClosed() {
        return closed;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public String getIdEnterprise() { return idEnterprise; }

    public String getPinned() {
        return pinned;
    }

    public String getUrl() {
        return url;
    }

    public String getShortUrl() { return shortUrl; }
}
