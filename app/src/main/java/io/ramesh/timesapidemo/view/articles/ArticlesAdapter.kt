package io.ramesh.timesapidemo.view.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.ramesh.timesapidemo.R
import io.ramesh.timesapidemo.api.model.Article
import io.ramesh.timesapidemo.databinding.ArticleItemBinding


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */


class ArticlesAdapter(var articles: MutableList<Article>, var callback: ArticleItemCallback) :
        RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var articlesBinding = DataBindingUtil.inflate<ArticleItemBinding>(
                layoutInflater, R.layout.article_item,
                parent, false
        )
        return ArticlesViewHolder(articlesBinding)
    }

    override fun getItemCount(): Int {

        return articles.size
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {

        val article = articles.get(position)
        holder.binding.article = article


        holder.binding.root.setOnClickListener {
            callback.showArticleDetails(article.url, article.adx_keywords.split(";")[0])
        }
    }

    class ArticlesViewHolder(articlesBinding: ArticleItemBinding) : RecyclerView.ViewHolder(articlesBinding.root) {
        var binding: ArticleItemBinding = articlesBinding
    }

}