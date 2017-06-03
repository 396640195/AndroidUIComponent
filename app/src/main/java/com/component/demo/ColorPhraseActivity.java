package com.component.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.component.share.ColorPhrase;

/**
 * 这是一个改变文字显示颜色组件用法
 * Created by Administrator on 2017/6/3.
 */
public class ColorPhraseActivity extends Activity {
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_color_phrase_activity);

        textView = (TextView) this.findViewById(R.id.content);

        CharSequence chars = ColorPhrase.from("党的十八大以来,以{习近平}同志为核心的党中央从依然严峻复杂的斗争形势出发,把{巡视}作为推进全面{从严治党}的重大举措,高度重视巡视工作,意志品质顽强,领导坚强有力。中央政治局常委会听取每轮巡视情况汇报,习近平总书记{身体力行、率先垂范},先后18次发表重要讲话,对加强和改进巡视工作作出一系列决策部署,为做好巡视工作指明了方向。中央巡视工作领导小组坚决贯彻中央要求,保持力度和节奏,踩着不变的步伐,组织开展12轮巡视,今年上半年完成对中管高校的巡视后,将实现一届任期内中央巡视全覆盖目标任务,充分体现了以习近平同志为核心的党中央全面从严治党的坚定决心,是党内监督无禁区的最好诠释")
                .withSeparator("{}")
                .innerColor(0xFFE6454A)
                .outerColor(0xFF666666)
                .format();

        textView.setText(chars);
    }
}
