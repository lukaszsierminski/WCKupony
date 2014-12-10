package com.wildchicken.voucher;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VouchersList extends ListFragment {

    private static final String IMG_ID = "IMG_ID";
    private ArrayList<Integer> items;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        items = new ArrayList<Integer>();
        items.add(Integer.valueOf(R.drawable.ticket_bucket));
        items.add(Integer.valueOf(R.drawable.ticket_french_fries));
        items.add(Integer.valueOf(R.drawable.ticket_tortilla));
        items.add(Integer.valueOf(R.drawable.ticket_chicken_max));
        ArrayAdapter<Integer> adapter = new VouchersArrayAdapter(getActivity(), items);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String name = getResources().getResourceEntryName(items.get(position));
        int resourceId = getActivity().getResources().getIdentifier(name + "_big", "drawable", getActivity().getPackageName());
        Intent intent = new Intent(this.getActivity(), VoucherImage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(IMG_ID, resourceId);
        startActivity(intent);
    }
}
