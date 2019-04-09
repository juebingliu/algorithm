package com.util;

import com.netty.xml.dom4j.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author juebing
 * @date 2018/11/22 18:12
 * @description
 */
public class JaxbUtil {

    public static void convertToXml(Object obj, File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            //格式化输出，即按标签自动换行，否则就是一行输出
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //设置编码（默认编码就是utf-8）
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //是否省略xml头信息，默认不省略（false）
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
            marshaller.marshal(obj, file);
            //控制台输出
            marshaller.marshal(obj,System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static <T> T convertToJavaBean(Class<T> clz, File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            T t = (T) unmarshaller.unmarshal(file);
            return t;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}