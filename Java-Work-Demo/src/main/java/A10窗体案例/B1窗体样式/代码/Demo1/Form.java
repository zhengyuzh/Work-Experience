package A10窗体案例.B1窗体样式.代码.Demo1;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A10窗体案例.B1窗体样式.代码.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-20  14:00
 * @Description: 使用java 语言制作一个窗体，用来收集用户输入的信息。给银行人员 制作一个可视化的操作窗口
 * @Version: 1.0
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/16 15:06
 * @Description: 使用java制作一个窗体，用来收集用户输入的内容
 */

public class Form extends JFrame {
    JLabel jlabel;
    JTextField jtf1;
    JButton jb1, jb2;
    JPanel pane;

    private String PackageConfig = "";
    private String MainKey = "";

    public String getMainKey() {
        return MainKey;
    }

    public void setMainKey(String mainKey) {
        MainKey = mainKey;
    }

    public String getPackageConfig() {
        return this.PackageConfig;
    }

    public void setPackageConfig(String packageConfig) {
        this.PackageConfig = packageConfig;
    }

    /**
     * 构造函数
     *
     * @param title
     */
    public Form(String title) {
        super(title);
        this.getContentPane().setLayout(null);
        this.setBounds(500, 500, 460, 460);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pane = new JPanel();
        pane.setBounds(10, 10, 400, 300);
        pane.setLayout(null);
        jlabel = new JLabel("设备主秘匙:");
        jlabel.setBounds(30, 40, 80, 30);
        jtf1 = new JTextField();
        jtf1.setBounds(110, 40, 260, 30);
        pane.add(jlabel);
        pane.add(jtf1);


        jb1 = new JButton("保存");
        jb1.setBounds(130, 100, 70, 30);
        pane.add(jb1);

        jb2 = new JButton("取消");
        jb2.setBounds(220, 100, 70, 30);
        pane.add(jb2);
        this.add(pane);


        /**
         * 处理文本内容
         * true 包含中文字符  false 不包含中文字符
         */
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //正则表达式
                Pattern p = Pattern.compile("[\u4E00-\u9FA5|\\！|\\，|\\。|\\（|\\）|\\《|\\》|\\“|\\”|\\？|\\：|\\；|\\【|\\】]");
                String inputMainKey = jtf1.getText().trim();

                if (jtf1.getText().trim().length() == 0) {
                    JOptionPane.showMessageDialog(null, "输入内容不能为空！！！");
                } else {
                    Matcher m = p.matcher(inputMainKey);
                    if (m.find()) {
                        JOptionPane.showMessageDialog(null, "输入内容不合法，应该为数字+英文组合！！！");
                    } else {
                        JOptionPane.showMessageDialog(null, "修改成功！！！");
                    }
                }
            }

        });

        this.setVisible(true);
    }


    public static void main(String[] args) {
        Form c = new Form("修改主秘匙的值");
    }
}