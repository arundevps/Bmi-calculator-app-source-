package com.example.bmicalculator;

import android.os.Bundle;
import android.app.Activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	public  EditText weight;
	public EditText height;
	public  TextView result;
	
	

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		EditText height=(EditText)findViewById(R.id.editText1);
		EditText weight=(EditText)findViewById(R.id.editText2);
		TextView result=(TextView)findViewById(R.id.result);
		Button buttonOnclick=(Button)findViewById(R.id.button1);
		
		
buttonOnclick.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				calculateBMI();
				
			}
		});
	}//end on create
		
	
	
	
	private void calculateBMI(){String heightstr=height.getText().toString();
	String weightstr =  weight.getText().toString();
	if(heightstr !=null && "".equals(heightstr) && 
			weightstr !=null && !"".equals(weightstr)){
		float heigthvalue=Float.parseFloat(heightstr)/100;
		float wightvalue =Float.parseFloat(weightstr);
		float bmi=wightvalue/ (heigthvalue*heigthvalue);
		displayBMI(bmi);
		}
	
		
	
	}
	private void displayBMI(Float bmi) {
		String bmil="";
		if(Float.compare(bmi, 15f)<=0){
			bmil=getString(R.string.very_under_weight);
	      }
		else if(Float.compare(bmi, 15f)>0 && Float.compare(bmi, 16f)<=0){
			bmil=getString(R.string.under_weight);
			
		}
		else if(Float.compare(bmi, 18.5f)>0 && Float.compare(bmi, 25f)<=0){
			bmil =getString(R.string.normal_condition);
		}
		
		
		
		
		bmil=bmi+ "\n\n" +bmil;
		result.setText(bmil);
		}//end of method displayBMI
	

	



	
}//main
