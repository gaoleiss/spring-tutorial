/**
 * Created by lei on 4/6/14.
 */

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class Demo {


    /**
     * ##############################################################################
     *
     * @param args
     * @throws InterruptedException ##############################################################################
     * @DESCRIBE
     */
    public static void main(String[] args) throws InterruptedException {


        // 使用默认配置文件创建CacheManager
        CacheManager manager = CacheManager.create();
        // 通过manager可以生成指定名称的Cache对象
        Cache cache = manager.getCache("cache1");
        // 使用manager移除指定名称的Cache对象
//        manager.removeCache("cache1");
        // 可以通过调用manager.removalAll()来移除所有的Cache。通过调用manager的shutdown()方法可以关闭CacheManager。
        //有了Cache对象之后就可以进行一些基本的Cache操作，例如：
        //往cache中添加元素
        Element element = new Element("key", "value");
        cache.put(element);
//从cache中取回元素
        element = cache.get("key");
        System.out.println(element.getObjectValue());
//从Cache中移除一个元素
        cache.remove("key");
    }

}
