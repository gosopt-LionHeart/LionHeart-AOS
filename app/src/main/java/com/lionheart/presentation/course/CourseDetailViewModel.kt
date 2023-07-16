package com.lionheart.presentation.course

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.domain.entity.Article
import com.lionheart.domain.entity.CourseWeek
import com.lionheart.domain.entity.Lion
import com.lionheart.domain.repository.LionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CourseDetailViewModel @Inject constructor(
    private val lionRepository: LionRepository
) : ViewModel() {
    private val _exampleData = MutableLiveData<Lion>()
    val exampleData: LiveData<Lion> get() = _exampleData

    val tempHeader = CourseWeek(
        week = 28,
        imageUrl = "https://github.com/gosopt-LionHeart/LionHeart-AOS/assets/74162198/4743f4e7-5323-4230-8db2-ac38df8e926b"
    )

    val courseWeeklyList = listOf(
        Article(
            "육아카드 만들기 A-Z",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "젖병을 잘못 구매하면, 배앓이를 한다는 말 들어보셨나요? 오늘은 신생아에게 가장 중요한 젖병 이야기를 들려드릴게요.",
            9,
            false,
            listOf("신체변화", "건강", "병원 정보"),
        ),
        Article(
            "육아카드 만들기 A-Z",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "젖병을 잘못 구매하면, 배앓이를 한다는 말 들어보셨나요? 오늘은 신생아에게 가장 중요한 젖병 이야기를 들려드릴게요. 젖병을 잘못 구매하면, 배앓이를 한다는 말 들어보셨나요? 오늘은 신생아에게 가장 중요한 젖병 이야기를 들려드릴게요.",
            12,
            false,
            listOf("신체변화", "태교", "병원 정보"),
        ),
        Article(
            "육아카드 만들기 A-Z",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "젖병을 잘못 구매하면, 배앓이를 한다는 말 들어보셨나요? 오늘은 신생아에게 가장 중요한 젖병 이야기를 들려드릴게요.",
            9,
            false,
            listOf("신체변화", "건강", "병원 정보"),
        ),
        Article(
            "육아카드 만들기 A-Z",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "젖병을 잘못 구매하면, 배앓이를 한다는 말 들어보셨나요? 오늘은 신생아에게 가장 중요한 젖병 이야기를 들려드릴게요.",
            12,
            false,
            listOf("신체변화", "건강", "병원 정보"),
        ),
        Article(
            "육아카드 만들기 A-Z",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "젖병을 잘못 구매하면, 배앓이를 한다는 말 들어보셨나요? 오늘은 신생아에게 가장 중요한 젖병 이야기를 들려드릴게요.",
            9,
            false,
            listOf("신체변화", "건강", "병원 정보"),
        ),
        Article(
            "육아카드 만들기 A-Z",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "젖병을 잘못 구매하면, 배앓이를 한다는 말 들어보셨나요? 오늘은 신생아에게 가장 중요한 젖병 이야기를 들려드릴게요.",
            12,
            false,
            listOf("신체변화", "건강", "병원 정보"),
        ),
        Article(
            "육아카드 만들기 A-Z",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "젖병을 잘못 구매하면, 배앓이를 한다는 말 들어보셨나요? 오늘은 신생아에게 가장 중요한 젖병 이야기를 들려드릴게요.",
            9,
            false,
            listOf("신체변화", "건강", "병원 정보"),
        ),
    )

    fun getExampleData() {
        viewModelScope.launch {
            lionRepository.getArticleList(1)
                .onSuccess { response ->
                    _exampleData.value = response
                }
                .onFailure {
                    Timber.tag("getExampleDataFailure").d(it)
                }
        }
    }
}