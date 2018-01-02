package com.salton123.livevideo.fm;

import android.os.Bundle;
import android.view.View;

import com.salton123.base.BaseSupportFragment;
import com.salton123.livevideo.R;
import com.salton123.widget.StatusTitleBar;

/**
 * User: newSalton@outlook.com
 * Date: 2018/1/2 13:20
 * ModifyTime: 13:20
 * Description:
 */
public class LiveBoradcastComponent extends BaseSupportFragment {
    StatusTitleBar mTitleBar;

    @Override
    public int GetLayout() {
        return R.layout.cp_live_broadcast;
    }

    @Override
    public void InitVariable(Bundle savedInstanceState) {

    }

    @Override
    public void InitViewAndData() {
        mTitleBar = f(R.id.view_status_title_bar);
        mTitleBar.setBackText("", View.GONE).setTitleText("视频推荐", View.VISIBLE);
    }

    @Override
    public void InitListener() {

    }
}
