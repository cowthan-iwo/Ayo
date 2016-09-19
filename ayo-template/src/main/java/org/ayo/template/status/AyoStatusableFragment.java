package org.ayo.template.status;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/8/21.
 */
public abstract class AyoStatusableFragment extends Fragment {

    StatusUIManager statusUIManager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        statusUIManager.addStatusProvider("netoff", new StatusProvider(getActivity(), "netoff", null, new StatusProvider.OnStatusViewCreateCallback() {
//            @Override
//            public void onCreate(int status, View statusView) {
//
//            }
//        }) {
//            @Override
//            public View getStatusView() {
//                return null;
//            }
//        });

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        statusUIManager = new StatusUIManager();
        initStatusUI(statusUIManager);
        super.onViewCreated(view, savedInstanceState);
    }

    protected abstract void initStatusUI(StatusUIManager statusUIManager);

    protected void showStatus(String status){
        statusUIManager.show(status);
    }

    protected void clearStatus(){
        statusUIManager.clearStatus();
    }
}
