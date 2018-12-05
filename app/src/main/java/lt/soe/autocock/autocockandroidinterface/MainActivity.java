package lt.soe.autocock.autocockandroidinterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import lt.soe.autocock.autocockandroidinterface.http.JavaServer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JavaServer javaServer = new JavaServer();
        List<String> cocktailNames = javaServer.getCocktailNames();

        ListView cocktailsListView = findViewById(R.id.cocktails_list);
        ListAdapter cocktailListAdapter = new CocktailListAdapter(getLayoutInflater(), cocktailNames);
        cocktailsListView.setAdapter(cocktailListAdapter);
    }

}
