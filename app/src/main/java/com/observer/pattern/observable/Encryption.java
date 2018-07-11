package com.observer.pattern.observable;

import android.util.Log;

import com.observer.pattern.observers.IObservers;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Encryption library is the subject which notify its client about the encryption key change so they can encrypt and decrypt data using new key.
 */
public class Encryption implements IObservable {

    private int mKey;

    List<IObservers> mObservers;

    public Encryption(){
        mObservers=new ArrayList<>();

    }

    @Override
    public void add(IObservers observer) {
        mObservers.add(observer);
    }

    @Override
    public void remove(IObservers observer) {
        mObservers.remove(observer);
    }

    @Override
    public void performNotify(int oldKey) {

        for(IObservers observer:mObservers){
            observer.process(oldKey,mKey);
        }
    }

    public void changeEncryptionKey(){
        int oldKey;
        Random rand = new Random();
        oldKey=mKey;
        mKey= rand.nextInt();
        performNotify(oldKey);
    }

    @Override
    public void success(IObservers observer){

        Log.d("","Data encrypted!!");
    }
}
