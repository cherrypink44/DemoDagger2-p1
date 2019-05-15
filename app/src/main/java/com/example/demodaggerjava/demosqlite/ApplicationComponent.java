package com.example.demodaggerjava.demosqlite;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(App app);

    DataManager getDataManager();
}
