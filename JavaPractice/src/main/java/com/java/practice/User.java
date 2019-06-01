package com.java.practice;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/21 03:14
 */
public class User {
    static User mUser;

    private User() {}

    public static User getUserInstance() {
        synchronized (User.class) {
            if (mUser == null) {
                mUser = new User();
            }
        }
        return mUser;
    }

}