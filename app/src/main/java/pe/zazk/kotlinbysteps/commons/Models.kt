package pe.zazk.kotlinbysteps.commons

import pe.zazk.kotlinbysteps.commons.adapter.AdapterConstants
import pe.zazk.kotlinbysteps.commons.adapter.ViewType

/**
 * Created by user on 5/23/17.
 */
data class RedditNewsItem (
    val author:String,
    val title: String,
    val numComments:Int,
    val created:Long,
    val thumbnail:String,
    val url:String

) : ViewType{
    override fun getViewType() = AdapterConstants.NEWS
}