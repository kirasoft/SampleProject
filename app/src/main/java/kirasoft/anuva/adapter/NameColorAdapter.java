package kirasoft.anuva.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kirasoft.anuva.R;
import kirasoft.anuva.model.NameBlock;

/**
 * Created by dekir on 12/14/2016.
 */

public class NameColorAdapter extends ArrayAdapter<NameBlock> {

    public NameColorAdapter(Context context, int resource, List<NameBlock> objects) {
        super(context, resource, objects);
    }

    //return single view of name and color
    @Override
    public View getView(int position, View view, ViewGroup container){

        NameColorViewHolder viewHolder;
        NameBlock nb = getItem(position);

        if(view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.name_color_list_item, null);
            viewHolder = new NameColorViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (NameColorViewHolder) view.getTag();
        }

        if(viewHolder != null) {
            viewHolder.block.setBackgroundColor(ContextCompat.getColor(getContext(), nb.getColor()));
            viewHolder.nameText.setText(nb.getName());
        }

        return view;
    }

    static class NameColorViewHolder {

        @BindView(R.id.name_text)
        TextView nameText;
        @BindView(R.id.block)
        View block;

        public NameColorViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
