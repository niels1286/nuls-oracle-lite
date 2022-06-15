package io.nuls.contract;

public class ValueInfo {
    private String value;
    private long updateTime;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ValueInfo{" +
                "value=" + value +
                ", updateTime=" + updateTime +
                '}';
    }
}
