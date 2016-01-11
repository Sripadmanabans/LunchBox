package zerobase.us.lunchbox.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.lunchbox.R;

/**
 * This is the fragment that is used to register the food truck
 * Created by Sripad on 1/11/2016.
 */
public class RegistrationFragment extends Fragment {

    @Bind(R.id.truck_name_wrapper)
    TextInputLayout truckNameLayout;

    @Bind(R.id.activation_code_wrapper)
    TextInputLayout activationCodeLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        ButterKnife.bind(this, view);

        truckNameLayout.setHint(getString(R.string.truck_name_hint));
        activationCodeLayout.setHint(getString(R.string.activation_code_hint));

        return view;
    }
}
