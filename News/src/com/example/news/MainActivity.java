package com.example.news;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView mListView;
    private static String URL = "http://www.imooc.com/api/teacher?type=4&num=30";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView=(ListView) findViewById(R.id.lv_main);

        new NewsAsyncTask().execute(URL);
    }

    /**
     *瀹炵幇缃戦〉鐨勫紓姝ヨ闂�
     */


    class NewsAsyncTask extends AsyncTask<String, Void, List<NewsBean>> {

        @Override
        protected List<NewsBean> doInBackground(String... params) {
            return getJsonData(params[0]);
        }

        @Override
        protected void onPostExecute(List<NewsBean> newsBeen) {
            super.onPostExecute(newsBeen);
            NewsAdapter adapter=new NewsAdapter(MainActivity.this,newsBeen);
            mListView.setAdapter(adapter);
        }
    }

        /**
         * 灏唘rl瀵瑰簲鐨凧SON鏍煎紡鏁版嵁杞寲涓烘垜浠墍灏佽鐨凬ewsBean
         *
         * @param url
         * @return
         */

        private List<NewsBean> getJsonData(String url) {
            //List<NewsBean> newsBeanList = new ArrayList<>();
        	
        	List<NewsBean> newsBeanList =new ArrayList<NewsBean>();

            try {
                String jsonString = readStream(new URL(url).openStream());

                JSONObject jsonObject;
                NewsBean newsBean;

                try {
                    jsonObject = new JSONObject(jsonString);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        jsonObject = jsonArray.getJSONObject(i);
                        newsBean = new NewsBean();
                        newsBean.newsIconUrl = jsonObject.getString("picSmall");
                        newsBean.newsTitle = jsonObject.getString("name");
                        newsBean.newsContent = jsonObject.getString("description");
                        newsBeanList.add(newsBean);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }


            return newsBeanList;
        }

        /**
         * 閫氳繃is瑙ｆ瀽缃戦〉鐨勬暟鎹�
         *
         * @param is
         * @return
         */

        private String readStream(InputStream is) {
            InputStreamReader isr;
            String result = "";

            try {
                String line = "";
                isr = new InputStreamReader(is, "utf-8");
                BufferedReader br = new BufferedReader(isr);

                while ((line = br.readLine()) != null) {

                    result += line;
                }


            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }
    }

