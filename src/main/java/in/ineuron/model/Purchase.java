package in.ineuron.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Purchase")
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer purchaseId;
	private Integer pid;
	private Integer cid;

	//select * from product p inner join purchase pr on p.pid=pr.purchase_id;
}
