package com.way.rapid.myapplication;

        import java.util.ArrayList;
        import java.util.List;

public class StaticList {
    public static List<Bean> list1;
    static {
        list1 = new ArrayList<Bean>();
        list1.add(new Bean(R.drawable.ic_oo_, "Ī���", "���������죬����һ��ȥ��ɽ����������һ��"));
        list1.add(new Bean(R.drawable.ic_qq, "���", "ʮ��ɱһ�ˣ�ǧ�ﲻ����"));
        list1.add(new Bean(R.drawable.ic_vv_, "�Ÿ�", " ��ʱ��ѧϰһ����"));
    }
}