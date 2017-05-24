package pe.zazk.kotlinbysteps.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.ViewParent
import pe.zazk.kotlinbysteps.R
import pe.zazk.kotlinbysteps.commons.adapter.ViewType
import pe.zazk.kotlinbysteps.commons.adapter.ViewTypeDelegateAdapter
import pe.zazk.kotlinbysteps.commons.extensions.inflate


/**
 * Created by user on 5/23/17.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {


    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {

    }

    class LoadingViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        parent.inflate(R.layout.news_item_loading)){
    }

}