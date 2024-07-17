package it.gianluca.MySpring;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Repliche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_replica;
	private int id_spettacolo;
	private Date data_replica;

	protected Repliche(int id_replica, int id_spettacolo, Date data_replica) {
		super();
		this.id_replica = id_replica;
		this.id_spettacolo = id_spettacolo;
		this.data_replica = data_replica;
	}

	public int getId_replica() {
		return id_replica;
	}

	public void setId_replica(int id_replica) {
		this.id_replica = id_replica;
	}

	public int getId_spettacolo() {
		return id_spettacolo;
	}

	public void setId_spettacolo(int id_spettacolo) {
		this.id_spettacolo = id_spettacolo;
	}

	public Date getData_replica() {
		return data_replica;
	}

	public void setDataReplica(Date data_replica) {
		this.data_replica = data_replica;
	}

}
