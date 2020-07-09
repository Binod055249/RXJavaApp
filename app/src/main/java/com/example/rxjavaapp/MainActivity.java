package com.example.rxjavaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtHii) TextView txtHii;
    @BindView(R.id.myRecyclerView)
    RecyclerView myRecyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RVCustomAdapter rvCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        linearLayoutManager=new LinearLayoutManager(this);
        rvCustomAdapter=new RVCustomAdapter();

        myRecyclerView.setLayoutManager(linearLayoutManager);
        myRecyclerView.setAdapter(rvCustomAdapter);

        Observable.just("How are you?").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Throwable {

                txtHii.setText(s);
            }
        });
     //   Observable.just("how are you").subscribe(s -> txtHii.setText(s));

//        Observable.just("bind","kumar","dakua","papu","ross","jhon","morteza").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Throwable {
//              rvCustomAdapter.addStringToList(s);
//            }
//        });

        Entry entry1= new Entry("PS4", BigDecimal.valueOf(15000),new Date());
        Entry entry2=new Entry("Xbox 1",BigDecimal.valueOf(2000),new Date());
        Entry entry3=new Entry("Xbox small",BigDecimal.valueOf(3000),new Date());
        Entry entry4=new Entry("Xbox big",BigDecimal.valueOf(3000),new Date());
        Entry entry5= new Entry("XS5",BigDecimal.valueOf(40000),new Date());
        Entry entry6= new Entry("XS big",BigDecimal.valueOf(780000),new Date());
        Entry entry7= new Entry("XS small",BigDecimal.valueOf(40890),new Date());

        Observable.just(entry1,entry2,entry3,entry4,entry5,entry6,entry7).subscribe(new Consumer<Entry>() {
            @Override
            public void accept(Entry entry) throws Throwable {
                rvCustomAdapter.addEntryToList(entry);
            }
        });
    }
}