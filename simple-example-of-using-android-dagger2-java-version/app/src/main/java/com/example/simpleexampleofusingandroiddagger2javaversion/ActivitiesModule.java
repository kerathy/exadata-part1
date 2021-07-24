package com.example.simpleexampleofusingandroiddagger2javaversion;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivitiesModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
