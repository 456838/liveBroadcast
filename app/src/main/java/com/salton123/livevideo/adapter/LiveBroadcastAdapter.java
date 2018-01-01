package com.salton123.livevideo.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salton123.base.AdapterBase;
import com.salton123.base.ViewHolder;
import com.salton123.livevideo.LiveBroadcastSource;
import com.salton123.livevideo.R;

/**
 * Created by salton on 2018/1/1.
 */

public class LiveBroadcastAdapter extends AdapterBase<LiveBroadcastSource>{
    public LiveBroadcastAdapter(Context pContext) {
        super(pContext);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = GetLayoutInflater().inflate(R.layout.adapter_item_live_broadcast,null);
        }
        TextView title = ViewHolder.get(view,R.id.title);
        title.setText(getItem(i).title);
        return view;
    }

}
