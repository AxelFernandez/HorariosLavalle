package com.sistemas51.horarioslavalle.callback;

import java.util.Map;

public interface Callback {

    void callBack(String step, int stepNumber);
    Map<Integer,String> getData();
    boolean getSpecial();
    void moveToStep(int step);
}
