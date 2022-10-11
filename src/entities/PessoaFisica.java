package entities;

public class PessoaFisica extends Pessoa{
	
	private Double gastosComSaude;
	
	public PessoaFisica() {
	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastosComSaude) {
		super(nome, rendaAnual);
		this.gastosComSaude = gastosComSaude;
	}

	public Double getGastosComSaude() {
		return gastosComSaude;
	}

	public void setGastosComSaude(Double gastosComSaude) {
		this.gastosComSaude = gastosComSaude;
	}
	
	private double descontoImposto() {
		return gastosComSaude * 0.50;
	}
	
	@Override
	public double calculoImposto() {
		if (rendaAnual < 20000.00) {
			return  (rendaAnual * 0.15) - descontoImposto();
		} 
		return (rendaAnual * 0.25) - descontoImposto();
	}
	
	@Override
	public String toString() {
		return getNome()
				+ ": $ "
				+ String.format("%.2f", calculoImposto());
	}	
}