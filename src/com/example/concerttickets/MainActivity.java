package com.example.concerttickets;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	double costPerTicket=59.99;
	int numOfTickets;
	double totalCost;
	String groupChoice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText num_tix=(EditText) findViewById(R.id.txtTickets);
		final Spinner group=(Spinner) findViewById(R.id.txtGroup);
		Button cost=(Button) findViewById(R.id.btnCost);
		final TextView result=((TextView) findViewById(R.id.txtResult));
		cost.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				numOfTickets=Integer.parseInt(num_tix.getText().toString());
				totalCost=costPerTicket*numOfTickets;
				DecimalFormat currency = new DecimalFormat("$###,###.##");
				groupChoice=group.getSelectedItem().toString();
				result.setText("Total cost for "+groupChoice+" is "+currency.format(totalCost));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
