package com.observer.pattern.observers;

import com.observer.pattern.observable.IObservable;

public class DbClass implements IObservers {

    String mData;
    IObservable observable;
    public DbClass(IObservable observable){
        this.observable=observable;
        mData=new String("Observer");
    }

    @Override
    public void process(int oldkey, int newkey) {

        if(oldkey==0){
            //First time encryption
            encryptData(newkey,mData);
        }
        else{
            String decryptedData=decryptData(oldkey);
            encryptData(newkey,decryptedData);
        }

        observable.success(this);
    }

    // Concept function
    private void encryptData(int newkey,String input){

    }

    // Concept function
    private String decryptData(int oldKey){

        return mData;
    }
}
