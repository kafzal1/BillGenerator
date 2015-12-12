package com.example.acer.billgenerator;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// Do the same for TabFragment2 and TabFragment3
// Just change R.layout.tab_fragment_1

public class TabFragment3 extends Fragment{

    TextView updateText;
    final static String DATA_RECEIVE = "data_receive";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_3, null);

        updateText=(TextView)rootView.findViewById(R.id.amountDisplay);
       // String strtext=getArguments().getString("value");
       /* if(strtext.equals(""))
        {
            Toast.makeText(this, "Got it!", Toast.LENGTH_SHORT).show();
        }
        else
        {

        }*/
        //updateText.setText("komal");
      /*  Bundle args = getArguments();
        if (args != null) {
            updateText.setText(args.getString(DATA_RECEIVE));
        }*/

        MainActivity activity = (MainActivity) getActivity();
        String myData = activity.getMyData();
        if (myData.equals(""))
        {
            updateText.setText("no database available");
        }
        else
        {updateText.setText(myData);}

        return rootView;
    }

    public void updateTextField(){
       // updateText.setText();
    }

   /* @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        String value = bundle.getString(DATA_RECEIVE);
        Toast.makeText(getActivity(),value,Toast.LENGTH_SHORT).show();
    }*/
  /* @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
      //  if (args != null) {
            updateText.setText(args.getString("value"));


    }*/


}