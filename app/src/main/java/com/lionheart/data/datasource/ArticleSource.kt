package com.lionheart.data.datasource

import com.lionheart.data.model.request.BookMarkRequest
import com.lionheart.data.service.ArticleService
import com.lionheart.domain.entity.ArticleCategory
import javax.inject.Inject

class ArticleSource @Inject constructor(
    private val articleService: ArticleService,
) {
    suspend fun getCategoryArticle(category: ArticleCategory) =
        articleService.getArticles(category)

    suspend fun switchBookmark(articleId: Long, bookmarkStatus: Boolean) =
        articleService.switchBookmark(BookMarkRequest(articleId, bookmarkStatus))
}
