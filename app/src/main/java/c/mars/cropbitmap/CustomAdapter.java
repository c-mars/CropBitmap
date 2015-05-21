package c.mars.cropbitmap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

/**
 * Created by mars on 5/21/15.
 */
public class CustomAdapter extends ArrayAdapter<String> {
    private Item[] items;
    LayoutInflater inflater;

    public CustomAdapter(Context context, Item[] items) {
        super(context, android.R.layout.simple_list_item_1);
        this.items = items;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return items[position].getView(getContext(), inflater, convertView, parent);
    }

    @Override
    public int getCount() {
        return items.length;
    }
}
