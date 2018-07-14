package dto;
//��¶��ɱ��ַ
public class Exposer {

	private boolean exposed;
	
	private long seckillId;

	//����
	private String md5;
	
	private long now;
	
	private long start;
	
	private long end;
	
	public boolean isExposed() {
		return exposed;
	}


	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}


	public long getSeckillId() {
		return seckillId;
	}


	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}


	public String getMd5() {
		return md5;
	}


	public void setMd5(String md5) {
		this.md5 = md5;
	}


	public long getNow() {
		return now;
	}


	public void setNow(long now) {
		this.now = now;
	}


	public long getStart() {
		return start;
	}


	public void setStart(long start) {
		this.start = start;
	}


	public long getEnd() {
		return end;
	}


	public void setEnd(long end) {
		this.end = end;
	}


	
	public Exposer(boolean exposed, String md5, long seckillId) {
		super();
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}

	
	public Exposer(boolean exposed, long seckillId) {
		super();
		this.exposed = exposed;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposed, long seckillId, long now, long start, long end) {
		super();
		this.seckillId = seckillId;
		this.exposed = exposed;
		this.now = now;
		this.start = start;
		this.end = end;
	}


	@Override
	public String toString() {
		return "Exposer [exposed=" + exposed + ", seckillId=" + seckillId + ", md5=" + md5 + ", now=" + now + ", start="
				+ start + ", end=" + end + "]";
	}

	
	
}
