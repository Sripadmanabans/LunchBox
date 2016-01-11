package zerobase.us.lunchbox.interfaces;

import android.app.Fragment;
import android.content.Context;

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

    /**
     * This is the function that needs to be overridden to open a new activity.
     *
     * @param context        This is the context from which we move to the next activity.
     * @param activityToOpen This is the activity to move to.
     */
    void openActivity(Context context, Class<?> activityToOpen);
}
