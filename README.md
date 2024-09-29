<div align="center">
  <img alt="Ada" style="border-radius: 50%; width: 50px;" src="FotosReadme/Ada.png">
  <h1 style="font-size: 20px;"><b>LOCADORA DE VEÍCULOS</b></h1>
</div>

<h1 align="center">
  <img alt="Santander Coders" src="https://ada-strapi-production.s3.sa-east-1.amazonaws.com/Thumb_Meta_20_f25502065b.png" width="350" height="210">
</h1>

<div align="center">
<b><span style="font-size: 18px;">Módulo 3: Programação Orientada a Objetos II</span></b><br>Projeto desenvolvido pelo grupo 5 da turma 1173 do programa <b>Santander Coders</b> 2024.1 em parceria com a <b>Ada Tech</b>
</div>

## Objetivos do Projeto
Criar uma aplicação que gerencie o aluguel de veículos, onde cada item abaixo seja considerado:
- Cadastrar os veículos;
- Alterar um veículo cadastrado;
- Buscar um veículo por parte da placa;
- Cadastrar a agência onde o veículo será alugado/devolvido;
- Alterar a agência onde o veículo será alugado/devolvido;
- Buscar uma agência por parte do nome ou do logradouro do endereço;
- Cadastrar o cliente (pessoa física/jurídica);
- Alterar o cliente (pessoa física/jurídica);
- Alugar um veículo para pessoa física;
- Alugar um veículo para pessoa jurídica;
- Devolver um veículo para pessoa física;
- Devolver um veículo para pessoa jurídica;
- Gerar um comprovante com todos os dados do aluguel (aberto para o grupo decidir o que vai ser demonstrado);
- Gerar um comprovante com todos os dados da devolução (aberto para o grupo decidir o que vai ser demonstrado).

## Regras de Negócio
**RN1**: Os veículos não podem ser repetidos;

**RN2:** Tipos de veículos que serão considerados: carro, moto e caminhão;

**RN3:** Os aluguéis e devoluções terão o local, data e horário;

**RN4:** Os veículos que estiverem alugados não poderão estar disponíveis;

**RN5:** Agências não podem estar duplicadas;

**RN6:** Clientes não podem estar duplicados;

**RN7:** Regras de devolução:
- Caso pessoa física tenha ficado com o carro mais que 5 dias terá direito a 5% de desconto;
- Caso pessoa jurídica tenha ficado com o carro mais que 3 dias terá direito a 10% de desconto.

Valores base da diária por tipo de veículo:

| Tipo de Veículo | Valor por dia |
| --------------- | ------------- |
| Moto            | R$ 100,00     |
| Carro           | R$ 150,00     |
| Caminhão        | R$ 200,00     |

## Principais Classes

```mermaid
---
title: Principais classes
---
classDiagram

    class Veiculo{
        <<Abstract>>
        #String placa
        #String modelo
        #String marca
        #Boolean disponivel
        #BigDecimal valor

        +getters()
        +setters()
        +constructor()
    }


    class Carro{
        +toString()
    }
    class Moto{
        +toString()
    }
    class Caminhao{
        +toString()
    }

    class Pessoa{
        <<Abstract>>
        -String nome
        -String endereco
        -String telefone

        +getters()
        +setters()
    }

    Pessoa <|-- PessoaFisica
    Pessoa <|-- PessoaJuridica


    class PessoaFisica {
        -String cpf
        +toString()
    }

    class PessoaJuridica {
        -String cnpj
        +toString()
    }

    class Agencia {
        -String nome
        -String endereco
        -int identificador
        -List~Veiculo~ veiculos
        +getters()
        +setters()
        +constructor()
        +toString()
    }

    class Aluguel {
        #Pessoa cliente
        #Agencia agencia
        #Veiculo veiculo
        #LocalDate dataInicio
        #LocalDate dataDevolucaoPrevista

        +imprimirComprovanteAluguel(int quantidadeDias, String tipoPessoa)
        +getters()
        +setters()
        +constructor()
    }

    class Devolucao {
        -Aluguel aluguel
        +calcularDevolucao(LocalDate data, String tipoPessoa)
    }

    Veiculo <|-- Carro
    Veiculo <|-- Moto
    Veiculo <|-- Caminhao
    Agencia o-- Veiculo : 0..*
    Aluguel o-- Pessoa : 1
    Aluguel o-- Agencia : 1
    Aluguel o-- Veiculo : 1
    Devolucao *-- Aluguel : 1

```

## Linguagem
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

## Ferramentas Utilizadas
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)

## Principais Desafios Encontrados no Projeto
*Compreensão de Como Estruturar o Projeto:* Entender como estruturar o projeto, definir as classes e métodos necessários para construir a aplicação e integrar toda a estrutura para garantir que o programa funcione corretamente.

*Aplicar Novos Conceitos:* Conseguir aplicar os novos conceitos que foram ensinados durante o módulo, como princípios SOLID, e construção de diagrama de classes.

*Validação de Dados:* Garantir que os dados inseridos pelos usuários sejam válidos e estejam no formato correto, além de implementar validações para evitar duplicidade de agências, veículos e clientes.

*Interface de Usuário:* Desenvolver uma interface de usuário intuitiva e fácil de usar para que os usuários possam realizar todas as operações necessárias.

## Integrantes
<table align="center" style="width: 80%;">
  <tr>
    <td align="center" style="width: 20%;">
      <img style="border-radius: 5%;" src="FotosReadme/LauraFoto.jpeg" height="90px" width="100px;" alt=""/><br />
      <sub><b>Ana Laura Marques Rodrigues</b></sub><br />
      <a href="https://github.com/lauluah" target="_blank">GitHub</a>
    </td>
    <td align="center" style="width: 20%;">
      <img style="border-radius: 5%;" src="FotosReadme/Arthur.jpeg" height="90px" width="100px;" alt=""/><br />
      <sub><b>Arthur Gabriel De Menezes Viana</b></sub><br />
      <a href="https://github.com/arthurgmv" target="_blank">GitHub</a>
    </td>
    <td align="center" style="width: 20%;">
      <img style="border-radius: 5%;" src="FotosReadme/Mariana.jpeg" height="90px" width="100px;" alt=""/><br />
      <sub><b>Mariana Lainara Silva</b></sub><br />
      <a href="https://github.com/la1ni" target="_blank">GitHub</a>
    </td>
    <td align="center" style="width: 20%;">
      <img style="border-radius: 5%;" src="FotosReadme/Taina.jpeg" height="90px" width="100px;" alt=""/><br />
      <sub><b>Tainá Souza Peixoto</b></sub><br />
      <a href="https://github.com/peixotots" target="_blank">GitHub</a>
    </td>
  </tr>
</table>

