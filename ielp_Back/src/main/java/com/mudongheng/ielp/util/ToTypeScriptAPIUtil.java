package com.mudongheng.ielp.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import com.mudongheng.ielp.controller.UserInfoController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 幕冬
 * @since 2021年11月23日
 */
public class ToTypeScriptAPIUtil {

    /**
     * 查找并收集包下的类
     * @param baseClass 基础类，作为项目路径索引，一般为程序入口，如Application。
     * @param packageName 包名，如com.mudongheng.controller
     * @return 类的列表
     */
    public static List<Class<?>> searchClass(Class<?> baseClass, String packageName) {
        String classpath = Objects.requireNonNull(baseClass.getResource("/")).getPath();
        String searchPath = classpath + packageName.replace(".", "/");
        List<String> classPaths = FileUtil.listFileNames(searchPath);
        List<Class<?>> res = new ArrayList<>();

        for (String s : classPaths) {
            s = packageName + "." + s.substring(0, s.length() - 6);
            try {
                res.add(Class.forName(s));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * 将类变为TypeScript代码
     * @param aClass 类
     * @return TypeScript代码
     */
    public static String toAPI(Class<?> aClass) {

        System.out.printf("处理：%s类%n", aClass.getSimpleName());

        if (!aClass.isAnnotationPresent(RestController.class)) {
            System.out.println("该类不属于控制层！");
            return "";
        }

        StringBuilder res = new StringBuilder();

        for (Method method : aClass.getMethods()) {

            String requestType;
            String[] value;
            String requestBodyType = "";

            if (method.isAnnotationPresent(GetMapping.class)) {
                requestType = "GET";
                value = method.getAnnotation(GetMapping.class).value();
            } else if (method.isAnnotationPresent(PostMapping.class)) {
                requestType = "POST";
                value = method.getAnnotation(PostMapping.class).value();

                Parameter[] methodParameters = method.getParameters();

                if (methodParameters.length > 0) {
                    String typeName = methodParameters[0].getType().getSimpleName();

                    if (typeName.equals("Integer")) {
                        typeName = "number";
                    } else if (typeName.equals("String")) {
                        typeName = "string";
                    }
                    requestBodyType += "data: " + typeName;
                }
            } else {
                continue;
            }

            if (value.length == 0) {
                continue;
            }

            String aResMethod = String.format("export function %s(%s): Promise<any> {\n", method.getName(), requestBodyType) +
                    "    return requestService({\n" +
                    String.format("        url: \"%s\",\n", value[0]) +
                    String.format("        method: \"%s\"\n", requestType) +
                    "    })\n" +
                    "}\n";

            res.append(aResMethod);
        }
        System.out.println("处理完成！");
        return res.toString();
    }

    public static void outputAPIFile(Class<?> baseClass, String packageName, String outputPath) {
        List<Class<?>> classList = searchClass(baseClass, packageName);

        for (Class<?> aClass : classList) {
            String simpleName = aClass.getSimpleName();
            String fileName = simpleName.substring(0, simpleName.length() - 10);
            FileWriter fileWriter = new FileWriter(outputPath + fileName + "API.ts");
            fileWriter.write(toAPI(aClass));
        }

    }

    public static void main(String[] args) {
        outputAPIFile(UserInfoController.class, "com.mudongheng.ielp.controller", "D:\\下载\\out\\api\\");
    }
}
