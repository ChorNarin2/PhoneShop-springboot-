package chornarin.com.kh.Phone_Shop.Impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReportDownloader {

    public static void main(String[] args) {
        String urlString = "https://narinchir.jsreportonline.net/api/report";
        String templateId = "<your-template-id>";

        String jsonData = "{\n" +
                "    \"template\": { \"shortid\": \"" + templateId + "\" },\n" +
                "    \"data\": [\n" +
                "        {\"productId\": 2, \"productName\": \"Iphone 10\", \"unit\": 10, \"totalAmount\": 15000.0},\n" +
                "        {\"productId\": 1, \"productName\": \"Iphone 1\", \"unit\": 60, \"totalAmount\": 60000.0}\n" +
                "    ]\n" +
                "}";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                os.write(jsonData.getBytes());
                os.flush();
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (FileOutputStream fos = new FileOutputStream("report.pdf")) {
                    connection.getInputStream().transferTo(fos);
                }
                System.out.println("Report downloaded successfully.");
            } else {
                System.out.println("Failed to generate report. Response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
