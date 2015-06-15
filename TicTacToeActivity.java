/*
 * Created by: Lou Cram
 * Created on: 3/5/15
 * 
 */

package com.lcram.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class TicTacToeActivity extends Activity
		implements OnClickListener {
	
	private Button buttonTL; 
	private Button buttonTC;
	private Button buttonTR;
	private Button buttonCL;
	private Button buttonCC;
	private Button buttonCR;
	private Button buttonBL;
	private Button buttonBC;
	private Button buttonBR;
	
	private TextView status;
	
	private SharedPreferences savedValues;
	
	private int count = 0;	
	private int selection = 0;
    private String letter = ""; 
    private boolean win = false;    
    private int tl = 0;
    private int tc = 0;
    private int tr = 0;
    private int cl = 0;
    private int cc = 0;
    private int cr = 0;
    private int bl = 0;
    private int bc = 0;
    private int br = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tic_tac_toe);
		
		try {
			buttonTL = (Button) findViewById(R.id.buttonTL);
			buttonTC = (Button) findViewById(R.id.buttonTC);
			buttonTR = (Button) findViewById(R.id.buttonTR);
			buttonCL = (Button) findViewById(R.id.buttonCL);
			buttonCC = (Button) findViewById(R.id.buttonCC);
			buttonCR = (Button) findViewById(R.id.buttonCR);
			buttonBL = (Button) findViewById(R.id.buttonBL);
			buttonBC = (Button) findViewById(R.id.buttonBC);
			buttonBR = (Button) findViewById(R.id.buttonBR);
			
			status = (TextView) findViewById(R.id.statusTextView);
			
			buttonTL.setOnClickListener(this);
			buttonTC.setOnClickListener(this);
			buttonTR.setOnClickListener(this);
			buttonCL.setOnClickListener(this);
			buttonCC.setOnClickListener(this);
			buttonCR.setOnClickListener(this);
			buttonBL.setOnClickListener(this);
			buttonBC.setOnClickListener(this);
			buttonBR.setOnClickListener(this);
			
			
			status.setText("To begin, press 'New Game'");
			buttonTL.setEnabled(false);
			buttonTC.setEnabled(false);
			buttonTR.setEnabled(false);
			buttonCL.setEnabled(false);
			buttonCC.setEnabled(false);
			buttonCR.setEnabled(false);
			buttonBL.setEnabled(false);
			buttonBC.setEnabled(false);
			buttonBR.setEnabled(false);
			
			savedValues = getSharedPreferences("savedValues", MODE_PRIVATE);
		} catch (Exception e) {
			Toast t = Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG);
			t.show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tic_tac_toe, menu);
		return true;		

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		else if(id == R.id.menu_newgame) {
			newGame();
		}
		return super.onOptionsItemSelected(item);
	}
		
	public void setLetter() {
		selection++;
		if(selection % 2 == 0) {
			letter = "O";	
			status.setText("Player 'X' Turn");
		}
		else {
			letter = "X";
			status.setText("Player 'O' Turn");			
		}
	}

	@Override
	public void onClick(View v) {
		setLetter();
		count++;
		
		if(v.equals(buttonTL)) {
			buttonTL.setText(letter);
			buttonTL.setEnabled(false);
			tl = 1;
			if(letter == "X") {
				buttonTL.setTextColor(Color.BLUE);
			}
			else {
				buttonTL.setTextColor(Color.RED);
			}
		}		
		if(v.equals(buttonTC)) {
			buttonTC.setText(letter);
			buttonTC.setEnabled(false);
			tc = 1;
			if(letter == "X") {
				buttonTC.setTextColor(Color.BLUE);
			}
			else {
				buttonTC.setTextColor(Color.RED);
			}
		}		
		if(v.equals(buttonTR)) {
			buttonTR.setText(letter);
			buttonTR.setEnabled(false);
			tr = 1;
			if(letter == "X") {
				buttonTR.setTextColor(Color.BLUE);
			}
			else {
				buttonTR.setTextColor(Color.RED);
			}
		}		
		if(v.equals(buttonCL)) {
			buttonCL.setText(letter);
			buttonCL.setEnabled(false);
			cl = 1;
			if(letter == "X") {
				buttonCL.setTextColor(Color.BLUE);
			}
			else {
				buttonCL.setTextColor(Color.RED);
			}
		}		
		if(v.equals(buttonCC)) {
			buttonCC.setText(letter);
			buttonCC.setEnabled(false);
			cc= 1;
			if(letter == "X") {
				buttonCC.setTextColor(Color.BLUE);
			}
			else {
				buttonCC.setTextColor(Color.RED);
			}
		}		
		if(v.equals(buttonCR)) {
			buttonCR.setText(letter);
			buttonCR.setEnabled(false);
			cr = 1;
			if(letter == "X") {
				buttonCR.setTextColor(Color.BLUE);
			}
			else {
				buttonCR.setTextColor(Color.RED);
			}
		}		
		if(v.equals(buttonBL)) {
			buttonBL.setText(letter);
			buttonBL.setEnabled(false);
			bl = 1;
			if(letter == "X") {
				buttonBL.setTextColor(Color.BLUE);
			}
			else {
				buttonBL.setTextColor(Color.RED);
			}
		}		
		if(v.equals(buttonBC)) {
			buttonBC.setText(letter);
			buttonBC.setEnabled(false);
			bc = 1;
			if(letter == "X") {
				buttonBC.setTextColor(Color.BLUE);
			}
			else {
				buttonBC.setTextColor(Color.RED);
			}
		}		
		if(v.equals(buttonBR)) {
			buttonBR.setText(letter);
			buttonBR.setEnabled(false);
			br = 1;
			if(letter == "X") {
				buttonBR.setTextColor(Color.BLUE);
			}
			else {
				buttonBR.setTextColor(Color.RED);
			}
		}
		this.getWinner();	
	}	
	
	@Override
	public void onPause(){
		super.onPause();
		
		Editor ed = savedValues.edit();
		ed.putString("buttonTL", buttonTL.getText().toString());
		ed.putString("buttonTC", buttonTC.getText().toString());
		ed.putString("buttonTR", buttonTR.getText().toString());
		ed.putString("buttonCL", buttonCL.getText().toString());
		ed.putString("buttonCC", buttonCC.getText().toString());
		ed.putString("buttonCR", buttonCR.getText().toString());
		ed.putString("buttonBL", buttonBL.getText().toString());
		ed.putString("buttonBC", buttonBC.getText().toString());
		ed.putString("buttonBR", buttonBR.getText().toString());
		ed.putString("status", status.getText().toString());
		ed.putInt("tl", tl);
		ed.putInt("tc", tc);
		ed.putInt("tr", tr);
		ed.putInt("cl", cl);
		ed.putInt("cc", cc);
		ed.putInt("cr", cr);
		ed.putInt("bl", bl);
		ed.putInt("bc", bc);
		ed.putInt("br", br);
		ed.putInt("selection", selection);
		
		ed.commit();
	}
	
	@Override
	public void onResume(){
		super.onResume();
		
		buttonTL.setText(savedValues.getString("buttonTL", ""));
		buttonTC.setText(savedValues.getString("buttonTC", ""));
		buttonTR.setText(savedValues.getString("buttonTR", ""));
		buttonCL.setText(savedValues.getString("buttonCL", ""));
		buttonCC.setText(savedValues.getString("buttonCC", ""));
		buttonCR.setText(savedValues.getString("buttonCR", ""));
		buttonBL.setText(savedValues.getString("buttonBL", ""));
		buttonBC.setText(savedValues.getString("buttonBC", ""));
		buttonBR.setText(savedValues.getString("buttonBR", ""));
		status.setText(savedValues.getString("status", ""));
		
		selection = savedValues.getInt("selection", selection);
		tl = savedValues.getInt("tl", tl);
		tc = savedValues.getInt("tc", tc);
		tr = savedValues.getInt("tr", tr);
		cl = savedValues.getInt("cl", cl);
		cc = savedValues.getInt("cc", cc);
		cr = savedValues.getInt("cr", cr);
		bl = savedValues.getInt("bl", bl);
		bc = savedValues.getInt("bc", bc);
		br = savedValues.getInt("br", br);
		
		
		if(tl == 1) {
			buttonTL.setEnabled(false);
		}
		else {
			buttonTL.setEnabled(true);
		}
		
		if(tc == 1) {
			buttonTC.setEnabled(false);
		}
		else {
			buttonTC.setEnabled(true);
		}
		
		if(tr == 1) {
			buttonTR.setEnabled(false);
		}
		else {
			buttonTR.setEnabled(true);
		}
		
		if(cl == 1) {
			buttonCL.setEnabled(false);
		}
		else {
			buttonCL.setEnabled(true);
		}
		
		if(cc == 1) {
			buttonCC.setEnabled(false);
		}
		else {
			buttonCC.setEnabled(true);
		}
		
		if(cr == 1) {
			buttonCR.setEnabled(false);
		}
		else {
			buttonCR.setEnabled(true);
		}
		
		if(bl == 1) {
			buttonBL.setEnabled(false);
		}
		else {
			buttonBL.setEnabled(true);
		}
		
		if(bc == 1) {
			buttonBC.setEnabled(false);
		}
		else {
			buttonBC.setEnabled(true);
		}
		
		if(br == 1) {
			buttonBR.setEnabled(false);
		}
		else {
			buttonBR.setEnabled(true);
		}
		
		getWinner();
		gameStatus();
	}
	
	public void getWinner() {		
		//Horizontal winner	
		if(buttonTL.getText() == buttonTC.getText() &
				buttonTC.getText() == buttonTR.getText() & buttonTL.getText() != "") {
			win = true;
			buttonTL.setBackgroundColor(Color.YELLOW);
			buttonTC.setBackgroundColor(Color.YELLOW);
			buttonTR.setBackgroundColor(Color.YELLOW);
		}		
		else if(buttonCL.getText() == buttonCC.getText() &
				buttonCC.getText() == buttonCR.getText() & buttonCL.getText() != "") {
			win = true;
			buttonCL.setBackgroundColor(Color.YELLOW);
			buttonCC.setBackgroundColor(Color.YELLOW);
			buttonCR.setBackgroundColor(Color.YELLOW);
		}
		else if(buttonBL.getText() == buttonBC.getText() &
				buttonBC.getText() == buttonBR.getText() & buttonBL.getText() != "") {
			win = true;
			buttonBL.setBackgroundColor(Color.YELLOW);
			buttonBC.setBackgroundColor(Color.YELLOW);
			buttonBR.setBackgroundColor(Color.YELLOW);
		}
		
		//Vertical winner
		else if(buttonTL.getText() == buttonCL.getText() &
				buttonCL.getText() == buttonBL.getText() & buttonTL.getText() != "") {
			win = true;
			buttonTL.setBackgroundColor(Color.YELLOW);
			buttonCL.setBackgroundColor(Color.YELLOW);
			buttonBL.setBackgroundColor(Color.YELLOW);
		}
		else if(buttonTC.getText() == buttonCC.getText() &
				buttonCC.getText() == buttonBC.getText() & buttonTC.getText() != "") {
			win = true;
			buttonTC.setBackgroundColor(Color.YELLOW);
			buttonCC.setBackgroundColor(Color.YELLOW);
			buttonBC.setBackgroundColor(Color.YELLOW);
		}
		else if(buttonTR.getText() == buttonCR.getText() &
				buttonCR.getText() == buttonBR.getText() & buttonTR.getText() != "") {
			win = true;
			buttonTR.setBackgroundColor(Color.YELLOW);
			buttonCR.setBackgroundColor(Color.YELLOW);
			buttonBR.setBackgroundColor(Color.YELLOW);
		}
		
		//Diagonal winner
		else if(buttonTL.getText() == buttonCC.getText() &
				buttonCC.getText() == buttonBR.getText() & buttonTL.getText() != "") {
			win = true;
			buttonTL.setBackgroundColor(Color.YELLOW);
			buttonCC.setBackgroundColor(Color.YELLOW);
			buttonBR.setBackgroundColor(Color.YELLOW);
		}
		else if(buttonTR.getText() == buttonCC.getText() &
				buttonCC.getText() == buttonBL.getText() & buttonTR.getText() != "") {
			win = true;
			buttonTR.setBackgroundColor(Color.YELLOW);
			buttonCC.setBackgroundColor(Color.YELLOW);
			buttonBL.setBackgroundColor(Color.YELLOW);
		}
		
		//No winner
		else {
			win = false;
		}
		this.gameStatus();
	}
	
	public void gameStatus() {
		if(win == true) {
			status.setText(letter + " has won.");
			buttonTL.setEnabled(false);
			buttonTC.setEnabled(false);
			buttonTR.setEnabled(false);
			buttonCL.setEnabled(false);
			buttonCC.setEnabled(false);
			buttonCR.setEnabled(false);
			buttonBL.setEnabled(false);
			buttonBC.setEnabled(false);
			buttonBR.setEnabled(false);			
		}
		else if(count==9 && win == false) {
			status.setText("Game Over. It's a draw");
		}
	}
	
	

	public void newGame() {
			count = 0;
			selection = 0;
			win = false;
			letter = "";
			
			buttonTL.setText("");
			buttonTL.setBackgroundColor(Color.LTGRAY);
			buttonTL.setEnabled(true);
			tl = 0;
			buttonTC.setText("");
			buttonTC.setBackgroundColor(Color.LTGRAY);
			buttonTC.setEnabled(true);
			tc = 0;
			buttonTR.setText("");
			buttonTR.setBackgroundColor(Color.LTGRAY);
			buttonTR.setEnabled(true);
			tr = 0;
			buttonCL.setText("");
			buttonCL.setBackgroundColor(Color.LTGRAY);
			buttonCL.setEnabled(true);
			cl = 0;
			buttonCC.setText("");
			buttonCC.setBackgroundColor(Color.LTGRAY);
			buttonCC.setEnabled(true);
			cc = 0;
			buttonCR.setText("");
			buttonCR.setBackgroundColor(Color.LTGRAY);
			buttonCR.setEnabled(true);
			cr = 0;
			buttonBL.setText("");
			buttonBL.setBackgroundColor(Color.LTGRAY);
			buttonBL.setEnabled(true);
			bl = 0;
			buttonBC.setText("");
			buttonBC.setBackgroundColor(Color.LTGRAY);
			buttonBC.setEnabled(true);
			bc = 0;
			buttonBR.setText("");
			buttonBR.setBackgroundColor(Color.LTGRAY);
			buttonBR.setEnabled(true);
			br = 0;
			
			status.setText("Player 'X' Turn");
	}	
}
