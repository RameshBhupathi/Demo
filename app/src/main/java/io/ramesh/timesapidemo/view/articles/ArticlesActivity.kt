package io.ramesh.timesapidemo.view.articles

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.ramesh.timesapidemo.AppConstansts
import io.ramesh.timesapidemo.R
import io.ramesh.timesapidemo.api.response.MostViewedArticlesResponse
import io.ramesh.timesapidemo.databinding.ActivityArticlesBinding
import io.ramesh.timesapidemo.view.articles_details.ArticleDetailsActivity
import io.ramesh.timesapidemo.view.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject

class ArticlesActivity : BaseActivity(),ArticleItemCallback {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var binding: ActivityArticlesBinding

    lateinit var viewModel: ArticlesViewModel

    var articlesAdapter: ArticlesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_articles)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ArticlesViewModel::class.java)
        binding.rvArticles.setLayoutManager(LinearLayoutManager(this))
        loadArticles()
        showArticles()
    }

    fun loadArticles() {
        viewModel.getMostViewedArticles(1).observe(this, Observer {
            if (it.status) {
                Timber.d("size " + ((it.data) as MostViewedArticlesResponse).results.size)
                viewModel.articles.value = ((it.data) as MostViewedArticlesResponse).results
                showArticles()
            } else {
                showToastMessage(it.message)
            }

        })

    }

    private fun showArticles() {
        viewModel.articles.observe(this, Observer {
            articlesAdapter = ArticlesAdapter(it,this)
            binding.rvArticles.adapter = articlesAdapter
        })
    }

    override fun showArticleDetails(url: String,keyword :String) {
        val articleDetailsIntent= Intent(this,ArticleDetailsActivity::class.java)
        articleDetailsIntent.putExtra(AppConstansts.ARTICLE_DETAILS_URL,url)
        articleDetailsIntent.putExtra(AppConstansts.ARTICLE_ADX_KEYWORD,keyword)
        startActivity(articleDetailsIntent)
    }

}
