package pe.zazk.kotlinbysteps.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_item.view.*
import pe.zazk.kotlinbysteps.R
import pe.zazk.kotlinbysteps.commons.RedditNewsItem
import pe.zazk.kotlinbysteps.commons.adapter.ViewType
import pe.zazk.kotlinbysteps.commons.adapter.ViewTypeDelegateAdapter
import pe.zazk.kotlinbysteps.commons.extensions.inflate
import pe.zazk.kotlinbysteps.commons.extensions.loadImg

/**
 * Created by user on 5/24/17.
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return LoadingViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as LoadingViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item) ){
      fun bind(item:RedditNewsItem) = with(itemView){
          img_thumbnail.loadImg(item.thumbnail)
          description.text = item.title
          author.text = item.title
          comments.text = "${item.numComments} comments"
          time.text = item.created.toString()

      }
    }
}