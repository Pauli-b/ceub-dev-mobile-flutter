
// PRIMEIRA ATIVIDADE

// Função para retornar a soma de dois números.
int soma(int a, int b) {
  return a + b;
}

// Função para retornar o século de um ano.
int seculoDoAno(int ano) {
  // Divide o ano por 100 e adiciona 1 para obter o século.
  // Por exemplo, 2024 seria o século 21.
  return ((ano - 1) ~/ 100) + 1;
}

void main() {
  // Testando a função soma
  print("A soma de 5 e 7 é: ${soma(5, 7)}");

  // Testando a função seculoDoAno
  print("O século de 2024 é: ${seculoDoAno(2024)}");
}
