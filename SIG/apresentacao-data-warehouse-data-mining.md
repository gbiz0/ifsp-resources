---
marp: true
theme: default
paginate: true
size: 16:9
footer: "SIG · IFSP Campus Votuporanga · Data Warehouse e Data Mining"
style: |
  section {
    position: relative;
    font-family: "Segoe UI", "Noto Sans", "Liberation Sans", sans-serif;
    font-size: 26px;
    line-height: 1.35;
    color: #142033;
    background: #f3f6f8;
    padding: 46px 56px 54px;
  }
  section:not(.lead) {
    display: flex;
    flex-direction: column;
    justify-content: center;
  }
  section:not(.lead)::before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    height: 7px;
    background: linear-gradient(90deg, #0f2744 0%, #0f766e 62%, #d97706 100%);
  }
  section::after {
    font-size: 15px;
    font-weight: 700;
    color: #64748b;
  }
  footer {
    font-size: 13px;
    color: #64748b;
    letter-spacing: 0.01em;
  }
  h1 {
    margin: 0 0 0.42em;
    font-size: 38px;
    line-height: 1.12;
    letter-spacing: -0.02em;
    color: #0f2744;
  }
  h2 {
    margin: 0 0 0.35em;
    font-size: 28px;
    font-weight: 650;
    color: #0f2744;
  }
  h3 {
    margin: 0 0 0.2em;
    font-size: 20px;
    line-height: 1.25;
    color: #0f2744;
  }
  p { margin: 0.3em 0; }
  strong { color: #0f2744; }
  ul { margin: 0.2em 0; }
  li { margin: 0.28em 0; }
  blockquote {
    margin: 0 0 0.7em;
    padding: 0.75em 1em 0.7em;
    background: #ffffff;
    border: 0;
    border-left: 5px solid #d97706;
    border-radius: 0 14px 14px 0;
    box-shadow: 0 10px 28px rgba(15, 39, 68, 0.07);
    font-size: 22px;
    line-height: 1.4;
    color: #1e293b;
  }
  blockquote p { margin: 0; }
  blockquote cite {
    display: block;
    margin-top: 0.55em;
    font-style: normal;
    font-size: 16px;
    font-weight: 700;
    letter-spacing: 0.02em;
    color: #0f766e;
  }
  section.lead {
    color: #f8fafc;
    background:
      radial-gradient(circle at 92% 8%, rgba(45, 212, 191, 0.28), transparent 32%),
      radial-gradient(circle at 4% 96%, rgba(217, 119, 6, 0.22), transparent 28%),
      linear-gradient(155deg, #07111f 0%, #0f2744 46%, #115e59 100%);
    padding: 68px 76px;
  }
  section.lead h1,
  section.lead h2,
  section.lead strong {
    color: #ffffff;
    border: 0;
  }
  section.lead h1 {
    font-size: 58px;
    max-width: 16ch;
    margin: 0.12em 0 0.16em;
  }
  section.lead h2 {
    max-width: 28ch;
    font-size: 30px;
    font-weight: 560;
    color: #99f6e4;
  }
  section.lead::after { color: rgba(248, 250, 252, 0.72); }
  section.lead footer { color: rgba(248, 250, 252, 0.72); }
  .eyebrow {
    margin: 0;
    font-size: 15px;
    font-weight: 750;
    letter-spacing: 0.16em;
    text-transform: uppercase;
    color: #fbbf24;
  }
  .rule {
    width: 84px;
    height: 4px;
    margin: 22px 0 18px;
    border-radius: 99px;
    background: #f59e0b;
  }
  .meta {
    margin: 0.15em 0;
    font-size: 20px;
    color: #e2e8f0;
  }
  .team {
    display: flex;
    flex-wrap: wrap;
    gap: 10px;
    margin-top: 28px;
  }
  .team span {
    padding: 8px 14px;
    border: 1px solid rgba(255, 255, 255, 0.28);
    border-radius: 999px;
    background: rgba(255, 255, 255, 0.08);
    font-size: 18px;
  }
  .agenda {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 12px 18px;
  }
  .agenda div {
    display: flex;
    align-items: center;
    gap: 12px;
    padding: 11px 14px;
    background: #ffffff;
    border-radius: 12px;
    box-shadow: 0 8px 22px rgba(15, 39, 68, 0.06);
    font-size: 22px;
  }
  .agenda b {
    min-width: 1.8em;
    color: #0f766e;
    font-size: 18px;
    font-variant-numeric: tabular-nums;
  }
  .grid2, .grid3, .cols, .steps, .split2, .kpis {
    display: grid;
    gap: 14px;
  }
  .grid2, .cols, .split2, .kpis { grid-template-columns: 1fr 1fr; }
  .grid3, .steps { grid-template-columns: 1fr 1fr 1fr; }
  .card, .step, .panel, .mini, .kpi, .node {
    background: #ffffff;
    border-radius: 14px;
    box-shadow: 0 10px 26px rgba(15, 39, 68, 0.07);
  }
  .card, .mini, .step, .panel {
    padding: 14px 16px 12px;
  }
  .card p, .mini p, .step p, .panel li, .caption {
    font-size: 18px;
    line-height: 1.35;
    color: #334155;
  }
  .card p, .mini p, .step p { margin: 0; }
  .mini { border-top: 4px solid #0f766e; }
  .mini:nth-child(2) { border-top-color: #0e7490; }
  .mini:nth-child(3) { border-top-color: #1d4ed8; }
  .mini:nth-child(4) { border-top-color: #d97706; }
  .step { border-top: 4px solid #0f766e; }
  .step .n, .sol .n {
    display: block;
    margin-bottom: 4px;
    font-size: 13px;
    font-weight: 800;
    letter-spacing: 0.12em;
    color: #0f766e;
  }
  .cols { align-items: center; gap: 22px; }
  .cols ul { margin: 0; padding-left: 1.15em; font-size: 21px; }
  .cols li { margin: 0.45em 0; }
  .caption {
    margin: 8px 0 0;
    text-align: center;
    font-weight: 650;
    color: #0f766e;
  }
  .callout {
    margin: 14px 0 0;
    padding: 12px 16px;
    border-radius: 12px;
    background: #0f2744;
    color: #f8fafc;
    font-size: 20px;
  }
  .callout strong { color: #fde68a; }
  .points div:last-child strong { color: #fde68a; }
  .star, .star-row {
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .star { flex-direction: column; }
  .vlink {
    width: 3px;
    height: 16px;
    background: #94a3b8;
  }
  .hlink {
    width: 16px;
    height: 3px;
    flex: none;
    background: #94a3b8;
  }
  .dimbox, .factbox {
    border-radius: 12px;
    text-align: center;
    font-size: 16px;
    font-weight: 750;
  }
  .dimbox {
    min-width: 124px;
    padding: 12px 14px;
    background: #ffffff;
    border: 2.5px solid #0f766e;
    color: #0f2744;
  }
  .dimbox.c { border-color: #0e7490; }
  .dimbox.p { border-color: #1d4ed8; }
  .dimbox.l { border-color: #d97706; }
  .factbox {
    min-width: 148px;
    padding: 22px 16px;
    background: #0f2744;
    color: #ffffff;
  }
  .sector { border-left: 5px solid #0f766e; }
  .sector:nth-child(2) { border-left-color: #0e7490; }
  .sector:nth-child(3) { border-left-color: #1d4ed8; }
  .sector:nth-child(4) { border-left-color: #7c3aed; }
  .sector:nth-child(5) { border-left-color: #d97706; }
  .sector:nth-child(6) { border-left-color: #be123c; }
  .panel.good { border-top: 5px solid #0f766e; }
  .panel.warn { border-top: 5px solid #d97706; }
  .panel ul { margin: 0.2em 0 0; padding-left: 1.1em; }
  .kpis { margin-bottom: 14px; }
  .kpi {
    padding: 16px 18px 14px;
    border-top: 5px solid #0f766e;
  }
  .kpi.up { border-top-color: #1d4ed8; }
  .kpi .num {
    margin: 0;
    font-size: 52px;
    font-weight: 760;
    letter-spacing: -0.03em;
    line-height: 1;
    color: #0f2744;
  }
  .kpi p { margin: 6px 0 0; font-size: 18px; color: #334155; }
  .stack {
    display: flex;
    flex-direction: column;
    gap: 12px;
  }
  .pipe, .arch {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 8px;
  }
  .pipe > .node,
  .pipe > .arch-branch {
    width: min(100%, 880px);
  }
  .arch-row, .arch-branch {
    display: flex;
    align-items: stretch;
    justify-content: center;
    gap: 10px;
    width: 100%;
  }
  .node {
    flex: 1;
    padding: 10px 12px 9px;
    text-align: center;
  }
  .node small {
    display: block;
    margin-bottom: 2px;
    font-size: 12px;
    font-weight: 750;
    letter-spacing: 0.08em;
    text-transform: uppercase;
    color: #0f766e;
  }
  .node strong { display: block; font-size: 20px; }
  .node span { display: block; margin-top: 2px; font-size: 15px; color: #475569; }
  .node.focus { background: #0f2744; }
  .node.focus strong, .node.focus small, .node.focus span { color: #ffffff; }
  .node.focus small { color: #99f6e4; }
  .node.decision {
    width: 72%;
    flex: none;
    background: #115e59;
  }
  .node.decision strong { color: #ffffff; font-size: 22px; }
  .arr {
    align-self: center;
    color: #0f766e;
    font-size: 26px;
    font-weight: 700;
    line-height: 1;
  }
  .arch-branch { width: 78%; }
  .points div {
    margin: 0 0 10px;
    padding: 12px 16px;
    background: #ffffff;
    border-left: 5px solid #0f766e;
    border-radius: 0 12px 12px 0;
    box-shadow: 0 8px 20px rgba(15, 39, 68, 0.06);
    font-size: 22px;
  }
  .points div:last-child {
    margin-bottom: 0;
    border-left-color: #d97706;
    background: #0f2744;
    color: #f8fafc;
  }
  section.refs { font-size: 22px; }
  section.refs ul { margin: 0; padding: 0; list-style: none; }
  section.refs li {
    margin: 0 0 12px;
    padding: 14px 16px;
    background: #ffffff;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(15, 39, 68, 0.06);
  }
  section.thanks { text-align: left; }
  section.thanks h1 { font-size: 72px; max-width: none; }
  section.thanks .team { margin-top: 18px; }
---

<!-- _class: lead -->
<!-- _paginate: false -->
<!-- _footer: "" -->

<p class="eyebrow">Sistemas de Informações Gerenciais</p>

# Aplicações em Banco de Dados

## Data Warehouse e Data Mining aplicados às Organizações

<div class="rule"></div>

<p class="meta">Prof. Dr. Marcelo Luis Murari</p>
<p class="meta">IFSP — Campus Votuporanga</p>

<div class="team">
  <span>Gustavo Bizo Jardim</span>
  <span>Guilherme Grigolin</span>
  <span>Ravi Vendramini</span>
</div>

---

# Agenda

<div class="agenda">
  <div><b>01</b> Introdução</div>
  <div><b>02</b> O que é Data Warehouse</div>
  <div><b>03</b> O que é Data Mining</div>
  <div><b>04</b> Relação entre DW e DM</div>
  <div><b>05</b> Aplicações nas organizações</div>
  <div><b>06</b> Estudo de caso</div>
  <div><b>07</b> Arquitetura da solução</div>
  <div><b>08</b> Benefícios e desafios</div>
  <div><b>09</b> Conclusão</div>
  <div><b>10</b> Referências</div>
</div>

---

# 1. Introdução

<div class="grid2">
  <div class="mini">
    <h3>Volume de dados</h3>
    <p>As organizações geram grandes volumes de dados diariamente: vendas, clientes, operações e logística.</p>
  </div>
  <div class="mini">
    <h3>Limite do OLTP</h3>
    <p>Dados brutos, isolados em sistemas transacionais, não geram valor por si só.</p>
  </div>
  <div class="mini">
    <h3>Necessidade</h3>
    <p>É preciso consolidar, organizar e analisar essas informações para apoiar a tomada de decisão.</p>
  </div>
  <div class="mini">
    <h3>Resposta</h3>
    <p>Nesse contexto, Data Warehouse e Data Mining se tornam essenciais.</p>
  </div>
</div>

---

# 2. O que é Data Warehouse?

<blockquote>
  <p>Um Data Warehouse é uma coleção de dados orientada por assunto, integrada, variante no tempo e não volátil, utilizada para dar suporte ao processo de tomada de decisão.</p>
  <cite>Bill Inmon</cite>
</blockquote>

<div class="grid2">
  <div class="mini">
    <h3>Orientado por assunto</h3>
    <p>Organizado por temas de negócio: vendas, clientes, produtos.</p>
  </div>
  <div class="mini">
    <h3>Integrado</h3>
    <p>Consolida dados de múltiplas fontes.</p>
  </div>
  <div class="mini">
    <h3>Histórico</h3>
    <p>Variante no tempo: mantém a série histórica dos dados.</p>
  </div>
  <div class="mini">
    <h3>Não volátil</h3>
    <p>Os dados não são alterados; são carregados e consultados.</p>
  </div>
</div>

---

# 2.1 Processo ETL

<p>O Data Warehouse é alimentado pelo processo ETL, que garante qualidade e consistência para a análise.</p>

<div class="steps">
  <div class="step">
    <span class="n">01 · EXTRACT</span>
    <h3>Extração</h3>
    <p>Coleta de dados dos sistemas transacionais: ERP, CRM, planilhas e outras fontes.</p>
  </div>
  <div class="step">
    <span class="n">02 · TRANSFORM</span>
    <h3>Transformação</h3>
    <p>Limpeza, padronização e adequação dos dados ao modelo analítico.</p>
  </div>
  <div class="step">
    <span class="n">03 · LOAD</span>
    <h3>Carga</h3>
    <p>Inserção dos dados tratados no Data Warehouse.</p>
  </div>
</div>

---

# 2.2 Modelagem dimensional

<div class="cols">
  <div class="stack">
    <div class="mini">
      <h3>Estrela ou floco de neve</h3>
      <p>O DW usa o modelo estrela (<em>star schema</em>) ou o floco de neve (<em>snowflake</em>).</p>
    </div>
    <div class="mini">
      <h3>Tabelas fato</h3>
      <p>Métricas e eventos de negócio, como o valor da venda.</p>
    </div>
    <div class="mini">
      <h3>Tabelas dimensão</h3>
      <p>Contexto descritivo: cliente, produto, tempo e região.</p>
    </div>
  </div>
  <div>
    <div class="star">
      <div class="dimbox">Dim_Tempo</div>
      <div class="vlink"></div>
      <div class="star-row">
        <div class="dimbox c">Dim_Cliente</div>
        <div class="hlink"></div>
        <div class="factbox">Fato_Vendas</div>
        <div class="hlink"></div>
        <div class="dimbox p">Dim_Produto</div>
      </div>
      <div class="vlink"></div>
      <div class="dimbox l">Dim_Loja</div>
    </div>
    <p class="caption">Estrela de vendas: o fato no centro, as dimensões ao redor</p>
  </div>
</div>

---

# 3. O que é Data Mining?

<div class="points">
  <div>Processo de <strong>descoberta de padrões, tendências e conhecimento</strong> em grandes volumes de dados.</div>
  <div>Usa técnicas de <strong>estatística, aprendizado de máquina e inteligência artificial</strong>.</div>
  <div>Vai além da consulta: busca <strong>relações ocultas</strong> e <strong>previsões</strong>.</div>
</div>

---

# 3.1 Principais técnicas

<div class="grid2">
  <div class="mini">
    <h3>Classificação</h3>
    <p>Atribui registros a categorias conhecidas, como risco de crédito alto ou baixo.</p>
  </div>
  <div class="mini">
    <h3>Clusterização</h3>
    <p>Agrupa itens semelhantes sem categorias prévias, formando perfis de clientes.</p>
  </div>
  <div class="mini">
    <h3>Associação</h3>
    <p>Encontra itens que ocorrem juntos, como nas regras de cesta de compras.</p>
  </div>
  <div class="mini">
    <h3>Regressão</h3>
    <p>Estima valores e antecipa tendências, como a demanda do próximo período.</p>
  </div>
</div>

---

# 4. Relação entre DW e DM

<div class="cols">
  <div class="panel good">
    <h3>Data Warehouse</h3>
    <ul>
      <li>Armazena e organiza dados históricos</li>
      <li>Responde “o que aconteceu?”</li>
      <li>É a infraestrutura de dados</li>
    </ul>
  </div>
  <div class="panel" style="border-top: 5px solid #1d4ed8;">
    <h3>Data Mining</h3>
    <ul>
      <li>Analisa e extrai padrões dos dados</li>
      <li>Responde “por que aconteceu?” e “o que pode acontecer?”</li>
      <li>É a camada analítica e inteligente</li>
    </ul>
  </div>
</div>

<p class="callout">O <strong>DW</strong> fornece a base limpa e estruturada de que o <strong>Data Mining</strong> precisa para gerar insights confiáveis.</p>

---

# 5. Aplicações nas organizações

<div class="grid3">
  <div class="card sector">
    <h3>Varejo</h3>
    <p>Análise de cesta de compras e previsão de demanda.</p>
  </div>
  <div class="card sector">
    <h3>Setor financeiro</h3>
    <p>Detecção de fraudes e análise de crédito.</p>
  </div>
  <div class="card sector">
    <h3>Saúde</h3>
    <p>Identificação de padrões em diagnósticos.</p>
  </div>
  <div class="card sector">
    <h3>Marketing</h3>
    <p>Segmentação de clientes e campanhas direcionadas.</p>
  </div>
  <div class="card sector">
    <h3>Indústria</h3>
    <p>Manutenção preditiva e controle de qualidade.</p>
  </div>
  <div class="card sector">
    <h3>Setor público</h3>
    <p>Análise de indicadores sociais e econômicos.</p>
  </div>
</div>

---

# 6. Estudo de caso

## Rede de varejo fictícia — MercadoMais

<div class="split2">
  <div class="panel good">
    <h3>Contexto</h3>
    <ul>
      <li>Rede de supermercados com 40 lojas em São Paulo</li>
      <li>Vendas dispersas nos sistemas locais de cada loja (PDV)</li>
      <li>Dificuldade para ver tendências de consumo e otimizar o estoque</li>
    </ul>
  </div>
  <div class="panel warn">
    <h3>Problema</h3>
    <ul>
      <li>Perda de vendas por ruptura de estoque</li>
      <li>Promoções pouco eficazes, sem base em dados</li>
      <li>Decisões tomadas por intuição gerencial</li>
    </ul>
  </div>
</div>

---

# 6.1 Solução implementada

<div class="split2">
  <div class="panel good">
    <span class="n">01</span>
    <h3>Construção do Data Warehouse</h3>
    <ul>
      <li>Consolidação das vendas de todas as lojas via ETL</li>
      <li>Modelo estrela: <strong>Fato_Vendas</strong> ligado a Dim_Produto, Dim_Loja, Dim_Tempo e Dim_Cliente</li>
    </ul>
  </div>
  <div class="panel" style="border-top: 5px solid #1d4ed8;">
    <span class="n">02</span>
    <h3>Aplicação de Data Mining</h3>
    <ul>
      <li><strong>Associação:</strong> quem compra pão frequentemente compra manteiga e leite</li>
      <li><strong>Clusterização:</strong> perfis economia, conveniência e premium</li>
      <li><strong>Previsão de demanda</strong> por série temporal e sazonalidade</li>
    </ul>
  </div>
</div>

---

# 6.2 Resultados obtidos

<div class="kpis">
  <div class="kpi">
    <p class="num">−18%</p>
    <p>nas rupturas de estoque, com previsão de demanda mais precisa</p>
  </div>
  <div class="kpi up">
    <p class="num">+12%</p>
    <p>nas vendas, com promoções direcionadas por perfil de cliente</p>
  </div>
</div>

<div class="grid2">
  <div class="mini">
    <h3>Gôndolas reorganizadas</h3>
    <p>Produtos complementares ficaram próximos, com base nas regras de associação.</p>
  </div>
  <div class="mini">
    <h3>Gestão data-driven</h3>
    <p>As decisões estratégicas passaram a ser orientadas por dados.</p>
  </div>
</div>

---

# 7. Arquitetura da solução

<div class="pipe">
  <div class="node">
    <small>Origem</small>
    <strong>Sistemas transacionais</strong>
    <span>PDV das lojas</span>
  </div>
  <div class="arr">↓</div>
  <div class="node">
    <small>Integração</small>
    <strong>ETL</strong>
    <span>Extração, transformação e carga</span>
  </div>
  <div class="arr">↓</div>
  <div class="node focus">
    <small>Repositório</small>
    <strong>Data Warehouse</strong>
    <span>Modelo estrela</span>
  </div>
  <div class="arr">↓</div>
  <div class="arch-branch">
    <div class="node">
      <small>Consulta</small>
      <strong>Ferramentas OLAP</strong>
      <span>Dashboards</span>
    </div>
    <div class="node">
      <small>Descoberta</small>
      <strong>Data Mining</strong>
      <span>Padrões e previsões</span>
    </div>
  </div>
  <div class="arr">↓</div>
  <div class="node decision">
    <strong>Tomada de decisão gerencial</strong>
  </div>
</div>

---

# 8. Benefícios e desafios

<div class="split2">
  <div class="panel good">
    <h3>Benefícios</h3>
    <ul>
      <li>Visão unificada e histórica dos dados organizacionais</li>
      <li>Decisões mais rápidas e assertivas</li>
      <li>Identificação de oportunidades ocultas nos dados</li>
      <li>Vantagem competitiva frente à concorrência</li>
    </ul>
  </div>
  <div class="panel warn">
    <h3>Desafios</h3>
    <ul>
      <li>Custo de implementação e manutenção da infraestrutura</li>
      <li>Qualidade e governança de dados</li>
      <li>Equipe capacitada: analistas e cientistas de dados</li>
      <li>Privacidade e segurança dos dados</li>
    </ul>
  </div>
</div>

---

# 9. Conclusão

<div class="points">
  <div>Data Warehouse e Data Mining são <strong>pilares complementares</strong> dos Sistemas de Informações Gerenciais.</div>
  <div>Juntos, transformam <strong>dados brutos em conhecimento estratégico</strong>.</div>
  <div>O caso MercadoMais mostrou ganhos concretos: menos ruptura, mais vendas e decisões mais informadas.</div>
  <div>Em um mercado competitivo, organizações que usam esses recursos têm <strong>vantagem real</strong>.</div>
</div>

---

<!-- _class: lead thanks -->
<!-- _paginate: false -->
<!-- _footer: "" -->

<p class="eyebrow">Sistemas de Informações Gerenciais</p>

# Obrigado!

## Perguntas?

<div class="rule"></div>

<div class="team">
  <span>Gustavo Bizo Jardim</span>
  <span>Guilherme Grigolin</span>
  <span>Ravi Vendramini</span>
</div>

<p class="meta">IFSP — Campus Votuporanga</p>

---

<!-- _class: refs -->

# Referências

- INMON, W. H. *Building the Data Warehouse*. Wiley, 2005.
- HAN, J.; KAMBER, M.; PEI, J. *Data Mining: Concepts and Techniques*. Morgan Kaufmann, 2011.
- TURBAN, E. et al. *Sistemas de Apoio à Decisão e Inteligência de Negócios*. Bookman, 2009.
- LAUDON, K. C.; LAUDON, J. P. *Sistemas de Informação Gerenciais*. Pearson, 2014.
