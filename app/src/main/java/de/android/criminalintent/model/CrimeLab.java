package de.android.criminalintent.model;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import de.android.criminalintent.model.database.CrimeBaseHelper;

public class CrimeLab {
    private static CrimeLab crimeLab;
    private List<Crime> crimes;
    private Context context;
    private SQLiteDatabase database;

    private CrimeLab(Context context){
        this.context = context.getApplicationContext();
        database = new CrimeBaseHelper(context).getWritableDatabase();
        crimes = new ArrayList<>();
    }

    public static CrimeLab get(Context context) {
        if (crimeLab == null) {
            crimeLab = new CrimeLab(context);
        }
        return crimeLab;
    }

    public void addCrime(Crime c) {
        crimes.add(c);
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : crimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}
