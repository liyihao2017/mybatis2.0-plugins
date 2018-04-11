/**
 * The contents of this file are copyright (c) 2017 by medavis GmbH, Karlsruhe, Germany
 */
package plugins;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author eason.li
 *
 */
public class Invocation {
    private Object target;
    private Method method;
    private Object[] args;
    
    public Invocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }
    
    public Object getTarget() {
        return target;
      }
    
      public Method getMethod() {
        return method;
      }
    
      public Object[] getArgs() {
        return args;
      }
      
   public Object proceed() throws InvocationTargetException, IllegalAccessException {
      return method.invoke(target, args);
    }
}
