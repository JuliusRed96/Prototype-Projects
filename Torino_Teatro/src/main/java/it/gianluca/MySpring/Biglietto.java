package it.gianluca.MySpring;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Biglietto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_operazione;
	private int id_cliente;
	private int id_replica;
	private LocalDateTime data_ora;
	private String tipo_pagamento;
	private int quantita;

	protected Biglietto(int id_operazione, int id_cliente, int id_replica, LocalDateTime data_ora,
			String tipo_pagamento, int quantita) {
		super();
		this.id_operazione = id_operazione;
		this.id_cliente = id_cliente;
		this.id_replica = id_replica;
		this.data_ora = data_ora;
		this.tipo_pagamento = tipo_pagamento;
		this.quantita = quantita;
	}

	public int getId_operazione() {
		return id_operazione;
	}

	public void setId_operazione(int id_operazione) {
		this.id_operazione = id_operazione;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_replica() {
		return id_replica;
	}

	public void setId_replica(int id_replica) {
		this.id_replica = id_replica;
	}

	public LocalDateTime getData_ora() {
		return data_ora;
	}

	public void setData_ora(LocalDateTime data_ora) {
		this.data_ora = data_ora;
	}

	public String getTipo_pagamento() {
		return tipo_pagamento;
	}

	public void setTipo_pagamento(String tipo_pagamento) {
		this.tipo_pagamento = tipo_pagamento;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
}
