package kirasoft.anuva.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by dekir on 12/14/2016.
 */

public class ButtonListAdapter extends ArrayAdapter<Drawable> {

    //needed constructor
    public ButtonListAdapter(Context context, int resource, List<Drawable> drawables) {
        super(context, resource, drawables);
    }





}
