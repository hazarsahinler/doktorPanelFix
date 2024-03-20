package com.doktor_panel.doktor.Service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.VideoListResponse;
import com.google.api.services.youtube.model.VideoSnippet;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Service
public class DoctorService {

    private static final String APPLICATION_NAME = "doctor";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    private static final YouTube youtube;

    static {
        try {
            youtube = new YouTube.Builder(
                    GoogleNetHttpTransport.newTrustedTransport(),
                    JSON_FACTORY,
                    new HttpRequestInitializer() {
                        @Override
                        public void initialize(HttpRequest request) throws IOException {
                            request.getHeaders().set("Authorization", "Bearer " + System.getenv("YOUTUBE_API_KEY"));
                        }
                    })
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException("Error initializing YouTube client", e);
        }
    }

    public String getVideoThumbnailUrl(String videoLink) throws IOException {
        String videoId = getVideoIdFromLink(videoLink);
        YouTube.Videos.List videoList = youtube.videos().list(Collections.singletonList("snippet"));
        videoList.setId(Collections.singletonList(videoId));
        VideoListResponse response = videoList.execute();
        VideoSnippet snippet = response.getItems().get(0).getSnippet();
        return snippet.getThumbnails().getDefault().getUrl();
    }

    public void openVideo(String videoLink) throws IOException {
        String command;
        if (isWindows()) {
            command = "cmd /c start " + videoLink;
        } else if (isMac()) {
            command = "open " + videoLink;
        } else {
            throw new UnsupportedOperationException("Unsupported operating system");
        }
        Runtime.getRuntime().exec(command);
    }

    private String getVideoIdFromLink(String videoLink) {
        String[] parts = videoLink.split("=");
        return parts.length > 1 ? parts[1] : videoLink;
    }

    private boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("windows");
    }

    private boolean isMac() {
        return System.getProperty("os.name").toLowerCase().contains("mac");
    }
}





