package com.salton123.livevideo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.salton123.base.BaseSupportFragment;
import com.salton123.event.StartBrotherEvent;
import com.salton123.livevideo.adapter.LiveBroadcastAdapter;
import com.salton123.livevideo.fm.LiveBoradcastComponent;
import com.salton123.livevideo.fm.LiveDetailComponent;
import com.salton123.util.EventUtil;
import com.salton123.util.ToastUtil;
import com.salton123.util.ViewUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by salton on 2018/1/1.
 */

public class LiveBroadcastListView extends LinearLayout {
    private View rootView;
    private ListView listView;
    private LiveBroadcastAdapter mAdapter;

    public LiveBroadcastListView(Context context) {
        super(context);
        init();
    }

    public LiveBroadcastListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LiveBroadcastListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        rootView = LayoutInflater.from(getContext()).inflate(R.layout.view_live_boradcast_list, this);
        listView = ViewUtils.f(rootView, R.id.listView);
        mAdapter = new LiveBroadcastAdapter(getContext());
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                LiveBroadcastSource item = (LiveBroadcastSource) adapterView.getItemAtPosition(i);
                EventBus.getDefault().post(new StartBrotherEvent(BaseSupportFragment.newInstance(LiveDetailComponent.class, item)));
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                LiveBroadcastSource item = (LiveBroadcastSource) parent.getItemAtPosition(position);
                ClipboardManager cm = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(item.url);
                ToastUtil.showToast(getContext(), "地址已经复制:" + item.url);
                return false;
            }
        });
        setData(fakeData(), true);
    }

    public void setData(List<LiveBroadcastSource> data, boolean clear) {
        if (clear) {
            mAdapter.AddAll(data);
        } else {
            mAdapter.AddToList(data);
        }
    }


//    好莱坞动作大片,http://ws4.streamhls.huya.com/huyalive/30765679-2484192572-10669525853706125312-2847687498-10057-A-1509356612-1_1200/playlist.m3u8
//    李连杰电影,http://ws.streamhls.huya.com/huyalive/94525224-2460686093-10568566295157014528-2789253848-10057-A-1514680452-1_1200/playlist.m3u8
//    林正英电影,http://ws4.streamhls.huya.com/hqlive/94525224-2460686034-10568566041753944064-2789274542-10057-A-1512526089-1_1200/playlist.m3u8
//    刘德华电影,http://ws4.streamhls.huya.com/huyalive/94525224-2467341872-10597152648291418112-2789274550-10057-A-1512526192-1_1200/playlist.m3u8
//    周润发电影,http://ws.streamhls.huya.com/hqlive/94525224-2460685774-10568564925062447104-2789253840-10057-A-1509184308-1_1200/playlist.m3u8
//    周星驰电影,http://ws.streamhls.huya.com/hqlive/94525224-2460685313-10568562945082523648-2789274524-10057-A-1512526024-1_1200/playlist.m3u8
//    成龙电影,http://ws4.streamhls.huya.com/hqlive/94525224-2460685722-10568564701724147712-2789253838-10057-A-1513132292-1_1200/playlist.m3u8
//    异形怪物,http://ws4.streamhls.huya.com/huyalive/30765679-2478268764-10644083292078342144-2847699106-10057-A-1509333975-1_1200/playlist.m3u8
//    施瓦辛格终结者轮播,http://ws.streamhls.huya.com/huyalive/30765679-2484192708-10669526437821677568-3049003172-10057-A-1511834497-1_1200/playlist.m3u8

    public List<LiveBroadcastSource> fakeData() {
        List<LiveBroadcastSource> data = new ArrayList<>();
        data.add(new LiveBroadcastSource("好莱坞动作大片", "http://ws4.streamhls.huya.com/huyalive/30765679-2484192572-10669525853706125312-2847687498-10057-A-1509356612-1_1200/playlist.m3u8"));
        data.add(new LiveBroadcastSource("刘德华电影", "http://ws4.streamhls.huya.com/huyalive/94525224-2467341872-10597152648291418112-2789274550-10057-A-1512526192-1_1200/playlist.m3u8"));
        data.add(new LiveBroadcastSource("周润发电影", "http://ws.streamhls.huya.com/hqlive/94525224-2460685774-10568564925062447104-2789253840-10057-A-1509184308-1_1200/playlist.m3u8"));
        data.add(new LiveBroadcastSource("周星驰电影", "http://ws.streamhls.huya.com/hqlive/94525224-2460685313-10568562945082523648-2789274524-10057-A-1512526024-1_1200/playlist.m3u8"));
        return data;

    }

}
