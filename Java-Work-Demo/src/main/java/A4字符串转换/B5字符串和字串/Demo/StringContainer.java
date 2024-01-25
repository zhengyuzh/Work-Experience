package A4字符串转换.B5字符串和字串.Demo;

import org.junit.Test;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A4字符串转换.B5字符串和字串.Demo
 * @Author: zhengyuzhu
 * @CreateTime: 2023-12-07  09:58
 * @Description: TODO
 * @Version: 1.0
 */
public class StringContainer {

    @Test
    public void testDemo1() {
        String father = "/home/atmp/share/FaceAgr/ATM_FACE_AGR-12342256644_44.jpg";
        String son = "ATM_FACE_AGR";
        boolean status = father.contains(son);
        if (status) {
            System.out.println("包含");
        } else {
            System.out.println("不包含");
        }

    }

    @Test
    public void testDemo2() {
        String versionType = "/home/atmp/share/FaceAgr/ATM_FACE_AGR-12342256644_44.jpg";
        String faceProtocol = "ATM_FACE_AGR";
        String personaProtocol = "BranchAgreementSwitch";
        String insuringProtocol = "adpack";
        int rs = 0;

        if (versionType.contains(faceProtocol)) {
            //刷脸协议
            rs = 1;
        } else if (versionType.contains(personaProtocol)) {
            //个性化协议
            rs = 2;
        } else if (versionType.contains(insuringProtocol)) {
            //保险协议
            rs = 3;
        }

        if (1 == rs) {
            System.out.println("刷脸协议");

        } else if (2 == rs) {
            System.out.println("个性化协议");

        } else if (3 == rs) {
            System.out.println("保险协议");

        }
    }

    @Test
    public void testDemo3(){
        String faceVersionBase = "";
        if(faceVersionBase == ""){
            System.out.println("123");
        }
    }
}
