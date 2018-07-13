package org.seckill.web;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import dto.Exposer;
import dto.SeckillExcution;
import dto.SeckillResult;
import enums.SeckillStateEnum;
import exception.RepeatKillException;
import exception.SeckillCloseException;
import exception.SeckillException;

@Controller
@RequestMapping("/seckill")//url:模块/资源/{id}/细分/seckill/list
public class SeckillController {

	private final Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		//获取列表页
		List<Seckill> list = seckillService.getSeckillList();
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("seckillId")Long seckillId, Model model) {
		if(seckillId == null) {
			return "redirect:/seckill/list";
		}
		Seckill seckill = seckillService.getById(seckillId);
		if(seckill == null) {
			return "forward:/seckill/list";
		}
		
		model.addAttribute("seckill", seckill);
		return "detail";
		
	}
	
	//ajax Json
	@RequestMapping(value = "/{seckillId}/exposer",
			method = RequestMethod.POST,
			produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<Exposer> exposer(@PathVariable Long seckillId) {
		SeckillResult<Exposer> result;
		try {
			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			result = new SeckillResult<Exposer>(true, exposer);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = new SeckillResult<Exposer>(false,e.getMessage());
		}
		return result;
		
	}
	
	@RequestMapping(value = "/{seckillId}/{md5}/excution",
			method = RequestMethod.POST,
					produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<SeckillExcution> excute(@PathVariable("seckillId")Long seckillId,
			@PathVariable("md5")String md5,
			@CookieValue(value = "killphone", required = false)Long phone) { 	
		if(phone == null) {
			return new SeckillResult<SeckillExcution>(false, "未注册");
		}
		SeckillResult<SeckillExcution> result;
		try {
			SeckillExcution excution = seckillService.excuteSeckill(seckillId, phone, md5);
			return new SeckillResult<SeckillExcution>(true, excution);
		} catch (RepeatKillException e) {
			SeckillExcution seckillExcution = new SeckillExcution(seckillId, SeckillStateEnum.REPEAT_KILL);
			return new SeckillResult<SeckillExcution>(false, seckillExcution);
		}catch (SeckillCloseException e) {
			SeckillExcution seckillExcution = new SeckillExcution(seckillId, SeckillStateEnum.END);
			return new SeckillResult<SeckillExcution>(false, seckillExcution);
		}catch (Exception e) {
			logger.error(e.getMessage());
			SeckillExcution seckillExcution = new SeckillExcution(seckillId, SeckillStateEnum.INNER_ERROR);
			return new SeckillResult<SeckillExcution>(true, seckillExcution);
		}
		
	}
	
	@RequestMapping(value = "/time/now", method = RequestMethod.GET)
	@ResponseBody
	public SeckillResult<Long> time() {
		Date now = new Date();
		return new SeckillResult<Long>(true,now.getTime());
	}
}
