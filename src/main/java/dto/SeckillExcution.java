package dto;

import org.seckill.entity.SuccessKilled;

import enums.SeckillStateEnum;

//��װ��ɱִ�к���
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
	
	//ִ��״̬
	private int state;
	
	//״̬��ʶ
	private String stateInfo;
	
	private SuccessKilled successKilled;
}
