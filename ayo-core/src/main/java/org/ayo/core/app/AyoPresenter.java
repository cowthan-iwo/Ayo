package org.ayo.core.app;

/**
 * Created on : 05-03-2016
 * Author     : derohimat
 * Name       : Deni Rohimat
 * Email      : rohimatdeni@gmail.com
 * GitHub     : https://github.com/derohimat
 * LinkedIn   : https://www.linkedin.com/in/derohimat
 */

public interface AyoPresenter<T extends AyoView>{
    void attachView(T view);
    void detachView();
}