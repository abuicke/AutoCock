package lt.soe.androidapp;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class JsonUtils {

    private static final String TAG = JsonUtils.class.getSimpleName();

    public static String fetchJson(String url) throws IOException {
        return new OkHttpClient()
                .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()
                .newCall(new Request.Builder().url(url).build())
                .execute()
                .body()
                .string();
    }

    public static void postJson(Object object, String url) throws IOException {
        MediaType jsonMediaType = MediaType.parse("application/json; charset=utf-8");
        String jsonStr = new Gson().toJson(object);

        RequestBody body = RequestBody.create(jsonMediaType, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        if (response.body() != null) {
            Log.i(TAG, response.body().string());
        }
    }

}
