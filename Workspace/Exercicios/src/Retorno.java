
public class Retorno {
	
	private String nome;
	private int idade;
	

	public int somar(int s) {
		return s + 10;
	}	
	
	public void escrever() {
		System.out.println("Escrevendo Bobagens...");
	}
	
	
	public static void main(String[] args) {
		Retorno r = new Retorno();
		
		r.idade = 10;
		r.nome = "Ben";
		
				
		r.escrever();
		System.out.println(r.somar(14) + " bobagens, pra ser exato. E meu nome é " + r.nome + r.idade);
	}
	

}
