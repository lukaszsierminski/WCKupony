package com.wildchicken.voucher;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Window;
import android.widget.TabHost;

public class MainScreen extends FragmentActivity {
	
    private FragmentTabHost tabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        tabHost = (FragmentTabHost) findViewById(R.id.main_tab_host);
        tabHost.setup(this, getSupportFragmentManager(), R.id.tab_content);
        TabHost.TabSpec splashTab = tabHost.newTabSpec(getResources().getString(R.string.splash_screen_desc));
        splashTab.setIndicator(getResources().getString(R.string.splash_screen_desc));

        TabHost.TabSpec ticketsTab = tabHost.newTabSpec(getResources().getString(R.string.tickets));
        ticketsTab.setIndicator(getResources().getString(R.string.tickets));
        tabHost.addTab(splashTab, SplashScreenFragment.class, null);
        tabHost.addTab(ticketsTab, VouchersList.class, null);
	}
}
