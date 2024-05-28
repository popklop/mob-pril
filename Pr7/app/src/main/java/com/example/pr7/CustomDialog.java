package com.example.pr7;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CustomDialog extends DialogFragment
{
   public static String name = null;
    @Override
    public Dialog onCreateDialog(Bundle savedIntanceState)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.fragment_custom_dialog,null);
        builder.setView(view);
        EditText editText = view.findViewById(R.id.editTextText2);
        editText.setText(name);
        return builder.create();
    }
}