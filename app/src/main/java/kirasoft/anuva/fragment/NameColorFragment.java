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

    private int red = R.color.IndianRed;
    private int blue = R.color.Aquamarine;
    private int green = R.color.ForestGreen;

    private int nbColor = red;
    private String nbName = "";

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
        nbList.add(new NameBlock("Joe", red));
        nbList.add(new NameBlock("Bill", blue));
        nbList.add(new NameBlock("Bob", green));

        colorAdapter = new NameColorAdapter(getActivity(), R.layout.name_color_list_item, nbList);
        listView.setAdapter(colorAdapter);
        return rootView;
    }


    @OnClick(R.id.button_add_name)
    public void addNameClick() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_name_color);
        dialog.setCancelable(true);
        RadioGroup colorGroup = (RadioGroup) dialog.findViewById(R.id.dialog_radio_group);
        EditText nameEdit = (EditText) dialog.findViewById(R.id.edit_name);
        colorGroup.check(R.id.radio_red);
        colorGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_green:
                        nbColor = green;
                        break;
                    case R.id.radio_blue:
                        nbColor = blue;
                        break;
                    case R.id.radio_red:
                        nbColor = red;
                        break;
                    default:
                        break;
                }
            }
        });

        nameEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                nbName = s.toString();
            }
        });

        Button submit = (Button)dialog.findViewById(R.id.button_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nbName.isEmpty()){
                    Toast.makeText(getActivity(), "Name can't be empty", Toast.LENGTH_LONG).show();
                    return;
                }
                NameBlock nameBlock = new NameBlock(nbName, nbColor);
                nbName = "";
                nbList.add(nameBlock);
                colorAdapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });


        dialog.show();

    }


}
