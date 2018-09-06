package cn.luliangwei.interview.questions.string;
/**
 * 
 * String相关问题.
 * </p>
 *
 * @author luliangwei
 */
public class StringQuestion {

    /**
     * <1>字符串
     * <pre>
     * 1秒 空间限制：32768K
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
     * 
     * 结果：
     * 运行时间：25ms
     * 占用内存：9484K
     * </pre>
     */
    public static String replaceSpace2String(String str) {
        return str.replace(" ", "%20");
    }
    
}
