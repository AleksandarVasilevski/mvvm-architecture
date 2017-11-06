package com.aleksandarvasilevski.mvvm_architecture.view;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.aleksandarvasilevski.mvvm_architecture.R;
import com.aleksandarvasilevski.mvvm_architecture.ArchApplication;
import com.aleksandarvasilevski.mvvm_architecture.repository.MainRepository;
import com.aleksandarvasilevski.mvvm_architecture.repository.data.entity.Message;
import com.aleksandarvasilevski.mvvm_architecture.viewmodel.MainViewModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_output) TextView mOutputTV;
    @BindView(R.id.et_input) EditText mInputET;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private MainRepository mainRepository;
    private MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((ArchApplication) getApplication()).getApplicationComponent().inject(this);

        // Get the ViewModel
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        mViewModel.getLastMessage().observe(this, new Observer<Message>() {
            @Override
            public void onChanged(@Nullable Message message) {
                mOutputTV.setText(message + "");
            }
        });
    }

    @OnClick(R.id.bt_enter)
    public void enter(){
        mViewModel.insertMessage(new Message(0, mInputET.getText().toString()));
        //mOutputTV.setText(mViewModel.getAllMessages().toString());
    }
}
