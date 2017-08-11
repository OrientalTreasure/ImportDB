package com.imdb.importdb;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.imdb.importdb.gen.DaoMaster;
import com.imdb.importdb.gen.DaoSession;

import org.greenrobot.greendao.database.Database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/8/10.
 */

public class BaseApplication extends Application {
    //外部数据库名称
    public static final String DB_EXTERNAL = "user_temp-db.db";
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        copyDbFile(this, DB_EXTERNAL);

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, DB_EXTERNAL);
        Database writableDb = devOpenHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(writableDb);
        daoSession = daoMaster.newSession();


    }

    public DaoSession getDaoSession() {
        return daoSession;
    }


    /**
     * 复制数据库文件
     *
     * @param context 上下文
     * @param db_name 外部数据库的文件名
     */
    public static void copyDbFile(Context context, String db_name) {
        InputStream in = null;
        FileOutputStream out = null;
        String path = "/data/data/" + context.getPackageName() + "/databases/";
        File file = new File(path + db_name);

        //创建文件夹
        File filePath = new File(path);
        if (!filePath.exists())
            filePath.mkdirs();

        if (file.exists()) {
            Log.w("IDB", "数据库已经文件存在");
            return;
        } else {
            try {
                Log.w("IDB", "数据库进行复制……");
                in = context.getAssets().open(db_name); // 从assets目录下复制
                out = new FileOutputStream(file);
                int length = 0;
                byte[] buf = new byte[1024];
                while ((length = in.read(buf)) != -1) {
                    out.write(buf, 0, length);
                }
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null) in.close();
                    if (out != null) out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
