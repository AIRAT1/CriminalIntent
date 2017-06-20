package de.android.criminalintent.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import de.android.criminalintent.R;
import de.android.criminalintent.model.Crime;

public class CrimeFragment extends Fragment{
    private Crime crime;
    private EditText titleField;
    private Button dateButton;
    private CheckBox solvedCheckBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        crime = new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        titleField = (EditText)v.findViewById(R.id.crime_title);
        titleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence c, int start, int before, int count) {
                // unused
            }

            @Override
            public void onTextChanged(CharSequence c, int start, int before, int count) {
                crime.setTitle(c.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        dateButton = (Button)v.findViewById(R.id.crime_date);
        dateButton.setText(crime.getDate().toString());
        dateButton.setEnabled(false);

        solvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        solvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                crime.setSolved(isChecked);
            }
        });
        return v;
    }
}
