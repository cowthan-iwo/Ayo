/*
 * Copyright (c) 2015 Hannes Dorfmann.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.ayo.list.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import org.ayo.list.adapter.holder.AyoViewHolder;


/**
 */

@Deprecated
public abstract class AbsDelegationAdapter<T> extends RecyclerView.Adapter<AyoViewHolder> {

  protected AdapterDelegatesManager<T> delegatesManager;
  protected T items;

  public AbsDelegationAdapter() {
    this(new AdapterDelegatesManager<T>());
  }

  public AbsDelegationAdapter(@NonNull AdapterDelegatesManager<T> delegatesManager) {
    if (delegatesManager == null) {
      throw new NullPointerException("AdapterDelegatesManager is null");
    }

    this.delegatesManager = delegatesManager;
  }

  @Override public AyoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return delegatesManager.onCreateViewHolder(parent, viewType);
  }

  @Override public void onBindViewHolder(AyoViewHolder holder, int position) {
    delegatesManager.onBindViewHolder(items, position, holder);
  }

  @Override public int getItemViewType(int position) {
    return delegatesManager.getItemViewType(items, position);
  }

  public T getItems() {
    return items;
  }

  public void setItems(T items) {
    this.items = items;
  }
}
