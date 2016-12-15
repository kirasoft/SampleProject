package kirasoft.anuva.fragment;

import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kirasoft.anuva.R;
import kirasoft.anuva.adapter.ButtonListAdapter;

/**
 * Created by Kota on 12/14/2016.
 */

public class ListFragment extends Fragment {

    @BindView(R.id.list_view)
    ListView listView;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        //use butterknife to reduce boilerplate. (no view = findViewById..)
        ButterKnife.bind(this, getActivity());

        ButtonListAdapter adapter = new ButtonListAdapter(getActivity(), 0, getButtonDrawablesList());
        listView.setAdapter(adapter);

        return rootView;
    }


    //Get Drawables from resources and return as list of drawables
    private List<Drawable> getButtonDrawablesList(){
        List<Drawable> drawableList = new ArrayList<>();
        for(int id : getResources().getIntArray(R.array.list_items)){
            //add each drawable by id found in int-array in arrays.xml
            drawableList.add(ContextCompat.getDrawable(getActivity(), id));
        }
        return drawableList;
    }

}
