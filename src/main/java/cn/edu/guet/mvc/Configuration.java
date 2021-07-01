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
                System.out.println("���µ�����class��" + className);
                String fullClassName = controllerPackageName + "." + StringUtils.substringBefore(className, ".class");
                System.out.println("class�� ȫ������" + fullClassName);
                try {
                    Class controllerClass = Class.forName(fullClassName);
                /*
                ���clazz����Controllerע�⣬�Ž�һ������
                 */
                    if (controllerClass.isAnnotationPresent(Controller.class)) {
                        Method methods[] = MethodUtils.getMethodsWithAnnotation(controllerClass, RequestMapping.class);
                    /*
                     �ҵ���Щ����ʹ����RequestMappingע��
                     */
                        for (Method method : methods) {
                            /*
                            ��ȡ��RequestMappingע���ֵ  url
                            */
                            RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                            ControllerMapping mapping = new ControllerMapping(controllerClass, method);
                            System.out.print("��������"+controllerClass.getSimpleName());
                            System.out.print("\t������"+method.getName());
                            System.out.println("\turlע���ֵ��" + annotation.value());
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
