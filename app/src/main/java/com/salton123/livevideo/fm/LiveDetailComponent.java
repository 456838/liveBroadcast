package com.salton123.livevideo.fm;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.salton123.base.BaseSupportFragment;
import com.salton123.livevideo.LiveBroadcastSource;
import com.salton123.livevideo.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

/**
 * User: newSalton@outlook.com
 * Date: 2018/1/2 13:40
 * ModifyTime: 13:40
 * Description:
 */
public class LiveDetailComponent extends BaseSupportFragment {
    private StandardGSYVideoPlayer videoView;
    LiveBroadcastSource mLiveBroadcastSource;

    @Override
    public int GetLayout() {
        return R.layout.cp_live_detail;
    }

    @Override
    public void InitVariable(Bundle savedInstanceState) {
        mLiveBroadcastSource = getArguments().getParcelable(ARG_ITEM);
        if (mLiveBroadcastSource == null) {
            pop();
            toast("找不到资源");
        }
    }

    @Override
    public void InitViewAndData() {
        videoView = f(R.id.videoView);
        //是否可以滑动调整
        videoView.setIsTouchWiget(true);
        videoView.setUp(mLiveBroadcastSource.url, false, mLiveBroadcastSource.title);
        videoView.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //释放所有
                videoView.setStandardVideoAllCallBack(null);
                GSYVideoPlayer.releaseAllVideos();
                pop();
            }
        });

        if (videoView.getRenderProxy() ==null){
            toast("getRenderProxy == null");
        }
        // mTextureView.setRotation(mTextureView.getRotation() + 90);
        // mTextureView.requestLayout();
    }

    @Override
    public void InitListener() {
        f(R.id.rotation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.setRotation(videoView.getRotation()+90);
                videoView.requestLayout();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        GSYVideoManager.onResume();
    }


    public boolean onBackPressed() {
        if (StandardGSYVideoPlayer.backFromWindowFull(getActivity())) {
            return true;
        }
        return false;
    }

}
