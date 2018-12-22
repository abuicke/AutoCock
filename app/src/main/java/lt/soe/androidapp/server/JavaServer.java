package lt.soe.androidapp.server;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lt.soe.androidapp.cocktail.Cocktail;
import lt.soe.androidapp.json.JsonUtils;

public final class JavaServer {

    private static final String SERVER_URL = "http://192.168.0.15:8080";

    public interface Listener {
        void onCocktailsReceived(List<Cocktail> cocktails);
    }

    public void getCocktails(Listener listener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    List<Cocktail> cocktails = new ArrayList<>();
                    String jsonStr = JsonUtils.fetchJson(SERVER_URL + "/get_cocktails");
                    JSONArray cocktailsJsonArray = new JSONArray(jsonStr);
                    for (int i = 0; i < cocktailsJsonArray.length(); i++) {
                        String cocktailName = cocktailsJsonArray.getJSONObject(i).getString("name");
                        Cocktail cocktail = Cocktail.TEST_COCKTAIL(cocktailName);
                        cocktails.add(cocktail);
                    }
                    listener.onCocktailsReceived(cocktails);
                } catch (JSONException | IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        }.start();
    }

    public void constructCocktail(Cocktail cocktail) {
        new Thread() {
            @Override
            public void run() {
                try {
                    JsonUtils.postJson(cocktail, SERVER_URL + "/construct_cocktail");
                } catch (IOException ioe) {
                    throw new IllegalStateException(ioe);
                }
            }
        }.start();
    }

}
