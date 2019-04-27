package io.ramesh.timesapidemo.view.articles

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.ramesh.timesapidemo.GlideApp
import io.ramesh.timesapidemo.R
import io.ramesh.timesapidemo.api.model.Article
import io.ramesh.timesapidemo.databinding.ArticleItemBinding
import timber.log.Timber


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */


class ArticlesAdapter(var context: Context, var articles: MutableList<Article>, var callback: ArticleItemCallback) :
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

        GlideApp.with(context).load(
            article.media.get(0).mediaMetadata.get(0).url
        ).placeholder(R.drawable.ic_newspaper)
            .error(R.drawable.ic_newspaper)
            .into(holder.binding.ivArticle)

        Timber.d(
            "" + article.media.get(0).mediaMetadata.get(0).url
        );
    }

    class ArticlesViewHolder(articlesBinding: ArticleItemBinding) : RecyclerView.ViewHolder(articlesBinding.root) {
        var binding: ArticleItemBinding = articlesBinding
    }

}