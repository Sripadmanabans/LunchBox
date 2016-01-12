package zerobase.us.lunchbox.base;

import android.app.Activity;
import android.app.Fragment;

import zerobase.us.lunchbox.R;
import zerobase.us.lunchbox.interfaces.SwitchInterface;

/**
 * This is the base fragment that is to be used by all the fragments.
 * Created by Sripad on 1/11/2016.
 */
public class BaseFragment extends Fragment {

    protected SwitchInterface switchPage;

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            switchPage = (SwitchInterface) activity;
        } catch (ClassCastException exception) {
            throw new ClassCastException(getString(R.string.class_cast_exception_message));
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        switchPage = null;
    }
}
