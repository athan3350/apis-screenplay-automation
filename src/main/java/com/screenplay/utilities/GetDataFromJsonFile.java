package com.screenplay.utilities;


import org.apache.log4j.Level;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class GetDataFromJsonFile {
    LoggerSetup logger = new LoggerSetup();
    JSONParser parser = new JSONParser();
    JSONObject jsonObject = null;
    JSONArray jsonArray = null;

    public JSONObject getJsonFileAsJSONObject(String jsonFilePath) throws JSONException {

        try {
            Object obj = parser.parse(new FileReader(jsonFilePath));
            jsonObject = (JSONObject) obj;
        } catch (ParseException | IOException e) {
            logger.writerLogger(Level.ERROR, GetDataFromJsonFile.class.toString(), e.toString());
        }
        return jsonObject;
    }

    public JSONArray getJsonFileAsJSONArray(String jsonFilePath) throws JSONException {

        try {
            Object obj = parser.parse(new FileReader(jsonFilePath));
            jsonArray = (JSONArray) obj;
        } catch (ParseException | IOException e) {
            logger.writerLogger(Level.ERROR, GetDataFromJsonFile.class.toString(), e.toString());
        }

        return jsonArray;
    }
}
