package zerobase.us.lunchbox.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.lunchbox.R;
import zerobase.us.lunchbox.adapter.ShopMenuListAdapter;
import zerobase.us.lunchbox.base.BaseFragment;
import zerobase.us.lunchbox.utils.NonScrollableListView;

/**
 * This is the fragment that is used to display the shop details.
 * Created by Sripad on 1/12/2016.
 */
public class ShopFragment extends BaseFragment {

    @Bind(R.id.address_line1_wrapper)
    TextInputLayout addressLine1;

    @Bind(R.id.address_line2_wrapper)
    TextInputLayout addressLine2;

    @Bind(R.id.city_wrapper)
    TextInputLayout city;

    @Bind(R.id.state_wrapper)
    TextInputLayout state;

    @Bind(R.id.menu_items)
    NonScrollableListView menuList;

    @Bind(R.id.shop_status_button)
    Button shopStatusButton;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this, view);

        addressLine1.setHint(getString(R.string.address_line1_hint));
        addressLine2.setHint(getString(R.string.address_line2_hint));
        city.setHint(getString(R.string.city_hint));
        state.setHint(getString(R.string.state_hint));

        ShopMenuListAdapter adapter = new ShopMenuListAdapter();
        menuList.setAdapter(adapter);

        return view;
    }
}
