package org.chandroid.simpledialer;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Simple Dialer practice, simple solution
 * @author vfdiaz
 *
 */
public class SimpleDialer extends Activity {
    
	
	
    private static final String PHONE_PATTERN = "[6-9][0-9]{8}";
    private static final String PHONE_PREFFIX = "tel:";
	private Button btnCall;
    private EditText txtNumber;
    

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btnCall = (Button) findViewById(R.id.btnCall);
        txtNumber = (EditText) findViewById(R.id.number);
        
        btnCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	try{
	            	call();
            	}catch (Exception e) {
            	}
            }
        });
        
    }

	protected void call() {
		String number = txtNumber.getText().toString();
		if(number.matches(PHONE_PATTERN)){
			try{
				Intent callNumber = new Intent(Intent.ACTION_CALL, Uri.parse(PHONE_PREFFIX + number));
				startActivity(callNumber);
			}catch (ActivityNotFoundException e) {
				Log.e("SimpleDialer", "Error",e);
			}
		}else{
			txtNumber.setText(R.string.badNumber);
		}
		
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_CALL) {
			call();
			return true;
		}
		return false;
	}
	
}