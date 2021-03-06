package org.ayo.template.recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ayo.list.ItemBean;
import org.ayo.list.LocalDisplay;
import org.ayo.list.adapter.real.AyoItemTemplate;
import org.ayo.list.adapter.recycler.AyoSoloAdapter;
import org.ayo.list.recycler.XRecyclerView;
import org.ayo.template.R;
import org.ayo.template.status.AyoStatusableFragment;

import java.util.Collection;
import java.util.List;

/**
 */
abstract class AyoListable<T extends ItemBean> extends AyoStatusableFragment {

    public static final int RANGE_FROM_CACHE_TO_REFRESH = 300;

    private View root = null;
    protected XRecyclerView mXRecyclerView;
    protected AyoSoloAdapter mAdapter;
    protected List<T> list;

    protected abstract void onCreateViewFinished(View root, XRecyclerView mXRecyclerView);

    protected abstract List<AyoItemTemplate> getTemplate();
    protected abstract RecyclerView.LayoutManager getLayoutManager();
    protected abstract void initXRecyclerView();


    public void notifyError(boolean isUIChanged, String status, String reason, int code){}
    public void notifyNotAnyMore(){}

    protected RecyclerView.LayoutManager generateLinearLayout(boolean isHorizontal, boolean reverse){
        return new LinearLayoutManager(getActivity(), isHorizontal ? LinearLayoutManager.HORIZONTAL : LinearLayoutManager.VERTICAL, reverse);
    }

    protected RecyclerView.LayoutManager generateGridLayout(int spanCount, boolean isHorizontal, boolean reverse){
        return new GridLayoutManager(getActivity(), spanCount, isHorizontal ? GridLayoutManager.HORIZONTAL : GridLayoutManager.VERTICAL, reverse);
    }

    protected RecyclerView.LayoutManager generateStaggeredGridLayout(int spanCount, boolean isHorizontal){
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, isHorizontal ? StaggeredGridLayoutManager.HORIZONTAL : StaggeredGridLayoutManager.VERTICAL);
        return staggeredGridLayoutManager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        LocalDisplay.init(getActivity());
        root = View.inflate(getActivity(), R.layout.ayo_tmpl_frag_recycler, null);
        mXRecyclerView = (XRecyclerView) root.findViewById(R.id.ptr_frame);

        initRecyclerView();
        initXRecyclerView();

        onCreateViewFinished(root, mXRecyclerView);
        return root;
    }

    private void initRecyclerView() {
        mXRecyclerView = (XRecyclerView) root.findViewById(R.id.ptr_frame);
        //使RecyclerView保持固定的大小,这样会提高RecyclerView的性能
        mXRecyclerView.setHasFixedSize(true);
        //设置LayoutManager
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        mXRecyclerView.setLayoutManager(layoutManager);

        //设置Adapter
        mAdapter = new AyoSoloAdapter(getActivity(), getTemplate());
        mXRecyclerView.setAdapter(mAdapter);

        //adapter刷新列表的方法
        /*
        public final void notifyDataSetChanged()
        public final void notifyItemChanged(int position)
        public final void notifyItemRangeChanged(int positionStart, int itemCount)
        public final void notifyItemInserted(int position)
        public final void notifyItemMoved(int fromPosition, int toPosition)
        public final void notifyItemRangeInserted(int positionStart, int itemCount)
        public final void notifyItemRemoved(int position)
        public final void notifyItemRangeRemoved(int positionStart, int itemCount)
         */
    }

    protected boolean isEmpty(List<T> t){
        return t == null || t.size() == 0;
    }
    public static <T> Collection<T> combine(Collection<T> c1,
                                            Collection<T> c2) {
        if (c1 == null && c2 == null)
            return null;
        if (c1 == null)
            return c2;
        if (c2 == null)
            return c1;
        c1.addAll(c2);
        return c1;
    }

    public void _refreshList(List<T> data, boolean append){

        stopRefreshOrLoadMore(append);

        if(append && isEmpty(data)){
            ///没有更多页了，并且这一页也是空
            //Toaster.toastLong("没有下一页了");
            notifyNotAnyMore();
            return;
        }

        if(append){
            this.list = (List<T>) combine(this.list, data);
        }else{
            this.list = data;
        }

        if(isEmpty(this.list)){
            mAdapter.notifyDataSetChanged(null);
            showStatus(ListStatus.STATUS_EMPTY);
        }else{
            clearStatus();

            if(append){
                mAdapter.notifyDataSetChanged(list);
            }else{
                mAdapter = new AyoSoloAdapter(getActivity(), getTemplate());
                mXRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged(this.list);
            }
        }

    }

    public void stopRefreshOrLoadMore(boolean isLoadMore){
        try{
            if(isLoadMore){
                mXRecyclerView.loadMoreComplete();
            }else{
                mXRecyclerView.refreshComplete();
            }

        }catch (Exception e){

        }
    }
}
