package com.example.tabhost;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TabHost;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost tabHost = (TabHost) findViewById(R.id.tabHost1);
		tabHost.setup();
		tabHost.addTab(tabHost.newTabSpec("tag1").setContent(R.id.text1).setIndicator("Tag 1"));
		tabHost.addTab(tabHost.newTabSpec("tag2").setContent(R.id.text2).setIndicator("Tag 2"));
		tabHost.addTab(tabHost.newTabSpec("tag3").setContent(R.id.text3).setIndicator("Tag 3"));

		findViewById(R.id.text1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
				View view = inflater.inflate(R.layout.popup_window, null);
				PopupWindow pw = new PopupWindow(view, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
				pw.setBackgroundDrawable(new BitmapDrawable());
				pw.showAsDropDown(v);
			}
		});
	}
}
