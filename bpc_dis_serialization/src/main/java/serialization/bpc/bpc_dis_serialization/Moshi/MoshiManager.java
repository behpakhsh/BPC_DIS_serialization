package serialization.bpc.bpc_dis_serialization.Moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;

public class MoshiManager {

    public static <T> T jsonStringToModel(String json, Class<T> modelClass) {
        try {
            Moshi moshi = new Moshi.Builder().build();
            JsonAdapter<T> jsonAdapter = moshi.adapter(modelClass);
            return jsonAdapter.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T jsonStringToModel(String json, Class<T> adapterClass, Class<T> modelClass) {
        try {
            Moshi moshi = new Moshi.Builder().add(adapterClass).build();
            JsonAdapter<T> jsonAdapter = moshi.adapter(modelClass);
            return jsonAdapter.fromJson(json);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> String modelToJsonString(Class<T> modelClass, T model) {
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<T> jsonAdapter = moshi.adapter(modelClass);
        return jsonAdapter.toJson(model);
    }

    public static <T> String modelToJsonString(Class<T> adapterClass, Class<T> modelClass, T model) {
        Moshi moshi = new Moshi.Builder().add(adapterClass).build();
        JsonAdapter<T> jsonAdapter = moshi.adapter(modelClass);
        return jsonAdapter.toJson(model);
    }

}
