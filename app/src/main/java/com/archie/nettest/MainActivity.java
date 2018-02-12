package com.archie.nettest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.archie.library.retrofit.RestClient;
import com.archie.library.retrofit.callback.IError;
import com.archie.library.retrofit.callback.IFailure;
import com.archie.library.retrofit.callback.ISuccess;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<MovieBean.DataBean.MoviesBean> mList = new ArrayList<>(); //数据源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        RestClient.Builder()
                .context(this)
                .url("movie/list.json?type=hot")
                .params("offset", 0)
                .params("limit", 10)
                .clazz(MovieBean.class)
                .listener(new ISuccess() {
                    @Override
                    public void onSuccess(Object response) {
                        MovieBean bean = (MovieBean) response;
                        mList.addAll(bean.getData().getMovies());
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerView.setAdapter(new IndexListAdapter(MainActivity.this, mList));
                    }
                })
                .listener(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Log.e("onError: ", msg);
                    }
                })
                .listener(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.e("onFailure: ", "请求失败");
                    }
                })
                .build()
                .get();
    }
}
