package com.java.practice.abstract_class;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/12/04 02:33
 */
public abstract class BaseActivity {



      void onCreate(){
        System.out.println("onCreate");
    }

    abstract void onStart();

    abstract void onResume();

    abstract void onPause();

    void onStop() {

    }

}
