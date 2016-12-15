package kirasoft.anuva.fragment;

import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.fragment_name_color, container, false);
        //use Butterknife to reduce boilerplate. (no view = findViewById..)
        ButterKnife.bind(this, rootView);

        nbList = new ArrayList<>();
        nbList.add(new NameBlock("Joe", R.color.Red));
        nbList.add(new NameBlock("Bill", R.color.Blue));
        nbList.add(new NameBlock("Bob", R.color.Green));

        colorAdapter = new NameColorAdapter(getActivity(), R.layout.name_color_list_item, nbList);
        listView.setAdapter(colorAdapter);
        return rootView;
    }


    //create dialog with color choices, name field and submit button
    @OnClick(R.id.button_add_name)
    public void addNameClick() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_name_color);
        dialog.setCancelable(true);

        final RadioGroup colorGroup = (RadioGroup) dialog.findViewById(R.id.dialog_radio_group);
        final EditText nameEdit = (EditText) dialog.findViewById(R.id.edit_name);
        colorGroup.check(R.id.radio_red);

        Button submit = (Button)dialog.findViewById(R.id.button_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nbName = nameEdit.getText().toString();
                //if name is empty, they need to try again
                if(nbName.isEmpty()){
                    Toast.makeText(getActivity(), "Name can't be empty", Toast.LENGTH_LONG).show();
                    return;
                }

                int nbColor = 0;

                final int checked = colorGroup.getCheckedRadioButtonId();
                switch (checked){
                    case R.id.radio_green:
                        nbColor =  R.color.Green;
                        break;
                    case R.id.radio_blue:
                        nbColor = R.color.Blue;
                        break;
                    case R.id.radio_red:
                        nbColor = R.color.Red;
                        break;
                    default:
                        break;
                }

                //create new nameblock from user choice and add it to list view
                NameBlock nameBlock = new NameBlock(nbName, nbColor);
                nbList.add(nameBlock);
                colorAdapter.notifyDataSetChanged();

                dialog.dismiss();
            }
        });

        dialog.show();
    }


}
