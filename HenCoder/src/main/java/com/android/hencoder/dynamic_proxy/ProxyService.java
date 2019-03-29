package com.android.hencoder.dynamic_proxy;

import android.support.annotation.Nullable;
import okhttp3.internal.platform.Platform;
import retrofit2.Call;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * TODO
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @version 1.0
 * @since 2019/03/29 16:26
 */
public class ProxyService implements GithubService {

    InvocationHandler invocationHandler = new InvocationHandler() {
        private final Platform platform = Platform.get();
        private final Object[] emptyArgs = new Object[0];

        @Override
        public Object invoke(Object proxy, Method method, @Nullable Object[] args)
                throws Throwable {
            // If the method is a method from Object then defer to normal invocation.
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, args);
            }
            if (platform.isDefaultMethod(method)) {
                return platform.invokeDefaultMethod(method, service, proxy, args);
            }
            return loadServiceMethod(method).invoke(args != null ? args : emptyArgs);
        }
    };

    @Override
    public Call<List<Repo>> getUserRepos() {
        try {
            Method method = GithubService.class.getMethod("getUserRepos");
            return (Call<List<Repo>>) invocationHandler.invoke(this, method, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    /*
    @Override
    public Call<User> getOtherMethod(){

        return ...;
    }
    */


}