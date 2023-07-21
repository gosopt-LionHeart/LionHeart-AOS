package com.lionheart.presentation.course

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lionheart.core.view.ItemDiffCallback
import com.lionheart.databinding.ItemCourseDetailThumbnailBinding
import com.lionheart.domain.entity.Article

class CourseDetailAdapter(
    private val onClickBookmark: (articleId: Long, switching: Boolean) -> Unit,
) :
    ListAdapter<Article, RecyclerView.ViewHolder>(diffUtil) {
    private val bookmarkStatus = SparseBooleanArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCourseDetailThumbnailBinding.inflate(inflater, parent, false)
        return CourseWeeklyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CourseWeeklyViewHolder).onBind(
            getItem(position),
            bookmarkStatus,
            onClickBookmark,
        )
    }

    companion object {
        private val diffUtil = ItemDiffCallback<Article>(
            onItemsTheSame = { old, new -> old == new },
            onContentsTheSame = { old, new -> old == new },
        )
    }
}

class CourseWeeklyViewHolder(private val binding: ItemCourseDetailThumbnailBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(
        data: Article,
        bookmarkStatus: SparseBooleanArray,
        onClickBookmark: (articleId: Long, switching: Boolean) -> Unit,
    ) {
        binding.data = data
        bookmarkStatus.put(layoutPosition, data.isMarked)
        initBookmark(data, bookmarkStatus, onClickBookmark)
    }

    private fun initBookmark(
        data: Article,
        bookmarkStatus: SparseBooleanArray,
        onClickBookmark: (articleId: Long, switching: Boolean) -> Unit,
    ) {
        with(binding.btnCourseWeeklyThumbnailBookmark) {
            isSelected = data.isMarked
            setOnClickListener {
                bookmarkStatus.put(position, isSelected)
                isSelected = isSelected.not()
                // 북마크 저장 작업
                onClickBookmark(data.articleId, isSelected)
            }
        }
    }
}
