package org.ayo.list.adapter;

import android.support.annotation.NonNull;

/**
 */
public abstract class AbsFallbackAdapterDelegate<T> implements AdapterDelegate<T> {

  @Override public boolean isForViewType(@NonNull Object items, int position) {
    return true;
  }
}
