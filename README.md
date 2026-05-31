# 🖥️ Infinity Tech — Sistema de Loja de Varejo

Sistema de gerenciamento para loja de varejo desenvolvido em Java, com funcionalidades de cadastro de clientes, controle de estoque, vendas e geração de nota fiscal em PDF.

---

## 📋 Funcionalidades

### Funcionário
- Cadastrar produtos
- Listar produtos
- Realizar vendas com diferentes formas de pagamento
- Buscar produto por nome ou ID

### Gerente
- Cadastrar, alterar e excluir produtos
- Visualizar relatório de vendas
- Visualizar relatório de produtos

### Geral
- Cadastro e busca de clientes por CPF
- Geração de nota fiscal em PDF
- Histórico de operações salvo em arquivo
- Dados persistidos entre sessões (clientes, produtos e vendas)

---

## 💳 Formas de Pagamento
- Dinheiro (com cálculo de troco)
- Cartão de débito e crédito (com opção de parcelamento em até 10x)
- Pix (com QR Code)

---

## 🗂️ Estrutura do Projeto


SistemaGeral/<br>
├── Dominio/<br>
│   ├── Cliente.java       # Cadastro e persistência de clientes<br>
│   ├── Produto.java       # Cadastro e persistência de produtos<br>
│   ├── Venda.java         # Lógica de vendas e pagamentos<br>
│   ├── Gerente.java       # Operações do gerente<br>
│   ├── Funcionario.java   # Operações do funcionário<br>
│   ├── Credenciais.java   # Login e senha<br>
│   ├── Notafiscal.java    # Geração de nota fiscal em PDF<br>
│   ├── Relatorio.java     # Relatórios de vendas e produtos<br>
│   └── Historico.java     # Registro de histórico em arquivo<br>
└── Start/<br>
    └── StartNow.java      # Classe principal (main)<br>


---

## 💾 Persistência de Dados

Os dados são salvos automaticamente ao fechar o sistema e carregados ao iniciar:

| Arquivo | Conteúdo |
|---------|----------|
| clientes.dat | Lista de clientes cadastrados |
| produtos.dat | Lista de produtos e estoque |
| vendas.dat | Histórico de vendas |
| historico.txt | Log de operações com data e hora |

---

## 🚀 Como executar



### Executar
 src/SistemaGeral/Start/StartNow.java


---

## 🔐 Credenciais padrão

| Perfil | Login | Senha |
|--------|-------|-------|
| Funcionário | root | root |
| Gerente | admin | admin |

---

## 🛠️ Tecnologias utilizadas

- Java
- Apache PDFBox (geração de PDF)
- Serialização de objetos (persistência de dados)

---

## 👨‍💻 Autor

Desenvolvido por *Arthur Ongaro, Apolo Marcos, Gustavo Paulo e Kauã Ribeiro*
