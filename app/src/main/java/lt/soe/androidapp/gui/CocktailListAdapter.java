package lt.soe.androidapp.gui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import lt.soe.androidapp.R;
import lt.soe.androidapp.cocktail.Cocktail;

public class CocktailListAdapter extends BaseAdapter {

    private LayoutInflater _layoutInflater;
    private List<Cocktail> _cocktailNames;

    public CocktailListAdapter(LayoutInflater inflater, List<Cocktail> cocktailNames) {
        _layoutInflater = inflater;
        _cocktailNames = cocktailNames;
    }

    @Override
    public int getCount() {
        return _cocktailNames.size();
    }

    @Override
    public Object getItem(int i) {
        return _cocktailNames.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) _layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        textView.setText(_cocktailNames.get(i).name);
        return textView;
    }

}
