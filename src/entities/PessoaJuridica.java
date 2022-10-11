package entities;

public class PessoaJuridica extends Pessoa {
	
	private Integer numeroFuncionarios;
	
	PessoaJuridica(){
	}

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	@Override
	public double calculoImposto(){
		if (numeroFuncionarios > 10) {
			return rendaAnual * 0.14;
		}
		 return rendaAnual * 0.16;
	}

	@Override
	public String toString() {
		return getNome()
				+ ": $ "
				+ String.format("%.2f", calculoImposto());
	}	
}