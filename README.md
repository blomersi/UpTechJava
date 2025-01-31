# UpTechJava
Projeto UpTech - Criado para estudo das linguagens Java, Python e Go

# **🏆 Sistema de Gestão do Campeonato Brasileiro**

## **📌 Visão Geral**  
Este projeto tem como objetivo desenvolver um sistema de gestão para o **Campeonato Brasileiro**, dividindo responsabilidades entre três APIs escritas em **Java, Python e Go**, todas integradas com **MongoDB**. Cada API será responsável por uma parte específica do sistema, implementando **CRUD**, autenticação via **JWT** e integração com o banco de dados.  

---

## **🛠 Tecnologias Utilizadas**  
🔹 **Backend Java**: Spring Boot, Spring Security, MongoDB  
🔹 **Backend Python**: FastAPI/Flask, PyJWT, MongoDB  
🔹 **Backend Go**: Gin/Echo, golang-jwt, MongoDB  
🔹 **Autenticação**: JWT  
🔹 **Banco de Dados**: MongoDB  

---

## **📌 Arquitetura do Projeto**  

### **1️⃣ API Java – Gestão de Times**  
https://github.com/blomersi/UpTechJava/  
🔹 Responsável pelo gerenciamento dos times participantes.  

#### **📌 Funcionalidades:**  
✅ CRUD para times (nome, estádio, cidade, estado, ano de fundação, etc.).  
✅ Endpoint para listar todos os times, com filtros por estado ou cidade.  

#### **🚀 Tecnologias:**  
- **Framework:** Spring Boot  
- **Autenticação:** Spring Security + JWT  
- **Banco:** MongoDB  

---

### **2️⃣ API Python – Gestão de Jogadores**  
https://github.com/blomersi/UpTechPython/  
🔹 Responsável pelo gerenciamento dos jogadores cadastrados no sistema.  

#### **📌 Funcionalidades:**  
✅ CRUD para jogadores (nome, idade, posição, nacionalidade, time associado, etc.).  
✅ Endpoint para buscar jogadores de um time específico.  

#### **🚀 Tecnologias:**  
- **Framework:** FastAPI ou Flask  
- **Autenticação:** JWT com `PyJWT`  
- **Banco:** MongoDB  

---

### **3️⃣ API Go – Gestão de Partidas**  
https://github.com/blomersi/UpTechGo/  
🔹 Responsável pelo gerenciamento das partidas do campeonato.  

#### **📌 Funcionalidades:**  
✅ CRUD para partidas (data, horário, time mandante, time visitante, placar, local, etc.).  
✅ Endpoint para listar partidas de um time específico ou entre datas definidas.  

#### **🚀 Tecnologias:**  
- **Framework:** Gin ou Echo  
- **Autenticação:** JWT com `golang-jwt`  
- **Banco:** MongoDB  

---

## **📌 Estrutura do Banco de Dados (MongoDB)**  
Cada API possui sua própria coleção:  
📌 **Java API** → `teams`  
📌 **Python API** → `players`  
📌 **Go API** → `matches`  

### **🔗 Relacionamentos:**  
- `players` contém uma referência ao time (`team_id`).  
- `matches` contém referências aos times (`home_team_id` e `away_team_id`).  

---

## **🔒 Autenticação JWT**  
Todas as APIs exigem autenticação para acessar os endpoints.  
✅ Um endpoint de autenticação central (na API Java) gera tokens JWT.  
✅ As outras APIs validam os tokens recebidos para garantir acesso seguro.  

---

## **📌 Fluxo de Integração**  
📌 **Java API (Times)**: Permite criar e gerenciar os times participantes.  
📌 **Python API (Jogadores)**: Os jogadores são associados aos times existentes.  
📌 **Go API (Partidas)**: As partidas utilizam os IDs dos times da API Java para definir mandantes e visitantes.  

---

## **🚀 Para Tornar o Projeto Mais Desafiador**  
🔹 **Logs e Monitoramento**: Adicione logs estruturados com ferramentas como ELK Stack ou Grafana + Loki.  
🔹 **Cache**: Implemente cache com Redis para endpoints de leitura frequente.  
🔹 **Documentação**: Cada API deve expor uma documentação Swagger/OpenAPI.  
🔹 **Testes**: Testes unitários e de integração para validar funcionalidades.  
