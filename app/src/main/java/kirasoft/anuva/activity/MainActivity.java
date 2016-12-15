package kirasoft.anuva.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kirasoft.anuva.R;
import kirasoft.anuva.fragment.ButtonsFragment;
import kirasoft.anuva.fragment.NumbersFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.container)
    FrameLayout container;

    private static final String FIRST_FRAGMENT_TAG = "BUTTONS";
    private static final String SECOND_FRAGMENT_TAG = "NUMBERS";
    private static final String THIRD_FRAGMENT_TAG = "COLOR_NAME";
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    //using Butterknife's onclick removes boilerplate.
    //add Buttons List Fragment to users view
    @OnClick(R.id.radio_first)
    public void radioFirstClick(){
        getFragmentManager().beginTransaction().replace(R.id.container,
                new ButtonsFragment(), FIRST_FRAGMENT_TAG).addToBackStack(TAG).commit();
    }

    //add Numbers Fragment to users view
    @OnClick(R.id.radio_second)
    public void radioSecondClick() {
        getFragmentManager().beginTransaction().replace(R.id.container,
                new NumbersFragment(), SECOND_FRAGMENT_TAG).addToBackStack(TAG).commit();
    }




}
