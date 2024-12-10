package facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attribute) throws IOException, ParseException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new InputStreamReader(connection.getInputStream()));

        return extractAttributeFromJson(jsonObject, attribute);
    }

    private String extractAttributeFromJson(JSONObject jsonObject, String attribute) {
        Object value = jsonObject.get(attribute);
        if (value instanceof JSONObject) {
            return value.toString();
        } else if (value instanceof String) {
            return (String) value;
        } else {
            return String.valueOf(value);
        }
    }
}