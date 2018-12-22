package lt.soe.androidapp.gui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import lt.soe.androidapp.R;
import lt.soe.androidapp.cocktail.Cocktail;
import lt.soe.androidapp.cocktail.CocktailOrder;
import lt.soe.androidapp.server.JavaServer;

public class CocktailListAdapter extends BaseAdapter {

    private LayoutInflater _layoutInflater;
    private List<Cocktail> _cocktails;

    public CocktailListAdapter(LayoutInflater inflater, List<Cocktail> cocktails) {
        _layoutInflater = inflater;
        _cocktails = cocktails;
    }

    @Override
    public int getCount() {
        return _cocktails.size();
    }

    @Override
    public Object getItem(int i) {
        return _cocktails.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Cocktail cocktail = _cocktails.get(i);
        TextView textView = (TextView) _layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        textView.setText(cocktail.name);
        textView.setOnClickListener(v -> {
            CocktailOrder cocktailOrder = new CocktailOrder(cocktail.id);
            new JavaServer().orderCocktail(cocktailOrder);
        });
        return textView;
    }

}
