package hibernatequerylanguage;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
	private int stuId;
	private String stuName;
	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER) // mappedBy is used to map the bidirectional relationship
	private List<Book> bList = new ArrayList<>();

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public List<Book> getbList() {
		return bList;
	}

	public void setbList(List<Book> bList) {
		this.bList = bList;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + "]";
	}

}
