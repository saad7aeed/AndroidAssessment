package com.example.plateform.core.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.R
import com.example.android.databinding.ActivityPostScreenBinding
import com.example.android.databinding.ActivitySocialPostBinding
import com.example.plateform.core.adapters.CustomerAdapter
import com.example.plateform.core.adapters.ProfilePostAdapter
import com.example.plateform.core.model.CommentsSection
import com.example.plateform.core.model.PostDataArrayModel
import com.example.plateform.core.model.PostDataModel
import com.example.plateform.core.model.SubCommentsSection

class SocialPostActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySocialPostBinding
    private var postData: ArrayList<PostDataModel> = ArrayList()
    private var postDataArray = ArrayList<PostDataArrayModel>()
    private var comments = ArrayList<CommentsSection>()
    private var subComments = ArrayList<SubCommentsSection>()
    var postAdapter: ProfilePostAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySocialPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        setUpRecyclerViewForPost()
    }

    fun initView() {
        subComments.add(
            SubCommentsSection(
                "",
                "ㅇㅅㅇ",
                false,
                "1일전",
                "오 대박! 라이브 리뷰 오늘 올라온대요? 챙겨봐야겠다",
                5,
                1
            )
        )
        comments.add(
            CommentsSection(
                "",
                "안녕 나 응애",
                true,
                "1일전",
                "어머 제가 있던 테이블이 제일 반응이 좋았나보네요\uD83E\uDD2D \n" +
                        "우짤래미님도 아시겠지만 저도 일반인 몸매 그 이상도 이하도\n" +
                        "아니잖아요?! 그런 제가 기꺼이 도전해봤는데 생각보다\n" +
                        "괜찮았어요! 오늘 중으로 라이브 리뷰 올라온다고 하니\n" +
                        "꼭 봐주세용~!",
                5,
                5,
                subComments
            )
        )
        postData.add(PostDataModel(
            "",
            "안녕 나 응애",
            true,
            "165cm . ",
            "53kg",
            "1일전",
            "팔로우",
            "지난 월요일에 했던 이벤트 중 가장 괜찮은 상품 뭐야?",
            "지난 월요일에 2023년 S/S 트렌드 알아보기 이벤트 참석했던 팝들아~\n" +
                    "혹시 어떤 상품이 제일 괜찮았어? \n" +
                    "\n" +
                    "후기 올라오는거 보면 로우라이즈? 그게 제일 반응 좋고 그 테이블이 \n" +
                    "제일 재밌었다던데 맞아???\n" +
                    "\n" +
                    "올해 로우라이즈가 트렌드라길래 나도 도전해보고 싶은데 말라깽이가\n" +
                    "아닌 사람들도 잘 어울릴지 너무너무 궁금해ㅜㅜ로우라이즈 테이블에\n" +
                    "있었던 팝들 있으면 어땠는지 후기 좀 공유해주라~~!",
            "",
            5,
            5,
            comments
        ))
    }

    private fun setUpRecyclerViewForPost() {
        val layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.postSection.layoutManager = layoutManager
        postData.let {
            postAdapter = ProfilePostAdapter(
                this,
                it
            )
        }
        binding.postSection.adapter = postAdapter
    }
}