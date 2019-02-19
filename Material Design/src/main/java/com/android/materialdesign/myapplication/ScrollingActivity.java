package com.android.materialdesign.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liangyanqiao
 */
public class ScrollingActivity extends AppCompatActivity {

    private EditText edit_text;

    private TextView show_time;

    private ArrayList<Object> wxImgList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        edit_text = (EditText) findViewById(R.id.edit_text);
        show_time = (TextView) findViewById(R.id.show_time);
        Button do_show = (Button) findViewById(R.id.do_show);

        Handler handler = new Handler();
        handler.obtainMessage(1,Object.class).sendToTarget();




        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.addTab(tabs.newTab().setText("TAB 1"));

        tabs.addTab(tabs.newTab().setText("TAB 2"));

        tabs.addTab(tabs.newTab().setText("TAB 3"));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        do_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = edit_text.getText().toString();
                if (!TextUtils.isEmpty(time)) {
                    show_time.setText(TimeUtil.formatRelativeDate(Long.valueOf(time)));
                }
            }
        });

        if ("1".equals(null)) {
            Log.d("TAG", "--------------");
        }

        /*连接中如果有空格，则不能解析*/
        new Thread(new Runnable() {
            @Override
            public void run() {
                // global_error_msg warn 异常情况
                try {
                    //Document doc = Jsoup.connect("https://mp.weixin.qq.com/s/JLv1V7ySyRlBTSowVq1GcA").get();
                    Document doc = Jsoup.connect("https://mp.weixin.qq.com/s/h8BU_mZbUycDyP4o-aGz4Q").get();
                    String title = doc.title();

                    String strRegex = "[a-zA-z]+://[^\\s]*";
                    Pattern pattern = Pattern.compile(strRegex);
                    Matcher matcher = pattern.matcher(doc.toString());
                    wxImgList = new ArrayList<>();
                    while (matcher.find()) {
                        String resultUrl = matcher.group();
                        if(!TextUtils.isEmpty(resultUrl) && resultUrl.contains("mmbiz.qpic.cn")){
                            wxImgList.add(resultUrl);
                        }
                    }
                    for(int i = 0; i < wxImgList.size(); i++){
                        Log.d("mytag", "wei xin img list-----" + wxImgList.get(i));
                    }

                    Elements describe = doc.select("div.rich_media_content").select("p");

                    Elements withStyle = doc.select("div.rich_media_content").select("p").select("span").select("strong");
                    String s = describe.text().replaceAll("[\\u00A0]+","").replace(" ","");
                    Log.i("mytag", "网页标题：" + title + " 网页描述:" +  s.trim());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(ScrollingActivity.this, "lalalalala",0).show();
                        }
                    });

                }catch(Exception e) {
                    Log.i("mytag", e.toString());
                }
            }
        }).start();


//        Gson gson = new Gson();
//        GroupInfo mGroupInfo = new GroupInfo();
//        Map<String, GroupInfo> map = new LinkedHashMap<>();
//        mGroupInfo.id = "123";
//        mGroupInfo.nickName = "桥";
//        map.put("liang", mGroupInfo);
//        map.put("liangyuanyuan", mGroupInfo);
//        //转换成json数据，再保存
//        System.out.println("gson " + gson.toJson(map));
//        System.out.println("----------------------");
//        Map<String, Object> maps = JsonToMap.toMap(gson.toJson(map));
//        Map<String, GroupInfo> maps = toMap(gson.toJson(map));

//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        for(String s : list){
//            if("2".equals(s)){
//                list.remove(s);
//            }
//        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * json to map
     * @param object
     * @return
     */
    public Map<String, GroupInfo> toMap(String object) {
        Map<String, GroupInfo> data = new HashMap<>();
        // 将json字符串转换成jsonObject
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(object).getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
        for (Iterator<Map.Entry<String, JsonElement>> iter = entrySet.iterator(); iter.hasNext(); ) {
            Map.Entry<String, JsonElement> entry = iter.next();
            GroupInfo mGroupInfo = new  GroupInfo();
                String key = entry.getKey();
                JsonElement value = entry.getValue();
                mGroupInfo.id = value.getAsJsonObject().get("id").getAsString();
                mGroupInfo.nickName = value.getAsJsonObject().get("name").getAsString();
                data.put(key, mGroupInfo);
        }
        return data;
    }
}
