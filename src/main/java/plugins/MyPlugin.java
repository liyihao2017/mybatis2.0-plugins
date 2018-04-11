package plugins;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;

import config.MyMapperRegistory;
import executor.Executor;

/**
 * @author eason.li
 *
 */
@Intercepts({@Signature(type=Executor.class,
             method="query",
             args = {MyMapperRegistory.MapperData.class, Object.class})})
public class MyPlugin implements Interceptor{
    
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MyMapperRegistory.MapperData mappedStatement = (MyMapperRegistory.MapperData) invocation.getArgs()[0];
        
//        BoundSql boundSql = mappedStatement.getBoundSql(invocation.getArgs()[1]);
        System.out.println(String.format("plugin output sql = %s , param=%s", mappedStatement.getSql(),invocation.getArgs()[1]));
        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties paramProperties) {
        
    }
    
    @Override
    public Object plugin(Interceptor interceptor, Object target) {
        return Plugin.wrap(target, this);
    }

    
}
