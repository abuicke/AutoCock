package lt.soe.autocock.autocockandroidinterface.http;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class JsonFetcher {

    private static final String TAG = JsonFetcher.class.getSimpleName();

    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();

    public static String fetchJson(String jsonUrl) {
        Request jsonRequest = new Request.Builder()
                .url(jsonUrl)
                .build();

        try {
            Call jsonHttpCall = OK_HTTP_CLIENT.newCall(jsonRequest);
            Response jsonResponse = jsonHttpCall.execute();
            ResponseBody jsonResponseBody = jsonResponse.body();
            if (jsonResponseBody != null) {
                String jsonStr = jsonResponseBody.string();
                return jsonStr;
            } else {
                throw new IllegalStateException("json str empty");
            }
        } catch (IOException e) {
            throw new IllegalStateException("fetch json failed", e);
        }
    }

}
