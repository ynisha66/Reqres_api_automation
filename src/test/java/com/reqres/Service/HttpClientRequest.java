package com.reqres.Service;


import org.json.JSONObject;
import org.testng.Reporter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpClientRequest {
        public static HttpResponse<String> makeGetRequest(String url, HashMap<String, Object> paramsMap)
                throws IOException, InterruptedException {
                if(paramsMap != null){
                        String queryUrl = "";
                        for(Map.Entry<String, Object> entry : paramsMap.entrySet()){
                                if(queryUrl.length() > 0){
                                        queryUrl += "&";
                                }
                                queryUrl += entry.getKey()+"="+entry.getValue();
                        }
                        url += "?"+queryUrl;
                }
                HttpRequest httpRequest = HttpRequest.newBuilder().GET()
                        .uri(URI.create(url))
                        .header("Content-Type", "application/json")
                        .build();

                Reporter.log(String.valueOf(httpRequest),true);
                HttpClient client = HttpClient.newBuilder().build();
                HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                Reporter.log(String.valueOf(response.body()),true);
                return response;
        }
        public static HttpResponse<String> makePostRequest(String url, JSONObject requestBody)
                throws IOException, InterruptedException {
                HttpRequest httpRequest = HttpRequest.newBuilder()
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                        .header("Content-Type", "application/json")
                        .uri(URI.create(url))
                        .build();
                Reporter.log(String.valueOf(httpRequest),true);
                HttpClient client = HttpClient.newBuilder().build();
                HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                Reporter.log(String.valueOf(response.body()),true);
                return response;
        }
        public static HttpResponse<String> makePutRequest(String url, JSONObject requestBody)
                throws IOException, InterruptedException {
                HttpRequest httpRequest = HttpRequest.newBuilder()
                        .PUT(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                        .header("Content-Type", "application/json")
                        .uri(URI.create(url))
                        .build();
                Reporter.log(String.valueOf(httpRequest),true);
                HttpClient client = HttpClient.newBuilder().build();
                HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                Reporter.log(String.valueOf(response.body()),true);
                return response;
        }
        public static HttpResponse<String> makeDeleteRequest(String url)
                throws IOException, InterruptedException {
                HttpRequest httpRequest = HttpRequest.newBuilder()
                        .DELETE()
                        .header("Content-Type", "application/json")
                        .uri(URI.create(url))
                        .build();
                Reporter.log(String.valueOf(httpRequest),true);
                HttpClient client = HttpClient.newBuilder().build();
                HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                Reporter.log(String.valueOf(response.body()),true);
                return response;
        }
}
