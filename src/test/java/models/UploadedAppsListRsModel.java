package models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UploadedAppsListRsModel {
    @JsonProperty("app_name")
    private String appName;
    @JsonProperty("app_version")
    private String appVersion;
    @JsonProperty("app_url")
    private String appUrl;
    @JsonProperty("app_id")
    private String appId;
    @JsonProperty("uploaded_at")
    private String uploadedAt;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(String uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
