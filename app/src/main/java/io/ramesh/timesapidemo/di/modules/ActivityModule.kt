package io.ramesh.timesapidemo.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.ramesh.timesapidemo.view.articles.ArticlesActivity
import io.ramesh.timesapidemo.view.articles_details.ArticleDetailsActivity
import io.ramesh.timesapidemo.view.base.BaseActivity


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeBaseActivity(): BaseActivity

    @ContributesAndroidInjector
    internal abstract fun contributeArticlesActivity(): ArticlesActivity

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): ArticleDetailsActivity


}