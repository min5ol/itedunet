package dto1;

public class member
{
	private String id;
	private String password;
	private String name;
	
	//기본생성자
	public member(){}

	//전체생성자
	public member(String id, String password, String name)
	{
		this.id = id;
		this.password = password;
		this.name = name;
	}

	//toString()
	@Override
	public String toString()
	{
		return "member [id=" + id + ", password=" + password + ", name=" + name + "]";	
	}

	//getter, setter
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	};

}
