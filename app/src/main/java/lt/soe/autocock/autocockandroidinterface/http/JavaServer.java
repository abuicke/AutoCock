package lt.soe.autocock.autocockandroidinterface.http;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public final class JavaServer {

    public List<String> getCocktailNames() {
        final Semaphore semaphore = new Semaphore(0);
        final List<String> cocktailNames = new ArrayList<>();

        new Thread() {
            @Override
            public void run() {
                String jsonStr = JsonFetcher.fetchJson("http://78.17.177.112/get_cocktails");
                try {
                    JSONArray cocktailsJsonArray = new JSONArray(jsonStr);
                    for (int i = 0; i < cocktailsJsonArray.length(); i++) {
                        String cocktailName = cocktailsJsonArray.getJSONObject(i).getString("name");
                        cocktailNames.add(cocktailName);
                    }
                    semaphore.release();
                } catch (JSONException e) {
                    semaphore.release();
                    throw new IllegalStateException(e);
                }
            }
        }.start();

        try {
            semaphore.acquire();
        } catch (InterruptedException ie) {
            throw new IllegalStateException(ie);
        }

        return cocktailNames;
    }

}
