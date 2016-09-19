package org.ayo.template.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.ayo.template.status.StatusProvider;
import org.ayo.template.status.StatusUIManager;

import java.util.List;

/**
 */
public abstract class AyoListFragment<T> extends AyoRefreshable{


    public void onLoadOk(List<T> t){
        _refreshList(t, isLoadMore);
    }

    public void onLoadFail(boolean forceChangeUIWhenHasData, String status, String errorReason, int errorCode){
        boolean isUIChanged = false;
        if(list == null || list.size() == 0){
            showStatus(status);
            isUIChanged = true;
        }else{
            if(forceChangeUIWhenHasData){
                showStatus(status);
                isUIChanged = true;
            }
        }
        notifyError(isUIChanged, status, errorReason, errorCode);
    }

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

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return generateLinearLayout(false, false);
    }

    @Override
    protected void initStatusUI(StatusUIManager statusUIManager) {
        statusUIManager.addStatusProvider(ListStatus.STATUS_LOADING, new DefaultStatusProvider.DefaultLoadingStatusView(getActivity(), ListStatus.STATUS_LOADING, mXRecyclerView, new StatusProvider.OnStatusViewCreateCallback() {
            @Override
            public void onCreate(int status, View statusView) {

            }
        }));

        statusUIManager.addStatusProvider(ListStatus.STATUS_EMPTY, new DefaultStatusProvider.DefaultEmptyStatusView(getActivity(), ListStatus.STATUS_EMPTY, mXRecyclerView, new StatusProvider.OnStatusViewCreateCallback() {
            @Override
            public void onCreate(int status, View statusView) {

            }
        }));

        statusUIManager.addStatusProvider(ListStatus.STATUS_SERVER_ERROR, new DefaultStatusProvider.DefaultServerErrorStatusView(getActivity(), ListStatus.STATUS_SERVER_ERROR, mXRecyclerView, new StatusProvider.OnStatusViewCreateCallback() {
            @Override
            public void onCreate(int status, View statusView) {

            }
        }));

        statusUIManager.addStatusProvider(ListStatus.STATUS_LOGIC_FAIL, new DefaultStatusProvider.DefaultLogicFailStatusView(getActivity(), ListStatus.STATUS_LOGIC_FAIL, mXRecyclerView, new StatusProvider.OnStatusViewCreateCallback() {
            @Override
            public void onCreate(int status, View statusView) {

            }
        }));

        statusUIManager.addStatusProvider(ListStatus.STATUS_NETOFF, new DefaultStatusProvider.DefaultNetOffStatusView(getActivity(), ListStatus.STATUS_NETOFF, mXRecyclerView, new StatusProvider.OnStatusViewCreateCallback() {
            @Override
            public void onCreate(int status, View statusView) {

            }
        }));

        statusUIManager.addStatusProvider(ListStatus.STATUS_lOCAL_ERROR, new DefaultStatusProvider.DefaultLocalErrorStatusView(getActivity(), ListStatus.STATUS_lOCAL_ERROR, mXRecyclerView, new StatusProvider.OnStatusViewCreateCallback() {
            @Override
            public void onCreate(int status, View statusView) {

            }
        }));
    }


}
