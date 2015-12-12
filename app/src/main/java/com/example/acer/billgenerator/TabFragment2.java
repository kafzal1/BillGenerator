package com.example.acer.billgenerator;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// Do the same for TabFragment2 and TabFragment3
// Just change R.layout.tab_fragment_1

public class TabFragment2 extends Fragment{

    EditText userInput;
    EditText deleteInput;
    Button bbutton;
   // Button dbutton;
    String userData;
    String deleteData;
    private OnFragmentInteractionListener mListener;
   // private OnFragmentInteractionListener mListener1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_2, null);

        userInput = (EditText)rootView.findViewById(R.id.enterName);
        bbutton = (Button)rootView.findViewById(R.id.addButton);
      //  dbutton = (Button)rootView.findViewById(R.id.deleteButton);
        deleteInput=(EditText)rootView.findViewById(R.id.deleteName);

        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userData = userInput.getText().toString();
                deleteData= deleteInput.getText().toString();
                onButtonPressed(userData,deleteData);
            }
        });



        return rootView;
    }

    public void onButtonPressed(String userContent,String amountContent) {
       // if (mListener != null)
        {
            mListener.onFragmentInteraction(userContent, amountContent);
        }
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String userContent, String amountContent);
    }
}