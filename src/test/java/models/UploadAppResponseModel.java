package models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UploadAppResponseModel {
    @JsonProperty("app_url")
    private String appUrl;

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }
}