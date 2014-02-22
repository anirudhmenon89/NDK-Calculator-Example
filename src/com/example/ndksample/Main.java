package com.example.ndksample;

import java.security.PublicKey;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
	
	NativeLib lib=null;
	
	EditText etNum1, etNum2;
	
	Button btnCalculate;
	
	RadioButton rbAdd, rbSub, rbMul, rbDiv;
	
	TextView tvAns;
	
	int num1, num2;
	
	static{
		System.loadLibrary("myjni"); 
		/** 
		 * myjni.dll in Windows
		 * libmyjni.so in Unix/Linux
		 */
	}
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		/** Initialize all Widgets */
		etNum1=(EditText) findViewById(R.id.etNum1);
		etNum2=(EditText) findViewById(R.id.etNum2);
		
		btnCalculate=(Button) findViewById(R.id.btnCalculate);
		
		rbAdd=(RadioButton) findViewById(R.id.rbAdd);
		rbSub=(RadioButton) findViewById(R.id.rbSub);
		rbMul=(RadioButton) findViewById(R.id.rbMul);
		rbDiv=(RadioButton) findViewById(R.id.rbDiv);
		
		tvAns=(TextView) findViewById(R.id.tvAns);
		
		btnCalculate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int ans=0;
				
				/** Get the values of the numbers */
				
				String n1=etNum1.getText().toString();
				String n2=etNum2.getText().toString();
				if(n1.equals("") || n2.equals(""))
					showToast("Please enter two numbers");
				else{
					num1=Integer.parseInt(n1);
					num2=Integer.parseInt(n2);
				}
				
				if(rbAdd.isChecked()){
					lib=new NativeLib();
					ans=lib.add(num1, num2);
				}
				else if(rbSub.isChecked()){
					lib=new NativeLib();
					ans=lib.sub(num1, num2);
				}
				else if(rbMul.isChecked()){
					lib=new NativeLib();
					ans=lib.mul(num1, num2);
				}
				else if(rbDiv.isChecked()){
					lib=new NativeLib();
					ans=lib.div(num1, num2);
				}
				else{
					showToast("Please select an operation");
				}
				
				if(lib!=null){
					tvAns.setVisibility(View.VISIBLE);
					tvAns.setText("Answer: "+ans);
				}
				
			}
		});
	}
	
	void showToast(String message){
		Toast.makeText(Main.this, message, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

class NativeLib{
	
	
	public native int add(int n1, int n2);
	
	public native int sub(int n1, int n2);
	
	public native int mul(int n1, int n2);
	
	public native int div(int n1, int n2);
	
}
