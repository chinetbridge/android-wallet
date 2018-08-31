package io.xdag.xdagwallet.model;

import android.text.TextUtils;
import io.xdag.common.tool.ACache;
import io.xdag.xdagwallet.R;
import io.xdag.xdagwallet.config.Config;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * created by lxm on 2018/8/31.
 */
public class PoolListModel implements Serializable {

    private static final String CACHE_KEY = "io,xdag.android-wallet.pool.list";

    private static final PoolListModel sInstance = new PoolListModel();

    public static PoolListModel load() {
        Object object = ACache.getInstance().getSerializable(CACHE_KEY);
        if (object instanceof PoolListModel) {
            sInstance.poolList.clear();
            sInstance.poolList.addAll(((PoolListModel) object).poolList);
        }
        return get();
    }

    public static PoolListModel get() {
        return sInstance;
    }

    private List<PoolModel> poolList = new ArrayList<>();


    private PoolListModel() {
        poolList.add(new PoolModel("xdagmine.com:13654"));
        poolList.add(new PoolModel("xdagscan.com:13654"));
        poolList.add(new PoolModel("cn.xdag.vspool.com:13654"));
        poolList.add(new PoolModel("142.44.143.234:777"));
        poolList.add(new PoolModel("pool.xdagcn.com:13654"));
        poolList.add(new PoolModel("pool.xdagpool.com:13654"));
        poolList.add(new PoolModel("xdag.coolmine.top:13654"));
    }

    public List<PoolModel> getPoolListToAdapter() {
        for (int i = 0; i < poolList.size(); i++) {
            if (TextUtils.equals(Config.getPoolAddress(), poolList.get(i).address)) {
                poolList.get(i).selectedImage = R.drawable.ic_pool_selected;
            } else {
                poolList.get(i).selectedImage = 0;
            }
        }
        return poolList;
    }

    public void add(PoolModel poolModel) {
        poolList.add(poolModel);
    }

    public void delete(PoolModel poolModel) {
        poolList.remove(poolModel);
    }

    public boolean contains(PoolModel pool) {
        return poolList.contains(pool);
    }

    public void save() {
        ACache.getInstance().put(PoolListModel.CACHE_KEY, sInstance);
    }

}
