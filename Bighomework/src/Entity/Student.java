package Entity;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.inject.New;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="Db_student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String sname;
	private String snumber;
	private String spass;
	@OneToMany(mappedBy="student",fetch=FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private Set<Form> forms=new HashSet<Form>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	
	public String getSpass() {
		return spass;
	}
	public void setSpass(String spass) {
		this.spass = spass;
	}
	public Set<Form> getForms() {
		return forms;
	}
	public void setForms(Set<Form> forms) {
		this.forms = forms;
	}
	
	
}
