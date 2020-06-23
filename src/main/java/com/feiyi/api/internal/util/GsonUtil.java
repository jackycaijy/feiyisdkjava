package com.feiyi.api.internal.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonUtil {

    /**
     *
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJSON(String json, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

    public static <T> T fromJSON(String json,Type type) {
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

    public static <T> List<T> getObjectList(String jsonString,Class<T> cls){
        List<T> list = new ArrayList<T>();
        try {
            Gson gson = new Gson();
            JsonArray arry = new JsonParser().parse(jsonString).getAsJsonArray();
            for (JsonElement jsonElement : arry) {
                list.add(gson.fromJson(jsonElement, cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     *
     *
     * @param object
     * @return
     */
    public static String format(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(gson.toJson(object));
        String prettyJsonString = gson.toJson(je);

        String[] lines = prettyJsonString.split("\n");
        lines = replaceFunctionQuote(lines);
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    /**
     *
     *
     * @param object
     * @return
     */
    public static String prettyFormat(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(gson.toJson(object));
        String prettyJsonString = gson.toJson(je);

        String[] lines = prettyJsonString.split("\n");
        lines = replaceFunctionQuote(lines);
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
            stringBuilder.append(line + "\n");
        }
        return stringBuilder.toString();
    }

    /**
     *
     *
     * @param lines
     * @return
     */
    public static String[] replaceFunctionQuote(String[] lines) {
        boolean function = false;
        boolean immediately = false;
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].trim();
            if (!function && line.contains("\"function")) {
                function = true;
                line = line.replaceAll("\"function", "function");
            }
            if (function && line.contains("}\"")) {
                function = false;
                line = line.replaceAll("\\}\"", "\\}");
            }

            if (!immediately && line.contains("\"(function")) {
                immediately = true;
                line = line.replaceAll("\"\\(function", "\\(function");
            }
            if (immediately && line.contains("})()\"")) {
                immediately = false;
                line = line.replaceAll("\\}\\)\\(\\)\"", "\\}\\)\\(\\)");
            }
            lines[i] = line;
        }
        return lines;
    }



    /**
     *
     *
     * @param object
     * @return
     */
    public static void print(Object object) {
        System.out.println(format(object));
    }

    /**
     *
     *
     * @param object
     * @return
     */
    public static void printPretty(Object object) {
        System.out.println(prettyFormat(object));
    }


}
