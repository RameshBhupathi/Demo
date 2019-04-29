package io.ramesh.timesapidemo.view.articles

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import io.ramesh.timesapidemo.AppConstansts
import io.ramesh.timesapidemo.R
import io.ramesh.timesapidemo.data.api.model.Article
import io.ramesh.timesapidemo.databinding.ActivityArticlesBinding
import io.ramesh.timesapidemo.view.articles_details.ArticleDetailsActivity
import io.ramesh.timesapidemo.view.base.BaseActivity
import javax.inject.Inject

class ArticlesActivity : BaseActivity(), ArticleItemCallback {

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
        setTitle(getString(R.string.most_viewed_articles))
        loadArticles()
        showArticles()
    }

    fun loadArticles() {
        binding.tvInfo.visibility = GONE
        binding.pbArticles.visibility = View.VISIBLE
        viewModel.getMostViewedArticles(1).observe(this, androidx.lifecycle.Observer {
            binding.pbArticles.visibility = GONE
            if (it.status) {
                if(it.data!=null) {
                    viewModel.articles.value = (it.data) as MutableList<Article>
                    showArticles()
                }
            } else {
                showToastMessage(it.message)
            }

        })
    }

    private fun showArticles() {

        //BgTask(ArticlesActivity@this).execute()
        viewModel.articles.observe(this, androidx.lifecycle.Observer {
            articlesAdapter = ArticlesAdapter(ArticlesActivity@ this, it, this)
            binding.rvArticles.adapter = articlesAdapter
        })

    }

    /*inner class BgTask(var articlesActivity: ArticlesActivity) : AsyncTask<Void, Void, LiveData<MutableList<Article>>>() {
        override fun doInBackground(vararg params: Void?): LiveData<MutableList<Article>> {
            var articles = articlesDao.getAllArticles()


            Timber.d("size " + articlesDao.getAllArticles()??.size)
            return articles
        }

        override fun onPostExecute(articles: LiveData<MutableList<Article>>) {
            super.onPostExecute(articles)
            articlesAdapter = ArticlesAdapter(articlesActivity, articles.value, articlesActivity)
            binding.rvArticles.adapter = articlesAdapter

            //
        }

    }*/


    override fun showArticleDetails(url: String?, keyword: String) {
        val articleDetailsIntent = Intent(this, ArticleDetailsActivity::class.java)
        articleDetailsIntent.putExtra(AppConstansts.ARTICLE_DETAILS_URL, url)
        articleDetailsIntent.putExtra(AppConstansts.ARTICLE_ADX_KEYWORD, keyword)
        startActivity(articleDetailsIntent)
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetworkInfo: NetworkInfo? = null
        activeNetworkInfo = cm.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }

}
