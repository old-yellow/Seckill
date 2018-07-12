package service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.seckill.service.SeckillService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.qos.logback.classic.Logger;
import dto.Exposer;
import dto.SeckillExcution;
import exception.RepeatKillException;
import exception.SeckillCloseException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml"
})
public class SeckillServiceTest {
	
	private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;

	@Test
	public void testGetSeckillList() {
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}", list);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		long id = 1000;
		Seckill seckill = seckillService.getById(id);
		logger.info("seckill={}", seckill);
		//fail("Not yet implemented");
	}

	//测试代码完整逻辑，注意可重复执行
	@Test
	public void testSeckillLogic() {
		long id = 1001;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		if(exposer.isExposed()) {
			logger.info("exposer={}", exposer);
			long phone = 17683885992l;
			String md5 = exposer.getMd5();
			try {
				SeckillExcution seckillExcution = seckillService.excuteSeckill(id, phone, md5);
				logger.info("result={}", seckillExcution);
			} catch (RepeatKillException e) {
				logger.error(e.getMessage());
			}catch (SeckillCloseException e) {
				logger.error(e.getMessage());
			}
		}else {
			//秒杀未开启
			logger.warn("exposer={}", exposer);
		}
		logger.info("exposer={}", exposer);
		//fail("Not yet implemented");
	}

	

}
