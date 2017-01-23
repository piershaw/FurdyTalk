
//Created by Pier Shaw on 02/11/2012
//Copyright © 2012 Pier Shaw. All rights reserved.
//piershaw@gmail.com



package com.example.furdytalk.xml;

import java.util.ArrayList;

import com.TP.furbytalk.R;
import com.flurry.android.FlurryAgent;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends Activity implements OnClickListener {

	
	public ListView LV;
	private ArrayList<String> resultNew;
	public Button voiceButton;
	private static int checkTag = 1111;
	private Context context;
	private ViewGroup viewSpace;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //list
        LV = (ListView)findViewById(R.id.lv);
        voiceButton = (Button)findViewById(R.id.button);
        voiceButton.setOnClickListener(this);
        //viewSpace = (ViewGroup)findViewById(R.id.view1);
       
        
        
       // View promoView = appCircle.getHook(context, "hookName", int mode);
       // if (promoView != null) {
        	//viewGroup.addView(promoView);
        //}
        
        
        
        context = this.getApplicationContext();
        
        //FlurryAgent.initializeAds(context);
  
       
    }

 

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak");
		startActivityForResult(i, checkTag);
	}
	
	
	
	public void onStart(){
		super.onStart();
		//Amazon
	  ///////////////////// appCircle
		//FlurryAgent.enableTestAds(true);
		//FlurryAgent.onStartSession(context, "TM5VCN86BWHYS73ZR5ZC");
		//FlurryAgent.getAd(context,"adSpace",viewSpace, flurryAdSize ,100);
		
		 ///////////////////// appCircle
	}
	
	public void onStop(){
		super.onStop();
		//FlurryAgent.onEndSession(this); 
	}
	
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == checkTag && resultCode == RESULT_OK){
			ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			resultNew = new ArrayList<String>();
		
			
			
			Log.v("Moto"," > " + result);
			
			//switch(result){
			//case "noo noo": resultNew = Å; break;
			//}
			
			if(result.contains("no no")){
				resultNew.add("Talk");
			}
			
			if(result.contains("nee may")){
				resultNew.add("Sweet!");
			}
			
			Log.v("Moto"," > New " + resultNew);
			
	
			LV.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,resultNew));
		}
		
		
	}
}
