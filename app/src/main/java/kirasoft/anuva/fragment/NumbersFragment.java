package kirasoft.anuva.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kirasoft.anuva.R;

/**
 * Created by dekir on 12/14/2016.
 */

public class NumbersFragment extends Fragment {

    @BindView(R.id.list_view)
    ListView listView;

    private Stack<Integer> countList;
    private ArrayAdapter<Integer> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        countList = new Stack<>();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.fragment_numbers_list, container, false);
        //use Butterknife to reduce boilerplate. (no view = findViewById..)
        ButterKnife.bind(this, rootView);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, countList);
        listView.setAdapter(adapter);
        return rootView;
    }

    //add another number to the ListView
    //if the top of the number stack reaches 20, start it over from 1
    @OnClick(R.id.button_increase)
    public void increaseButtonClick(){

        Integer newNum = countList.peek() + 1;
        if(newNum > 20) {
            newNum = 1;
        }
        countList.push(newNum);
        adapter.notifyDataSetChanged();
    }

}
