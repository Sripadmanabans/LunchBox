package zerobase.us.lunchbox.interfaces;

import android.app.Fragment;

/**
 * This is the interface used to switch fragments.
 * Created by Sripad on 1/11/2016.
 */
public interface SwitchInterface {

    /**
     * This is the function that needs to be overridden to open new fragments.
     *
     * @param fragment       The fragment that needs to be opened.
     * @param addToBackStack A boolean that if true, means the fragment has to be added to the back
     *                       stack. Else the fragment is not added to it.
     */
    void openFragment(Fragment fragment, boolean addToBackStack);
}
