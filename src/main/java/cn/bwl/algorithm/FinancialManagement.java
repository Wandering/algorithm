package cn.bwl.algorithm;

import java.util.List;
import java.util.stream.LongStream;

/**
 * Created by Administrator on 2017/9/27.
 */
public class FinancialManagement {
    private static final int month = 12;
    public double avg(List<Double> list){
        LongStream ll = list.stream().mapToLong((v)->{
            Double vv = (v * 100);
            return vv.longValue();
        });
        return ll.sum()/month;
    }
}
