package com.observer.pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.observer.pattern.observable.Encryption;
import com.observer.pattern.observers.DbClass;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    Encryption mEncryption;
    DbClass mDbClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mEncryption=new Encryption();
        mDbClass=new DbClass(mEncryption);
        mEncryption.add(mDbClass);

    }

    @OnClick(R.id.encryption)
    public void encryption(View view) {
        mEncryption.changeEncryptionKey();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mEncryption.remove(mDbClass);
    }
}
