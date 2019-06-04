package ex.aaronfae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@GetMapping("get/{key}")
	public String get(@PathVariable String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@PostMapping("set/{key}/{value}")
	public String set(@PathVariable String key, @PathVariable String value) {
		redisTemplate.opsForValue().set(key, value);
		return "set: " + key + "=" + value;
	}

}
