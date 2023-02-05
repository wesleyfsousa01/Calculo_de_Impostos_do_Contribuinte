package entidades;

public class PessoaFisica extends Contribuinte {
    private Double despesasComSaude;

    public PessoaFisica(String nome, Double rendaAnual, Double despesasComSaude) {
        super(nome, rendaAnual);
        this.despesasComSaude = despesasComSaude;
    }

    public Double getDespesasComSaude() {
        return despesasComSaude;
    }

    public void setDespesasComSaude(Double despesasComSaude) {
        this.despesasComSaude = despesasComSaude;
    }

    @Override
    public double taxa() {
        double imposto = 0;
        if(getRendaAnual() < 20000){
            imposto = (getRendaAnual() * 0.15) - (despesasComSaude * 0.5);
            return  imposto;
        }else {
            imposto = (getRendaAnual() * 0.25) - (despesasComSaude * 0.5);
            return imposto;
        }
    }
}
