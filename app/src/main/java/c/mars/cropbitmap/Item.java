package c.mars.cropbitmap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * Created by mars on 5/21/15.
 */
public class Item {
    public Item(String text) {
        this.text = text;
    }

    String text;

    public View getView(Context context, LayoutInflater inflater, View convertView, ViewGroup parent) {
        View rootView = convertView;
        if (rootView == null) {
            rootView=inflater.inflate(R.layout.row, null);
        }
        TextView textView= (TextView) rootView.findViewById(R.id.text);
        textView.setText(text);
        return rootView;
    }
}
