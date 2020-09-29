package serialization.bpc.bpc_dis_serialization.Gson;

import android.annotation.SuppressLint;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GSONManager {

    @SuppressLint("SimpleDateFormat")
    public static Gson gsonWithDateSerializer() {

        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

            final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                try {
                    if (json != null) {
                        if (json.getAsString() != null) {
                            Date parse = df.parse(json.getAsString());
                            if (parse != null) {
                                return new SerializableDateTime(parse);
                            }
                        }
                    }
                    return null;
                } catch (final java.text.ParseException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });

        builder.registerTypeAdapter(SerializableDateTime.class, new JsonDeserializer<SerializableDateTime>() {

            final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");

            @Override
            public SerializableDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                try {
                    if (json != null) {
                        if (json.getAsString() != null) {
                            Date parse = df.parse(json.getAsString());
                            if (parse != null) {
                                return new SerializableDateTime(parse);
                            }
                        }
                    }
                    return null;
                } catch (final java.text.ParseException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });

        builder.registerTypeAdapter(SerializableDateTime.class, new JsonDeserializer<SerializableDateTime>() {

            final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            @Override
            public SerializableDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                try {
                    if (json != null) {
                        if (json.getAsString() != null) {
                            Date parse = df.parse(json.getAsString());
                            if (parse != null) {
                                return new SerializableDateTime(parse);
                            }
                        }
                    }
                    return null;
                } catch (final java.text.ParseException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });

        builder.registerTypeAdapter(SerializableDateTime.class, new JsonDeserializer<SerializableDateTime>() {

            final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            @Override
            public SerializableDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                try {
                    if (json != null) {
                        if (json.getAsString() != null) {
                            Date parse = df.parse(json.getAsString());
                            if (parse != null) {
                                return new SerializableDateTime(parse);
                            }
                        }
                    }
                    return null;
                } catch (final java.text.ParseException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });

        return builder.create();
    }

    public static Gson getGson() {
        return gsonWithDateSerializer();
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