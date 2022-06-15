package io.nuls.contract;

import io.nuls.contract.sdk.Block;
import io.nuls.contract.sdk.Contract;
import io.nuls.contract.sdk.Utils;
import io.nuls.contract.sdk.annotation.Required;
import io.nuls.contract.sdk.annotation.View;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个简单的链上数据存储、更新、查询合约，用于外部系统向区块链写入数据，供其他合约来查询
 */
public class OracleLiteContract extends Ownable implements Contract {

    private Map<String, ValueInfo> dataMap = new HashMap<String, ValueInfo>();

    public OracleLiteContract() {
    }

    public void submit(@Required String key, @Required String value) {
        onlyOwner();
        if (value == null || value.trim().length() == 0) {
            Utils.revert("Value can not be blank.");
        }
        ValueInfo data = new ValueInfo();
        data.setValue(value);
        data.setUpdateTime(Block.timestamp());
        dataMap.put(key, data);
    }

    public void batchSubmit(@Required String[] keys, @Required String[] values) {
        onlyOwner();
        for (short i = 0; i < keys.length; i++) {
            submit(keys[i], values[i]);
        }
    }

    @JSONSerializable
    @View
    public ValueInfo getValue(@Required String key) {
        ValueInfo info = dataMap.get(key);
        return info;
    }

    @JSONSerializable
    @View
    public ValueInfo[] getValues(@Required String[] keys) {
        ValueInfo[] values = new ValueInfo[keys.length];
        for (short i = 0; i < keys.length; i++) {
            values[i] = dataMap.get(keys[i]);
        }
        return values;
    }
}
