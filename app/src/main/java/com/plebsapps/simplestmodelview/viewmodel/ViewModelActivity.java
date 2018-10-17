package com.plebsapps.simplestmodelview.viewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.plebsapps.simplestmodelview.model.PersonInterceptor;
import com.plebsapps.simplestmodelview.model.PersonViewModel;
import com.plebsapps.simplestmodelview.model.PersonViewModelFactory;
import com.plebsapps.simpleviewmodel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewModelActivity extends AppCompatActivity {

    @BindView(R.id.ed_vorname)
    protected EditText edVorname;

    @BindView(R.id.ed_name)
    protected EditText edName;

    @BindView(R.id.tv_say)
    protected TextView tvSay;

    private PersonViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        PersonViewModelFactory interceptor = new PersonViewModelFactory(new PersonInterceptor());

        viewModel = ViewModelProviders.of(this, interceptor).get(PersonViewModel.class);
        sayHello(viewModel.sayHello());
    }

    @OnClick(R.id.btn_say)
    public void sayHello(View button){
        viewModel.setPerson(edVorname.getText().toString(), edName.getText().toString());
        sayHello(viewModel.sayHello());
    }

    private void sayHello(String hello) {
        tvSay.setText(hello);
    }
}