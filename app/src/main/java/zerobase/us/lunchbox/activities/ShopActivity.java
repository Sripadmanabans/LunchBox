package zerobase.us.lunchbox.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.lunchbox.R;
import zerobase.us.lunchbox.base.BaseActivity;
import zerobase.us.lunchbox.fragments.ShopFragment;

/**
 * This is the activity that is used to open and close the truck shop.
 * Created by Sripad on 1/11/2016.
 */
public class ShopActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        fragmentContainerID = R.id.fragment_container;
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        collapsingToolbarLayout.setTitle(getString(R.string.app_name));

        openFragment(new ShopFragment(), false);
    }
}
