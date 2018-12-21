package lt.soe.androidapp;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public final class JavaServer {

    public interface Listener {
        void onCocktailsReceived(List<String> cocktails);
    }

    public void getCocktails(Listener listener) {
        new Thread() {
            @Override
            public void run() {
                String jsonStr = JsonFetcher.fetchJson("http://192.168.0.15:8080/get_cocktails");
                try {
                    List<String> cocktailNames = new ArrayList<>();
                    JSONArray cocktailsJsonArray = new JSONArray(jsonStr);
                    for (int i = 0; i < cocktailsJsonArray.length(); i++) {
                        String cocktailName = cocktailsJsonArray.getJSONObject(i).getString("name");
                        cocktailNames.add(cocktailName);
                    }
                    listener.onCocktailsReceived(cocktailNames);
                } catch (JSONException e) {
                    throw new IllegalStateException(e);
                }
            }
        }.start();
    }

}
