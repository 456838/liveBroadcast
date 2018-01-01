package com.salton123.livevideo;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.salton123.base.BaseSupportActivity;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.internal.operators.completable.CompletableToObservable;

public class MainActivity extends BaseSupportActivity {



    @Override
    public int GetLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void InitVariable(Bundle savedInstanceState) {
        new RxPermissions(this).ensureEach(Manifest.permission.INTERNET);
    }

    @Override
    public void InitViewAndData() {

    }

    @Override
    public void InitListener() {

    }
}
