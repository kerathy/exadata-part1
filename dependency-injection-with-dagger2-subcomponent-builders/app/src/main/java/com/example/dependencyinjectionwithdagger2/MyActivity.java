package com.example.dependencyinjectionwithdagger2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import javax.inject.Inject;

public class MyActivity extends Activity {

    @Inject
    ArrayAdapter arrayAdapter;

    public void onCreate(Bundle savedInstance) {
        // assign singleton instances to fields
        // We need to cast to `MyApp` in order to get the right method
        System.out.println("print: MyActivity");
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

//
//        MyActivitySubcomponent.Builder builder = (MyActivitySubcomponent.Builder)
//                ((MyApp) getApplication()).getApplicationComponent())
//                .subcomponentBuilders()
//                .get(MyActivitySubcomponent.Builder.class)
//                .get();
//        builder.activityModule(new MyActivityModule(this)).build().inject(this);

        ApplicationComponent applicationComponent = ((MyApp) getApplication()).getApplicationComponent();
        MyActivitySubcomponent.Builder builder  = (MyActivitySubcomponent.Builder)applicationComponent
                .subcomponentBuilders()
                .get(MyActivitySubcomponent.Builder.class)
                .get();

        builder.activityModule(new MyActivityModule(this)).build().inject(this);
    }

}
