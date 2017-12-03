package com.tiptap.tda_user.tiptap.main.activity.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;
import com.tiptap.tda_user.tiptap.R;

public class Language
        extends AppCompatActivity{
        //implements mvp.RequiredViewOps {

    private CircleMenu circleMenu;
    String menu;

    //@Inject
    //public mvp.ProvidedPresenterOps mPresenter;

    //private static final String TAG = Language.class.getSimpleName();
   // private final StateMaintainer mStateMaintainer = new StateMaintainer( getFragmentManager(), Language.class.getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language);

        //setupViews();
       // setupMVP();

        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.mipmap.icon_earth, R.mipmap.icon_earth)
                .addSubMenu(Color.parseColor("#FF9800"), R.mipmap.icon_kurdistanflag)
                .addSubMenu(Color.parseColor("#FF9800"), R.mipmap.icon_turkeyflag)
                .addSubMenu(Color.parseColor("#FF9800"), R.mipmap.icon_chineseflag)
                .addSubMenu(Color.parseColor("#FF9800"), R.mipmap.icon_iranflag)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        switch(index){
                            case 0:
                                menu = "Kurdi";
                                break;
                            case 1:
                                menu = "Turki";
                                break;
                            case 2:
                                menu = "Chini";
                                break;
                            case 3:
                                menu = "Farsi";
                                break;
                        }
                    }
                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {}

            @Override
            public void onMenuClosed() {
                Function.lan = menu;
                //mPresenter.Empty();
                //mPresenter.NewFunction("word "+menu);
                //mPresenter.NewFunction("verb "+menu);
                //mPresenter.NewFunction("Grammar "+menu);
                startActivity(new Intent(Language.this, Function.class));
            }
        });
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                circleMenu.openMenu();
            }
        },500);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       //mPresenter.onDestroy(isChangingConfigurations());
    }

   /* private void setupViews(){}

    private void setupMVP(){
        if ( mStateMaintainer.firstTimeIn() ) {
            initialize();
        } else {
            reinitialize();
        }
    }

    private void initialize(){
        Log.d(TAG, "initialize");
        setupComponent();
        mStateMaintainer.put(Presenter.class.getSimpleName(), mPresenter);
    }

    private void reinitialize() {
        Log.d(TAG, "reinitialize");
        mPresenter = mStateMaintainer.get(Presenter.class.getSimpleName());
        mPresenter.setView(this);
        if ( mPresenter == null )
            setupComponent();
    }

    private void setupComponent(){
        Log.d(TAG, "setupComponent");
        SampleApp.get(this)
                .getAppComponent()
                .getMComponent(new Lmodel(this))
                .inject(this);
    }
*/
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        circleMenu.openMenu();
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public void onBackPressed() {
        circleMenu.closeMenu();
        this.finish();
    }

    /*@Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }*/
}