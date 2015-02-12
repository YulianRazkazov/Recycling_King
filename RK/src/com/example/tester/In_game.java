package com.example.tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

import com.example.tester.R.drawable;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.os.Bundle; 
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

	public class In_game extends ActionBarActivity {
		Button Zero, One, Two, Three;
		TextView Score, Hint;
		AssetManager filequestions;
		List<String> questions;
		ImageView Center;
		

		public In_game() {
			questions = new ArrayList<String>();
		}

		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_in_game);
			Zero = (Button)findViewById(R.id.None);
	        One = (Button)findViewById(R.id.Metal);
	        Two =(Button)findViewById(R.id.Plastic);
	        Three =(Button)findViewById(R.id.Paper);
	        Score = (TextView) findViewById(R.id.Score);
	        Hint = (TextView) findViewById(R.id.Hint);
	        Center=(ImageView) findViewById(R.id.MainPicture);
		}
		
			public void fileReader(String[] lines) throws IOException {
				filequestions=getAssets();
				InputStream is = filequestions.open("Questionindex.txt");
				InputStreamReader inputStreamReader = new InputStreamReader(is);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String line;
				int i=0;
				while ((line=bufferedReader.readLine()) != null){
					lines[i] = line;
				}
			}
			public void questionMaker(String[] lines){
				for(int i=0; i<=lines.length;i+=2){
					questions.add(lines[i]+"\n"+lines[i+1]);
				}
				Collections.shuffle(questions, new Random(System.nanoTime()));
				
			}
	
		
		 @Override
		    public boolean onCreateOptionsMenu(android.view.Menu menu) {
		        // Inflate the menu; this adds items to the action bar if it is present.
		        getMenuInflater().inflate(R.menu.main, menu);
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
		        return super.onOptionsItemSelected(item);
		    }
		 
		    
		    
	}


