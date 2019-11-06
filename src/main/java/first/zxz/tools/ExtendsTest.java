package first.zxz.tools;
/**
 * 继承实现测试
 * @author zhangxz
 * 2019/10/25
 */
public class ExtendsTest {

    public static void main(String[] args) {
        AB a = (AB) new AC();
        a.print1();
    }

    static void print1(AB a){
        a.print1();
    }

}



interface A{
    void print1();
}

interface AB extends A{
    void print2();
}

class AC implements A{
    @Override
    public void print1() {
        System.out.println("this is class AC.");
    }
}