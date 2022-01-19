package continent.model;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import country.model.Country;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Continent")
@Data
@NoArgsConstructor
public class Continent {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String code;
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="CountinentId")
    private List<Country> country;
}