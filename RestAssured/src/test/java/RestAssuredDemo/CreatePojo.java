package RestAssuredDemo;

public class CreatePojo {
	private String name;
	private String job;

	public CreatePojo(String name,String job)
	{
		this.name=name;
		this.job=job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
