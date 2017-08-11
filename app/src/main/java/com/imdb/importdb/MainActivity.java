package com.imdb.importdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.imdb.importdb.entity.MyRoad;
import com.imdb.importdb.gen.DaoSession;
import com.imdb.importdb.gen.MyRoadDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BaseApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        application = ((BaseApplication) getApplication());
    }

    public void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.load:
                DaoSession daoSession = application.getDaoSession();
                MyRoadDao myRoadDao = daoSession.getMyRoadDao();
                List<MyRoad> myRoads = myRoadDao.loadAll();

                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < myRoads.size(); i++) {
                    MyRoad myRoad = myRoads.get(i);
                    stringBuffer.append(myRoad.getId() + " " + myRoad.getName())
                            .append(" ")
                            .append(myRoad.getName());
                }
                Log.w("IDB", "myRoads:" + myRoads.size()+"\n"+stringBuffer.toString());
                break;
        }
    }
}
