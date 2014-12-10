package com.wildchicken.voucher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class SplashScreenFragment extends Fragment {

    private final static String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    private final static String FACEBOOK_URI_PREFIX = "fb://profile/";
    private final static String FACEBOOK_URL = "https://www.facebook.com/";
    private final static String FACEBOOK_PROFILE_ID = "283348805179827";
    private final static String PHONE_NUMBER = "423079999";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.splash_screen, container, false);
        Button facebookButton = (Button) inflatedView.findViewById(R.id.facebook_button);
        Button dialButton = (Button) inflatedView.findViewById(R.id.dial_button);

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebookIntent;
                Toast.makeText(getActivity(), getString(R.string.facebook_loading), Toast.LENGTH_SHORT).show();
                try {
                    getActivity().getPackageManager().getPackageInfo(FACEBOOK_PACKAGE_NAME, 0);
                    facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(FACEBOOK_URI_PREFIX + FACEBOOK_PROFILE_ID));
                } catch (PackageManager.NameNotFoundException e) {
                    facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(FACEBOOK_URL + FACEBOOK_PROFILE_ID));
                }
                startActivity(facebookIntent);
            }
        });

        dialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + PHONE_NUMBER));
                startActivity(intent);
            }
        });

        return inflatedView;
    }
}
