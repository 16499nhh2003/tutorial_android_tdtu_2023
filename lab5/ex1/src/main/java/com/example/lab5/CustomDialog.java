package com.example.lab5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CustomDialog extends DialogFragment {
    DialogListener listener;
    public interface DialogListener{
        public void onDialogPositiveClick(int b);
        public void onDialogNegativeClick(int b);
    }
    int id;
    public  CustomDialog (int id ){
        this.id  = id;
    }
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Xác nhận xóa")
                .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //send the position button event back to the host activity
                        listener.onDialogPositiveClick(id);
                    }
                })
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //send the negative button event back to the host activity
                        listener.onDialogNegativeClick(id);
                    }
                });
        return builder.create();
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (DialogListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(e + "");
        }
    }
}
