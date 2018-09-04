package Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Db_recept")
public class Recept {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String status;
	private String beginname;
	@OneToOne(mappedBy="recept",fetch=FetchType.EAGER)
	@Cascade(CascadeType.ALL)
	private Form form;
	
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBeginname() {
		return beginname;
	}
	public void setBeginname(String beginname) {
		this.beginname = beginname;
	}

}
