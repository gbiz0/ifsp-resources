# A01: Controle de Acesso Quebrado (Broken Access Control)

### T3-BSI
- Fabricio Tiago Arantes
- Guilherme Grigolin 
- Gustavo Bizo Jardim
- Ravi Vendramini
---

## Posição no Ranking OWASP
- Subiu da 5ª posição para o topo em 2021  
- Testado em **94% das aplicações**  
- Taxa média de incidência: **3.81%**  
- Mais de **318 mil ocorrências**  

---

## Descrição da Vulnerabilidade
O controle de acesso garante que usuários não ajam fora de suas permissões.  
Quando falha, pode resultar em:
1. Divulgação não autorizada de informações  
2. Modificação ou destruição de dados  
3. Execução de funções de negócio fora dos limites permitidos  

---

## CWEs Notáveis Associados
- **CWE-200**: Exposure of Sensitive Information  
- **CWE-201**: Insertion of Sensitive Information  
- **CWE-352**: Cross-Site Request Forgery (CSRF)  
- **CWE-425**: Direct Request (Forced Browsing)  
- **CWE-862**: Missing Authorization  

---

## Formas de Exploração

### Violação do Princípio do Mínimo Privilégio
- Acesso concedido a qualquer pessoa  
- Exemplo: recursos disponíveis sem restrição  

---

### IDOR (Insecure Direct Object References)
- Visualizar/editar conta de outro usuário alterando parâmetros  
- Exemplo:  

https://example.com/app/accountInfo?acct=notmyacct


---

### Force Browsing (Navegação Forçada)
- Acesso a páginas restritas sem autenticação/autorização  
- Exemplo:  

https://example.com/app/admin_getappInfo


---

### Bypass de Verificações
- Alteração de URL, HTML, API (parameter tampering)  
- Exemplo: uso indevido de métodos POST, PUT, DELETE sem controle  

---

### Manipulação de Metadados (Tokens)
- Alteração de cookies/JWT para elevação de privilégios  
- Exemplo: adulterar ou reutilizar tokens  

---

### Elevação de Privilégio
- Agir como admin estando logado como usuário comum  
- Resultado comum da manipulação de metadados  

---

### CORS Malconfigurado
- API acessível por origens não confiáveis  
- Referência: PortSwigger – Exploiting CORS Misconfiguration  

---

## Contramedidas e Prevenção

1. **Princípio de Negação Padrão**  
 - Negar acesso por padrão (exceto recursos públicos)  

2. **Centralização e Reutilização**  
 - Controle de acesso implementado uma única vez e reutilizado  

3. **Implementação de Propriedade de Registro**  
 - Impor propriedade do registro em modelos de acesso  

4. **Minimização de Risco em APIs e Sessões**  
 - Minimizar CORS  
 - Rate limit em APIs  
 - Invalidar sessões no logout  
 - Tokens JWT curtos e revogáveis  

5. **Configuração Segura de Servidores e Logs**  
 - Desabilitar listagem de diretórios  
 - Evitar arquivos sensíveis expostos (.git, backups)  
 - Registrar e alertar sobre falhas de acesso  

6. **Testes Rigorosos**  
 - Testes funcionais, unitários e de integração focados em controle de acesso  

---

## Referências e Padrões
- **OWASP Proactive Controls**: Enforce Access Controls  
- **OWASP ASVS**: V4 Access Control  
- **OWASP Testing Guide**: Authorization Testing  
- **OWASP Cheat Sheet**: Authorization  
- **OAuth**: Revoking Access  