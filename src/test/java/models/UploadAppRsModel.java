package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UploadAppRsModel {
    @JsonProperty("app_url")
    private String appUrl;

}