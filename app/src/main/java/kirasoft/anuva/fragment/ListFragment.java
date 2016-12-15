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


    private static int[] drawableIds = {
            R.drawable.btn_camera_up, R.drawable.btn_climate_up, R.drawable.btn_experience_up, R.drawable.btn_fireplace_up,
            R.drawable.btn_garage_up, R.drawable.btn_gate_up, R.drawable.btn_light_up,
            R.drawable.btn_locks_up, R.drawable.btn_music_up, R.drawable.btn_pool_up,
            R.drawable.btn_security_up, R.drawable.btn_sprinkler_up, R.drawable.btn_tv_up, R.drawable.btn_window_up
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        //use butterknife to reduce boilerplate. (no view = findViewById..)
        ButterKnife.bind(this, rootView);

        ButtonListAdapter adapter = new ButtonListAdapter(getActivity(), 0, getButtonDrawablesList());
        listView.setAdapter(adapter);

        return rootView;
    }


    //Get Drawables from resources and return as list of drawables
    private List<Drawable> getButtonDrawablesList() {

        List<Drawable> drawableList = new ArrayList<>();

        for (int id : drawableIds) {
            //add each drawable by id found in int-array in arrays.xml
            drawableList.add(ContextCompat.getDrawable(getActivity(), id));
        }
        return drawableList;
    }
}

