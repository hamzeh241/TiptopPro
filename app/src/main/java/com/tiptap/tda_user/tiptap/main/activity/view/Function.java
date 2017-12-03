package com.tiptap.tda_user.tiptap.main.activity.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tiptap.tda_user.tiptap.R;
import com.tiptap.tda_user.tiptap.common.SampleApp;
import com.tiptap.tda_user.tiptap.common.StateMaintainer;
import com.tiptap.tda_user.tiptap.di.module.MainActivityModule;
import com.tiptap.tda_user.tiptap.main.activity.MVP_Main;
import com.tiptap.tda_user.tiptap.main.activity.presenter.MainPresenter;
import com.tiptap.tda_user.tiptap.main.activity.view.recycler.NotesViewHolder;
import javax.inject.Inject;

public class Function
    extends AppCompatActivity
    implements MVP_Main.RequiredViewOps {

    public static String lan;
    private static final String TAG = Function.class.getSimpleName();
    private ListNotes mListAdapter;


    @Inject
    public MVP_Main.ProvidedPresenterOps mPresenter;

    private ProgressBar mProgress;
    private final StateMaintainer mStateMaintainer = new StateMaintainer( getFragmentManager(), Function.class.getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.function);
        setupViews();
        setupMVP();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy(isChangingConfigurations());
    }

    private void setupViews(){
        mProgress = (ProgressBar) findViewById(R.id.progressbar);

        TextView title = (TextView)findViewById(R.id.title);
        title.setText("Function List Of "+lan);

        mListAdapter = new ListNotes();
        RecyclerView mList = (RecyclerView) findViewById(R.id.list_notes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Function.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mList.setLayoutManager(linearLayoutManager);
        mList.setAdapter(mListAdapter);
        mList.setItemAnimator(new DefaultItemAnimator());
    }

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
        mStateMaintainer.put(MainPresenter.class.getSimpleName(), mPresenter);
    }

    private void reinitialize() {
        Log.d(TAG, "reinitialize");
        mPresenter = mStateMaintainer.get(MainPresenter.class.getSimpleName());
        mPresenter.setView(this);
        if ( mPresenter == null )
            setupComponent();
    }

    private void setupComponent(){
        Log.d(TAG, "setupComponent");
        SampleApp.get(this)
                .getAppComponent()
                .getMainComponent(new MainActivityModule(this))
                .inject(this);
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showToast(Toast toast) {
        toast.show();
    }

    @Override
    public void notifyDataSetChanged() {
        mListAdapter.notifyDataSetChanged();
    }

    private class ListNotes extends RecyclerView.Adapter<NotesViewHolder> {

        @Override
        public int getItemCount() {
            return mPresenter.getNotesCount();
        }

        @Override
        public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return mPresenter.createViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(NotesViewHolder holder, int position) {
            mPresenter.bindViewHolder(holder, position);
        }
    }
}