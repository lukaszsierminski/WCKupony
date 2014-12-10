package com.wildchicken.voucher;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class VouchersArrayAdapter extends ArrayAdapter<Integer>{

	Context context;
	ArrayList<Integer> itemsList;
	
	public VouchersArrayAdapter(Context context, ArrayList<Integer> values) {
		super(context, R.layout.voucher_item, values);
		this.context = context;
		itemsList = values;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.voucher_item, parent, false);
        ImageView rowImage = (ImageView) rowView.findViewById(R.id.pic);
        rowImage.setImageResource(itemsList.get(position));
        return rowView;
	}
}
