package com.project.recycleit.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.recycleit.dtos.LocationDto;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecyclingCentersService {
    private String apiKey = "AIzaSyChWylfBAn9zOk4avQ_M-AOAq0nZAelpto";

    private final OkHttpClient client = new OkHttpClient().newBuilder().build();

    public List<LocationDto> getNearbyRecyclingCenters(double latitude, double longitude, int radius) throws IOException {
        String[] keywords = {"recycling center", "recycling point", "mega image", "kaufland"};
        List<LocationDto> combinedResults = new ArrayList<>();

        for (String keyword : keywords) {
            String url = HttpUrl.parse("https://maps.googleapis.com/maps/api/place/nearbysearch/json")
                    .newBuilder()
                    .addQueryParameter("location", latitude + "," + longitude)
                    .addQueryParameter("radius", String.valueOf(radius))
                    .addQueryParameter("keyword", keyword)
                    .addQueryParameter("key", apiKey)
                    .addQueryParameter("region", "RO")
                    .build()
                    .toString();

            Request request = new Request.Builder()
                    .url(url)
                    .method("GET", null)
                    .build();

            System.out.println("Request URL: " + url);

            try (Response response = client.newCall(request).execute()) {
                if (response.body() != null) {
                    String responseBody = response.body().string();
                    System.out.println("Response: " + responseBody);

                    // Convert the response body to a Map
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode rootNode = mapper.readTree(responseBody);
                    JsonNode resultsNode = rootNode.path("results");

                    if (resultsNode.isArray()) {
                        for (JsonNode node : resultsNode) {
                            JsonNode locationNode = node.path("geometry").path("location");
                            double lat = locationNode.path("lat").asDouble();
                            double lng = locationNode.path("lng").asDouble();
                            String name = node.path("name").asText();

                            if (keyword.equals("mega image") || keyword.equals("kaufland")) {
                                combinedResults.add(new LocationDto(lat, lng, name, "market"));
                            } else if (keyword.equals("recycling point")) {
                                combinedResults.add(new LocationDto(lat, lng, name, "recyclingPoint"));
                            } else {
                                combinedResults.add(new LocationDto(lat, lng, name, "recyclingCenter"));
                            }
                        }
                    }
                } else {
                    System.out.println("No response body received");
                }
            }
        }
        return new ArrayList<>(combinedResults);
    }
}
