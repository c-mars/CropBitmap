package c.mars.cropbitmap;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Size;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    Item[] items=new Item[]{new Item("Alpha"), new Item("Beta"), new Item("Gamma")};
    ListView listView;
    CustomAdapter adapter;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.list);
        adapter=new CustomAdapter(this, items);
        listView.setAdapter(adapter);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus){
            ImageView  imgView= (ImageView) findViewById(R.id.img);
            cropBackground(this, imgView, R.drawable.fighter);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private static void cropBackground(Context context, ImageView imgView, int resId) {
        Bitmap original = BitmapFactory.decodeResource(context.getResources(), resId);

        int w = imgView.getWidth();
        int h = imgView.getHeight();
        Size size= new Size(w, h);
        Rect dstRect = new Rect(0, 0, w, h);
        Rect srcRect = dstRect;


        Bitmap bitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(original, srcRect, dstRect, null);

        Bitmap result = Bitmap.createBitmap(bitmap, 0, 0, size.getWidth(), size.getHeight());
        imgView.setImageBitmap(result);
    }


}
