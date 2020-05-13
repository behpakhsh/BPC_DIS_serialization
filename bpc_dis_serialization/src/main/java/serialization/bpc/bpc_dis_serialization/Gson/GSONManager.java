package serialization.bpc.bpc_dis_serialization.Gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GSONManager {

    public static Gson getGson() {
        return new GsonBuilder().create();
    }

    public static <T> String toJson(T obj) {
        try {
            return getGson().toJson(obj);
        } catch (Exception ex) {
            return "";
        }
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return getGson().fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOf) {
        return getGson().fromJson(json, typeOf);
    }

    public static <T> List<T> fromJsonList(String json, Class<T> clazz) {
        Object[] array = (Object[]) java.lang.reflect.Array.newInstance(clazz, 0);
        array = getGson().fromJson(json, array.getClass());
        List<T> list = new ArrayList<>();
        for (Object o : array)
            list.add(clazz.cast(o));
        return list;
    }

    public static <T> JsonObject convertObjectToJsonObject(T obj) {
        String jsonString = getGson().toJson(obj);
        JsonParser jsonParser = new JsonParser();
        try {
            return (JsonObject) jsonParser.parse((new JSONObject(jsonString)).toString());
        } catch (JSONException e) {
            e.printStackTrace();
            return new JsonObject();
        }
    }

    public static <T> JsonArray convertArrayToJsonArray(List<T> obj) {
        String jsonString = getGson().toJson(obj);
        JsonParser jsonParser = new JsonParser();
        try {
            return (JsonArray) jsonParser.parse((new JSONArray(jsonString)).toString());
        } catch (JSONException e) {
            e.printStackTrace();
            return new JsonArray();
        }
    }

}