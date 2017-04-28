package com.example.android.sunshine.app;
/*
 * Copyright (C) 2013 The Android Open Source Project
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by AnhHo on 4/9/2017.
 */

public class CustomEditTextPreference extends EditTextPreference {
    private static final int DEFAULT_MINIMUM_LENGTH = 0;
    private int mMinlength;

    public CustomEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomEditTextPreferenceAttribute, 0, 0);

        try {
            mMinlength = typedArray.getInteger(R.styleable.CustomEditTextPreferenceAttribute_minLength, DEFAULT_MINIMUM_LENGTH);
        } finally {
            typedArray.recycle();
        }
    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);
        EditText editText = getEditText();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Dialog dialog = getDialog();
                if (dialog instanceof AlertDialog) {
                    Button positiveButton = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    if (s.length() < mMinlength) {
                        positiveButton.setEnabled(false);
                    } else {
                        positiveButton.setEnabled(true);
                    }
                }

            }
        });
    }
}
