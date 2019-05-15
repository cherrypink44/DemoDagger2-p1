package com.example.demodaggerjava.demosqlite;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @Provides
    @DBHelper.ApplicationContext
    public Context provideApplicationContext() {
        return application;
    }

    @Provides
    @DBHelper.DatabaseInfo
    public String provideDBName() {
        return "DaggerExample-DB";
    }

    @Provides
    @DBHelper.DatabaseInfo
    public Integer provideDBVersion() {
        return 1;
    }

    @Provides
    public SharedPreferences provideSharedPreference() {
        return application.getSharedPreferences("DaggerExample-SharedPrefs", Context.MODE_PRIVATE);
    }
}
