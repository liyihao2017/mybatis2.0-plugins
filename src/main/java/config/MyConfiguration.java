package config;

import java.lang.reflect.Proxy;

import plugins.InterceptorChain;
import plugins.MyPlugin;
import proxy.MyProxy;
import session.MySqlsession;

/**
 * @author eason.li
 *
 */
public class MyConfiguration {
    
    private MyMapperRegistory registory = new MyMapperRegistory();
    protected final InterceptorChain interceptorChain = new InterceptorChain();
    
    public MyMapperRegistory getRegistory() {
        return registory;
    }

    
    public void setRegistory(MyMapperRegistory registory) {
        this.registory = registory;
    }

    public <T> T getMapper(Class<T> clazz, MySqlsession sqlsession) {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, new MyProxy(sqlsession));
    }


    
    public InterceptorChain getInterceptorChain() {
        interceptorChain.addInterceptor(new MyPlugin());
        return interceptorChain;
    }
    
    //mock parsing xml
//    static TestMapperXML {
//        public static final String namespace = "mapper.TestMapper";
//        
//        public static final Map<String,String> methodSqlMapping = new HashMap<>();
//        
//        static {
//            methodSqlMapping.put("selectByPrimaryKey", "select * from test.test where id=%d");
//        }
//    } 
}
