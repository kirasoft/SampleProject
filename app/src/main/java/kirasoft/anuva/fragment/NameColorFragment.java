package kirasoft.anuva.fragment;

import android.app.Fragment;
import android.os.Bundle;
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
import kirasoft.anuva.adapter.NameColorAdapter;
import kirasoft.anuva.model.NameBlock;

/**
 * Created by dekir on 12/14/2016.
 */

public class NameColorFragment extends Fragment {

    @BindView(R.id.list_view)
    ListView listView;

    private NameColorAdapter colorAdapter;
    List<NameBlock> nbList;

    private int red = R.color.IndianRed;
    private int blue = R.color.Aquamarine;
    private int green = R.color.ForestGreen;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.fragment_numbers_list, container, false);
        //use Butterknife to reduce boilerplate. (no view = findViewById..)
        ButterKnife.bind(this, rootView);

        nbList = new ArrayList<>();
        nbList.add(new NameBlock("Joe", red));
        nbList.add(new NameBlock("Bill", blue));
        nbList.add(new NameBlock("Bob", green));

        colorAdapter = new NameColorAdapter(getActivity(), R.layout.name_color_list_item, nbList);
        listView.setAdapter(colorAdapter);
        return rootView;
    }



}
