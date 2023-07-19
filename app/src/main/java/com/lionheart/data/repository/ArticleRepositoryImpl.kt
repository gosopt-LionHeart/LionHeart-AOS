package com.lionheart.data.repository

import com.lionheart.domain.entity.Article
import com.lionheart.domain.entity.ArticleCategory
import com.lionheart.domain.entity.ArticleDetail
import com.lionheart.domain.entity.TodayArticle
import com.lionheart.domain.entity.WeeklyCourse
import com.lionheart.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
//    private val articleDataSource: ArticleDataSource
) : ArticleRepository {
    override suspend fun getArticleByCategory(category: ArticleCategory): List<Article> {
        TODO("Not yet implemented")
    }

    override suspend fun getArticleDetail(articleId: Long): ArticleDetail {
        TODO("Not yet implemented")
    }

    override suspend fun getTodayArticle(): TodayArticle {
        TODO("Not yet implemented")
    }

    override suspend fun getWeeklyArticle(week: Long): WeeklyCourse {
        TODO("Not yet implemented")
    }

    override suspend fun switchBookmark(articleId: Long, switching: Boolean): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getBookmarks() {
        TODO("Not yet implemented")
    }
}
