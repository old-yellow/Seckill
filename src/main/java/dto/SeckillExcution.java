package dto;

import org.seckill.entity.SuccessKilled;

import enums.SeckillStateEnum;

//封装秒杀执行后结果
public class SeckillExcution {

	public SeckillExcution(long seckillId, SeckillStateEnum stateEnum) {
		super();
		this.seckillId = seckillId;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	public SeckillExcution(long seckillId, SeckillStateEnum stateEnum, SuccessKilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.successKilled = successKilled;
	}

	private long seckillId;
	
	//执行状态
	private int state;
	
	//状态标识
	private String stateInfo;
	
	private SuccessKilled successKilled;
}
