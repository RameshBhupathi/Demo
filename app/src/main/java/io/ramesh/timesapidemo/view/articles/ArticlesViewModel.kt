package io.ramesh.timesapidemo.view.articles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.ramesh.timesapidemo.api.Resource
import io.ramesh.timesapidemo.api.model.Article
import io.ramesh.timesapidemo.api.repository.ProjectRepository
import javax.inject.Inject


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
class ArticlesViewModel @Inject constructor(private val repository: ProjectRepository) : ViewModel() {
    var articles = MutableLiveData<MutableList<Article>>()


    fun getMostViewedArticles(index: Int): MutableLiveData<Resource<*>> {

        return repository.getMostViewedArticles(index)
    }
}