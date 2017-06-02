package cn.studyjams.s2.sj0141.careocd;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class FruitActivity extends AppCompatActivity {
    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAGE_ID = "fruit_image_id";
    public static final String OCD_introduction = "强迫症（英语：Obsessive-Compulsive Disorder, OCD）又译强迫性疾患、强迫性障碍、强迫性病症、强迫性神经症，亦译沉溺，是一种精神上的失调。\n\n" +
            "强迫性精神官能症简称强迫症，是属于焦虑症的一种。罹患强迫症的人会陷入一种无意义、且令人沮丧的重复的想法与行为当中，但是一直无法摆脱它。强迫症的表现可以自轻微到严重，但是假使症状严重而不治疗，可能摧毁一个人的工作能力，或在学校的表现，甚至连在家中的日常生活都有问题。最常见到的是重复而过度的清洁与检查行为，有时患者已经害怕重复行为的执行，为了逃避进而引发对于特定脏污产生强烈的排斥心理，例如遇到手上有油污会在大脑回路上产生清洁的欲望，正常的大脑会在执行完后清除神经回路的活性达到降低欲望进而结束动作，但是患者的在清洁后却得不到该有的神经回馈进而让欲望控制身体。在老鼠动物研究上，对特定神经传导受体进行基因改造而降低对抑制讯息的活性，实验老鼠会因为重复的脸部清洁动作而磨光脸部毛发。患者会感到需要不断反复地检查某些事，并且在患者的思绪中，会持续地重复浮现某种想法，或是感到需要一再地执行某些日常行为。\n\n" +
            "常见的重复行为包含洗手、计算东西、检查门是否上锁、迫人、明知故犯、屡教不改、懂礼貌却不守、要求物品以特定方式摆放或排序。有些患者可能会对丢弃物品有障碍，如果有强迫症的人改了这些习惯就很闷或者哭。这些重复行为严重的程度，会对患者的日常生活产生负面影响，比如患者每天会花1小时以上的时间去执行这些行为，大部分的成人患者能察觉他们的行为并不合理，强迫症的状况和抽搐、焦虑等失调有关，也可能会导致自杀风险提升。\n\n" +
            "强迫症的起因尚未知晓，由于同卵双胞胎比起非同卵双胞胎更容易罹患强迫症，因此部分原因可能是遗传因子所导致。强迫症的风险因子包含儿童时期可能有受虐经验，或是特定事件造成的压力，部分病例曾记载患者在罹患某种传染病后，才出现强迫症的行为。诊断的原则以症状为基础，并需要排除其它和药物相关的成因，分数量表例如耶鲁－布朗强迫症量表可以用来评估强迫症的严重程度。其他会产生类似症状的疾病包含：焦虑、重郁症、饮食失调（例如厌食或暴食）、抽搐以及强迫型人格障碍。\n\n" +
            "强迫症的治疗包括行为治疗，有时候会使用选择性血清素抑制剂（Selective serotonin reuptake inhibitor, SSRIs）提供患者辅助。行为治疗包括试图将患者暴露在引起强迫行为的环境下，但同时也试图抑制重复行为的发生。而部分对于 SSRI 有治疗耐受性的患者，加上像是 Quetiapine 等非典型抗精神病的药物，或许对治疗会有所帮助，但同时也提升了副作用的风险。如果未接受治疗，强迫症的症状往往会持续数十年。\n\n" +
            "据估计，约有近 2.3% 的人，在一生中的某个时刻会被强迫症所困扰。每一年大约都有将近 1.2% 的人有强迫症的症状，且并无特定地缘关系。一般来说，只有相当少的案例是在35岁以后发病，半数以上的患者，大都在20岁以前就出现症状。强迫症并没有性别差异，英文中 obsessive–compulsive，往往用在形容那些过度一丝不苟、完美主义、专心一致或是自恋的人。强迫症是世界上最常见精神问题中的第四位，其病发率跟气喘及糖尿病同样普遍，在美国每50个人就有一人可能是强迫症患者。\n " +
            "——来自维基百科";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        Intent intent = getIntent();
        String fruitName = intent.getStringExtra(FRUIT_NAME);
        int fruitImageId = intent.getIntExtra(FRUIT_IMAGE_ID,0);
        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        ImageView fruitImageView = (ImageView) findViewById(R.id.fruit_image_view);
        TextView fruitContentText = (TextView) findViewById(R.id.fruit_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(fruitName);
        Glide.with(this).load(fruitImageId).into(fruitImageView);
        String fruitContent = generateFruitContent(fruitName);
        fruitContentText.setText(fruitContent);
    }

/*
* 根据随机显示的图片的不同，使用不同的介绍文字
* */
    private String generateFruitContent(String fruitName){
//        StringBuilder fruitContent = new StringBuilder();
//       for(int i=0;i<500;i++){
//           fruitContent.append(fruitName);
//        }
//        return fruitContent.toString();
        fruitName =  OCD_introduction ;

        return fruitName;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
