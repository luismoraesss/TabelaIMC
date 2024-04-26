public class Calculo {
    private String nome;
    private char genero; // 'm' para masculino, 'f' para feminino, 'n' para não-binário
    private double altura;
    private double peso;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void calcularImc() {
        double imc = peso / (altura * altura);
        System.out.println("Nome: " + nome);
        System.out.println("Gênero: " + genero);
        System.out.println("Altura: " + altura);
        System.out.println("Peso: " + peso);
        System.out.print("Status: ");
        imprimirStatus(imc);
    }

    private void imprimirStatus(double imc) {
        String status = "";
        if (imc < obterLimiteInferiorNormal()) {
            status = "Abaixo do normal";
        } else if (imc < obterLimiteSuperiorNormal()) {
            status = "Normal";
        } else if (imc < obterLimiteSuperiorObesidadeLeve()) {
            status = "Obesidade leve";
        } else if (imc < obterLimiteSuperiorObesidadeModerada()) {
            status = "Obesidade moderada";
        } else {
            status = "Obesidade mórbida";
        }
        System.out.println(status);
    }

    private double obterLimiteInferiorNormal() {
        return (genero == 'f' || genero == 'n') ? 19 : 20;
    }

    private double obterLimiteSuperiorNormal() {
        return (genero == 'f' || genero == 'n') ? 23.9 : 24.9;
    }

    private double obterLimiteSuperiorObesidadeLeve() {
        return (genero == 'f' || genero == 'n') ? 28.9 : 29.9;
    }

    private double obterLimiteSuperiorObesidadeModerada() {
        return (genero == 'f' || genero == 'n') ? 38.9 : 39.9;
    }
}
