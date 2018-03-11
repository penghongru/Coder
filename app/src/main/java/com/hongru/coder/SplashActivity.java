package com.hongru.coder;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.hongru.base.ui.BaseActivity;
import com.hongru.coder.databinding.ActivitySplashBinding;

/**
 * @author 彭鸿儒
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        binding.setSplashVM(new SplashViewModule());

    }
}
