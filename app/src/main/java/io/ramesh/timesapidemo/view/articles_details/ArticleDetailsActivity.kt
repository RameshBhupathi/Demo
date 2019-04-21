package io.ramesh.timesapidemo.view.articles_details

import android.os.Bundle
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import io.ramesh.timesapidemo.AppConstansts.Companion.ARTICLE_ADX_KEYWORD
import io.ramesh.timesapidemo.AppConstansts.Companion.ARTICLE_DETAILS_URL
import io.ramesh.timesapidemo.R
import io.ramesh.timesapidemo.databinding.ActivityArticlesDetailsBinding
import io.ramesh.timesapidemo.view.base.BaseActivity
import javax.inject.Inject

class ArticleDetailsActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var binding: ActivityArticlesDetailsBinding
    lateinit var viewModel: ArticleDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_articles_details)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ArticleDetailsViewModel::class.java)

        binding.wvArticle.setInitialScale(1);
        binding.wvArticle.getSettings().setLoadWithOverviewMode(true);
        binding.wvArticle.getSettings().setUseWideViewPort(true);
        binding.wvArticle.getSettings().setJavaScriptEnabled(true);


        if (intent != null && intent.hasExtra(ARTICLE_DETAILS_URL)) {
            viewModel.articleUrl = intent.getStringExtra(ARTICLE_DETAILS_URL)
            viewModel.title = intent.getStringExtra(ARTICLE_ADX_KEYWORD)
            setTitle(viewModel.title)

            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            loadArticlesDetails()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadArticlesDetails() {
        binding.progressbar.visibility = VISIBLE
        binding.wvArticle.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.progressbar.visibility = GONE
            }
        }

        binding.wvArticle.loadUrl(viewModel.articleUrl)

    }
}
