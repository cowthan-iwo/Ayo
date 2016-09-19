package org.ayo.template.recycler;

import android.os.Handler;
import android.view.View;

import org.ayo.list.recycler.XRecyclerView;

/**
 */
public abstract class AyoListTemplateFragment<T> extends AyoListFragment<T> {


    boolean initAfterViewCreated = true;
    boolean isFirstCome = true;

    public void enableInitAfterViewCreated(boolean enable){
        initAfterViewCreated = enable;
    }

    @Override
    protected void onCreateViewFinished(View root, XRecyclerView mXRecyclerView) {
        if(initAfterViewCreated){
            loadCache();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    refreshAuto();
                }
            }, RANGE_FROM_CACHE_TO_REFRESH);
        }else{

        }

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        if(isVisibleToUser){
            if(initAfterViewCreated){
                if(isFirstCome){
                    //do nothing
                }else{
                    //有数据了，干点什么？
                }
            }else{
                if(isFirstCome){
                    loadCache();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            refreshAuto();
                        }
                    }, RANGE_FROM_CACHE_TO_REFRESH);
                }else{
                    //有数据了，干点什么？
                }
            }
            isFirstCome = false;

        }else{

        }

        super.setUserVisibleHint(isVisibleToUser);
    }

    public void refreshAuto(){
        clearStatus();
        mXRecyclerView.setRefreshing(true);
    }

    public void refreshWithLoadingStatus(){
        showStatus(ListStatus.STATUS_LOADING);
        condition.onPullDown();
        loadData(condition);
    }

    public abstract void loadCache();
//
//
//
//    @Override
//    public void loadData(AyoCondition cond) {
//
//    }
//
//    @Override
//    protected List<AyoItemTemplate> getTemplate() {
//        return null;
//    }
}
