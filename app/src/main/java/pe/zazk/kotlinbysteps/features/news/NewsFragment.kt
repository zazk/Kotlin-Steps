package pe.zazk.kotlinbysteps.features.news

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.zazk.kotlinbysteps.commons.extensions.inflate
import pe.zazk.kotlinbysteps.R

import kotlinx.android.synthetic.main.fragment_news.*
import pe.zazk.kotlinbysteps.commons.RedditNewsItem
import pe.zazk.kotlinbysteps.features.news.adapter.NewsAdapter


class NewsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return container?.inflate(R.layout.fragment_news)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true) // <-- Lazy executed!
        news_list.layoutManager = LinearLayoutManager(context)
        initAdapter()

        if (savedInstanceState == null){
            val news = mutableListOf<RedditNewsItem>()
            for ( i in 1..10){
                news.add(
                        RedditNewsItem(
                                "author$i",
                                "Title$i",
                                i, //Number of comments
                                1457207701L - i * 200, //time
                                "http://lorempixel.com/200/200/technics/$i", // image url
                                "url"
                        )
                )
            }
            (news_list.adapter as NewsAdapter).addNews(news)
        }
    }

    private fun initAdapter(){
        if( news_list.adapter == null){
            news_list.adapter = NewsAdapter()
        }
    }

}// Required empty public constructor
