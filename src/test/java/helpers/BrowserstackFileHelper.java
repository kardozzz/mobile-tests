package helpers;

import config.AuthWikiConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import models.UploadAppRsModel;
import models.UploadedAppsListRsModel;
import org.aeonbits.owner.ConfigFactory;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BrowserstackFileHelper {

    private static final AuthWikiConfig authWikiConfig =
            ConfigFactory.create(AuthWikiConfig.class, System.getProperties());

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(authWikiConfig.user(), authWikiConfig.key())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }

    public UploadAppRsModel uploadAppToBrowserstack() {
        UploadAppRsModel response = given()
                .auth().preemptive().basic(authWikiConfig.user(), authWikiConfig.key())
                .contentType(ContentType.URLENC)
                .formParam("url", "https://github.com/wikimedia/apps-android-wikipedia/" +
                        "releases/download/latest/app-alpha-universal-release.apk")
                .when()
                .post("https://api-cloud.browserstack.com/app-automate/upload")

                .then()
                .statusCode(200)
                .log().all()
                .extract().as(UploadAppRsModel.class);
        return response;
    }

    public String checkUploadedAppsList() {

        String responseString = given()
                .auth().preemptive().basic(authWikiConfig.user(), authWikiConfig.key())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/recent_apps")
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .asString();

        if (!responseString.contains("No results found")) {
            List<UploadedAppsListRsModel> responseJson =
                    new JsonPath(responseString).getList(".", UploadedAppsListRsModel.class);

            for (UploadedAppsListRsModel app : responseJson) {
                if (app.getAppName().equals("app-alpha-universal-release.apk")) {
                    return app.getAppUrl();
                }
            }
        }

        return uploadAppToBrowserstack().getAppUrl();
    }
}