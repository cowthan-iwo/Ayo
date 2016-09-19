package org.ayo.list.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import org.ayo.list.adapter.holder.AyoViewHolder;

import java.util.List;

/**
 */
public abstract class AbsListItemAdapterDelegate<I extends T, T>
    implements AdapterDelegate<List<T>> {

  @Override public final boolean isForViewType(@NonNull List<T> items, int position) {
    return isForViewType(items.get(position), items, position);
  }

  @Override public final void onBindViewHolder(@NonNull List<T> items, int position,
      @NonNull AyoViewHolder holder) {
    onBindViewHolder((I) items.get(position),  holder);
  }

  protected abstract boolean isForViewType(@NonNull T item, List<T> items, int position);

  @NonNull @Override public abstract AyoViewHolder onCreateViewHolder(@NonNull ViewGroup parent);

  protected abstract void onBindViewHolder(@NonNull I item, @NonNull AyoViewHolder viewHolder);
}
