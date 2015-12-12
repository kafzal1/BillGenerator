package com.example.acer.billgenerator;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// Do the same for TabFragment2 and TabFragment3
// Just change R.layout.tab_fragment_1

public class TabFragment3 extends Fragment{

    TextView updateText;
    EditText name;
    TextView deleteButton;
    String userData;
    // private OnFragmentInteractionListener mListener;
    final static String DATA_RECEIVE = "data_receive";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_3, null);

        updateText=(TextView)rootView.findViewById(R.id.amountDisplay);
      //  name=(EditText)rootView.findViewById(R.id.enterAmountText);
        deleteButton=(TextView)rootView.findViewById(R.id.deleteAmount);


      /*  deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userData = name.getText().toString();
                //  onButtonPressed(userData);
            }
        });*/


        MainActivity activity = (MainActivity) getActivity();
        String myData = activity.getMyData();
        if (myData.equals(""))
        {
            updateText.setText("no database available");
        }
        else
        {updateText.setText("");
            updateText.setText(myData);}

        MainActivity activity1 = (MainActivity) getActivity();
        String myData1 = activity1.getMyData1().toString();
        deleteButton.setText(myData1);

       // updateText.setText(" ");
        return rootView;
    }
/*
    public void onButtonPressed(String userContent) {
        // if (mListener != null)
        {
            mListener.onFragmentInteraction(userContent);
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
        void onFragmentInteraction(String userContent);
    }
*/

}
