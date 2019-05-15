package com.example.demodaggerjava.demosqlite;

import android.content.res.Resources;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {
    DBHelper mDbHelper;
    SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(DBHelper dbHelper, SharedPrefsHelper sharedPrefsHelper) {
        this.mDbHelper = dbHelper;
        this.mSharedPrefsHelper = sharedPrefsHelper;
    }

    public Long addHotGirl(Hotgirl girl) {
        return mDbHelper.insertUser(girl);
    }

    public List<Hotgirl> getAllGirl() throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getAllGirl();
    }

    public void clearDatabase() {
        mDbHelper.clearDatabase();
    }

    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken() {
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

}
