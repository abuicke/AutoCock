package lt.soe.androidapp.json;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public final class JsonUtils {

    public static String fetchJson(String url) throws IOException {
        return new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()
                .newCall(new Request.Builder().url(url).build())
                .execute()
                .body()
                .string();
    }

    public static void postJson(Object object, String url) throws IOException {
        MediaType jsonMediaType = MediaType.parse("application/json; charset=utf-8");
        String json = new Gson().toJson(object);
        new OkHttpClient()
                .newCall(new Request.Builder()
                        .url(url)
                        .post(RequestBody.create(jsonMediaType, json))
                        .build()
                ).execute();
    }

}
