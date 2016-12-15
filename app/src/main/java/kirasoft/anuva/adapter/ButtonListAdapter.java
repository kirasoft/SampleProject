package kirasoft.anuva.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kirasoft.anuva.R;

/**
 * Created by dekir on 12/14/2016.
 */

public class ButtonListAdapter extends ArrayAdapter<Drawable> {

    //needed constructor
    public ButtonListAdapter(Context context, int resource, List<Drawable> drawables) {
        super(context, resource, drawables);
    }

    //return single view of Button for list
    @Override
    public View getView(int position, View view, ViewGroup container){

        ButtonListViewHolder viewHolder;
        Drawable drawable = getItem(position);

        if(view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.button_list_item, null);
            viewHolder = new ButtonListViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ButtonListViewHolder)view.getTag();
        }

        if(viewHolder != null) {
            viewHolder.image.setImageDrawable(drawable);
        }

        return view;
    }

    //button list view holder
    //container for a reference to the imageview inside each item
    static class ButtonListViewHolder{
        @BindView(R.id.button_list_image_view)
        ImageView image;

        public ButtonListViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }
}
