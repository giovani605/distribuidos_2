package principal;

import java.util.Date;

import interfaces.InterfaceCliente;

public class Interresado {
	private Date dataValidade;
	private InterfaceCliente interf;
	
	public Interresado(InterfaceCliente interf, Date data) {
		this.dataValidade = data;
		this.interf = interf;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public InterfaceCliente getInterf() {
		return interf;
	}

	public void setInterf(InterfaceCliente interf) {
		this.interf = interf;
	}
}
