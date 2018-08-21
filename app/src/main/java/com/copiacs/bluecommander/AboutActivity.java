package com.copiacs.bluecommander;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_about);
        this.setTheme(R.style.AppThemeLight);
                AboutBuilder builder = AboutBuilder.with(this)
                .setAppIcon(R.mipmap.ic_launcher_round)
                .setAppName(R.string.app_name)
                .setPhoto(R.mipmap.ic_launcher_round)
                .setCover(R.mipmap.profile_cover)
                .setLinksAnimated(true)
                .setDividerDashGap(13)
                .setName("Copia")
                .setSubTitle("Consultancy and Services")
                .setLinksColumnsCount(3)
                .setBrief("\n" +
                        "Copia Consultancy Services is a private limited company established in 2013. We operate from Airoli, Navi Mumbai and are strategically located with excellent connectivity with Mumbai Downtown, Navi Mumbai, Thane, Pune and Nasik. Our location helps us to connect with this adjoining industrial belt to serve customers better. \n" +
                        "This company is formed by group of senior professionals having more than 100 years of collective experience in Information Technology, Supply Chain, Process Management & sales. Apart from having solid foundation of experienced professionals, we have a very dynamic, young and enthusiastic team of professionals who passionately work to solve customer issues.")
                .addGooglePlayStoreLink("")
                .addFacebookLink("1499136287080844")
                .addEmailLink("info@copiacs.com")
                .addWebsiteLink("www.copaics.com")
                .addLinkedInLink("company/copia-consyltancy")
                .addGooglePlusLink("103111182944227359400")
                .addFiveStarsAction()
                .addMoreFromMeAction("Copia Consultancy Services Pvt Ltd")
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .addUpdateAction()
                .setActionsColumnsCount(2)
                .addFeedbackAction("info@copiacs.com")
                .setWrapScrollView(true)
                .setShowAsCard(true);

        AboutView view = builder.build();
        view.setPadding(0,0,0,0);

        ConstraintLayout ylyl=findViewById(R.id.ylyl);
        ylyl.addView(view);
    }
}
