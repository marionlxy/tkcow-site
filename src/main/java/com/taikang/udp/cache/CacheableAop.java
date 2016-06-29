package com.taikang.udp.cache;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CacheableAop {
	@Autowired
	private RedisTemplate redisTemplate;

	@Around("@annotation(cache)")
	public Object cached(final ProceedingJoinPoint pjp, Cacheable cache) throws Throwable {

		String key = getCacheKey(pjp, cache);
		ValueOperations<String, Object> valueOper = redisTemplate.opsForValue();
		Object value = valueOper.get(key); // 从缓存获取数据
		if (value != null)
			return value; // 如果有数据,则直接返回

		value = pjp.proceed(); // 跳过缓存,到后端查询数据
		// 缓存30分钟
		valueOper.set(key, value, 30, TimeUnit.MINUTES);
		return value;
	}

	/**
	 * 获取缓存的key值
	 * 
	 * @param pjp
	 * @param cache
	 * @return
	 */
	private String getCacheKey(ProceedingJoinPoint pjp, Cacheable cache) {

		StringBuilder buf = new StringBuilder();
		buf.append(pjp.getSignature().getDeclaringTypeName()).append(".").append(pjp.getSignature().getName());
		if (cache.key().length() > 0) {
			buf.append(".").append(cache.key());
		}

		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			buf.append(".").append(arg.toString());
		}
		return buf.toString();
	}
}
