package zerobase.us.lunchbox;

import android.os.Bundle;

import zerobase.us.lunchbox.base.BaseActivity;

public class LunchBoxActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_box);
        fragmentContainerID = R.id.fragment_container;
    }
}
