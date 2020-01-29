package controller;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PredmetFileDownloader {
    private PredmetParser parser = new PredmetParser();

    public void setParser(PredmetParser parser) {
        this.parser = parser;
    }

    public void getCSV(String predmet, String katedra) throws URISyntaxException, IOException, InterruptedException {
        String url = "https://stag-demo.uhk.cz/ws/services/rest2/rozvrhy/getRozvrhByPredmet?jenBudouciAkce=true&zkratka=";
        url+= predmet;
        url += "&outputFormat=csv&katedra=";
        url += katedra;

        HttpClient client = HttpClient
                .newBuilder()
                .build();

        HttpRequest request = HttpRequest
                .newBuilder(new URI(url))
                .GET()
                .build();

        HttpResponse<Path> response = client
                .send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("predmety.csv")));
        if (response.statusCode() == 200){
            parser.fromCSVFile("predmety.csv");
        }
    }

}
