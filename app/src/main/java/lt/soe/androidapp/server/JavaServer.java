package lt.soe.androidapp.server;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import lt.soe.androidapp.cocktail.Cocktail;
import lt.soe.androidapp.cocktail.CocktailOrder;
import lt.soe.androidapp.json.JsonUtils;

public final class JavaServer {

    private static final String SERVER_URL = "http://192.168.0.15:8080";

    public interface Listener {
        void onCocktailsReceived(List<Cocktail> cocktails);
    }

    public void getCocktails(Listener listener) {
        new Thread(() -> {
            try {
                String jsonStr = JsonUtils.fetchJson(SERVER_URL + "/get_cocktails");
                Type listOfCocktails = new TypeToken<List<Cocktail>>() {
                }.getType();
                List<Cocktail> cocktails = new Gson().fromJson(jsonStr, listOfCocktails);
                listener.onCocktailsReceived(cocktails);
            } catch (IOException ioe) {
                throw new IllegalStateException(ioe);
            }
        }).start();
    }

    public void constructCocktail(Cocktail cocktail) {
        new Thread(() -> {
            try {
                ServerResponse serverResponse = JsonUtils.postJson(
                        cocktail, SERVER_URL + "/construct_cocktail"
                );

                if (serverResponse.successful) {
                    Log.i("java_server", serverResponse.message);
                } else {
                    Log.i("java_server", serverResponse.message);
                }
            } catch (IOException ioe) {
                throw new IllegalStateException(ioe);
            }
        }).start();
    }

    public void orderCocktail(CocktailOrder cocktailOrder) {
        new Thread(() -> {
            try {
                ServerResponse serverResponse = JsonUtils.postJson(
                        cocktailOrder, SERVER_URL + "/order_cocktail"
                );

                if (serverResponse.successful) {
                    Log.i("java_server", serverResponse.message);
                } else {
                    Log.i("java_server", serverResponse.message);
                }
            } catch (IOException ioe) {
                throw new IllegalStateException(ioe);
            }
        }).start();
    }

}
