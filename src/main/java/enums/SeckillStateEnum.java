package enums;

//���������ֵ�

public enum SeckillStateEnum {
	
	SUCCESS(1,"��ɱ�ɹ�"),
	END(0,"��ɱ����"),
	REPEAT_KILL(-1,"�ظ���ɱ"),
	INNER_ERROR(-2,"ϵͳ�쳣"),
	DATA_REWRITE(-3,"���ݴ۸�");

	private int state;
	
	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}


	private String stateInfo;
	
	private SeckillStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	public static SeckillStateEnum stateOf(int index) {
		for(SeckillStateEnum state: values()) {
			if(state.getState() == index) {
				return state;
			}
		}
		return null;
	}

	
	
	
}
