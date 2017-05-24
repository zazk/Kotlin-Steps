package pe.zazk.kotlinbysteps.features.news.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import pe.zazk.kotlinbysteps.commons.RedditNewsItem

import pe.zazk.kotlinbysteps.commons.adapter.AdapterConstants
import pe.zazk.kotlinbysteps.commons.adapter.ViewType
import pe.zazk.kotlinbysteps.commons.adapter.ViewTypeDelegateAdapter
import java.util.*

/**
 * Created by user on 5/23/17.
 */
class NewsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    private val loadingItem = object:ViewType{
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put( AdapterConstants.LOADING, LoadingDelegateAdapter() )
        delegateAdapters.put( AdapterConstants.NEWS, NewsDelegateAdapter() )
        items = ArrayList()
        items.add(loadingItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder( holder,this.items[position] )
    }


    override fun getItemViewType(position: Int): Int {
        return this.items.get(position).getViewType()
    }

    fun addNews(news : List<RedditNewsItem>){
        val initPosition = items.size -1
        items.removeAt(initPosition)
        notifyItemRemoved( initPosition )
        items.addAll(news)
        items.add(loadingItem)
        notifyItemChanged(initPosition, items.size+1 /* plus loading item */)
    }

    fun clearAndAddNews(news:List<RedditNewsItem>){
        items.clear()
        notifyItemRangeRemoved(0, getLastPosition())
        items.addAll(news)
        items.add(loadingItem)
        notifyItemRangeInserted(0,items.size)
    }

    fun getNews(): List<RedditNewsItem>{
        return items.filter { it.getViewType() == AdapterConstants.NEWS }
                .map { it as RedditNewsItem }
    }

    fun getLastPosition() = if (items.lastIndex == -1) 0 else items.lastIndex
}