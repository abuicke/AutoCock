package lt.soe.androidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JavaServer javaServer = new JavaServer();
        javaServer.getCocktails(cocktailNames -> runOnUiThread(() -> {
            ListView cocktailsListView = findViewById(R.id.cocktails_list);
            ListAdapter cocktailListAdapter = new CocktailListAdapter(getLayoutInflater(), cocktailNames);
            cocktailsListView.setAdapter(cocktailListAdapter);
        }));
    }

}
