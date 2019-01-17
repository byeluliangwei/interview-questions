package cn.luliangwei.interview.questions.error;

/**
 * 错题
 */
public class WrongAnswer {

    //检查此程序是否有问题，如无问题则写出输出结果
    public static class Example { 
        String str = new String("good"); 
        char[] ch = {'a','b','c'}; 
        public static void main(String[] args) { 
           Example ex = new Example(); 
           ex.change(ex.str, ex.ch); 
           System.out.print(ex.str +"and"); 
           System.out.print(ex.ch);  
        } 
          
        public void change(String str, char ch[]){ 
           str= "test ok"; 
           ch[0]= 'g'; 
        } 
      }
}
