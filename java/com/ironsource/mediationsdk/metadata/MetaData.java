package com.ironsource.mediationsdk.metadata;

import java.util.ArrayList;
import java.util.List;

public class MetaData {
    private String mKey;
    private List<String> mValues;
    private List<MetaDataValueTypes> mValuesType;

    public enum MetaDataValueTypes {
        META_DATA_VALUE_STRING,
        META_DATA_VALUE_BOOLEAN,
        META_DATA_VALUE_INT,
        META_DATA_VALUE_LONG,
        META_DATA_VALUE_DOUBLE,
        META_DATA_VALUE_FLOAT
    }

    public MetaData(String str, List<String> list, List<MetaDataValueTypes> list2) {
        this.mKey = str;
        this.mValues = list;
        this.mValuesType = list2;
    }

    public MetaData(String str, List<String> list) {
        this.mKey = str;
        this.mValues = list;
        this.mValuesType = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            this.mValuesType.add(MetaDataValueTypes.META_DATA_VALUE_STRING);
        }
    }

    public String getMetaDataKey() {
        return this.mKey;
    }

    public List<String> getMetaDataValue() {
        return this.mValues;
    }

    public List<MetaDataValueTypes> getMetaDataValueType() {
        return this.mValuesType;
    }
}
