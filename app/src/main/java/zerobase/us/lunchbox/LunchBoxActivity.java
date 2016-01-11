package zerobase.us.lunchbox;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.lunchbox.base.BaseActivity;
import zerobase.us.lunchbox.fragments.RegistrationFragment;

public class LunchBoxActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_box);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        fragmentContainerID = R.id.fragment_container;
        openFragment(new RegistrationFragment(), false);
    }
}
