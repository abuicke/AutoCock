package lt.soe.androidapp.server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import lt.soe.androidapp.cocktail.Cocktail;
import lt.soe.androidapp.cocktail.CocktailOrder;
import lt.soe.androidapp.json.JsonUtils;
import lt.soe.androidapp.pumps.PumpsConfiguration;

public final class JavaServer {

    private static final String SERVER_URL = "http://192.168.1.11";

    public interface OnCocktailsReceivedListener {
        void onCocktailsReceived(List<Cocktail> cocktails);
    }

    public interface OnPumpsConfigurationReceivedListener {
        void onPumpsConfigurationReceived(PumpsConfiguration pumpsConfiguration);
    }

    public void getCocktails(OnCocktailsReceivedListener listener) {
        new Thread(() -> {
            try {
                String jsonStr = JsonUtils.fetchJson(SERVER_URL + "/get_cocktails");
                Type listOfCocktails = new TypeToken<List<Cocktail>>() {
                }.getType();
                List<Cocktail> cocktails = new Gson().fromJson(jsonStr, listOfCocktails);
                listener.onCocktailsReceived(cocktails);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }).start();
    }

    public void constructCocktail(Cocktail cocktail) {
        new Thread(() -> {
            try {
                JsonUtils.postJson(cocktail, SERVER_URL + "/construct_cocktail");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }).start();
    }

    public void orderCocktail(CocktailOrder cocktailOrder) {
        new Thread(() -> {
            try {
                JsonUtils.postJson(cocktailOrder, SERVER_URL + "/order_cocktail");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }).start();
    }

    public void deleteCocktail(Cocktail cocktail) {
        new Thread(() -> {
            try {
                JsonUtils.postJson(cocktail, SERVER_URL + "/delete_cocktail");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }).start();
    }

    public void getPumpsConfiguration(OnPumpsConfigurationReceivedListener listener) {
        new Thread(() -> {
            try {
                String jsonStr = JsonUtils.fetchJson(SERVER_URL + "/get_pumps_configuration");
                PumpsConfiguration pumpsConfiguration = new Gson().fromJson(jsonStr, PumpsConfiguration.class);
                listener.onPumpsConfigurationReceived(pumpsConfiguration);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }).start();
    }

    public void setPumpsConfiguration(PumpsConfiguration pumpsConfiguration) {
        new Thread(() -> {
            try {
                JsonUtils.postJson(pumpsConfiguration, SERVER_URL + "/set_pumps_configuration");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }).start();
    }

}
