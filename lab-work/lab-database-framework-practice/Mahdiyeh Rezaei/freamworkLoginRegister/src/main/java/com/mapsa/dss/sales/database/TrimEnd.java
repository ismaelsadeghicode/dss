package com.mapsa.dss.sales.database;

public class TrimEnd {
    public TrimEnd(StringBuilder stringBuilder) {
        // remove extra spaces from the end of the StringBuilder. -> ex. (te st ,  ) => (te st )
        int i = stringBuilder.length() - 1;
        while (stringBuilder.charAt(i) == ' ') {
            stringBuilder.deleteCharAt(i);
            i--;
        }
        if(stringBuilder.charAt(i) == ','){
            stringBuilder.deleteCharAt(i);
        }
    }
}
