package com.liang.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import com.liang.myapplication.R;
import com.liang.myapplication.UserInfoActivity;
import com.liang.myapplication.base.BaseFragment;
import com.liang.myapplication.databinding.FragmentMineBinding;


/**
 * 个人中心
 * Created by SmileXie on 2017/6/29.
 */

public class MineFragment extends BaseFragment<FragmentMineBinding> {

    @Override
    public int setContent() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindingView.avatarIv.setOnClickListener(v -> startActivity(UserInfoActivity.class));
    }
}
