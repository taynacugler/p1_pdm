# Mii Bão - Gestão de Pamonhas Premium

## Descrição

Este programa foi desenvolvido para a primeira prova de dispositivos para dispositivos móveis com o objetivo de fazer um aplicativo para vendas de pamonhas personalizadas. 

### Funcionalidades

#### 1. Clientes
- **Cadastrar Cliente**:
  - **CPF** (String)
  - **Nome** (String)
  - **Telefone** (String)
  - **E-mail** (String)
- **Operações**:
  - Inserir
  - Listar todos
  - Atualizar
  - Excluir

#### 2. Pedidos de Pamonha
- **Cadastrar Pedido**:
  - **IDPamonha** (Inteiro)
  - **Tipo de Recheio** (String)
  - **Peso de Queijo** (Float)
  - **CPF do Cliente** (String - chave estrangeira)
- **Operações**:
  - Inserir
  - Listar todos
  - Atualizar
  - Excluir

### Tecnologias Utilizadas

- **Linguagem**: Kotlin
- **Plataforma**: Android
- **Banco de Dados**: SQLite


