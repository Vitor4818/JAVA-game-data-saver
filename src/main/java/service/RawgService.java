package service;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.Jogo;

public class RawgService {
    private final String API_KEY = "Sua api key aqui";

    public Jogo getJogo(String nomeJogo) throws IOException {
        Jogo jogo = null;

        String url = "https://api.rawg.io/api/games/" + nomeJogo + "?key=" + API_KEY;
        HttpGet request = new HttpGet(url);

        try (CloseableHttpClient httpClient =
                     HttpClientBuilder.create().disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity);
                Gson gson = new Gson();



                jogo = gson.fromJson(result, Jogo.class);
            }
        }
        return jogo;
    }
}
