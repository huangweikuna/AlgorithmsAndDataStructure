package test;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Fruit {
    public void show();
    public void aaa();
}
class Apple implements Fruit{
    @Override
    public void show() {
        System.out.println("<<<<show method is invoked");
    }

	@Override
	public void aaa() {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
}
public class DynamicAgent {

    //ʵ��InvocationHandler�ӿڣ����ҿ��Գ�ʼ����������Ķ���
    static class MyHandler implements InvocationHandler {
        private Object proxy;//ʵ������������
        public MyHandler(Object proxy) {
            this.proxy = proxy;
        }
            
        //�Զ���invoke����
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(">>>>before invoking");
            //�������÷����ĵط�
            Object ret = method.invoke(this.proxy, args);
            System.out.println(">>>>after invoking");
            return ret;
        }
    }
    //����һ�����޸Ĺ��Ķ���
    public static Object agent(Class interfaceClazz, Object proxy) {
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz},
                new MyHandler(proxy));
    }    
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //ע��һ��Ҫ���ؽӿڣ����ܷ���ʵ�������ᱨ��
        Fruit fruit = (Fruit) DynamicAgent.agent(Fruit.class, new Apple());
        fruit.show();
        fruit.aaa();
    }
}
