package io.ramesh.timesapidemo.view.articles_details

import androidx.lifecycle.ViewModel
import io.ramesh.timesapidemo.data.api.repository.ProjectRepository
import javax.inject.Inject


/**
 * Created by Ramesh Bhupathi on 2019-04-21.
 */
class ArticleDetailsViewModel @Inject constructor(private val repository: ProjectRepository) : ViewModel() {
    var articleUrl: String? = null
    var title: String? = null
}