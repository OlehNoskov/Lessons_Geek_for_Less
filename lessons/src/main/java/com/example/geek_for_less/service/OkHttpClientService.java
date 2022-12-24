package com.example.geek_for_less.service;

import com.example.geek_for_less.dto.RequestDTO;
import okhttp3.*;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class OkHttpClientService {

    // Fetch data from other source and service
    public String fetchData() {
    // OkHttpClient client = new OkHttpClient();
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(15L, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5").build();

        try (Response response = client.newCall(request).execute()) {
            TimeUnit.SECONDS.sleep(10L);
            assert response.body() != null;
            return response.body().string();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Send data to other service
    public String sendData() {
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(15L, TimeUnit.SECONDS).build();
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setType("JSON");
        RequestBody requestBody = RequestBody.create(requestDTO.getType(), MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url("https://localhost:8080/persons/post")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}