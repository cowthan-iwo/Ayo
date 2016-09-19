
package org.ayo.layout.swipeback.app;

import android.os.Bundle;

import org.ayo.core.activity.AyoActivityAttacher;
import org.ayo.layout.swipeback.SwipeBackLayout;
import org.ayo.layout.swipeback.Utils;


public class SwipeBackActivityAttacher extends AyoActivityAttacher implements SwipeBackActivityBase {
    private SwipeBackActivityHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(getActivity());
        mHelper.onActivityCreate();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

//    @Override
//    public View findViewById(int id) {
//        View v = super.findViewById(id);
//        if (v == null && mHelper != null)
//            return mHelper.findViewById(id);
//        return v;
//    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(getActivity());
        getSwipeBackLayout().scrollToFinishActivity();
    }
}
