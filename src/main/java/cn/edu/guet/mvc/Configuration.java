package cn.edu.guet.mvc;

import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Configuration {
    public Map<String, ControllerMapping> config() throws URISyntaxException {

        Map<String, ControllerMapping> controllerMapping = new HashMap<String, ControllerMapping>();

        ResourceBundle bundle = ResourceBundle.getBundle("config");
        String controllerPackageName = bundle.getString("controller.package");
        String path = controllerPackageName.replace(".", "/");
        URI uri = Configuration.class.getResource("/" + path).toURI();
        File controllerDirectory = new File(uri);
        String[] controllerFileNames = controllerDirectory.list();
        for (String className : controllerFileNames) {
            if (className.endsWith(".class")) {
                System.out.println("包下的所有class：" + className);
                String fullClassName = controllerPackageName + "." + StringUtils.substringBefore(className, ".class");
                System.out.println("class的 全类名：" + fullClassName);
                try {
                    Class controllerClass = Class.forName(fullClassName);
                /*
                如果clazz中有Controller注解，才进一步处理
                 */
                    if (controllerClass.isAnnotationPresent(Controller.class)) {
                        Method methods[] = MethodUtils.getMethodsWithAnnotation(controllerClass, RequestMapping.class);
                    /*
                     找到哪些方法使用了RequestMapping注解
                     */
                        for (Method method : methods) {
                            /*
                            获取到RequestMapping注解的值  url
                            */
                            RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                            ControllerMapping mapping = new ControllerMapping(controllerClass, method);
                            System.out.print("控制器："+controllerClass.getSimpleName());
                            System.out.print("\t方法："+method.getName());
                            System.out.println("\turl注解的值：" + annotation.value());
                            controllerMapping.put(annotation.value(), mapping);
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return controllerMapping;
    }
}
