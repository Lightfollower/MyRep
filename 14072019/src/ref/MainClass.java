package ref;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
    List<Method> methods = new ArrayList<>();
    List<Object> objects = new ArrayList<>();
    List<String> answers = new ArrayList<>();

    public MainClass() throws MalformedURLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        File file = new File("out/production/14072019/");
        File[] files = file.listFiles();
        for (File f :
                files) {
            System.out.println(f);
            if (f.toString().endsWith(".class")) {
                Class clazz = URLClassLoader.newInstance(new URL[]{new File("out/production/14072019/").toURL()}).loadClass(f.getName().substring(0, f.getName().indexOf(".")));
                Constructor constructor = clazz.getConstructor();
                objects.add(constructor.newInstance());
                methods.add(clazz.getDeclaredMethod("sayOlolo", int.class));
            }
        }
        for (int i = 0; i < objects.size(); i++) {
            answers.add((String)methods.get(i).invoke(objects.get(i),1));
        }
        System.out.println(answers);
    }
}
