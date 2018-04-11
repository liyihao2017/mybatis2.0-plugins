package plugins;

import java.util.Properties;

/**
 * @author eason.li
 *
 */
public interface Interceptor {
    Object intercept(Invocation invocation) throws Throwable;

    Object plugin(Interceptor interceptor, Object target);

    void setProperties(Properties properties);
    
//    public abstract Object intercept(Invocation paramInvocation) throws Throwable;
//
//    public abstract Object plugin(Object paramObject);
//
//    public abstract void setProperties(Properties paramProperties);
}
