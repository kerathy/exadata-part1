package com.example.dependencyinjectionwithdagger2;

import android.widget.ArrayAdapter;
import dagger.Module;
import dagger.Provides;

@Module
public class MyActivityModule {

    private final MyActivity activity;

    // must be instantiated with an activity
    public MyActivityModule(MyActivity activity) {
        System.out.println("print: MyActivityModule");
        this.activity = activity;
    }

//    @Provides
//    @MyActivityScope @Named("simple_list_item_1")
//    public ArrayAdapter providesMyListAdapter() {
//        return new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1);
//    }

    @Provides
    @MyActivityScope
    public ArrayAdapter providesMyListAdapter() {
        System.out.println("print: ArrayAdapter");
        return new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1);
    }
}
