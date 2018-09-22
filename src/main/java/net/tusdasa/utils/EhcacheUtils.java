package net.tusdasa.utils;

import java.net.URL;

import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;

public class EhcacheUtils {
	public static CacheManager getCacheMa() {
		final URL url = EhcacheUtils.class.getResource("/ehcahe.xml");
		Configuration xml = new XmlConfiguration(url);
		CacheManager manager = CacheManagerBuilder.newCacheManager(xml);
		return manager;
	}
//	public static void main(String[] args) {
//		CacheManager m =  EhcacheUtils.getCacheMa();
//		m.init();
//		Cache<String, String> cache = m.getCache("foo", String.class, String.class);
//		cache.put("admin", "123456");
//		System.out.println(cache.get("admin"));
//		//m.close();
//		//m.init();
//		Cache<String, String> caches = m.getCache("foo", String.class, String.class);
//		caches.put("111", "2222");
//		System.out.println(caches.get("111"));
//		System.out.println(caches.get("admin"));
//		m.close();
//	}
}
