package de.android.criminalintent.controller.activities;

import android.support.v4.app.Fragment;

import de.android.criminalintent.controller.fragments.CrimeFragment;
import de.android.criminalintent.controller.fragments.SingleFragmentActivity;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
