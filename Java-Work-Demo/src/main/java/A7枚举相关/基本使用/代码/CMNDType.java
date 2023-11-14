package A7枚举相关.基本使用.代码;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/16 16:33
 * @Description: 枚举的基本使用
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 指令下发
 * @author Lenovo
 */
public enum CMNDType {
    /**
     * 开机
     */
    Start("0"),
    /**
     * 关机
     */
    ShutDown("1"),
    /**
     * 重启设备
     */
    Reboot("2"),
    /**
     * 未知指令
     */
    UnKnow("999")
    ;

    private String code;

    CMNDType(String code) {
        this.code = code;
    }

    private static Map<String, CMNDType> map = new HashMap<>();

    /**
     * values()
     *  该方法可以将枚举类型成员以数组的形式返回
     *  枚举类型名称.values()
     */
    static {
        CMNDType [] ens = CMNDType.values();
        for(CMNDType en : ens){
            map.put(en.code, en);
        }
    }

    /**
     * 获取指令类型 通过key - value 的形式
     * @param code
     * @return
     */
    public static CMNDType get (String code){
        if(map.containsKey(code)){
            return map.get(code);
        }
        return UnKnow;
    }

    @Override
    public String toString(){
        return this.code;
    }



}
