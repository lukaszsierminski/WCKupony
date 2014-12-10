package com.wildchicken.voucher;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

public class VoucherImage extends Activity{

	private static final String IMG_ID = "IMG_ID";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		int resourceId = getIntent().getIntExtra(IMG_ID, -1);
        setContentView(R.layout.voucher_image);
		ImageView imageView = (ImageView) findViewById(R.id.voucher_image);
		imageView.setImageResource(resourceId);
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}
}
