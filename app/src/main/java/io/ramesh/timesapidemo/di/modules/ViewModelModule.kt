package io.vrinda.medigin.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.ramesh.timesapidemo.di.factory.AppViewModelFactory
import io.ramesh.timesapidemo.di.modules.ViewModelKey
import io.ramesh.timesapidemo.view.articles.ArticlesViewModel
import io.ramesh.timesapidemo.view.articles_details.ArticleDetailsViewModel


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
@Suppress("unused")
@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ArticlesViewModel::class)
    internal abstract fun bindArticlesViewModel(articlesViewModel: ArticlesViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(ArticleDetailsViewModel::class)
    internal abstract fun bindArticleDetailsViewModel(articlesViewModel: ArticleDetailsViewModel): ViewModel


    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

}