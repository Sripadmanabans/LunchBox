package zerobase.us.lunchbox.base;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import zerobase.us.lunchbox.interfaces.SwitchInterface;

/**
 * This is the base activity that will be used by all the activities.
 * Created by Sripad on 1/11/2016.
 */
public class BaseActivity extends AppCompatActivity implements SwitchInterface {

    protected Integer fragmentContainerID = null;

    @Override
    public void openFragment(Fragment fragment, boolean addToBackStack) {
        if(fragmentContainerID == null || fragment == null) {
            throw new NullPointerException("The fragmentContainerID Is null");
        }

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(fragmentContainerID, fragment, fragment.getClass().getSimpleName());

        if(addToBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }
}
