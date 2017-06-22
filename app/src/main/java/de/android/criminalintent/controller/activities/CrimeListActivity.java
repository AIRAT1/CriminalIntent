package de.android.criminalintent.controller.activities;

import android.support.v4.app.Fragment;

import de.android.criminalintent.controller.fragments.CrimeListFragment;
import de.android.criminalintent.controller.fragments.SingleFragmentActivity;

public class CrimeListActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
