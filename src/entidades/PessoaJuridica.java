package entidades;

public class PessoaJuridica extends Contribuinte{
    private Integer numFuncionarios;

    public PessoaJuridica(String nome, Double rendaAnual, Integer numFuncionarios) {
        super(nome, rendaAnual);
        this.numFuncionarios = numFuncionarios;
    }

    public Integer getNumFuncionarios() {
        return numFuncionarios;
    }

    public void setNumFuncionarios(Integer numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }

    @Override
    public double taxa() {
        double taxa = 0;
        if(numFuncionarios < 10){
            taxa = rendaAnual * 0.16;
            return taxa;
        }else {
            taxa = rendaAnual * 0.14;
            return taxa;
        }
    }
}
