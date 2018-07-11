package service;

import java.util.List;

import org.seckill.entity.Seckill;
import org.springframework.aop.ThrowsAdvice;

import dto.Exposer;
import dto.SeckillExcution;
import exception.RepeatKillException;
import exception.SeckillCloseException;
import exception.SeckillException;

//ҵ��ӿ�

public interface SeckillService {

	List<Seckill> getSeckillList();
	
	Seckill getById(long seckillId);
	
	Exposer exportSeckillUrl(long seckillId);
	
	SeckillExcution excuteSeckill(long seckillId, long userPhone, String md5) 
			throws SeckillException, RepeatKillException, SeckillCloseException;
}
