package com.example.data;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.data.adapter.ApService;
import com.example.data.adapter.Bean;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    private View view;
    private RecyclerView rec;
    private ArrayList<Bean.ResultsBean> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(inflate);
        return inflate;


    }

    private void initView(View inflate) {
        rec = (RecyclerView) inflate.findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();

        initData();
    }

    private void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApService.getUri)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApService apService = retrofit.create(ApService.class);
        Call<Bean> call = apService.getJson();
//        call.
    }
}
