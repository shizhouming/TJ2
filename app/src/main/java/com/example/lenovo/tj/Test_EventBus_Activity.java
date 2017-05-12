package com.example.lenovo.tj;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.example.lenovo.tj.fragment.ItemDetailFragment;
import com.example.lenovo.tj.fragment.ItemListFragment;

public class Test_EventBus_Activity extends FragmentActivity {

    private FrameLayout item_list_container;
    private FrameLayout item_detail_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__event_bus_);
        initView();
        initData();
    }

    private void initData() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.item_list_container,new ItemListFragment());
        transaction.add(R.id.item_detail_container,new ItemDetailFragment());
        transaction.commit();
    }

    private void initView() {
        item_list_container = (FrameLayout) findViewById(R.id.item_list_container);
        item_detail_container = (FrameLayout) findViewById(R.id.item_detail_container);
    }
}
