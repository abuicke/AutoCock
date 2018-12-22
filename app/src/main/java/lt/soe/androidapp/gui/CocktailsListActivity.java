package lt.soe.androidapp.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import lt.soe.androidapp.R;
import lt.soe.androidapp.server.JavaServer;

public class CocktailsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JavaServer javaServer = new JavaServer();
        javaServer.getCocktails(cocktails -> runOnUiThread(() -> {
            ListView cocktailsListView = findViewById(R.id.cocktails_list);
            ListAdapter cocktailListAdapter = new CocktailListAdapter(getLayoutInflater(), cocktails);
            cocktailsListView.setAdapter(cocktailListAdapter);
        }));
    }

}
