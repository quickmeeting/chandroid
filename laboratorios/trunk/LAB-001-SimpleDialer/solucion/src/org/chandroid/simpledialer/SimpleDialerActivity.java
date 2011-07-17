package org.chandroid.simpledialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SimpleDialerActivity extends Activity {
    
    static String mLogTag = "SimpleDialerActivity";
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(mLogTag,"Begin onCreate");
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button mButtonCaller = (Button) findViewById(R.id.button_Call);
        
        mButtonCaller.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callNumber();
            }
        });
        Log.d(mLogTag,"End onCreate");
    }

    public void callNumber(){
        Log.d(mLogTag,"Begin callNumber");
        
        EditText mTextNumber = (EditText) findViewById(R.id.text_Number);
        
        
        if (mTextNumber != null && !mTextNumber.getText().equals("")){
            Log.d(mLogTag,"Number to call = " + mTextNumber.getText());
            try {
                Intent startCaller = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + mTextNumber.getText()));
                startActivity(startCaller);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.d(mLogTag,"End callNumber");
    }
}