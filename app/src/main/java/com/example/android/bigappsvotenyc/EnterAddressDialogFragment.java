package com.example.android.bigappsvotenyc;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by catwong on 4/11/17.
 */

public class EnterAddressDialogFragment extends DialogFragment {

    private View mRoot;
    private Button bt_submit_address;
    private Dialog dialog;
    public EditText etAddress;
    public EditText etCity;
    public EditText etState;
    public EditText etZipCode;

    public static EnterAddressDialogFragment newInstance(String address) {
        EnterAddressDialogFragment fragment = new EnterAddressDialogFragment();
        Bundle args = new Bundle();
        args.putString("address", address);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_enter_address, parent, false);
        setViews();
        return mRoot;
    }


   public void setViews(){
       etAddress = (EditText) mRoot.findViewById(R.id.et_address);
       etCity = (EditText) mRoot.findViewById(R.id.et_city);
       etState = (EditText) mRoot.findViewById(R.id.et_state);
       etZipCode = (EditText) mRoot.findViewById(R.id.et_zip);
       bt_submit_address = (Button) mRoot.findViewById(R.id.bt_address_submit);
       bt_submit_address.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (etAddress.getText().toString().isEmpty() || etCity.getText().toString().isEmpty()
                       || etState.getText().toString().isEmpty() || etZipCode.getText().toString().isEmpty()) {

                   Toast.makeText(getActivity(), "All fields required", Toast.LENGTH_SHORT).show();

           } else {
                   dialog.dismiss();
               }
           }
       });

   }


}


