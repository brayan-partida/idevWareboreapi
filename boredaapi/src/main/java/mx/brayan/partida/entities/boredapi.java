package mx.brayan.partida.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

//import org.springframework.data.annotation.Id;

import com.sun.istack.NotNull;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "boredapi")
@NoArgsConstructor
public class boredapi {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String activity;

	private String type;

	@NotNull
	private Integer participants;

	private Long price;

	private String link;

	@Column(length = 200)
	private String keyApp;

	private Long accessibility;

	public boredapi(Integer id, String activity, String type, Integer participants, Long price, String link,
			String keyApp, Long accessibility) {
		super();
		this.id = id;
		this.activity = activity;
		this.type = type;
		this.participants = participants;
		this.price = price;
		this.link = link;
		this.keyApp = keyApp;
		this.accessibility = accessibility;
	}

	public boredapi() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getParticipants() {
		return participants;
	}

	public void setParticipants(Integer participants) {
		this.participants = participants;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getKeyApp() {
		return keyApp;
	}

	public void setKeyApp(String keyApp) {
		this.keyApp = keyApp;
	}

	public Long getAccessibility() {
		return accessibility;
	}

	public void setAccessibility(Long accessibility) {
		this.accessibility = accessibility;
	}

}
