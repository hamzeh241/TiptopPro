package com.tiptap.tda_user.tiptap.webService.Api;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.ViewPager;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.tiptap.tda_user.tiptap.common.SampleApp;
import com.tiptap.tda_user.tiptap.main.activity.view.function.CardItem;
import com.tiptap.tda_user.tiptap.main.activity.view.function.CardPagerAdapter;
import com.tiptap.tda_user.tiptap.main.activity.view.function.ShadowTransformer;
import com.tiptap.tda_user.tiptap.webService.AppInfoService;
import com.tiptap.tda_user.tiptap.webService.BaseSetingApi;
import com.tiptap.tda_user.tiptap.webService.ErrorVolley;
import com.tiptap.tda_user.tiptap.webService.IAppInfo;
import com.tiptap.tda_user.tiptap.webService.PostError;
import com.tiptap.tda_user.tiptap.webService.viewmodel.FunctionViewModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import static com.tiptap.tda_user.tiptap.common.SampleApp.getMethodName;

public class Api_Function extends BaseSetingApi {

    IAppInfo iAppInfo;
    Context context;
    Activity mactivity;
    ProgressDialog pDialog;
    ViewPager mViewPager;
    CardPagerAdapter mCardAdapter;
    ShadowTransformer mCardShadowTransformer;
    SQLiteDatabase mdb;
    boolean mnet;
    List<FunctionViewModel> functionViewModels= new ArrayList<>();

    public Api_Function (boolean net, Context conContext, Activity activity, SQLiteDatabase db, ViewPager viewPager, CardPagerAdapter cardAdapter, ShadowTransformer shadowTransformer) {
        context = conContext;
        iAppInfo = new AppInfoService(context);
        mactivity = activity;
        mViewPager = viewPager;
        mCardAdapter = cardAdapter;
        mCardShadowTransformer = shadowTransformer;
        mdb = db;
        mnet = net;
        get();
    }

    public Api_Function get() {

        if(mnet){
            JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET,
                    url+ "Function?rowVersion=0x0", null, new Response.Listener<JSONArray>() {


                @Override
                public void onResponse(JSONArray response) {
                    boolean insert = false;
                    try {
                        int maxId = 0; //Splash.sqlite.GetMaxId_function();
                        String Q1 = "insert into function (id,title,row) values ";

                        for (int i=0; i<response.length(); i++) {
                            JSONObject jsonObject = response.getJSONObject(i);
                            String id = jsonObject.getString("C_id");
                            String title = jsonObject.getString("Title");
                            String row = "1";
                            int Id = Integer.parseInt(id);

                            FunctionViewModel functionViewModel = new FunctionViewModel();
                            functionViewModel.setId_function(id);
                            functionViewModel.setTitle_function(title);
                            functionViewModel.setRow_version(row);
                            functionViewModels.add(functionViewModel);

                            // insert
                            if(Id>maxId) {
                                insert = true;
                                Q1 = Q1.concat("('" + id + "','" + title + "','" + row + "')," );
                            }
                            // update
                            else {
                                String Q2="update function set title='"+title+"',row='"+row+"' where id="+id;
                                iAppInfo.InsertAd(Q2);
                            }
                        }

                        if(insert) {
                            Q1 = Q1.substring(0, Q1.trim().length() - 1).concat(";");
                            iAppInfo.InsertAd(Q1);
                        }

                        Cursor c = mdb.rawQuery("select * from function", null);
                        ArrayList<String> titles = new ArrayList<String>();
                        if (c.moveToFirst()) {
                            do {
                                String title = c.getString(c.getColumnIndex("title"));
                                mCardAdapter.addCardItem(new CardItem(title));
                                titles.add(title);
                            } while (c.moveToNext());
                        }
                        mdb.close();

                        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
                        mCardShadowTransformer.enableScaling(true);
                        mViewPager.setAdapter(mCardAdapter);
                        mViewPager.setPageTransformer(false, mCardShadowTransformer);
                        mViewPager.setOffscreenPageLimit(3);


                    } catch (JSONException e) {
                        pDialog.dismiss();
                        e.printStackTrace();
                        new PostError(context,e.getMessage(), getMethodName()).postError();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    // pDialog.dismiss();
                    new ErrorVolley(context).Error(volleyError,"get");
                    if (volleyError.networkResponse == null) {
                        if (volleyError.getClass().equals(TimeoutError.class)) {
                            //cls_mainActivity cls_event = new cls_mainActivity(mDemoSlider, iAppInfo, context);
                            //cls_event.LoadPage();
                        }
                    }
                }
            });
            SampleApp.getInstance().addToRequestQueue(jsonObjReq);

        }else{

            Cursor c = mdb.rawQuery("select * from function", null);
            ArrayList<String> titles = new ArrayList<String>();
            if (c.moveToFirst()) {
                do {
                    String title = c.getString(c.getColumnIndex("title"));
                    mCardAdapter.addCardItem(new CardItem(title));
                    titles.add(title);
                } while (c.moveToNext());
            }
            mdb.close();

            mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
            mCardShadowTransformer.enableScaling(true);
            mViewPager.setAdapter(mCardAdapter);
            mViewPager.setPageTransformer(false, mCardShadowTransformer);
            mViewPager.setOffscreenPageLimit(3);
        }
        return null;
    }
}