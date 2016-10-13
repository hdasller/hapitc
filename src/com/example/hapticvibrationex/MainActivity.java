package com.example.hapticvibrationex;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.HapticFeedbackConstants;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity extends Activity {

	
	private EditText et1;
	private EditText et2;
	private EditText et3;
	
	private Button bt1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
et1 = (EditText) findViewById(R.id.editText1);
et2 = (EditText) findViewById(R.id.editText2);		
et3 = (EditText) findViewById(R.id.editText3);

bt1 = (Button) findViewById(R.id.button1);

et1.setOnTouchListener(new HapiticoPersonalizado());
et1.setHapticFeedbackEnabled(true);
et2.setOnTouchListener(new HapiticoPersonalizado());
et2.setHapticFeedbackEnabled(true);
et3.setOnTouchListener(new HapiticoPersonalizado());
et3.setHapticFeedbackEnabled(true);

bt1.setOnClickListener(new OnClickListener(){

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		Toast.makeText(MainActivity.this, "Envio dados formulario", Toast.LENGTH_LONG).show();
		Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		vb.vibrate(50);
	}});

	}
	
	public class HapiticoPersonalizado implements OnTouchListener{

		@Override
		public boolean onTouch(View view, MotionEvent event) {
			// TODO Auto-generated method stub
			
			Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
			vb.vibrate(50);
			
	view.requestFocus();
	InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	imm.showSoftInput(view, 0);
	
	
	return true;
		}
		
		
	}
	
	public class HapiticoNativo implements OnTouchListener{

		@Override
		public boolean onTouch(View view, MotionEvent event) {
			// TODO Auto-generated method stub
			
			
			
			view.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP);
	
			view.requestFocus();
			// Mostrar o Teclado
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
						imm.showSoftInput(view, 0);
			
			
			return true;
		}
		
		
	}
	
}
